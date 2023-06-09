package Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 * composite pattern  
 * 
 */
public class MainMenu extends Menu{

    private static MainMenu instance = null;
    private List<Menu> menus;

    public static MainMenu getInstance(){
        if(instance == null){
            instance = new MainMenu();
        }

        return instance;
    }

    private MainMenu() {
        super("메인", 0);
        menus = new ArrayList<>();
    }

    private boolean isExist(Menu menu){
        return this.menus.contains(menu);
    }

    public void addMenu(Menu menu){
        if(!isExist(menu)){
            this.menus.add(menu);
        }
    }

    public void removeMenu(Menu menu){
        if(isExist(menu)){
            this.menus.remove(menu);
        }
    }

    public Menu getMenu(int num){
        return this.menus.get(num-1);
    }

    @Override
    public void print() {
        Collections.sort(this.menus, (m1, m2) -> m1.getPriority() - m2.getPriority());
        for(int i = 0 ; i < this.menus.size() ; i++){
            System.out.print( (i+1) + ". ");
            this.menus.get(i).print();
        }
    }

    @Override
    public Menu exec(String s) {

        Menu resMenu = this;

        try{
            int intVal = Integer.valueOf(s);
            resMenu = getMenu(intVal);
            
        }catch(NumberFormatException e){
            System.out.println(" ! 번호를 입력하세요. ! ");
        }catch(IndexOutOfBoundsException i){
            System.out.println(" ! 해당 메뉴를 찾을 수 없습니다. ! ");
            resMenu = this;
        }
        
        return resMenu;
        
    }
    
}
