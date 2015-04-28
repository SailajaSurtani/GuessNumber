package com.test.sailaja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* This class represents the basic Number Guessing game based on Binary Search.
*
* @author Sailaja
*/
public class NumberGuess {

/**
* Field to store the number of attempts
*/
private int numAttempts = 0;
/**
* Reader to read user inputs
*/
private BufferedReader bufferedReader = null;

public static final String GO = "GO";
public static final String HIGHER = "HIGHER";
public static final String LOWER = "LOWER";
public static final String YES = "YES";
public static final String EXIT = "EXIT";
/**
* Default Constructor - creates instance of buffer reader to read user input
*/
public NumberGuess() {
try {
bufferedReader = new BufferedReader(new InputStreamReader(System.in));
} catch (final Exception ex) {
System.err.println("Exception while creating a BufferedReader: " + ex.getMessage());
}
}
/**
* the core business method that tries to 'guess' the number relies on the standard 'binary
* search' algorithm, uses recursion
*
* @param lower
* @param higher
* @throws Exception
*/
public void guessNumber(final int lower, final int higher) throws IOException {
final int guess = (lower + higher) / 2;
numAttempts++;
// Binary search, start with the middle number
System.out.print("Is the number - " + guess
+ "? (Please respond with HIGHER, LOWER, or YES. Enter EXIT to exit the game.):");
while (true) {
final String userResp = bufferedReader.readLine();
if (userResp== null || userResp.equals("")) {
System.out.println("Invalid Response - Null or blank.");
} else if (userResp.equalsIgnoreCase(HIGHER)) {
guessNumber(guess + 1, higher);
} else if (userResp.equalsIgnoreCase(LOWER)) {
guessNumber(lower, guess - 1);
} else if (userResp.equalsIgnoreCase(YES)) {
System.out.println("Found it !!!");
System.out.println("Number of attemts - " + numAttempts);
break;
} else if (userResp.equalsIgnoreCase(EXIT)) {
System.out.println("Exiting....");
System.exit(0);
} else {
System.out.println("Invalid input !!!");
}
}
}
/**
* Closes the buffered reader
*/
public void closeReader() {
try {
bufferedReader.close();
} catch (final Exception ex) {
System.err.println("Exception while closing the buffered reader");
}
}
/**
* Main method to run the program
*
* @param args
*/
public static void main(final String[] args) {
final NumberGuess nGame = new NumberGuess();
System.out.println("Choose a random number (integer) between -100 and 100");
boolean gameStarted = false;
while (!gameStarted) {
System.out.print("enter GO to start the game: ");
String userInput;
try {
userInput = nGame.getBufferedReader().readLine();
if (userInput != null) {
if (GO.equalsIgnoreCase(userInput.trim())) {
gameStarted = true;
} else {
System.out.print("Invalid input!");
}
}
System.out.println("This program will now start guessing the number...");
nGame.guessNumber(-100, 100);
} catch (final IOException e) {
// TODO Auto-generated catch block
System.out.print("Exception!");
} finally {
nGame.closeReader();
}
}
}


/**
* Retrieves the value of the {@link #bufferedReader} field.
*
* @return the value of the {@link #bufferedReader} field
*/
public BufferedReader getBufferedReader() {
return bufferedReader;
}
}
