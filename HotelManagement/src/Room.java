class Room{
	String roomType;
	int roomNum;
	double roomPrice;
	boolean roomAvail;
	String freeDate;
	
	public Room(int roomType,int roomNum){
		if(roomType==1){
			this.roomType="Single Bed";
			this.roomPrice=1000;
		}
		else if(roomType==2){
			this.roomType="Double Bed";
			this.roomPrice=2000;
		}
		this.roomNum=roomNum;
		this.roomAvail=true;
		this.freeDate=null;
	}
}