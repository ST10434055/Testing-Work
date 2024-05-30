package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import st10434055poe.Register;

public class RegisterTest {
    @Test
    public void testCheckPasswordFalse() {
        boolean Value=Register.CheckPassword("password");
        assertEquals(false, Value);
        System.out.println(Value);
    }

    @Test
    public void testValidationUserNameTrue() {
        boolean Value=Register.CheckUserName("Kyl_1");
        assertEquals(true,Value);
        System.out.println(Value);
    }

    @Test
    public void testCheckPasswordTrue() {
        boolean Value=Register.CheckPassword("Ch&&sec@ke99!");
        assertEquals(true,Value);
        System.out.println(Value);

    }

    @Test
    public void testCheckUserNameFalse() {
        boolean Value=Register.CheckUserName("Kyle!!!!!!!!!");
        assertEquals(false,Value);
        System.out.println(Value);
    }
}
