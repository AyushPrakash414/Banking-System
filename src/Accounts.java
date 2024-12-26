import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Accounts {
    private final Connection connection;
    private final Scanner scanner;

    public Accounts(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    // this class have 4 Methods Open_Account,GetAccountNumber,GenerateAccountNumber,AccountExist

    public long GenerateAccountNumber()
    {
        String query="Select account_number from accounts order by account_number DESC limit 1";
        long acc=2312001;
        try
        {

            PreparedStatement p=connection.prepareStatement(query);
            ResultSet r=p.executeQuery();
            if (r.next())
            {
                return ++acc;
            }
            else
            {
                return acc;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return acc;
    }

    public boolean AccountExist(String Email)
    {
        String query="Select * from accounts where email= ?";
        try
        {
            PreparedStatement p=connection.prepareStatement(query);
            p.setString(1,Email);
            ResultSet r=p.executeQuery();
            return r.next();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;

    }
}
