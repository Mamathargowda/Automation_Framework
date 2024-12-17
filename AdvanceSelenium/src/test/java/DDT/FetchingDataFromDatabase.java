package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchingDataFromDatabase {

	public static void main(String[] args) throws Throwable {
		Driver refDriver = new Driver();
		DriverManager.registerDriver(refDriver);
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "root");
	    Statement state = conn.createStatement();
	    String Query = "select * from students";
	    

	}

}
