# PROG5121Part_1
Registration and Login

package amukelaniPart1;

public class Login {

    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    public Login(String userNameInput, String passwordInput,
                 String cellPhoneInput, String firstNameInput,
                 String lastNameInput) {

        username = userNameInput;
        password = passwordInput;
        cellPhoneNumber = cellPhoneInput;
        firstName = firstNameInput;
        lastName = lastNameInput;
    }
    public boolean checkUserName() {

        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPasswordComplexity() {

        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        if (password.length() < 8) {
              return false;
        }

        for (int i = 0; i < password.length(); i++) {

            char character = password.charAt(i);

            if (Character.isUpperCase(character)) {
                hasCapitalLetter = true;
            }

        
            if (Character.isDigit(character)) {
                hasNumber = true;
            }
            
            if (!Character.isLetterOrDigit(character)) {
                hasSpecialCharacter = true;
            }
        }
    
        if (hasCapitalLetter && hasNumber && hasSpecialCharacter) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkCellPhoneNumber() {

        if (cellPhoneNumber.matches("^\\+27[0-9]{9}$")) {
            return true;
        } else {
            return false;
        }
    }

    // Register the user
    public String registerUser() {

        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "Username successfully captured."
                + "Password successfully captured."
                + "Cell phone number successfully added.";
    }

    public boolean loginUser(String usernameInput, String passwordInput) {

        if (username.equals(usernameInput)
                && password.equals(passwordInput)) {

            return true;

        } else {

            return false;
        }
    }

    public String returnLoginStatus(boolean loginSuccessful) {

        if (loginSuccessful) {

            return "Welcome " + firstName + " " + lastName
                    + " it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";
        }

        //Registration Main class
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create Scanner
        Scanner input = new Scanner(System.in);

        // Ask the user for their information
        System.out.println("REGISTRATION");

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter a username: ");
        String username = input.nextLine();

        System.out.print("Enter a password: ");
        String password = input.nextLine();

        System.out.print("Enter your South African cellphone number: ");
        String cellPhoneNumber = input.nextLine();

        // Create Login object
        Login user = new Login(
                username,
                password,
                cellPhoneNumber,
                firstName,
                lastName
        );

        // Register user
        System.out.println("REGISTRATION RESULTS");

        System.out.println(user.registerUser());

        // Check if registration was successful
        if (user.checkUserName()
                && user.checkPasswordComplexity()
                && user.checkCellPhoneNumber()) {

            System.out.println("Registration successful!");

            // Login section
            System.out.println("LOGIN");

            System.out.print("Enter your username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter your password: ");
            String loginPassword = input.nextLine();

            // Check login
            boolean loginSuccessful =
                    user.loginUser(loginUsername, loginPassword);

            // Display login message
            System.out.println(
                    user.returnLoginStatus(loginSuccessful)
            );

        } else {

            System.out.println("Please correct your details and register again.");
        }

        input.close();
    }
}
//login test

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginTest {

    // Test username
    @Test
    public void testUsername() {

        Login user = new Login(
                "u_1",
                "Password1!",
                "+27821234567",
                "John",
                "Smith"
        );

        assertTrue(user.checkUserName());
    }

    // Test incorrect username
    @Test
    public void testIncorrectUsername() {

        Login user = new Login(
                "john123",
                "Password1!",
                "+27821234567",
                "John",
                "Smith"
        );

        assertFalse(user.checkUserName());
    }

    // Test password
    @Test
    public void testPassword() {

        Login user = new Login(
                "u_1",
                "Password1!",
                "+27821234567",
                "John",
                "Smith"
        );

        assertTrue(user.checkPasswordComplexity());
    }

    // Test incorrect password
    @Test
    public void testIncorrectPassword() {

        Login user = new Login(
                "u_1",
                "password",
                "+27821234567",
                "John",
                "Smith"
        );

        assertFalse(user.checkPasswordComplexity());
    }

    // Test cellphone number
    @Test
    public void testCellPhoneNumber() {

        Login user = new Login(
                "u_1",
                "Password1!",
                "+27821234567",
                "John",
                "Smith"
        );

        assertTrue(user.checkCellPhoneNumber());
    }

    // Test incorrect cellphone number
    @Test
    public void testIncorrectCellPhoneNumber() {

        Login user = new Login(
                "u_1",
                "Password1!",
                "0821234567",
                "John",
                "Smith"
        );

        assertFalse(user.checkCellPhoneNumber());
    }

    // Test successful login
    @Test
    public void testSuccessfulLogin() {

        Login user = new Login(
                "u_1",
                "Password1!",
                "+27821234567",
                "John",
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
                "u_1",
                "Password1!",
                "+27821234567",
                "John",
                "Smith"
        );

        assertFalse(
                user.loginUser("wrong", "wrong")
        );
    }
}
    }
}
