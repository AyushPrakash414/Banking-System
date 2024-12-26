import java.sql.*;
import java.util.Scanner;

public class user {
    private final Connection connection;
    private final Scanner scanner;

    public user(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    // in userClass we have three  functions->Register,Login,userExist;
    public void register()
    {
        System.out.print("Enter Your Full Name:");
        String full_name=scanner.nextLine();
        System.out.println("Enter your Email:");
        String email=scanner.nextLine();
        if (user_exist(full_name,email))
        {
            System.out.println("User Exist!!");
            return;
        }
        else
        {
            System.out.print("Enter the password you want to set:");
            String password=scanner.nextLine();
            String query="insert into user (full_name,email,user_password) values(?,?,?)";
            try
            {
                PreparedStatement p=connection.prepareStatement(query);
                p.setString(1,full_name);
                p.setString(2,email);
                p.setString(3,password);
                int check=p.executeUpdate();
                if (check>0)
                {
                    System.out.println("You are Successfully Registered");
                }
                else
                {
                    System.out.println("Registration failed");
                }
            }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    public boolean user_exist(String full_name,String email)
    {
        try
        {

            String query="select * from user where email= ?";
            PreparedStatement p=connection.prepareStatement(query);
            p.setString(1,email);;
            ResultSet rs=p.executeQuery();
            return rs.next();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String User_login(Connection connection,Scanner scanner)
    {
        System.out.print("Enter Your Email:");
        String Email=scanner.nextLine();
        System.out.print("Enter the password:");
        String Password=scanner.nextLine();
        String query="select * from user where email= ? and user_password= ?";
        try
        {
            PreparedStatement p=connection.prepareStatement(query);
            p.setString(1,Email);
            p.setString(2,Password);
            ResultSet rs=p.executeQuery();
            if (rs.next())
            {
                return Email;
            }
            else {
                return null;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
