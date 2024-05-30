package st10434055poe;

import javax.swing.JOptionPane;

public class KanbanMenu {

      public enum KanbanOptionMenu {
        AddTasks,
        ShowReport,
        Quit
    }

    //Below is the code for the Kanban Menu
    public static void PromptKanBanMenu() {
    
        //Creating the object array
        Object[] KanbanMenuOptions = {KanbanOptionMenu.AddTasks, KanbanOptionMenu.ShowReport, KanbanOptionMenu.Quit} ;
    
        // Display the menue to the User 
        Object MenuList = JOptionPane.showInputDialog(null, "Please Select an option", "Menu", JOptionPane.QUESTION_MESSAGE, null, KanbanMenuOptions, KanbanMenuOptions[0]) ;
        System.out.println(MenuList);

        KanbanOptionMenu Option = (KanbanOptionMenu) MenuList;

            //If they press cancel it brings them to the register and login menu again
            if (MenuList == null) {
                Menu.PromptMenu();
            }

            //The options and what they do
            switch (Option) {
                case AddTasks:
                    // Adding a task to the kanban board
                    AddingTask.AddTask();
                    break;
                case ShowReport:
                    // Tells them the function of this choice is coming soon
                   JOptionPane.showMessageDialog(null, "These Functions are coming soon!");
                   PromptKanBanMenu();
                    break;
                case Quit:
                    //Quites
                    JOptionPane.showMessageDialog(null, "Bye, You have Quit the program");
                default:
                    System.out.println("Invalid choice. Please select one of the options");
                    break;
            }

            
          
        
    }

}
