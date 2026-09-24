/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package amukelanipart1;

/**
 *
 * @author Amukelani
 */
import java.util.Scanner;

public class AmukelaniPart1 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Registration");

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

        Login user = new Login(
                username,
                password,
                cellPhoneNumber,
                firstName,
                lastName
        );

        // Register user
        System.out.println("Registration results");

        System.out.println(user.registerUser());

        if (user.checkUserName()
                && user.checkPasswordComplexity()
                && user.checkCellPhoneNumber()) {

            System.out.println("Registration successful");

         //Login
            System.out.println("Login");

            System.out.print("Enter your username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter your password: ");
            String loginPassword = input.nextLine();
            
            boolean loginSuccessful =
                    user.loginUser(loginUsername, loginPassword);
            
            System.out.println(
                    user.returnLoginStatus(loginSuccessful)
            );

        } else {

            System.out.println("Please correct your details and register again.");
        }

        input.close();
    }
}
    

