package metier;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class SingletonConnection {
 private static Connection connection;
    static{
    	try
    	   {
		     //Class.forName("oracle.jdbc.driver.OracleDriver");
		      //connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CAT_PROD","admin");
    		Class.forName("com.mysql.jdbc.Driver");
		     connection = DriverManager.getConnection("jdbc:mysql://localhost/CAT_PROD","root","admin");
		   }
		 catch (Exception e) 
    		{
		      e.printStackTrace();
		    }
    }
    
    
	public static Connection getConnection() {
		return connection;
	}
    
    
}