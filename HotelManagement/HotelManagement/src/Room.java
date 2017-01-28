import java.util.Date;

class Room{
	String roomType;
	int roomNum;
	double roomPrice;
	String freeDate;
	
	public Room(int roomNum,String roomType){
		if(roomType.matches("Single Bed")){
			this.roomType="Single Bed";
			this.roomPrice=1000;
		}
		else if(roomType.matches("Double Bed")){
			this.roomType="Double Bed";
			this.roomPrice=2000;
		}
		this.roomNum=roomNum;
	}
}