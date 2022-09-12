
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
public class reg {
	String u_name;
    Scanner scanner = new Scanner(System.in);
    reg(){
        System.out.println("----GPA Calculator----");
        get_data();
        
    }
    void get_data(){
        
        int c_duration;
        try{
            u_name=get_name();

            try{
                c_duration=get_duration();
                scanner.close();
                String url ="jdbc:mysql://localhost:3306/student";
        		String user="root";
        		String pw="";
        		Connection connect=DriverManager.getConnection(url,user,pw);
        		
        		Statement statement = connect.createStatement();
        		String query = "INSERT INTO `user` (`name`, `course_dura`)"+ "VALUES ('"+u_name+"', '"+c_duration+"')";
                PreparedStatement preparedstatement = connect.prepareStatement(query);
                statement.executeUpdate(query);
                statement.close(); 
                connect.close();
                System.out.println("Congratulation. User regestraton success");
            }
            catch(Exception e){
                System.out.println(e);
            }

            
            
        }
        catch(Exception e){
            System.out.println("Something went wrong.");
            get_data();
        }
    }


    String get_name(){
        String name;
        
        System.out.print("Enter Your name : ");
        name = scanner.nextLine();
        return name;
    }

    int get_duration(){
        System.out.print("Course duration(in years) : ");
        int duration =scanner.nextInt();
        return duration;
    }
}




