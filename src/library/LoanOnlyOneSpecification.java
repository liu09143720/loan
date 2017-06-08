package library;

import java.util.ArrayList;

public class LoanOnlyOneSpecification implements Specification<Member> {
	private Book wantbook;

	public LoanOnlyOneSpecification(Book wantbook) {
		this.wantbook = wantbook;
	}

	@Override
	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		ArrayList<Loan> Loans = new ArrayList<Loan>();
		Loans = member.getLoans();
		int i=0;
		for (Loan l : Loans) {
			if (l.getBook().getId()==wantbook.getId()&&!(l.getReturnDate() == null)){
					i=i+1;				
			}			
		}
		if(i<1){
			return true;
		}
		return false;		
	}

}
