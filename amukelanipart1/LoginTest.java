/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Amukelani
 */
public class LoginTest {
    
   // Test username
    @Test
    public void testUsername() {

        Login user = new Login(
                "Kyl_1",
                "Password1!",
                "+27821234567",
                "Kyle",
                "Smith"
        );

        assertTrue(user.checkUserName());
    }

    // Test incorrect username
    @Test
    public void testIncorrectUsername() {

        Login user = new Login(
                "kyle123",
                "Password1!",
                "+27821234567",
                "Kyle",
                "Smith"
        );

        assertFalse(user.checkUserName());
    }

    // Test password
    @Test
    public void testPassword() {

        Login user = new Login(
                "Kyl_1",
                "Password1!",
                "+27821234567",
                "Kyle",
                "Smith"
        );

        assertTrue(user.checkPasswordComplexity());
    }

    // Test incorrect password
    @Test
    public void testIncorrectPassword() {

        Login user = new Login(
                "Kyl_1",
                "password",
                "+27821234567",
                "Kyle",
                "Smith"
        );

        assertFalse(user.checkPasswordComplexity());
    }

    // Test cellphone number
    @Test
    public void testCellPhoneNumber() {

        Login user = new Login(
                "Kyl_1",
                "Password1!",
                "+27821234567",
                "Kyle",
                "Smith"
        );

        assertTrue(user.checkCellPhoneNumber());
    }

    // Test incorrect cellphone number
    @Test
    public void testIncorrectCellPhoneNumber() {

        Login user = new Login(
                "Kyl_1",
                "Password1!",
                "0821234567",
                "Kyle",
                "Smith"
        );

        assertFalse(user.checkCellPhoneNumber());
    }

    // Test successful login
    @Test
    public void testSuccessfulLogin() {

        Login user = new Login(
                "Kyl_1",
                "Password1!",
                "+27821234567",
                "Kyle",
                "Smith"
        );

        assertTrue(
                user.loginUser("u_1", "Password1!")
        );
    }

    // Test unsuccessful login
    @Test
    public void testUnsuccessfulLogin() {

        Login user = new Login(
                "Kyl_1",
                "Password1!",
                "+27821234567",
                "Kyle",
                "Smith"
        );

        assertFalse(
                user.loginUser("wrong", "wrong")
        );
    }
}