package PharmecyProject;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public static Connection getconnect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "");
    
    return connect;
    }
}
