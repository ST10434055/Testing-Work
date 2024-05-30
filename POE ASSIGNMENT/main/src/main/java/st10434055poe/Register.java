package st10434055poe;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Register {

    

    //This is where the function is called so that i can take it to main page to run
    static void promptRegister(){

        register();
        Menu.PromptMenu();
        
    }

    public static void register() {


        //Using Code that we learnt in ICETASK4 to create a JOptionpane to allow user to enter all details at once

        JTextField UserName = new JTextField();
        JPasswordField userPassword = new JPasswordField();
        JTextField NAME = new JTextField();
        JTextField SURNAME  = new JTextField();

        Object[] fields = {
            "Username:", UserName,
            "*(Username must be Contain an \"_\" and no more than 5 chracters long) \n \n Password:", userPassword,
            "*(Password must be atleast 8 characters long -Contain a capital letter -Contain a number -Contain a special character) \n \nName:", NAME,
            "Surname:", SURNAME,
        };
        
        //Displaying the JOption Pane that Prompts Users for details...
        int result = JOptionPane.showConfirmDialog(null, fields, "Please Enter All User Details", JOptionPane.OK_CANCEL_OPTION);
        
        //When the user enters details we need to get the detials in order to manipulate them to our requirements...
        if (result == JOptionPane.OK_OPTION) {
            String Uname = UserName.getText();
            String Upassword = String.valueOf(userPassword.getPassword());
            String name = NAME.getText();
            String surname = SURNAME.getText();
            // User a = new User(Uname, Upassword, name, surname); - ARRAY ATTEMPT
            // User newUser = new User(Uname, Upassword, name, surname);
            // UserManager.addUser(newUser);
        //Calling the functions here and inputing the variables so that it allows me to use them elsewhere.
            CheckUserName(Uname);    
            CheckPassword(Upassword);
            registerUser(Uname, Upassword);
           // Login.RegisterDetails(Uname, Upassword, name, surname); temporary incase need a run back
            User user = new User(Uname, Upassword, name, surname);
            User.addNewUser(user);
            
        }
        
   }
   


public static boolean CheckUserName(String Uname) {
        
    //Declares Underscore variable
    //Then used by a for loop to ittirate over the string to check for an underscore
    char Underscore = '_';
   

        if (Uname!= null && Uname.length() < 6 ) {
            for (int i = 0; i < Uname.length(); i++) {
                if (Uname.charAt(i) == Underscore) {
                    return true;
             }
         }
     }
    return false;
   } 
   

   public static boolean CheckPassword(String Upassword) {

    // Using a nested if statement for Checking Password Requirements are met
    
    if (Upassword!= null && Upassword.length() >= 8) {
        for (int i = 0; i < Upassword.length(); i++) {
            if (Character.isUpperCase(Upassword.charAt(i))) {
                for (int j = 0; j < Upassword.length(); j++) {
                    if (Character.isDigit(Upassword.charAt(j))) {
                        for (int j2 = 0; j2 < Upassword.length(); j2++) {
                            if (!(Character.isLetterOrDigit(Upassword.charAt(j2)))) {
                                return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
   }

   
   //If Username and Password are correct then display the results and correct if needed.
   public static void registerUser(String Uname,String Upassword) {
    
    boolean CorrectUsername = CheckUserName(Uname);
    boolean CorrectUPassword = CheckPassword(Upassword);

        if ( CorrectUsername == true ) {
            JOptionPane.showMessageDialog(null, "Username successfully captured");
            
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length .");
            promptRegister();
        }


        //Decided to nest this proceess with the above IF statement so that it only runs once.

        if ( CorrectUPassword == true ) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
            promptRegister();
        }

        User users = new User(Uname, Upassword, Uname, Uname);

        if (CheckUserName(Uname) && CheckPassword(Upassword)) {
            User.users[User.userCount] = users;
            User.userCount++;
        }


    //     if ( CorrectUPassword == true ) {
    //         JOptionPane.showMessageDialog(null, "Password successfully captured");
    //    } else {
    //         JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
    //         promptRegister();
    //      }
   }


   

    



}
