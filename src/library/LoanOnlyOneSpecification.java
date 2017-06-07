package library;

public class LoanOnlyOneSpecification implements Specification<Member> {
	private Book wantbook;

	public LoanOnlyOneSpecification(Book wantbook) {
		this.wantbook = wantbook;
	}

	@Override
	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		Loan loan = member.FindCurrentLoanFor(wantbook);
		if (loan==null||(!(loan==null)&&!(loan.getReturnDate()==null))) {
			return true;
		}
	return false;		
	}

}
