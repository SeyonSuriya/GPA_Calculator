
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.Scanner;

public class view_results {
    view_results(){
        System.out.println("----View Result----");
        System.out.println("Current GPA: ");
        System.out.println("No.of subjects: ");
        System.out.println("Total Credits: ");


        System.out.println("To view records:");
        System.out.println("1. Year 1");
        System.out.println("2. Year 2");
        System.out.println("3. Year 3");
        System.out.println("4. Year 4");
        System.out.println();
        System.out.println("0. Back");
        System.out.println();
        System.out.println("Enter your choice: ");

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        String url ="jdbc:mysql://localhost:3306/student";
		String user="root";
		String pw="";
		Connection connect=DriverManager.getConnection(url,user,pw);
		
		Statement statement = connect.createStatement();
		String query;

        switch(number){
            case(1):
            	query = "SELECT * FROM `data` WHERE 'data'=1";
            	break;
            case(2):
            	query = "SELECT * FROM `data` WHERE 'data'=2";
            	break;
            case(3):
            	query = "SELECT * FROM `data` WHERE 'data'=3";
            	break;
            case(4):
            	query = "SELECT * FROM `data` WHERE 'data'=4";
            	break;
        }
        input.close();
        ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			System.out.println("course code - "+(rs.getString("course")) );
			System.out.println("Grade - "+(rs.getString("grade")) );
			System.out.println("Credits - "+(rs.getString("credits")+"\n") );
		}
        statement.close(); 
        connect.close();

        System.out.println("To delete your records press d");
        System.out.println("To go back press 0");

        System.out.println("Enter your choice:");
        Scanner input2 = new Scanner(System.in);



    }
}


