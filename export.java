

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.FileWriter; 

public class export {
  export(){
    try {
      File myObj = new File("filename.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
        FileWriter myWriter = new FileWriter("filename.txt");
        
        try {
        	System.out.println("----View Result----");
            String url ="jdbc:mysql://localhost:3306/student";
    		String user="root";
    		String pw="";
        	Connection connect=DriverManager.getConnection(url,user,pw);
    		
    		Statement statement = connect.createStatement();
    		String query = "SELECT * FROM `data`";
	        ResultSet rs = statement.executeQuery(query);
	        myWriter.write("Year\t course\t grade\t Credits\t\n");
			while (rs.next()) {
				myWriter.write((rs.getString("year"))+"\t"+(rs.getString("course"))+"\t"+(rs.getString("grade"))+"\t"+(rs.getString("credits"))+"\n");

			}
	        statement.close(); 
	        connect.close();
	        myWriter.close();
	        System.out.println("Successfully wrote to the file.");
	        
	        }
	        catch(Exception e){
	            System.out.println(e);
	        }
        
        
        
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
