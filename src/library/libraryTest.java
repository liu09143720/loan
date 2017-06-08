package library;

import java.util.ArrayList;

import org.junit.Test;

public class libraryTest {
	Member member1 = new Member();
	Member member2 = new Member();
	Member member3 = new Member();
	Book book1 = new Book("01", "ISBN-1-1", "《Book1》");
	Book book2 = new Book("01", "ISBN-1-2", "《Book2》");
	Book book3 = new Book("02", "ISBN-2-1", "《Book3》");
	Book book4 = new Book("02", "ISBN-2-2", "《Book4》");
	Book book5 = new Book("03", "ISBN-3-1", "《Book5》");
	Book book6 = new Book("03", "ISBN-3-2", "《Book6》");
	Member loanmember = member1;
	Book loanbook=book1;
	ArrayList<Loan> Loans = new ArrayList<Loan>();

	public libraryTest() {		
		member1.setId("01");
		member1.setName("Member1");
		member2.setId("02");
		member2.setName("Member1");
		member3.setId("03");
		member3.setName("Member1");		

		Loan loan = new Loan();
		loan.setMember(loanmember);
		loan.setBook(book6);
		Loans.add(loan);		
		loanmember.setLoans(Loans);
	}

	@Test	
	public void Loan() {
		Loan loan=loanmember.Loan(loanbook);
		 if(!(loan==null)){
		 System.out.println("借书记录："+'\r'+" 借书时间: " +
		 loan.getLoanDate()+
		 " 到期时间: " + loan.getDateForReuturn()+
		 " 借书人: " + loan.getMember().getName()+
		 " 所借书目: " + loan.getBook().getTitle());
		 }		 
		/**还书**/
		loanmember.Return(loanbook); 

	}
	
	
}
