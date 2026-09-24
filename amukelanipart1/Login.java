/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amukelanipart1;

/**
 *
 * @author Amukelani
 */
class Login {
    String username;
    String password;
    String cellPhoneNumber;
    String firstName;
    String lastName;

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
        // Check if all requirements are met
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
    }
}


