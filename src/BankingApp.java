import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BankingApp {
     private static final String url="jdbc:mysql://localhost:3306/BankingSystemDatabase";
    private static final String password="3151";
    private static final String username="root";

    public static void main(String[] args) {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");//load The driver
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            Connection connection= DriverManager.getConnection(url,username,password);
            Scanner scanner=new Scanner(System.in);
            AccountsManager Ayush=new AccountsManager(connection,scanner);
            System.out.println(Ayush.GetBalance(2312002L));
        }
        catch (SQLException e)
        {
            System.out.println("You Are not connect with dataBase");
        }

    }
}
