package hospital.management.system;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class Connect {

    Connection connection;
    Statement statement;

    public Connect(){

        // url format -> "jdbc:mysql://localhost:3306/your_database_name";

        String url = "jdbc:mysql://127.0.0.1:3306/hospital_management_system";
        String user = "root";
        String password = "Suman@200500";

        try{
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        }
        catch(Exception e){ 
            e.printStackTrace();
        }
    }
}
