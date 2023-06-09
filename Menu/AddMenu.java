package Menu;
public class AddMenu extends Menu{

    private static AddMenu instance = null;

    public static AddMenu getInstance(){
        if(instance == null){
            instance = new AddMenu();
        }
        return instance;
    }

    private AddMenu() {
        super("등록", 2);
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
