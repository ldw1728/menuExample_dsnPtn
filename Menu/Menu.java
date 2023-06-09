package Menu;

import java.util.Scanner;


/*
 * template method pattern
 * 특정 작업을 처리하는 일부분을 서브클래스로 캡슐화
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

    // 공통적으로 처리되는 특정작업인 template 메서드
    // 모든 메뉴는 해당 메소드가 실행되어 메뉴에 대한 처리를 하지만 구체적인 작업은 각 메뉴마다 다를 수있다.
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

    // 서브클래스에서 구현될 hook 메소드
    public abstract Menu exec(String s);
    public abstract void print();

}
