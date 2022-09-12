

import java.sql.*;

public class app {
    public static void main(String args[]){
    	String user_name;
        try{
            String url ="jdbc:mysql://localhost:3306/student";
    		String user="root";
    		String pw="";
    		Connection connect=DriverManager.getConnection(url,user,pw);
    		
    		Statement statement = connect.createStatement();
    		String query = "SELECT * FROM `user`";
            
    		ResultSet rs = statement.executeQuery(query);
    		rs.next();
    		user_name=(rs.getString("name"));
            statement.close(); 
            connect.close();
        }
        catch(Exception e){
            //System.out.println(e);
            reg aaa=new reg();
        	user_name=aaa.u_name;
        }
        MainMenu aaaaa= new MainMenu(user_name);
        

        
    }
}
