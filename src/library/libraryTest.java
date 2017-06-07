package library;

import java.util.ArrayList;

import org.junit.Test;

public class libraryTest {
	Member member1 = new Member();
	Member member2 = new Member();
	Member member3 = new Member();
	Book book1 = new Book("0001", "56-1", "语文");
	Book book2 = new Book("0002", "56-2", "数学");
	Book book3 = new Book("0003", "56-3", "英语");
	Member loanmember = member1;
	Book loanbook = book1;
	ArrayList<Loan> Loans = new ArrayList<Loan>();

	public libraryTest() {
		/*
		 * 添加借书人属性
		 */
		member1.setId("01");
		member1.setName("张三");
		member2.setId("02");
		member2.setName("李四");
		member3.setId("03");
		member3.setName("老王");
		book1.setISBN("1-1");
		book2.setISBN("1-2");
		book3.setISBN("1-3");
		/*
		 * 添加借书记录
		 */
		Loan loan1 = new Loan();
		loan1.setMember(loanmember);
		loan1.setBook(book1);
		Loans.add(loan1);
		Loan loan2 = new Loan();
		loan2.setMember(loanmember);
		loan2.setBook(book2);
		Loans.add(loan2);
		Loan loan3 = new Loan();
		loan3.setMember(loanmember);
		loan3.setBook(book3);
		Loans.add(loan3);
		loanmember.setLoans(Loans);
	}

	@Test
	/* 
	 * 借书
	 */
	public void Loan() {
		 Loan loan=loanmember.Loan(loanbook);
		 if(!(loan==null)){
		 System.out.println("借书成功！");
		 System.out.println("借书记录：*************"+'\r'+"借书时间: " +
		 loan.getLoanDate()+
		 " 到期时间: " + loan.getDateForReuturn()+
		 " 借书人: " + loanmember.getName()+
		 " 所借书籍: " + loanbook.getTitle());
		 }
		 else{
		 System.out.println("借书不成功！");
		 }
		/**还书**/
		loanmember.Return(loanbook); 

	}
	
	@Test
	/* 
	 * 规则测试
	 */
	public void rule(){
	LoanOnlyOneSpecification one = new LoanOnlyOneSpecification(loanbook);
	System.out.println(one.IsSatisfiedBy(loanmember));

		
	}

}
