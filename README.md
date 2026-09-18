# PROG5121Part_1
Registration and Login

package amukelaniPart1;

public class Login {

    // Variables
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructor
    public Login(String userNameInput, String passwordInput,
                 String cellPhoneInput, String firstNameInput,
                 String lastNameInput) {

        username = userNameInput;
        password = passwordInput;
        cellPhoneNumber = cellPhoneInput;
        firstName = firstNameInput;
        lastName = lastNameInput;
    }

    // Check if username is correctly formatted
    public boolean checkUserName() {

        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    // Check if password is correctly formatted
    public boolean checkPasswordComplexity() {

        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        // Check password length
        if (password.length() < 8) {
            return false;
        }

        // Check each character in the password
        for (int i = 0; i < password.length(); i++) {

            char character = password.charAt(i);

            // Check for capital letter
            if (Character.isUpperCase(character)) {
                hasCapitalLetter = true;
            }

            // Check for number
            if (Character.isDigit(character)) {
                hasNumber = true;
            }

            // Check for special character
            if (!Character.isLetterOrDigit(character)) {
                hasSpecialCharacter = true;
            }
        }

        // Check if all requirements are met
        if (hasCapitalLetter && hasNumber && hasSpecialCharacter) {
            return true;
        } else {
            return false;
        }
    }

    // Check cellphone number
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

        return "Username successfully captured.\n"
                + "Password successfully captured.\n"
                + "Cell phone number successfully added.";
    }

    // Check if the username and password are correct
    public boolean loginUser(String usernameInput, String passwordInput) {

        if (username.equals(usernameInput)
                && password.equals(passwordInput)) {

            return true;

        } else {

            return false;
        }
    }

    // Display login status
    public String returnLoginStatus(boolean loginSuccessful) {

        if (loginSuccessful) {

            return "Welcome " + firstName + " " + lastName
                    + " it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";
        }
    }
}
