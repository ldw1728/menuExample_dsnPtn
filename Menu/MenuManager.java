package Menu;

import java.util.Scanner;

public class MenuManager {

    public MenuManager(){
        
    }
    
    public void startMenu(){

        Scanner sc = new Scanner(System.in);

        Menu currMenu = MenuManager.getMenuInstance("main");

        while(true){
            currMenu = currMenu.operation(sc);
        }
    }


    /* simple factory with singlton*/
    public static Menu getMenuInstance(String menuName){

        Menu rtnMenu = null;

        switch(menuName){
            case "add" : 
                rtnMenu = AddMenu.getInstance();
                break;
            case "check" :
                rtnMenu = CheckMenu.getInstance();
                break;
            case "main" : {
                MainMenu mainMenu = MainMenu.getInstance();
                mainMenu.addMenu(AddMenu.getInstance());
                mainMenu.addMenu(CheckMenu.getInstance());
                mainMenu.addMenu(DelMenu.getInstance());
                rtnMenu = mainMenu;  
                break;             
            }
        }
        return rtnMenu;
    }
}
