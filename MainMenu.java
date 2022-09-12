

import java.util.Scanner;
public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    MainMenu(String u_name){
        System.out.println("----GPA Calculator----\n");
        System.out.println("Hello"+ u_name +", Welcome back! \n");
        System.out.println("----Menu----");
        System.out.println("1. View results \n2. Add results \n3. Export data \n4. Clear data \n5. Exit");
        getSelection();

    }
    
    void getSelection(){
        int choice;
        System.out.print("\nEnter your choice: ");
        choice=scanner.nextInt();

        switch (choice){
            case 1:
                view_results rr=new view_results();
                break;
            case 2:
            	 Add_record ar=new Add_record();
                //statement
                break;
            case 3:
            	
            	export arss=new export();
                break;
            case 4:
            	System.exit(0);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("** Oops! Wrong selection. Try again **");
                getSelection();
                break;
            }
    }   
}