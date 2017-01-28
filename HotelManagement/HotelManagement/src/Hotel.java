import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
//Hotel class is used to get available rooms from the database and allots a room to the user
class Hotel{
	String hotelName="Harsh's Hotel";
	//creating an array of rooms
	Room[] room = new Room[20];
	Scanner scanner=new Scanner(System.in);
	int count=0;
	//connection to the database , creating global variables.
	OracleCon con =new OracleCon();
	Statement stmt=con.connectionDb();
	ResultSet rs;
	//todays date
	Date date = new Date();
	
	public Hotel() throws SQLException{
		System.out.println("Welcome To our Hotel "+ hotelName);
		System.out.println();
		getRooms();
	}
	
	public void getRooms() throws SQLException{
		//number of rooms are 10 single bed  and 10 double bed from database
		Date bookTill;
		rs = stmt.executeQuery("select * from room");
		
		while(rs.next()){
			bookTill=rs.getDate(5);
			if(bookTill.before(date) || bookTill.equals(date)){
				room[count]=new Room(rs.getInt(1),rs.getString(4));
				count+=1;
			}
		}
	}
	
	public Room availableRoom(int numOfDays) throws SQLException{
		//Adding number of days to the todays day and assigning it to bookedTill;
		Calendar cd = Calendar.getInstance();
		cd.setTime(new Date());
		cd.add(Calendar.DATE, numOfDays);
		//obtaining bookedTill
		Date bookedTill=cd.getTime();
		
		int day=bookedTill.getDate();
		int month=bookedTill.getMonth()+1;
		int year=bookedTill.getYear()+1900;
		
		//displaying available rooms 
		System.out.println("Options \t roomnum \t Availability \t Price \t Type \t BookedTill");
		for (int i=0;i<count;i++){
				System.out.print(i+"\t\t");
				System.out.print(room[i].roomNum+"\t\t");
				System.out.print(room[i].roomPrice+"\t\t");
				System.out.print(room[i].roomType+"\t\t");
				//System.out.print(room[i].freeDate+"\t\t");
				System.out.println();
		}
		
		//taking room number as input form user;
		System.out.println("Enter room number you want\n");
		int roomNum=scanner.nextInt();
		//assigning free date to that room
		try{
			room[roomNum-1].freeDate=day+"-"+month+"-"+year;
			return room[roomNum-1];
		}		
		catch(Exception e){
			System.out.println("Choose the room number properly");
			throw e;
		}
		
	}
}