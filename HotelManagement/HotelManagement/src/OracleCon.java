import java.sql.*;  
class OracleCon{  
	public Statement connectionDb(){  
	try{  
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:orcl","system","Qwerty123");  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		  
//		//step4 execute query  
//		ResultSet rs=stmt.executeQuery("select * from hotel");  
//		while(rs.next())  
//		System.out.println(rs.getString(1));  
//		System.out.print("Ys");  
//		//step5 close the connection object  
//		con.close();  
		return stmt;
		  
		}
	catch(Exception e){
			System.out.println(e);
		}  
		 
	return null;
	}  
}