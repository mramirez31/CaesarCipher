package CaesarCipher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a message to be encrypted or decrypted
        System.out.print("Enter a message to be encrypted or decrypted: ");
        String message = scanner.nextLine();

        // Prompt the user for an integer key value to be used for encryption or decryption
        System.out.print("Enter an integer key value for encryption or decryption: ");
        int key = scanner.nextInt();

        // Create an instance of the CaesarCipher class with the user-provided key value
        CaesarCipher cipher = new CaesarCipher(key);

        // Prompt the user for whether to encrypt or decrypt the message
        System.out.print("Enter 'e' for encryption or 'd' for decryption: ");
        char choice = scanner.next().charAt(0);

        // Call the appropriate encrypt or decrypt method of the CaesarCipher instance based on user input
        String result;
        switch (choice) {
            case 'e':
                result = cipher.encrypt(message);
                break;
            case 'd':
                result = cipher.decrypt(message);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                return;
        }

        // Display the resulting encrypted or decrypted message to the user
        System.out.println("Result: " + result);
    }
}
