package bullscows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        String guess = scanner.nextLine();
        int bullCount = 0;
        int cowCount = 0;

        for (int i = 0; i < guess.length(); i++) {
            for (int j = 0; j < guess.length(); j++) {
                boolean cow = guess.charAt(i) == secretCode.charAt(j) && i != j;
                if (cow) {
                    cowCount++;
                }
            }
            boolean bull = guess.charAt(i) == secretCode.charAt(i);
            if (bull) {
                bullCount++;
            }
        }
        if (cowCount > 0 && bullCount > 0) {
            System.out.println("Grade: " + bullCount + " bull(s) and " + cowCount + " cow(s). The secret code is "+ secretCode + ".");
        } else if (cowCount > 0) {
            System.out.println("Grade: " + cowCount + " cow(s). The secret code is " + secretCode + ".");
        } else if (bullCount > 0) {
            System.out.println("Grade: " + bullCount + " bull(s). The secret code is " + secretCode + ".");
        } else if (bullCount == 0 & cowCount == 0) {
            System.out.println("Grade: None. The secret code is " + secretCode + ".");
        }
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");
        var length = 0;
        var possibleChar = 0;
        try {
            length = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: " + length + " isn't a valid number.");
        }

        System.out.println("Input the number of possible symbols in the code:");
        try {
            possibleChar = scanner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("Error: " + possibleChar + " isn't a valid number.");
        }

        if (length > possibleChar) {
            System.out.println("Error: it's not possible to generate a code with a length of " + length + "with " + possibleChar + "unique symbols.");
        } else if ((int) length == 0 || possibleChar == 0) {
            System.out.println("Error: length or possible symbol number can't be 0");
        } else if (possibleChar > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z)");
        } else {
            StringBuilder secretCode = new StringBuilder();

            String alphabetAndNumbers = "0123456789abcdefghijklmnopqrstuvwxyz";

            boolean unieque = false;
            for (int i = 0; i < possibleChar; i++) {
                double random = Math.random() + 16;
                for (int j = 0; j < secretCode.length(); j++) {
                    unieque = alphabetAndNumbers.charAt((int) random) != secretCode.charAt(j);
                    if (!unieque) {
                        break;
                    }
                }
                if (secretCode.isEmpty()) {
                    secretCode.append(alphabetAndNumbers.charAt(i));
                } else if (unieque) {
                    secretCode.append(alphabetAndNumbers.charAt(i));
                }
            }
            System.out.println("The secret is prepared: ");
            for (int i = 0; i < length; i++) {
                System.out.print("*");
            }
            if (possibleChar < 10) {
                System.out.println(" (" + alphabetAndNumbers.substring(0, possibleChar) + ")");
            } else {
                System.out.println(" (" + alphabetAndNumbers.charAt(0) + "-" + alphabetAndNumbers.charAt(9) + ", " + alphabetAndNumbers.charAt(10) + "-" + alphabetAndNumbers.charAt(possibleChar - 1) + ")");
            }
            System.out.println("Okay, let's start a game!");
            boolean guessedTheSecretCode = false;
            int counter = 0;
            while (!guessedTheSecretCode) {
                counter++;
                System.out.println("Turn " + counter + ":");

                String guess = scanner.nextLine();
                int bullCount = 0;
                int cowCount = 0;

                for (int i = 0; i < guess.length(); i++) {
                    for (int j = 0; j < guess.length(); j++) {
                        boolean cow = guess.charAt(i) == secretCode.charAt(j) && i != j;
                        if (cow) {
                            cowCount++;
                        }
                    }
                    boolean bull = guess.charAt(i) == secretCode.charAt(i);
                    if (bull) {
                        bullCount++;
                    }
                }
                if (cowCount > 0 && bullCount > 0) {
                    System.out.println("Grade: " + bullCount + " bull and " + cowCount + " cow.");
                } else if (cowCount > 0) {
                    System.out.println("Grade: " + cowCount + " cow.");
                } else if (bullCount > 0) {
                    System.out.println("Grade: " + bullCount + " bull.");
                } else if (bullCount == 0 & cowCount == 0) {
                    System.out.println("Grade: None.");
                }
                if (bullCount == length) {
                    guessedTheSecretCode = true;
                    System.out.println("Congratulations! You guessed the secret code.");
                }
            }
        }
    }
}
