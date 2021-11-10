package Comprog2;

import java.util.*;
public class Quiz {
    public static void main(String[] args) throws EmptyInputException {//Natanauan Nov 09
        Scanner s = new Scanner(System.in);
        int cor = 0, incor = 0;
        String userAns = "";
        String[] ques = {"1) Which vegetable gives Popeye his strength?" + "\n"+//qeustions that will be displayed from 1-10 
            "A. Broccoli B. Spinach C. Asparagus ",
            "2) Who was the ancient Greek goddess of love and beauty?" + "\n"
            + "A. Aphrodite B. Calliope C. Athena ",
            "3) What does the Q in IQ stand for?" + "\n"
            + "A. Quantity B. Quorum C. Quotient ",
            "4) What is the name of Superman’s home planet?" + "\n"
            + "A. Argon B. Rann C. Krypton ",
            "5) Bronze is mainly an alloy of tin and which other metal?" + "\n"
            + "A. Brass B. Lead C. Iron ",
            "6) Which Italian artist painted the Sistine Chapel ceiling?" + "\n"
            + "A. Botticelli B. Michelangelo C. Leonardo da Vinci ",
            "7) Which U.S. president abolished slavery?" + "\n"
            + "A. Thomas Jefferson B. James Garfield C. Abraham Lincoln ",
            "8) Where was the second atomic bomb dropped in World War 2?" + "\n"
            + "A. Nagasaki B. Hiroshima C. Osaka ",
            "9) What was the name of the first spacecraft to land on the moon?" + "\n"
            + "A. Spider B. Eagle C. Intrepid ",
            "10) What is the capital city of Ukraine?" + "\n"
            + "A. Kiev B. Vilnius C. Minsk "};
        String[] ans = {"B", "A", "C", "C", "C", "B", "C", "A", "B", "A"};//These are the correct answers to the questions
        
        for (int i = 0; i < ques.length; i++) {
            System.out.println(ques[i]);//will display the qestion from 1-10
            System.out.print("Anwer: ");
            do {//do while the input != ABC
                try {
                    userAns = s.nextLine();
                    if (userAns.isBlank()) {
                        throw new EmptyInputException();//blank
                    } else if (!userAns.matches("^[a-zA-Z]+$")) {
                        throw new InputMismatchException();//number of special chars
                    } else if (!userAns.equalsIgnoreCase("A") && !userAns.equalsIgnoreCase("B") && !userAns.equalsIgnoreCase("C")) {
                        throw new StringIndexOutOfBoundsException();//not ABC
                    }
                } catch (EmptyInputException e) {
                    System.out.println("-------- Empty input (Answer can't be Blank), Answer Again --------");
                    System.out.print(i + 1 + ") " + "Anwer: ");
                } catch (InputMismatchException ex) {
                    System.out.println("-------- Invalid input(No number or special character) Answer Again --------");
                    System.out.print(i + 1 + ") " + "Anwer: ");
                } catch (StringIndexOutOfBoundsException ex) {
                    System.out.println("-------- Invalid Letter(not A, B or C), Answer again --------");
                    System.out.print(i + 1 + ") " + "Anwer: ");
                }
            } while (!userAns.equalsIgnoreCase("A") && !userAns.equalsIgnoreCase("B") && !userAns.equalsIgnoreCase("C"));

            //This will check if the user input matches the answers, if match +1 to correct and if not +1 to incorrect 
            if (userAns.equalsIgnoreCase(ans[i])) {
                cor++;
            } else if (!userAns.equalsIgnoreCase(ans[i])) {
                incor++;
            }
        }
        System.out.println("---------------------------" + "\n"+"   You finished the Quiz ");
        System.out.println("Correct: " +cor+ "      Incorrect: "+incor );
        System.out.println("     Quiz Result : "+cor+"/10");  
    }
    private static class EmptyInputException extends Exception {//For blank Input
        public EmptyInputException() {
        }
    }
}
