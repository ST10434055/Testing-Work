package st10434055poe;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {


    //Declaring Global variables so that we can access them later
    static String RUname;
    static String RUpassword;
    static String Rname;
    static String Rsurname;
    static int i;

    //Below I used another JOption pane to prompt the user to login...
    public static void LOGIN() {

        JTextField UserName = new JTextField();
        JPasswordField Userpassword = new JPasswordField();

        Object[] fields = {
            "Username:", UserName,
            "Password:", Userpassword,
        };

        int result = JOptionPane.showConfirmDialog(null, fields, "Please Enter Login Details below", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String Uname = UserName.getText();
            String Upassword = String.valueOf(Userpassword.getPassword());
            ValidateLogin(Uname, Upassword); //not needed (Keeping incase)
            if ( ValidateLogin(Uname, Upassword) == true ) {
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
                KanbanMenu.PromptKanBanMenu();
            } else {
                JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");
                LOGIN();
            }
            
        }

        if (result == JOptionPane.CANCEL_OPTION) {
            Menu.PromptMenu();
        }
    }

  

    //This function validates the username and password for the login...
    public static boolean ValidateLogin(String Uname, String Upassword) {
        for ( i = 0; i < User.userCount; i++) {
            if (User.users[i]._username.equals(Uname) && User.users[i]._password.equals(Upassword)) {
                return true;
            }
        } return false;


        // if (RUname.equals(Uname) && RUpassword.equals(Upassword)) {
        //     JOptionPane.showMessageDialog(null, "Welcome "+ Rname +" "+ Rsurname + " ,it is great to see you again");
        // } else {
        //     JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");
        //     Login.LOGIN();
        // }


    }

}
