package CaesarCipher;

import java.util.Scanner;

/**
 * @Class: CaesarCipher
 * @Author: Miguel Ramirez
 * @Course: ITEC 2140 Section 05 Spring 2023
 * @Written: April 25, 2023
 * Description: This program will take in a message and key value from the user that they choose
 * and will give out an output that is either an encrypted or decrypted message based off the Caesar Cipher line.
 */
public class CaesarCipher {
    //Field
    //This is creating the instance variable to hold the encryption key(Integer)
    private int shift;

    //constructor
    //This is creating the constructor that will
    //take in an integer value for the encryption key
    // and initializes the shift instance variable.
    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    //The method is an encryption method called encrypt.
    //This method will take in the String message of the user to be encrypted and turned
    //into an encrypted message that is then returned to the user as an encrypted String
    //message.
    //This method also implements the caesar Cipher encryption algorithm
    //by shifting each letter or Character of the String message by the shift amount
    //and any non-letters Character Such as spaces, punctuation, and ECT. are left unchanged
    //and is simply appended to the StringBuilder without any modification.


    public String encrypt(String message) {
        //Creates a new StringBuilder to hold the encrypted message
        StringBuilder encryptedMessage = new StringBuilder();
        //loops through each character letter from the input message
        //given by the user using the for loop for each character
        // from the message.
        for (char c : message.toCharArray()) {
            //this will check if the character is a letter
            if (Character.isLetter(c)) {
                //This will check if the letter is UpperCase
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + shift) % 26 + base);
            }
            //returns if the character is not a letter
            encryptedMessage.append(c);
        }
        //returns an encrypted message as a String Message
        return encryptedMessage.toString();
    }

    //The Method created is for a decryption method called decrypt that decrypts the
    //Users encrypted message given and gives the user the decrypted Message as a string.
    //This method creates a new CaesarCipher object with a shift value
    //of '26 - shift' as its value. The reason for the value to be
    //'26 - shift' is because to decrypt a message that has already
    //been encrypted using the Caesar Cipher algorithm is that you
    //need to shift the value in the opposite direction meaning
    //that since the message was already shifted from by the 'shift' value
    //already that means the letters were shifted to the right and need
    //to be shifted to the left using the value '26-shift' to make it go
    //left and be able to decrypt the message and get the opposite of an
    // encrypted message or in other terms a decrypted message.

    public String decrypt(String message) {
        //creates a new CaesarCipher with a value of '26 - shift' to make it go left
        //and get the decrypted message and returned a decrypted String message.
        CaesarCipher decryptedMessage = new CaesarCipher(26 - shift);
        //returns a decrypted String message using the same encrypted method called
        // encrypt but with different shift values.
        return decryptedMessage.encrypt(message);
    }

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
        System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
        char choice = scanner.next().charAt(0);

        // Call the appropriate encrypt or decrypt method of the CaesarCipher instance based on user input
        // Display the resulting encrypted or decrypted message to the user
        String result;
        switch (choice) {
            case 'E':
                result = cipher.encrypt(message);
                System.out.println("Your encrypted message: " + result);
                break;
            case 'D':
                result = cipher.decrypt(message);
                System.out.println("Your decrypted message: " + result);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
}
