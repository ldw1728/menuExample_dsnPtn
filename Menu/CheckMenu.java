package Menu;
public class CheckMenu extends Menu{

    private static CheckMenu instance = null;

    public static CheckMenu getInstance(){
        if(instance == null){
            instance = new CheckMenu();
        }
        return instance;
    }

    private CheckMenu() {
        super("조회", 1);
    }

    

    @Override
    public void print() {
        System.out.println(" - " + this.getMenuName());
    }

    @Override
    public Menu exec(String s) {
        return MenuManager.getMenuInstance("main");
    }
    
}
