import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountsManager {
    private final Connection connection;
    private final Scanner scanner;

    public AccountsManager(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    // In this class we have 4 method 1->Credit Money 2-> Debit Money
    //3-> Transfer Money  4->Get Balance;

    public void Debit_Money(long Account_Number)
    {
        double Amount;
        String password;
        System.out.println("Enter the Amount:");
        Amount=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter the Security Pin:");
        password=scanner.nextLine();
        if (Account_Number!=0)
        {
            String query="Select * from accounts where account_number= ? and password= ?";
            try
            {
                PreparedStatement p=connection.prepareStatement(query);
                p.setLong(1,Account_Number);
                p.setString(2,password);
                ResultSet r=p.executeQuery();
                if (r.next())
                {
                    double amt=r.getDouble("balance");
                    if (amt<Amount)throw new RuntimeException("Your Amount is more than Current Amount!!");
                    String Query="update accounts set balance=balance- ? where account_number= ?";
                    PreparedStatement P=connection.prepareStatement(Query);
                    P.setDouble(1,Amount);
                    P.setLong(2,Account_Number);
                    int check=P.executeUpdate();
                    if (check>0)
                    {
                        System.out.println(Amount + "is Debited successfully");
                    }
                    else
                    {
                        System.out.println("Failed!!!");
                    }
                }
            }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("Account Number Is Wrong");
        }
    }

    public void Credit_Money(long Account_Number)
    {
        double Amount;
        String password;
        System.out.println("Enter the Amount:");
        Amount=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter the Security Pin:");
        password=scanner.nextLine();
        if (Account_Number!=0)
        {
            String query="Select * from accounts where account_number= ? and password= ?";
            try
            {
                PreparedStatement p=connection.prepareStatement(query);
                p.setLong(1,Account_Number);
                p.setString(2,password);
                ResultSet r=p.executeQuery();
                if (r.next())
                {
                   // double amt=r.getDouble("balance");
                    String Query="update accounts set balance=balance+ ? where account_number= ?";
                    PreparedStatement P=connection.prepareStatement(Query);
                    P.setDouble(1,Amount);
                    P.setLong(2,Account_Number);
                    int check=P.executeUpdate();
                    if (check>0)
                    {
                        System.out.println(Amount + "is Credited successfully");
                    }
                    else
                    {
                        System.out.println("Failed!!!");
                    }
                }
            }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("Account Number Is Wrong");
        }
    }

    public double GetBalance(Long Account_Number)
    {
        String Password;
        System.out.println("Enter Your Security Pin:");
        Password= scanner.nextLine();
        if (Account_Number!=0)
        {
            String query="Select * from accounts where account_number= ? and password= ?";
            try
            {
                PreparedStatement p=connection.prepareStatement(query);
                p.setLong(1,Account_Number);
                p.setString(2,Password);
                ResultSet r=p.executeQuery();
                if (r.next())
                {
                    return r.getDouble("balance");
                }
                else {
                    throw new RuntimeException("Security Pin Is Wrong");
                }
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            throw new RuntimeException("AccountNumber is Wrong");
        }
        return 0.0;
    }
    public void Transfer_Money(Long Account_Number_Sender,Long Account_Number_Receiver)
    {
        String Password;
        System.out.println("Enter The Security Pin:");
        Password=scanner.nextLine();
        if (Account_Number_Sender!=0&&Account_Number_Receiver!=0)
        {
            String query="Select * from accounts where account_number= ? and password= ?";
            String query2="Select * from accounts where account_number= ?";
            try
            {
                PreparedStatement p=connection.prepareStatement(query);
                p.setLong(1,Account_Number_Sender);
                p.setString(2,Password);
                ResultSet r=p.executeQuery();
                //Checking Receiver Accounts
                PreparedStatement p2=connection.prepareStatement(query2);
                p2.setDouble(1,Account_Number_Receiver);
                ResultSet r2=p.executeQuery();
                if (r.next()&&r2.next())
                {
                    double Amount1,Amount2;
                }
                else
                {
                    throw new RuntimeException("!!Failed!!");
                }
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            throw new RuntimeException("Any Account Number is wrong!!!");
        }
    }

}
