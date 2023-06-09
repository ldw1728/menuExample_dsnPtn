package Menu;

public class DelMenu extends Menu{

    private static DelMenu instance = null;

    public static DelMenu getInstance(){
        if(instance == null){
            instance = new DelMenu();
        }
        return instance;
    }

    protected DelMenu() {
        super("삭제", 3);
    }

    @Override
    public Menu exec(String s) {
        return MenuManager.getMenuInstance("main");
    }

    @Override
    public void print() {
        System.out.println(" - " + this.getMenuName());
    }
    
}
