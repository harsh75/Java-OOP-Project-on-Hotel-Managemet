import java.util.Scanner;

public class Customer{
	Scanner scanner= new Scanner(System.in);
	String customerName,customerGender,customerRoom;
	int customerAge;
	public Customer(Room r){
		System.out.println("You have selected room"+r.roomNum);
		this.customerRoom=r.roomType;
		getDetails();
	}
	public void getDetails(){
		System.out.println("Enter your name,gender,age in respective lines");
		this.customerName=scanner.next();
		this.customerGender=scanner.next();
		this.customerAge=scanner.nextInt();
				
	}
	

}

