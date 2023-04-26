package CaesarCipher;
/**
 * @Class: CaesarCipher
 * @Author: Miguel Ramirez
 * @Course: ITEC 2140 - 05, Spring 2023
 * @Written: April 25, 2023
 * Description: This is a
 */

import java.util.Scanner;

public class CaesarCipher {

    //Field
    //This field creates an instance variable shift that will
    //hold the encryption key(integer).
    private int shift;

    //Constructor
    //The constructor program will create a constructor in which it will
    //take in an integer value of the encryption key and initialize the shift
    //instance variable.

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    //The method is an encryption method call encrypt that will encrypt the
    //String message the user gave and will return an encrypted String message.


    //The method is called encrypt that will take a string message and return an
    //encrypt String message by first creating a new StringBuilder called
    // 'encryptedMessage' that will then loop using the for loop program that will
    //check each letter or character and see if each character letter is a letter
    //using the 'isLetter' method from the 'character' class. if the character or
    //letter is a letter it will then move onto the next step where it checks if
    //it's an uppercase or lowercase using the 'isUpperCase' method from the
    // 'Character' class and set the base of the variable to either 'A' or 'a'.
    // The next step will then calculate the new string message by using the
    // Caesar Cipher algorithm by subtracting the base character
    // from the input character and then add the shift value.
    // Next it will take the result modulo 26 to make sure that the value
    // is within the range of the alphabet and then finally add the base
    //value back. This will result in an encrypted String message to be made
    //from the users String message. It will then go through a method called
    //'encryptedMessage.append(c)' that will check for any non-letter characters
    //such as spaces, punctuation, etc., and simply append
    // them back to the StringBuilder without changing anything or modifying it.

    public String encrypt(String message) {
        //This will create a new StringBuilder object that is called encryptedMessage
        // that will store the encrypted String Message.
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            //this will check if the character is a letter
            if (Character.isLetter(c)) {
                //This will check if the letter is UpperCase
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                //This will encrypt the message using the Caesar Cipher algorithm
                c = (char) ((c - base + shift) % 26 + base);
            }
            //This will return any non-letter or character that is not
            //a character or letter such as spaces, punctuation, etc. it is
            //simply appended to the StringBuilder without any modification.
            encryptedMessage.append(c);
        }
        //This method will return the String message as an encrypted message by calling
        // it to the 'toString' method on the StringBuilder object.
        return encryptedMessage.toString();
    }

    //This method is a decryption method called decrypt that will decrypt any
    // encrypted String message given from the users input and will return a
    // decrypted String message.

    //The method is called decrypt and takes a String called message that will
    //then return a message using the Caesar Cipher algorithm.
    //The first thing is does is that it creates a 'CaesarCipher' class called
    //'decryptedMessage' with a shift value of '26-shift'. the reason for why
    // the shift value is ('26-shift') is because since
    // encryption and decryption algorithms are based on the same
    // principle of shifting characters by a certain number of positions
    // in the alphabet, but in opposite directions the encrypted message
    // given had already been shifted to the right making it where
    // the decrypted message need to shift left by the same amount it was
    // shifted before making its shift value equal 26 - shift so that it
    // shift the decrypted message to the left and gives the user a result
    // of a decrypted String message as its returned result.

    public String decrypt(String message) {
        //This creates a new instance CaesarCipher class called decryptedMessage
        //with a shift value of '26-shift'
        CaesarCipher decryptedMessage = new CaesarCipher(26 - shift);
        //return a decrypted String message using the 'encrypt' method but with
        //different shift values.
        return decryptedMessage.encrypt(message);
    }


    //Main class
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user for a message to be encrypted or decrypted
        System.out.print("Enter a message to be encrypted or decrypted: ");
        String message = input.nextLine();

        // Prompt the user for an integer key value to be used for encryption or decryption
        System.out.print("Enter an integer key value for encryption or decryption: ");
        int shift = input.nextInt();

        // Create an instance of the CaesarCipher class with the user-provided key value
        CaesarCipher cipher = new CaesarCipher(shift);

        // Prompt the user for whether to encrypt or decrypt the message
        System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
        char choice = input.next().charAt(0);


        // Perform encryption or decryption based on user choice
        // Call the appropriate encrypt or decrypt method of the CaesarCipher instance based on user input
        // Display the resulting encrypted or decrypted message to the user
        String result;
        //The switch-case method checks if the user wants his message to be
        // encrypted or decrypted by the letter the user puts whether it is
        // 'E' or 'D' and follows what is inside the case for the letter and
        // gives the user his answer whether if it's an encrypted or decrypted
        //message.
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
