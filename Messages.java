/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amukelani
 */
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Messages {

    // Stores messages sent during the program
    private static ArrayList<Message> sentMessages = new ArrayList<>();

    // Stores messages that were disregarded
    private static ArrayList<Message> disregardedMessages = new ArrayList<>();

    // Stores messages saved for later
    private static ArrayList<Message> storedMessages = new ArrayList<>();

    // Total number of messages sent
    private static int totalMessages = 0;

    // Message class
    static class Message {

        // Private variables
        private String messageID;
        private int messageNumber;
        private String recipient;
        private String message;
        private String hash;
        private String status;

        // Constructor
        public Message(
                String recipient,
                String messageContent,
                int messageNumber,
                String messageID) {

            this.recipient = recipient;
            this.message = messageContent;
            this.messageNumber = messageNumber;

            // Generate an ID if one was not provided
            if (messageID == null || messageID.trim().isEmpty()) {
                this.messageID = generateMessageID();
            } else {
                this.messageID = messageID;
            }

            this.hash = createMessageHash(
                    this.messageID,
                    messageNumber,
                    messageContent
            );

            this.status = checkMessageLength(messageContent);
        }

        // Generates a random message ID
        private String generateMessageID() {
            Random random = new Random();
            long id = 1000000000L + random.nextInt(900000000);
            return String.valueOf(id);
        }

        // Methods to access private variables
        public String getMessageID() {
            return messageID;
        }

        public int getMessageNumber() {
            return messageNumber;
        }

        public String getRecipient() {
            return recipient;
        }

        public String getMessage() {
            return message;
        }

        public String getHash() {
            return hash;
        }

        public String getStatus() {
            return status;
        }

        // Validates the message ID
        public boolean checkMessageID() {
            return messageID != null && messageID.length() <= 10;
        }

        // Validates the recipient's cellphone number
        public String checkRecipientCell() {

            if (recipient != null
                    && recipient.matches("^\\+27\\d{9}$")) {

                return "Cell phone number successfully captured.";

            } else {

                return "Cell phone number is incorrectly formatted "
                        + "or does not contain a valid international code. "
                        + "Please correct the number and try again.";
            }
        }

        // Creates the message hash
        private String createMessageHash(
                String messageID,
                int messageNumber,
                String message) {

            if (message == null || message.trim().isEmpty()) {
                return messageID.substring(0, 2)
                        + ":" + messageNumber + ":";
            }

            String[] words = message.trim().split("\\s+");

            String firstWord = words[0];
            String lastWord = words[words.length - 1];

            String messageHash = messageID.substring(0, 2)
                    + ":" + messageNumber
                    + ":" + firstWord + lastWord;

            return messageHash.toUpperCase();
        }

        // Checks the message length
        private String checkMessageLength(String message) {

            if (message == null) {
                return "Message cannot be null.";
            }

            if (message.length() > 250) {

                int extra = message.length() - 250;

                return "Message exceeds 250 characters by "
                        + extra + "; please reduce the size.";

            } else {

                return "Message ready to send.";
            }
        }

        // Provides the send message options
        public String sendMessageOption(int option) {

            switch (option) {

                case 1:
                    return "Message successfully sent.";

                case 2:
                    return "Message disregarded.";

                case 3:
                    return "Message successfully stored.";

                default:
                    return "Invalid option.";
            }
        }

        // Prints message details
        public void printMessageDetails() {

            System.out.println("Message Details");
            System.out.println("Message ID: " + messageID);
            System.out.println("Message Number: " + messageNumber);
            System.out.println("Message Hash: " + hash);
            System.out.println("Recipient: " + recipient);
            System.out.println("Message: " + message);
            System.out.println("Status: " + status);
        }
    }

    // QuickChat class
    static class QuickChat {

        public static void startQuickChat(Scanner input) {

            ArrayList<Message> messages = new ArrayList<>();

            boolean quit = false;

            System.out.println("Welcome to QuickChat!");

            while (!quit) {

                System.out.println("Menu:");
                System.out.println("1) Send Messages");
                System.out.println("2) Show Recently Sent Messages");
                System.out.println("3) Quit");
                System.out.print("Choose an option: ");

                if (!input.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    input.nextLine();
                    continue;
                }

                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print(
                                "How many messages do you want to send? "
                        );

                        if (!input.hasNextInt()) {
                            System.out.println(
                                    "Please enter a valid option."
                            );
                            input.nextLine();
                            break;
                        }

                        int numMessages = input.nextInt();
                        input.nextLine();

                        if (numMessages <= 0) {
                            System.out.println(
                                    "Please enter a number greater than zero."
                            );
                            break;
                        }

                        for (int i = 1; i <= numMessages; i++) {

                            System.out.println("Message " + i);

                            System.out.print("Enter recipient number: ");
                            String recipient = input.nextLine();

                            System.out.print("Enter message: ");
                            String messageContent = input.nextLine();

                            // Correct constructor argument order
                            Message tempMessage = new Message(
                                    recipient,
                                    messageContent,
                                    i,
                                    ""
                            );

                            // Validate the message ID
                            if (!tempMessage.checkMessageID()) {
                                System.out.println(
                                        "Invalid message ID."
                                );
                                continue;
                            }

                            // Validate the recipient number
                            System.out.println(
                                    tempMessage.checkRecipientCell()
                            );

                            // Display message details
                            tempMessage.printMessageDetails();

                            // Check the message length
                            if (messageContent.length() > 250) {
                                System.out.println(
                                        tempMessage.getStatus()
                                );
                                continue;
                            }

                            System.out.println("\nChoose an option:");
                            System.out.println("1 = Send");
                            System.out.println("2 = Disregard");
                            System.out.println("3 = Store");

                            System.out.print("Enter option: ");

                            if (!input.hasNextInt()) {
                                System.out.println(
                                        "Invalid option. Message not processed."
                                );
                                input.nextLine();
                                continue;
                            }

                            int option = input.nextInt();
                            input.nextLine();

                            System.out.println(
                                    tempMessage.sendMessageOption(option)
                            );

                            switch (option) {

                                case 1:
                                    sentMessages.add(tempMessage);
                                    messages.add(tempMessage);
                                    totalMessages++;
                                    break;

                                case 2:
                                    disregardedMessages.add(tempMessage);
                                    break;

                                case 3:
                                    storedMessages.add(tempMessage);
                                    break;

                                default:
                                    System.out.println(
                                            "Please choose 1, 2, or 3."
                                    );
                            }
                        }

                        System.out.println(
                                "Total messages sent: " + totalMessages
                        );

                        break;

                    case 2:

                        if (sentMessages.isEmpty()) {

                            System.out.println(
                                    "No sent messages available yet."
                            );

                        } else {

                            System.out.println("\nRecently Sent Messages:");

                            for (Message currentMessage : sentMessages) {
                                currentMessage.printMessageDetails();
                            }
                        }

                        break;

                    case 3:

                        quit = true;

                        System.out.println(
                                "Thank you for using QuickChat."
                        );

                        break;

                    default:

                        System.out.println(
                                "Invalid option. Please select 1, 2, or 3."
                        );
                }
            }
        }
    }

    // Main method: starts the program
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        QuickChat.startQuickChat(input);

        input.close();
    }
}

    

