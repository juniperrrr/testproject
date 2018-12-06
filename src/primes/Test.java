
package primes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        
        System.out.println("WELCOME TO THE GAME OF PRIMES!");
        System.out.println("Instructions: The game will give you a composite number, and your role is to break it down into its prime factors.");
        System.out.println("Note: A prime number is a number that 1 and itself as factors. Composite numbers have other factors other than 1 and itself.");
        System.out.println("For each number successfully broken down to its prime factors, you will receive 5 points.");
        System.out.println("However, you are only allowed to input a prime factor. Every time you input a composite factor, 1 point is deducted from your score.");
        System.out.println("The game lasts for ten rounds. Have fun!");
        System.out.println("");
        
        ArrayList <Integer> compNumbers = new ArrayList<>(); //instantiates an ArrayList
        
        for(int i = 3; i <= 99; i++){ //checks for all composite numbers from 3-99, if composite, add number to ArrayList
            for(int j = 2; j <= i/2; j++){
                if(i%j == 0){
                    compNumbers.add(i);
                    break; //prevents duplicate numbers
                }
            }
        }
        Collections.shuffle(compNumbers); //shuffles the whole list so it isn't sequential
        
        GameAbstract game = new Game();
        
        for(int i = 0; i < 10; i++){ //continue the game until it reaches 10 rounds
            
            int randomNum = compNumbers.get(i); //get the number at index i
            int testValue = 0;
            int quotient;
            boolean isComposite = true;
            boolean isNotDivisible = true;
            boolean quotientIsComposite = true;
            Scanner scan = new Scanner(System.in);
            System.out.println("Random number: " + randomNum);
            
            while(quotientIsComposite){
                while(isComposite || isNotDivisible) {
                    System.out.print("Enter a prime factor of " + randomNum + ": ");
                    testValue = scan.nextInt();
                    isComposite = game.isInputPrimeNum(testValue);
                    isNotDivisible = game.isDivisibleNum(randomNum, testValue);
                    if(isComposite || isNotDivisible){
                        System.out.println("Only prime factors allowed. Please try again: ");
                        game.setTryAgain(1);
                    }
                }
       
                quotient = randomNum / testValue;
                quotientIsComposite = game.isInputPrimeNum(quotient);
       
                if(quotientIsComposite) {
                    randomNum = quotient; // set the new value
                    System.out.println(randomNum + " is still composite, break it down further.");
                    isComposite = true;
                    isNotDivisible = true;
                }
                else{
                    game.setScoreCounter(5);
                }
            }
            System.out.println("Points  earned (so far): " + game.getScoreCounter());
            System.out.println("Point/s deducted (so far): " + game.getTryAgain());
            System.out.println("");
        }
        System.out.println("Total score is: " + game.displayScore(game.getScoreCounter(), game.getTryAgain()));
        System.out.println("Thank you for playing!");
    }      
}
