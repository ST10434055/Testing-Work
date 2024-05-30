package st10434055poe;

import javax.swing.JOptionPane;

public class Menu {

    public enum OpeningMenu {
        Register,
        Login,
    }

    public static void PromptMenu() {
    
        Object[] MenuOptions = {OpeningMenu.Register, OpeningMenu.Login,} ;
    
        // Display the menue to the User 
        Object MenuList = JOptionPane.showInputDialog(null, "Please Select an option", "Menu", JOptionPane.QUESTION_MESSAGE, null, MenuOptions, MenuOptions[0]) ;
        System.out.println(MenuList);

        OpeningMenu Option = (OpeningMenu) MenuList;

        
            switch (Option) {
                case Register:
                    // Do something for Option 0
                    Register.promptRegister(); 
                    break;
                case Login:
                    // Do something for Option 1
                    // KanbanMenu.PromptKanBanMenu();       //For Development purposes for easy access 
                    Login.LOGIN();
                    break;
                default:
                    System.out.println("Invalid choice. Please select one of the options");
                    break;
            } 
        
    }
    
}
