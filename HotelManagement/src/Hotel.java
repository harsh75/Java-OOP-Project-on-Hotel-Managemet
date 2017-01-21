import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class Hotel{
	String hotelName="Harsh's Hotel";
	Room[] room = new Room[20];
	Scanner scanner=new Scanner(System.in);
	public Hotel(){
		System.out.println("Welcome To our Hotel "+ hotelName);
		System.out.println();
		getRooms();
	}
	public void getRooms(){
		//number of rooms are 10 single bed  and 10 double bed
		for(int i =0;i<10;i++){
			room[i]=new Room(1,i);
		}
		for(int i =10;i<20;i++){
			room[i]=new Room(2,i);
		}
		
	}
	public Room availableRoom(int numOfDays){
		//if room is available for number of days
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, numOfDays);  // number of days to add
		String dt = sdf.format(c.getTime());  
		//free room missing
		for (int i=0;i<20;i++){
			if(room[i].roomAvail==true ){
				System.out.print(room[i].roomNum);
				System.out.print(room[i].roomAvail);
				System.out.print(room[i].roomPrice);
				System.out.print(room[i].roomType);
				System.out.println();
			}
		}
		
		System.out.println("Enter roomNum you want\n");
		int roomNum=scanner.nextInt();
		if(room[roomNum].roomAvail==true){
			room[roomNum].freeDate=dt;
			room[roomNum].roomAvail=false;
			return room[roomNum];
		}
		return null;
	}
	
	
}