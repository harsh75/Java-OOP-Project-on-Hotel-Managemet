import java.util.Scanner;

class HotelManagement{
	public static void main(String[] args){
		Scanner scanner= new Scanner(System.in);
		Hotel h=new Hotel();
		
		System.out.print("Check Available Room, press 1");
		int choice;
		
		do{
			System.out.println("Enter Your no. of days you want to stay from today");
			int numDays=scanner.nextInt();
			Room r=h.availableRoom(numDays);
			
			Customer c =new Customer(r);
			
			System.out.print("Welcome"+c.customerName+"You have been alloted"+c.customerRoom);
			
			System.out.print("Check Available Room, press 1");
			
			choice= scanner.nextInt();
			
		}while (choice==1);
		
		System.out.print("Thanks For the Visit");
		
		
		scanner.close();
		
	}
	
}
