import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestForConnectionWithDatabase {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/BankingSystemDatabase";
        String password="3151";
        String username="root";
        try(Connection connection= DriverManager.getConnection(url,username,password))
        {
            System.out.println("You Are  connect with dataBase");
        }
        catch (SQLException e)
        {
            System.out.println("You Are not connect with dataBase");
        }
    }
}
