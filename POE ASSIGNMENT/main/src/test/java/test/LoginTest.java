package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import st10434055poe.Login;
import st10434055poe.User;

public class LoginTest {
    @Test
    public void testValidateLoginTrue() {   
        User.userCount = 1;
        User.users[0] = new User("Kyl_1","Ch&&sec@ke99!","Kyle","James");


        boolean Value=Login.ValidateLogin("Kyl_1","Ch&&sec@ke99!");
        assertTrue(Value);
        System.out.println(Value);
    }
    @Test
    public void testValidateLoginFalse() {   
        User.userCount = 1;
        User.users[0] = new User("Kyl_1","Ch&&sec@ke99!","Kyle","James");


        boolean Value=Login.ValidateLogin("Kyle!!!!","password");
        assertFalse(Value);
        System.out.println(Value);
    }

}
