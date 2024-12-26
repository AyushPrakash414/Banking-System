import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Accounts {
    private final Connection connection;
    private final Scanner scanner;

    public long Open_Account( String Email)
    {
        if (!AccountExist(Email)) {
        String Full_name, Security_pin;
        System.out.print("Enter the Full Name:");
        Full_name = scanner.nextLine();
        System.out.println("Enter the Initial Amount");
        double Amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter the Security Pin:");
        Security_pin = scanner.nextLine();
        String query = "Insert into accounts (account_number,full_name,email,balance,password) values (?,?,?,?,?)";
        long Account_Number = GenerateAccountNumber();
        try {
            PreparedStatement p = connection.prepareStatement(query);
            p.setLong(1, Account_Number);
            p.setString(2, Full_name);
            p.setString(3, Email);
            p.setDouble(4, Amount);
            p.setString(5, Security_pin);
            int check = p.executeUpdate();
            if (check > 0)
            {
                System.out.println("Account Created Successfully!!");
            }
            else
            {
                throw new RuntimeException("Account Creation Failed!!");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return Account_Number;
    }
    else
    {
        throw new RuntimeException("Account Already Exist In the DataBase");
    }
    }
    public Accounts(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    // this class have 4 Methods Open_Account,GetAccountNumber,GenerateAccountNumber,AccountExist
    public long GetAccountNumber(String Email)
    {
        try
        {
            String query="select account_number from accounts where email=?";
            PreparedStatement p=connection.prepareStatement(query);
            p.setString(1,Email);
            ResultSet r=p.executeQuery();
            if (r.next()) { // Move the cursor to the first row
                return r.getLong(1); // Retrieve the value from the first column
            } else {
                throw new RuntimeException("No account found for the provided email.");
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

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
