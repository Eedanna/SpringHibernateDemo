import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class TestDB.
 */
public class TestDB {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		try
		{
		String url = "jdbc:mysql://localhost:3307/test";
		String user = "root";
		String password = "lg225295";

		// Load the Connector/J driver
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		// Establish connection to MySQL
		Connection conn = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
