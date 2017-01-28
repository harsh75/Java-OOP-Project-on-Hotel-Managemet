import java.util.Scanner;

public class Customer{
	String customerName,customerGender;
	int customerId;
	int customerAge;
	Scanner scanner=new Scanner(System.in);
	static int countNumOfCustomer;
	
	public Customer(){
		countNumOfCustomer+=1;
		System.out.println("Enter your name,gender,age in respective lines");
		this.customerName=scanner.next();
		this.customerGender=scanner.next();
		this.customerAge=scanner.nextInt();
		this.customerId=countNumOfCustomer;
	}
}

