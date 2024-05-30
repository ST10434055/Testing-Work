package st10434055poe;

public class User {


    // public static String[] UserDetails = new String[4];

    String _username;
    String _password;
    String _name;
    String _surname;

    public User(String username, String password, String name, String surname) {
        this._username = username;
        this._password = password;
        this._name = name;
        this._surname = surname;

    }

    static int ArrayLength = 5;
    public static User[] users = new User[ArrayLength];
    public static int userCount = 0;

    public static void addNewUser(User user) {
        users[userCount] = user;
        userCount++;
    }
}
    

