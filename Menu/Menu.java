package Menu;

import java.util.Scanner;


/*
 * template method pattern
 */
public abstract class Menu {

    private String menuName;
    private int priority;

    protected Menu(String menuName, int priority){
        this.menuName = menuName;
        this.priority = priority;
    }

    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Menu operation(Scanner sc){

        Menu    rtnMenu = null;
        String  inputStr = "";
        
        //해당 메뉴가 가지고있는 하위메뉴 출력
        this.print();

        System.out.print(" -> ");
        inputStr = sc.nextLine();

        if(":q".equals(inputStr)){
            System.exit(0);
        }

        // inputData에대한 해당메뉴의 작업 실행.
        rtnMenu = this.exec(inputStr);
        System.out.println("");

        return rtnMenu;
    }

    public abstract Menu exec(String s);
    public abstract void print();

}
