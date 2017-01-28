import java.sql.*;
import java.util.Scanner;

class HotelManagement{
	public static void main(String[] args) throws SQLException {
		//Connecting to database
		OracleCon con =new OracleCon();
		Statement stmt=con.connectionDb();
		
		Scanner scanner= new Scanner(System.in);  //scanner for reading 
		Hotel h=new Hotel();						//initialize the rooms and checks the availability
		System.out.print("Check Available Room");
		
		
			System.out.println("Enter Your no. of days you want to stay from today");
			
			//get RoomNumber and instantiate a room 
			Room r=h.availableRoom(scanner.nextInt());
			//get customer Information and instantiate a customer
			Customer c =new Customer();
			System.out.println("Are you sure you want to book the room? Press 1 to continue");
			System.out.println(r.freeDate);
			System.out.println(r.roomNum);
			int choice=scanner.nextInt();
			if(choice==1){
				//update room
				try{
						stmt.execute("update room set bookedtill=to_date('"+r.freeDate+"','dd-mm-yyyy') where roomNum="+r.roomNum);
						System.out.println("Room Booked");
						stmt.executeQuery("INSERT INTO CUSTOMER(NAME, GENDER, AGE, ROOMNUM) VALUES ('"+c.customerName+"', '"+c.customerGender+"','"+c.customerAge+"','"+r.roomNum+"')");
						System.out.println("Customer registered");
						System.out.println("Welcome "+c.customerName+" You have been alloted "+r.roomNum);
				}
				catch(Exception e){
					System.out.print("Error in updating Check again after some time ");
					throw e;
				}
			//update customer
			}
			else{
				
			}
			System.out.println("Thanks For the Visit");
			scanner.close();
			
			
		
		
	}
	
}
