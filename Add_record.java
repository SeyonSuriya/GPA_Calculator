

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
public class Add_record {
    Scanner scanner = new Scanner(System.in);
    Add_record(){
        System.out.println("----ADD results----");

        
        //System.out.println("year - course - grade - credits\n"+year+" "+ course+" "+ grade+ " "+ credits+" "+get_gpv(grade) );
        get_confirm();
    }

    int get_year(){
        int temp_year=0;
        try{
            System.out.print("Year (1,2,3,4) : ");
            temp_year = scanner.nextInt();
            String temp = scanner.nextLine();
            if (temp_year>0 && temp_year<5){
                return temp_year;
            }
            else{
                System.out.println("0<year<5");
                get_year();
            }
        }
        catch(Exception e){
            String temp = scanner.nextLine();
            System.out.println("Something went wrong.");
            get_year();
        }
        return temp_year;
    }
    String get_course(){
        String temp_course="";
        try{
            System.out.print("Course Code : ");
            temp_course = scanner.nextLine();
            //System.out.print(temp_course+"666666");
            return temp_course;
        }
        catch(Exception e){
            System.out.println("Something went wrong.");
            get_course();
        }
        return temp_course;
    }


    String get_grade(){
        String temp_grade ="";
        try{
            System.out.print("Grade : ");
            temp_grade =scanner.nextLine();
            double temp_GPV2=get_gpv(temp_grade);
            if (temp_GPV2==-1){
                get_grade();
            }
            else{
                return temp_grade;
            }
        }
        catch(Exception e){
            System.out.println("Something went wrong.");
            get_grade();
        }
        return temp_grade;
    }
    int get_credits(){
        int temp_credits=0;
        try{
            System.out.print("Credits : ");
            temp_credits =scanner.nextInt();
            return temp_credits;
        }
        catch(Exception e){
            System.out.println("Something went wrong.");
            get_year();
        }
        return temp_credits;
    }
    void get_confirm(){
        int year=get_year();
        String course=get_course();
        String grade=get_grade();
        int credits=get_credits();
        char temp_confirm =' ';
        System.out.print("Confirm (y/n) : ");
        temp_confirm =scanner.next().charAt(0);
        int temp_asc=temp_confirm;
        if (temp_asc==121){
        	try{
                String url ="jdbc:mysql://localhost:3306/student";
        		String user="root";
        		String pw="";
        		Connection connect=DriverManager.getConnection(url,user,pw);
        		
        		Statement statement = connect.createStatement();
        		
        		String query = "INSERT INTO `data` (`Year`, `course`, `Grade`, `credits`, `gpv`) VALUES ('"+year+"', '"+course+"', '"+ grade+"', '"+ credits+"', '"+get_gpv(grade)+"')";
                PreparedStatement preparedstatement = connect.prepareStatement(query);
                statement.executeUpdate(query);
                statement.close(); 
                connect.close();
                System.out.println("Record was added");
            }
            catch(Exception e){
                System.out.println(e);
            }       
        }
        else if (temp_asc==110){
        	
            System.out.println("Record was not added");
        }
        else{
            get_confirm();
        }   
    }
    double get_gpv(String temp_g){
        double temp_gpv;
        if (temp_g.equals("A+")){
            temp_gpv=4.0;
        }
        else if (temp_g.equals("A")){
            temp_gpv=4.0;
        }
        else if (temp_g.equals("A-")){
            temp_gpv=3.7;
        }
        else if (temp_g.equals("B+")){
            temp_gpv=3.3;
        }
        else if (temp_g.equals("B")){
            temp_gpv=3.0;
        }
        else if (temp_g.equals("B-")){
            temp_gpv=2.7;
        }
        else if (temp_g.equals("C+")){
            temp_gpv=2.3;
        }
        else if (temp_g.equals("C")){
            temp_gpv=2.0;
        }
        else if (temp_g.equals("C-")){
            temp_gpv=1.7;
        }
        else if (temp_g.equals("D+")){
            temp_gpv=1.3;
        }
        else if (temp_g.equals("D")){
            temp_gpv=1.0;
        }
        else if (temp_g.equals("E")){
            temp_gpv=0.0;
        }
        else{
            temp_gpv=-1.0;
        }
        return(temp_gpv);
    }
}
