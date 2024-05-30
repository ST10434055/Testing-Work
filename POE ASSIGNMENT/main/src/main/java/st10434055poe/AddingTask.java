package st10434055poe;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class AddingTask {

    public static void AddTask() {
        PromptQuestion2();
        // CreatingTask();
    }

    //Using Code From Register Class to create a similar process
    public static void CreatingTask() {

        JTextField TaskName = new JTextField();
        JTextField TaskDescription = new JTextField();
        JTextField DevName = new JTextField();
        JTextField DevSurname = new JTextField();
        JSpinner TaskDuration = new JSpinner();
        JCheckBoxMenuItem To_Do = new JCheckBoxMenuItem();
        JCheckBoxMenuItem Doing = new JCheckBoxMenuItem();
        JCheckBoxMenuItem Done = new JCheckBoxMenuItem();
        
         ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(To_Do);
        statusGroup.add(Doing);
        statusGroup.add(Done);
        
        
        Object[] fields = {
          "Please Enter the name of your Task", TaskName,
          "Please Enter the Task Description \n (Should not exceed 50 Characters)", TaskDescription,
          "Please Enter the Duration Expected for the Task", TaskDuration,
          "Please Enter Developer Name", DevName,
          "Please Enter Developer Surname", DevSurname,
          "Please Select the status of the TASK\n","To Do",To_Do,"Doing",Doing,"Done",Done
        };

         //Displaying the JOption Pane that Prompts Users for details...
        int result = JOptionPane.showConfirmDialog(null, fields, "Please Enter All User Details", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String Tname = TaskName.getText();
            String Tdescription = TaskDescription.getText();
            int Tduration = (int)TaskDuration.getValue();
            int Number = TaskArray.TaskCount+1;
            String DevName1 = DevName.getText();
            String DevSurname2 = DevSurname.getText();
            String ID = TaskArray.idMaker(Tname, DevSurname2, Number);
            int Nstatus = statusGroup.getButtonCount();
            String Status = "";
            if (Nstatus == 0) {
                 Status = "To Do";
            } else if (Nstatus == 1) {
                 Status = "Doing";
            } else if (Nstatus == 2) {
                 Status = "Done";
            }


            // if (statusGroup.equals(To_Do)) {
            //     Status = "To Do";
            // } else if (statusGroup.equals(Doing)) {
            //     Status = "Doing";
            // } else if (statusGroup.equals(Done)) {
            //     Status = "Done";
            // }

            // if (Tname.equals(null)) {
            //     PromptQuestion2();
            // } else if (Tdescription == null){
            //     PromptQuestion2();
            // }   else if (Tduration <= 0) {
            //     PromptQuestion2();
            // }     else if (DevName1.equals(null)){
            //     PromptQuestion2();
            // }       else if (DevSurname2.equals(null)) {
            //     PromptQuestion2();
            // }         else if (Status.equals(null)) {
            //     PromptQuestion2();
            // } else {
            //     TaskArray Task = new TaskArray(Tname, Tdescription, Tduration, Number, DevName1, DevSurname2, ID ,Status);

            //     TaskArray.addNewTask(Task);
    
            //     TaskArray.printAdded();
            // }

            TaskArray Task = new TaskArray(Tname, Tdescription, Tduration, Number, DevName1, DevSurname2, ID ,Status);

            TaskArray.addNewTask(Task);

            TaskArray.printAdded();
            
        }

        if (result == JOptionPane.CANCEL_OPTION) {
            KanbanMenu.PromptKanBanMenu();
        }

    }

    public enum Question {
        Yes,
        No,
        Quit,
    }

    //Function below prompts the user to select the amount of tasks they want to input
    public static void PromptQuestion2(){

        JSpinner AmountOfTasks = new JSpinner();

        Object[] fields = {
            "Amount of Tasks ", AmountOfTasks,
          };

          int result = JOptionPane.showConfirmDialog(null, fields, "Please Enter the Amount of Tasks you want to add below", JOptionPane.OK_CANCEL_OPTION);

          int x = 0;
          
          if (result == JOptionPane.OK_OPTION) {
                int amountoftasks = (int)AmountOfTasks.getValue();
                while (x < amountoftasks) {
                    CreatingTask();
                    x = x +1;
                }
                //If the user does not select any tasks it asks them to reselect or to quite the program
                if (amountoftasks == 0) {
                    JOptionPane.showMessageDialog(null, "You do not have any tasks, please select an amount of tasks or \"Cancel\" to go back to Kanban Menu" );
                    AddingTask.PromptQuestion2();
                } else {
                    //Displays all tasks and after displays the amount of hours
                    JOptionPane.showMessageDialog(null, "All your tasks will display together after this Message" );
                    JOptionPane.showMessageDialog(null, DisplayTasks());//HERE TO INSERT FUNCTION BY DEVELOPER
                    JOptionPane.showMessageDialog(null, "Your Total Duration in hours is: " + TaskArray.TotalHours());
                }
                
          }
          //If they select cancel it takes them back to the menu
          if (result == JOptionPane.CANCEL_OPTION) {
            KanbanMenu.PromptKanBanMenu();
          }
    }

    //A Loop through the array of tasks so that we can display them in the JOptionPane in the function above
    public static String DisplayTasks(){
        String allTasks = "";
        for (int i = 0; i < TaskArray.ArrayLength; i++) {

            if (!(TaskArray.TaskArr[i] == null)) {
                allTasks += "Task Name: " + TaskArray.TaskArr[i].Tname + "\n"
                + "Number: " + TaskArray.TaskArr[i].Number + "\n"
                + "Description: " + TaskArray.TaskArr[i].Tdescription + "\n"
                + "Developer: " + TaskArray.TaskArr[i].DevName + " " + TaskArray.TaskArr[i].DevSurname + "\n"
                + "Duration: " + TaskArray.TaskArr[i].Tduration + "\n"
                + "ID: " + TaskArray.TaskArr[i].ID + "\n"
                + "Status: " + TaskArray.TaskArr[i].Status + "\n\n";
            }
        }
        return allTasks;
    }
    

}
