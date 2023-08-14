
/*
Project Title: Mysteria - ICS3U Final Culminating

Project Description: This game is a murder mystery game where the player must complete a series
                        of puzzles to get clues as to finding the culprit, what weapon they used and where they did it.
                        1. The player gets to pick an avatar from four options and get their name
                        2. Then they begin with a short introduction of the situation and get called to action to begin the mission
                        3. There will be a set of 5 rotating mini-games that the player will participate in to earn hints and clues such as:
                            -fill in the blank word games
                            -math blitz
                            -rock paper scissors
                            -dice roll
                            -memory matching game
Name: Suhani Surya

Date: June 9th - June 16th, 2023
 */

//Importing all the important classes
import java.util.Random; //This imports the random class that will be used for a variety of purposes like generating random questions
import java.util.Scanner; //This is the scanner class that will be used to derive input from the user
import java.util.Timer; //This class is for the math blitz activity
import java.util.TimerTask; //This class is also for the math blitz activity

//CLASS HEADER
public class CulminatingAttempt2
{
    public static void main(String[] args)
    {
        //VARIABLE DECLARATION SECTION
        int avatarSelection; //this stores the value of the integer from 1 to 4 that the player chooses as their avatar
        String avatar; //this stores the string of the characters that are used to make the avatar

        //OBJECT INITIALIZATION SECTION
        Scanner keyboard = new Scanner(System.in); //this is the scanner object for the main method called keyboard
        Random randNum = new Random(); //this is the random class that will be used to shuffle the array and chose which set of elements will be the "culprit", "weapon" and "location"
        int culpritStory = randNum.nextInt(3); //this is the integer that stores which murder story will be used
        String userCulprit; //this stores the user's guess for the culprit
        String userMurderWeapon; //this stores the user's guess for the murder weapon
        String userLocation; //this stores the user's guess for the murder location
        int numberOfScenarios = 3;

        String [] culpritWeaponSetting = {"Rand", "Safiyye", "Suhani", "Knife", "Poison", "Gun", "Sun room", "Kitchen", "Attic"}; //this is the array that holds all the info for the culprit, murder weapon and location


        //BEGINNING OF PROGRAM
        System.out.println("MYSTERIA");//This line prints the title of the game
        System.out.println("--------");

        System.out.print("Hello! What is your name? "); //this line asks what the name of the user is
        String name = keyboard.nextLine(); //this line assigns the keyboard input to the String variable called name
        System.out.println("\nHi " + name + "! Welcome to Mysteria. \nThis is a game where you use your intelligence, creativity, critical analysis and scientific reasoning skills to find the culprit of certain crimes."); //introduces the user to what Mysteria is about
        System.out.println("\t\tMy name is Anastasia and I will guide you through this quest!"); //introducing the host of the game "npc"
        anastasia(); //calling the anastasia method to print her emoticon

        System.out.println("Now of course, the first thing we have to do is get you an avatar: Type the number you desire that is shown under each of the avatar choices."); //gets the user to print what avatar they want

        //AVATAR SELECTION
        System.out.println("ʕ•ᴥ•ʔ\t\t( ͡ᵔ ͜ʖ ͡ᵔ )\t\t(⌐■_■)\t\tಠ_ಠ"); //prints all the avatar selections, numbered from 1 to 4
        System.out.println("  1\t\t\t\t2\t\t\t   3\t\t 4"); //prints the numbers for the user to see.

        System.out.print("Which avatar have you selected? "); //asks the user which avatar they have selected
        avatarSelection = keyboard.nextInt(); // assigns the input to the avatar selection

        //INCORPORATING INPUT VALIDATION
        //this makes sure that the user choice is between 1 and 4 through a while loop
        while(avatarSelection > 4 || avatarSelection < 0)
        {
            System.out.print("Selection is invalid. Please enter a number between 1 and 4: "); //informs the user that the choice is invalid
            avatarSelection = keyboard.nextInt(); //reassigns users new choice to the avatar selection
        }

        //SERIES OF CONDITIONAL STATEMENTS THAT PRINT THE USER'S CHOICE
        if(avatarSelection == 1)
        {
            avatar = "ʕ•ᴥ•ʔ";
        }
        else if(avatarSelection == 2)
        {
            avatar = "( ͡ᵔ ͜ʖ ͡ᵔ )";
        }
        else if(avatarSelection == 3)
        {
            avatar = "(⌐■_■)";
        }
        else
        {
            avatar = "ಠ_ಠ";
        }

        System.out.print("\tGreat! You are now: ");
        userAvatar(avatar); //sends the string to the avatar method to use over and over again
        anastasia(); //calls the anastasia method to print her emoticon


        System.out.println("\nYou are the NYPD's finest detective who has been able to solve over 500 mysteries."); //introduction to the scenario
        System.out.println("You are relaxing at home when you receive a phone call...");
        System.out.println("Detective " + name + ", we need to on duty. There has been another murder and we want the best detective on the case.");

        int[] numbers = { 1, 2, 3, 4, 5}; //array of the 5 numbers of the 5 possible activities that the user could get, but they would only get 3 because there are 3 rounds

        //gameSelector(1, 1); //THIS LINE IS TO TEST IF CERTAIN MINI GAMES WORK (this can be disregarded)

        //FOR LOOP TO SHUFFLE ELEMENTS AROUND TO ENSURE UNIQUENESS
        for (int i = 0; i < numbers.length; i++)
        {
            int temp = numbers[i]; //using the temp to temporarily store the numbers index
            int rand = randNum.nextInt(5); //generating a random index between 0 and 4
            numbers[i] = numbers[rand]; //assigning the old index i to this
            numbers[rand] = temp; //assigning the numbers[rand] to temp to switch it around
        }

        int index = culpritStory; //sets the index as the certain scenario that was chosen

        //FOR LOOP TO RUN THE DIFFERENT METHODS OF MINI GAMES FROM THE SHUFFLED ARRAY AND TO GIVE THE PLAYER THE CLUE
        for (int i = 0; i < 3; i++, index+=numberOfScenarios)
        {
            gameSelector(numbers[i], (i + 1)); //this line calls the game selector method and gives it the index of the new shuffled array as well as what round of the gam the user is on
            System.out.println("Your clue is: " + culpritWeaponSetting[index]); //this line prints once the game is over. The index in the for loop header is incremented by the numberOfScenarios variable which is equal to three.
            //this is because in the array where I wrote all the culprits, murder weapons and locations, they correspond to each other in a certain way
        }

        index = culpritStory; //this resets the index to the culpritStory that was either 0, 1 or 2

        System.out.println("You should now have all 3 clues as to: 1) The culprit, 2) The murder weapon, 3) the location"); //informs the user that they have all the clues and can now solve the mystery
        keyboard.nextLine(); //creates a space and resets the keyboard input. this was necessary because without this line, my code below was not working properly

        System.out.print("Enter the name of the culprit: "); //asks the user to enter the name of the culprit
        userCulprit = keyboard.nextLine(); //assigns keyboard input to the userCulprit variable.

        System.out.print("Enter the name of the murder weapon: ");//asks the user to enter the murder weapon
        userMurderWeapon = keyboard.nextLine(); //assigns keyboard input to the userMurderWeapon variable.

        System.out.print("Enter the name of the murder location: ");//asks the user to enter the murder location
        userLocation = keyboard.nextLine(); //assigns keyboard input to the userLocation variable.


        if(userCulprit.equalsIgnoreCase(culpritWeaponSetting[index]) && userMurderWeapon.equalsIgnoreCase(culpritWeaponSetting[index + numberOfScenarios]) && userLocation.equalsIgnoreCase(culpritWeaponSetting[index + (numberOfScenarios * 2)]))
        //this is a conditional header where each of the user responses for the culprit, murder weapon and location are tested to see if they match with the ones in the array
        {
            System.out.println("Congratulations! You have cracked the case!"); //notifies the player that they have successfully completed the task.
        }

        keyboard.close();
    }

    public static void anastasia() //this is the anastasia method
    //anastasia is a non-playing character that is there to give instructions to the player
    {
        System.out.println("(✿◠‿◠)"); //this line prints the emoticon for anastasia
    }

    public static void userAvatar(String avatar) //this method gets the avatar that the user chose and stores it in an array to recall back to later!
    {
        System.out.println(avatar);
    }

    public static void gameSelector(int index, int round) //this method is the game selector method where 1 of 5 mini-games are selected for each round
    {
        System.out.println("\nAmazing! Now, you will begin activity #" + (round)); //tells the player which round they are playing

        if(index == 1) //if the index is 1, then call the fillInTheBlank method
        {
            fillInTheBlank();
        }
        else if(index == 2)  //if the index is 2, then call the mathBlitz method
        {
            mathBlitz();
        }
        else if(index == 3)
        {
            rockPaperScissors();//if the index is 3, then call the rockPaperScissors method
        }
        else if(index == 4)
        {
            diceRoll();  //if the index is 4, call the diceRoll method
        }
        else
        {
            memoryMatchingBoard(); //else (the index has to be 5 because of random number generation so call the memoryMatchingGame
        }


    }

    public static void fillInTheBlank() //This is the fill in the blank method header

    {
        System.out.println("\nWelcome to the Fill in the Blank activity! This activity consists of timed rounds, each 30 seconds long.");
        System.out.println("Your objective is to get as many fill in the blanks as possible in a single round."); //introduces the player to the game and how to play
        anastasia();

        Random rand = new Random(); //importing the random class for random generation
        Scanner keyboard = new Scanner(System.in); //importing the scanner class for user input

        String[] prompts = {"What has keys but can't open locks?", "What goes up but never comes down?", "What has a face and two hands but no arms or legs?", "What has to be broken before you can use it?", "What has cities but no houses, forests, or rivers?", "I am taken from a mine, and shut in a wooden case, from which I am never released, and yet I am used by almost every person. What am I?", "What can you catch but not throw?", "What gets wetter the more it dries?", "What has a thumb and four fingers, but is not alive?", "What has a neck but no head?", "What has one eye but cannot see?", "What has a bottom at the top?", "What has a ring but no finger?", "What has a bed but never sleeps, and a mouth but never eats?", "What has wheels and flies, but is not an airplane?", "What has a face that doesn't frown, and hands that don't wave?", "What has a head and a tail but no body?"};
        //Here is the array that holds all of the riddle prompts


        String[] answers = {"Piano", "Age", "Clock", "Egg", "Map", "Pencil", "Cold", "Towel", "Glove", "Bottle", "Needle", "Leg", "Telephone", "River", "Garbage truck", "Clock", "Coin"};
        //Here is the array that holds all of the riddle prompts answers

        //two temp variable
        //same random


        int countdownSeconds = 30; // Set the countdown time in seconds

        int correct = 0; //this is an accumulator variable that stores how many the player got correct

        Timer timer = new Timer(); //this is a new timer object

        //This is kind of like a method within a method for the timer task
        timer.scheduleAtFixedRate(new TimerTask()

        {
            int counter = countdownSeconds; //setting the counter as countdown seconds

            //another method within a method to see if the counter is greater than 0
            public void run()
            {
                if (counter > 0)
                {
                    counter--; //if the counter is greater than 0, decrement the counter by 1
                }
                else //if the counter is not greater than 0 (so at 0)
                {
                    System.out.println("Time's up!"); //print that the time is up
                    timer.cancel(); // Stop/ cancel the timer when the countdown reaches 0
                }
            }
        }, 0, 1000); //this is the delay period of 1 second or 1000 milliseconds

        while(countdownSeconds > 0 && correct < 3) //if the countdown seconds is above zero and the player has gotten less than 3 answers correct
        {
            int s = rand.nextInt(16) + 1; //generate a random number between 0 and 16 (which are the indexes of the riddles and answers) and assign it to s
            System.out.println(prompts[s] + ": "); //print the prompt using the index s random number that was generated
            String userAnswer = keyboard.nextLine(); //assign the users answer

            if(userAnswer.equalsIgnoreCase(answers[s])) //This is a conditional statemenht that evaluates if the users input is equal to the answers at that specific index
            {
                System.out.println("Correct!"); //prints that the player is correct
                correct++; //increments the correct accumulator variable by 1
            }
            else //if the answer is not the same to the player's entry
            {
                System.out.println("Sorry, the answer was " + answers[s]); //does not increment the correct variable because they are incorrect and informs them what the correct answer is
            }

        }

        System.out.println("You got " + correct + " riddles correct."); //tells the player how many riddles they got correct
        System.out.println("Congratulations! You can advance!"); //tells them they can advance

        //this is the end of the method, now the next mini-game method will run its code
        keyboard.close();
    }



    public static void mathBlitz() //this is the mathBlitz method header. It does not accept any parameter variables
    {
        Random rand = new Random(); //creating a random object named rand
        Scanner keyboard = new Scanner(System.in); //created a scanner object named keyboard
        System.out.println("\nWelcome to Math Blitz! This challenge tests your arithmetic and thinking skills by evaluating you on mathematical expressions.");
        System.out.println("You will be presented with 10 math questions that you must answer at least 5 of them to advance."); //instructions on how to play
        anastasia(); //calling the anastasia method to print her avatar
        int difficulty; //this integer variable is to decide the difficulty of the question
        int answer; //this is the answer that will be determined by the different methods that have different level of difficulty
        int userGuess; //this is the answer that the player inputs

        int correct; //this is an accumulator variable that resets for every set of 10 questions to ensure that the player can see how many questions they got correct
        do
        {
            correct = 0; //again, resetting the "correct" accumulator variable to 0 in order to accurately display how many answers the user got correct
            System.out.println("To pass this activity, you need to achieve a minimum score of 5/10!"); //tells the user that they need to get 5/10 questions correct to advance

            for (int i = 1; i <= 10; i++)
            //this for loop iterates 10 times
            {
                int num1 = rand.nextInt(10)+1;
                int num2 = rand.nextInt(10)+1;
                int num3 = rand.nextInt(10)+1;
                int num4 = rand.nextInt(10)+1;

                //for each question, num1, num2, num3 and num4 are regenerated to add variety to the game

                difficulty = rand.nextInt(4) +1;//here, the difficulty is randomly generated using the random class from 1 to 4
                if (difficulty == 1)
                {
                    answer = mathBlitz1(num1, num2, i); //if the difficulty is 1, the mathBlitz1 method will be called and pass 3 parameter variables
                    //the "i" is to keep track of the question number
                }
                else if (difficulty == 2)//if the difficulty is 2, the mathBlitz2 method will be called and pass 3 parameter variables
                {
                    answer = mathBlitz2(num1, num2, i);
                }
                else if (difficulty == 3)//if the difficulty is 3, the mathBlitz3 method will be called and pass 3 parameter variables
                {
                    answer = mathBlitz3(num1, num2, num3, i);
                }
                else
                {
                    answer = mathBlitz4(num1, num2, num3, num4, i);//if the difficulty is 4 (as there is no other option), the mathBlitz4 method will be called and pass 3 parameter variables
                }

                userGuess = keyboard.nextInt(); //this line assigns the player's answer into the userGuess variable

                if (userGuess == answer) //if the userGuess is equal to the answer (which was returned by each of the difficulty methods), the following code will execute
                {
                    System.out.println("Correct"); //this line prints "correct" indicating that the player's answer was correct
                    correct++; //increments the number of correct responses by 1
                }
                else
                {
                    System.out.println("Sorry, that is incorrect. The correct answer is: " + answer); //prints that the player's answer is incorrect and what the correct answer is
                }
            }
        }
        while (correct < 5); //if the number of correct answers is greater than or equal to 5, the following code will execute
        System.out.println("You got " + correct + " answers correct!"); //this line prints how many questions the user got correct
        System.out.println("Congratulations, you have passed and can advance!"); //lets them know they can advance

        //this is the end of the method. if applicable, the next mini-game method will run. if not, the space where the player can enter the 3 clues they got to solve the murder

        keyboard.close();
    }

    public static int mathBlitz1(int num1, int num2, int i)//this is the easiest level in the mathBlitz mini-game. this method takes 3 parameter variables
    {
        int answer = num1 + num2; //this assigns the variable "answer" with the correct answer to the math equation
        System.out.print("Question " + i + ": " + num1 + " + " + num2 + " = "); //this prints the question with the given numbers that were passed from the mathBlitz method
        return answer; //returns the answer to the mathBlitz method

    }
    public static int mathBlitz2(int num1, int num2, int i)//this is the second level of difficulty in the mathBlitz mini-game. this method takes 3 parameter variables
    {
        int answer = num1 - num2; //this assigns the variable "answer" with the correct answer to the math equation
        System.out.print("Question " + i + ": " + num1 + " - " + num2 + " = ");//this prints the question with the given numbers that were passed from the mathBlitz method
        return answer;//returns the answer to the mathBlitz method
    }
    public static int mathBlitz3(int num1, int num2, int num3, int i) //this is the third level of difficulty in the mathBlitz mini-game. this method takes 3 parameter variables
    {
        int answer = num1 - (num2 * num3);//this assigns the variable "answer" with the correct answer to the math equation
        System.out.print("Question " + i + ": " + num1 + " - " + num2 + " x " + num3 + " = ");//this prints the question with the given numbers that were passed from the mathBlitz method
        return answer;//returns the answer to the mathBlitz method
    }
    public static int mathBlitz4(int num1, int num2, int num3, int num4, int i) //this is the fourth level of difficulty in the mathBlitz mini-game. this method takes 3 parameter variables
    {
        int answer = num1 - (num2 * num3) - num4;//this assigns the variable "answer" with the correct answer to the math equation
        System.out.print("Question " + i + ": " + num1 + " - " + num2 + " x " + num3 + " - " + num4 + " = ");//this prints the question with the given numbers that were passed from the mathBlitz method
        return answer;//returns the answer to the mathBlitz method
    }


    public static void rockPaperScissors() //this is the rockPaperScissors mini-game method
    {
        int wins = 0; //this is the accumulator variable for the number of wins
        int round = 1; //this is the round
        String userPlay; //this is the String variable that stores what action the user wants to do

        Scanner keyboard = new Scanner(System.in); //new scanner object
        Random rand = new Random(); //new random object
        String [] rpsWords = {"Rock", "Paper", "Scissors"}; //this stores the possible actions that the computer can do
        int rpsComputerChoice; //this stores the computer's choice for the random number corresponding to the index of the rpsWords array

        System.out.println("\nWelcome to Rock Paper Scissors! This game requires you to win 3 times against the computer to advance"); //presents instructions to the user
        System.out.println("To play rock, type \"Rock\". To play paper, type \"Paper\". To play scissors, type \"Scissors\"."); //tells the user what to type exactly into the console
        System.out.println("Type your desired play after the phrase Round x: appears");
        System.out.println("Let's begin!");//more instructions to show tell the user how to play
        anastasia();

        //This is a do while loop that ensures at least one iteration
        do
        {
            System.out.print("Round " + round + ": "); //This statement prints out the round
            userPlay = keyboard.nextLine(); //assigning the user choice of "Rock", "Paper" or "Scissors"

            rpsComputerChoice = rand.nextInt(rpsWords.length); //this assigns the rpsComputer choice as something between 0 and 2
            System.out.println("Computer chose " + rpsWords[rpsComputerChoice]); //this statement prints what the computer choice

            if((userPlay.equalsIgnoreCase("Paper") && rpsComputerChoice == 0) || (userPlay.equalsIgnoreCase("Scissors") && rpsComputerChoice == 1) || (userPlay.equalsIgnoreCase("Rock") && rpsComputerChoice == 2))
            //this conditional evaluates if the user choice is "greater" in the sense that Rock beats Scissors or Paper beats Rock
            //this ignores case to allow for ease of user experience
            {
                System.out.println("You win this round!"); //this prints if the user wins
                wins++; // increments the wins accumulator variable
            }


            if((userPlay.equalsIgnoreCase("Paper") && rpsComputerChoice == 2) || (userPlay.equalsIgnoreCase("Scissors") && rpsComputerChoice == 0) || (userPlay.equalsIgnoreCase("Rock") && rpsComputerChoice == 1))
            //this conditional evaluates if the user choice is "less" in the sense that Rock beats Scissors or Paper beats Rock
            {
                System.out.println("Computer wins! Try again!");//prints that the computer wins
            }

            if((userPlay.equalsIgnoreCase("Paper") && rpsComputerChoice == 1)|| (userPlay.equalsIgnoreCase("Scissors") && rpsComputerChoice == 2) || (userPlay.equalsIgnoreCase("Rock") && rpsComputerChoice == 0))
            //this conditional evaluates if the user's choice and the computer choice are the same
            {
                System.out.println("It's a tie! Try again!");//prints that the round is a tie
            }

            round++; // increments the rounds
        }
        while(wins < 3);
        System.out.println("It took you " + round + " rounds to win");//this statement prints how many rounds it took the player to win
        System.out.println("Congratulations! You can advance!");//this statement prints the player can move onto the next round or if all 3 games have been played, to guess the culprit, weapon and setting

        keyboard.close();
    }

    public static void diceRoll()//this is the diceRoll method. it does not accept any parameter variables
    {
        Scanner keyboard = new Scanner(System.in);//this is the scanner object called keyboard for user input
        Random rand = new Random();//this is the random object called rand in order to generate random dice values

        int wins = 0;//this is the wins accumulator variable
        String startRound;//this is the variable that detects if the user is ready to advance to the next round
        char startRoundChar;//this is the variable that detects if the user is ready to advance to the next round for ease of use during gameplay

        System.out.println("\nWelcome to the Dice Roll Game! This game involves you rolling a sum that is greater than the sum that the computer generates. If you successfully complete this 3 times, you can advance!");
        anastasia(); //these statements print the instructions and calls the anastasia method to print her avatar

        while (wins < 3)//if the wins are less than three, execute the following code
        {
            System.out.print("Type \"go\" to roll your 2 dice and start the round: ");//this statement tells the user to write "go" in order to start the round
            startRound = keyboard.nextLine();//this assigns user input to startRound
            if(startRound.equalsIgnoreCase("Go"))//this conditional evaluates if the starRound equals some version of "Go" while ignoring case or character "G" in case the player wrote the word wrong
            {
                int userDice1;
                int userDice2;
                int compDice1;
                int compDice2;

                //these integer variables store the randomly generated dice values

                int userSum;
                int compSum;
                //these integer variables store the sum of the userDice or compDice values

                userDice1 = rand.nextInt(6) + 1;
                userDice2 = rand.nextInt(6) + 1;
                //these statements generate a random number between 1 and 6 to the user dice

                System.out.print(userDice1 + " " + userDice2 + " = ");
                //printing the values of the userDice1 and userDice2

                userSum = userDice1 + userDice2; //adding the two values of the dice
                System.out.println(userSum);//printing the sum


                compDice1 = rand.nextInt(6) + 1;
                compDice2 = rand.nextInt(6) + 1;
                //these statements generate a random number between 1 and 6 to the computer dice

                System.out.print(compDice1 + " " + compDice2 + " = ");
                //printing the values of the userDice1 and userDice2

                compSum = compDice1 + compDice2;//adding the two values of the dice
                System.out.println(compSum);//printing the sum

                if(userSum > compSum) //if the userSum is greater than the computer sum, the following code will execute
                {
                    System.out.println("User wins this round");//printing that the user won the round
                    wins++;//incrementing wins by 1
                }
                else if(userSum < compSum)//this code executes if the computer sum is greater than the userSum
                {
                    System.out.println("Computer wins this round");//printing that the computer won the round
                }
                else //this code will execute if both the userSum and compSum are equal
                {
                    System.out.println("Tie!");//printing that the round results in a tie

                }
            }
        }//end of while loop
        System.out.println("Congratulations! You can now advance!");//this statement prints the player can move onto the next round or if all 3 games have been played, to guess the culprit, weapon and setting

        keyboard.close();
    }

//    public static void memoryMatchingBoard()
//    {
//        System.out.println("\nWelcome to the Memory Matching Board!");
//        System.out.println("In this game, you must make all 8 matches and fill the board to advance! Type in the row and the column (coordinate point from 0 - 3) of the spot you are guessing.");
//        anastasia();
//        int[][] board = generateBoard();
//        boolean[][] flipped = new boolean[4][4];
//
//        playGame(board, flipped);
//    }
//
//    public static int[][] generateBoard() {
//        int[][] board = new int[4][4];
//        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8};
//        Random random = new Random();
//
//        // Shuffle the numbers
//        for (int i = nums.length - 1; i > 0; i--) {
//            int j = random.nextInt(i + 1);
//            int temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//        }
//
//        // Assign the shuffled numbers to the board
//        int count = 0;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                board[i][j] = nums[count];
//                count++;
//            }
//        }
//
//        return board;
//    }
//
//    public static void playGame(int[][] board, boolean[][] flipped)
//    {
//        Scanner scanner = new Scanner(System.in);
//        int pairsFound = 0;
//        int firstRow = -1;
//        int firstCol = -1;
//
//        int userEntry;
//
//        while (pairsFound < 8) {
//            printBoard(board, flipped);
//
//            System.out.print("Enter the column number (1-4): ");
//            userEntry = scanner.nextInt();
//            int col = userEntry - 1;
//
//            while(col > 3 || col < 0)
//            {
//                System.out.println("That is an invalid number. Please enter a number between 1 and 4");
//                userEntry = scanner.nextInt();
//                col = userEntry - 1;
//            }
//
//            System.out.print("Enter the row number (1 - 4): ");
//            userEntry = scanner.nextInt();
//            int row = userEntry - 1;
//
//            while(row > 3 || row < 0)
//            {
//                System.out.println("That is an invalid number. Please enter a number between 1 and 4");
//                userEntry = scanner.nextInt();
//                row = userEntry - 1;
//            }
//
//            if (flipped[row][col]) {
//                System.out.println("This card has already been flipped. Try again!");
//            } else {
//                flipped[row][col] = true;
//
//                if (firstRow == -1 && firstCol == -1)
//                {
//                    firstRow = row;
//                    firstCol = col;
//                } else {
//                    printBoard(board, flipped);
//
//                    if (pairsMatch(board, flipped, firstRow, firstCol, row, col)) {
//                        System.out.println("Congratulations! You found a pair!");
//                        pairsFound++;
//                    } else {
//                        System.out.println("Sorry! Try again.");
//                        flipped[firstRow][firstCol] = false;
//                        flipped[row][col] = false;
//                    }
//                    firstRow = -1;
//                    firstCol = -1;
//                }
//            }
//        }
//
//        System.out.println("You won the game!");
//    }
//
//    public static void printBoard(int[][] board, boolean[][] flipped)
//    {
//        System.out.println("Board:");
//
//        for (int i = 0; i < board.length; i++)
//
//        {
//            for (int j = 0; j < board[i].length; j++) {
//                if (flipped[i][j]) {
//                    System.out.print(board[i][j] + " ");
//                } else {
//                    System.out.print("* ");
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    public static boolean pairsMatch(int[][] board, boolean[][] flipped, int firstRow, int firstCol, int secondRow, int secondCol) {
//        int firstValue = board[firstRow][firstCol];
//        int secondValue = board[secondRow][secondCol];
//
//        return firstValue == secondValue;
//    }






    public static void memoryMatchingBoard()//This is the memory matching board method
    {
        System.out.println("\nWelcome to the Memory Matching Board!");
        System.out.println("In this game, you must make all 8 matches and fill the board to advance! Type in the row and the column (coordinate point from 0 - 3) of the spot you are guessing.");//these past 2 lines print the instructions for the activities
        anastasia();//calling the anastasia method to print her avatar

        int[][] board = generateBoard();//this is a 2 dimensional array that calls the generate board method
        boolean[][] flipped = new boolean[4][4];//this is a double boolean two-dimensional array that holds boolean values if certain grid boxes are flipped

        playGame(board, flipped);//calling the playGame method, giving the parameter variables of board and the flipped
    }

    public static int[][] generateBoard() //this is the generateBoard method

    {
        int[][] board = new int[4][4];//this creates a new 4 x 4 two-dimensional array
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8};//this is an array of 16 numbers, repeating numbers from 1 to 8. The repeating numbers are pairs
        Random random = new Random();//importing the random class

        // Shuffle the numbers
        for (int i = nums.length - 1; i > 0; i--) //this uses the fisher yates shuffle algorithm that I found online to help shuffle the numbers on the board. This was also done to shuffle the array at the beginning of the code in the main method!

        {
            int j = random.nextInt(i + 1);//generating a random number between the i, which is basically nums.length - 1
            int temp = nums[i];//stores the current element into a temp variable
            nums[i] = nums[j];//assigns the element in the temp to the new index
            nums[j] = temp;//assigns the element that was replaced into the temp to continue shuffling
        }

        // Assign the shuffled numbers to the board
        int count = 0;//this is the count accumulator variable

        for (int i = 0; i < board.length; i++) //board.length is 16 because it is [4 rows] x [4 columns]
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = nums[count];
                count++;
            }

            //assigning values one row at a time
//            * * * *
//            * * * *
//            * * * *
//            * * * *
        }

        return board;//returns the board to the board array in the memoryMatchingGame array
    }

    public static void playGame(int[][] board, boolean[][] flipped)//accepts 2 arrays
    {
        Scanner scanner = new Scanner(System.in);//new scanner object called scanner for user input of columns and rows
        int pairsFound = 0;//accumulator variable of how many pairs the user found

        int firstRow = -1;
        int firstCol = -1;

        // special value that means that there is valid index yet the absence of a valid index or a specific condition.

        int userEntry; //stores the integer of the user input

        while (pairsFound < 8) //when the number of pairs found is less than 8
        {
            printBoard(board, flipped);//call the printBoard method and sending the board and flipped array

            System.out.print("Enter the column number (1-4): ");//user is to enter the column number
            userEntry = scanner.nextInt();//assigns this to user entry
            int col = userEntry - 1;//subtracting 1 to get the correct index and assigning this to the column

            while(col > 3 || col < 0)//while the column is more than 3 or less than 0, the following code will execute
            {
                System.out.println("That is an invalid number. Please enter a number between 1 and 4");//Incorporating input validation so that this asks the user to re-enter values
                userEntry = scanner.nextInt();//assign the userEntry value from the scanner
                col = userEntry - 1;//userEntry - 1 to ensure the indexes are correct
            }

            System.out.print("Enter the row number (1 - 4): ");//user is to enter the column number
            userEntry = scanner.nextInt();//assign the userEntry value from the scanner
            int row = userEntry - 1;//userEntry - 1 to ensure the indexes are correct

            while(row > 3 || row < 0)//while the column is more than 3 or less than 0, the following code will execute
            {
                System.out.println("That is an invalid number. Please enter a number between 1 and 4");//Incorporating input validation so that this asks the user to re-enter values
                userEntry = scanner.nextInt();//assign the userEntry value from the scanner
                row = userEntry - 1;//userEntry - 1 to ensure the indexes are correct
            }

            if (flipped[row][col])//if the row and column are true - meaning they have been flipped
            {
                System.out.println("This card has already been flipped. Try again!");//printing that the card has already been flipped and found
            }
            else
            {
                flipped[row][col] = true; // if they are not true, make it true

                if (firstRow == -1 && firstCol == -1)//condition that checks if this is the first card being flipped

                {
                    firstRow = row;
                    firstCol = col;

                    // If it is the first card, the firstRow and firstCol variables are updated with the current row and col values.
                }
                else
                {
                    printBoard(board, flipped); // if the first card was not flipped,  display the current state of the board, including the currently flipped cards

                    if (pairsMatch(board, flipped, firstRow, firstCol, row, col))//check if the newly inputted card matches the first one by calling the pairsMatch method

                    {
                        System.out.println("Congratulations! You found a pair!");
                        pairsFound++;
                    }
                    else
                    {
                        System.out.println("Sorry! Try again.");//prints that the player needs to try again because the match was unsuccessful
                        flipped[firstRow][firstCol] = false;//making the flipped boolean array false in terms of the first row and first column
                        flipped[row][col] = false;//making the flipped boolean array false in terms of the first row and first column

                        //If the cards do not match, it prints a message indicating that the attempt was unsuccessful
                        //and sets both the previously flipped card and the current card to false in the flipped array.
                    }
                    firstRow = -1;//this indicates that the firstRow is not found
                    firstCol = -1;//this indicates that the firstCol is not found
                }
            }
        }

        System.out.println("You have completed the board and won the game! Congratulations!");//informing the user that they won the game
        scanner.close();//closing the scanner (Scanner object) in order to save memory space
    }

    public static void printBoard(int[][] board, boolean[][] flipped)//takes in the board array and the flipped array
    {
        System.out.println("Board:");//print out that this is the board

        for (int i = 0; i < board.length; i++) //iterate 16 times because that is the length of the board

        {
            for (int j = 0; j < board[i].length; j++)//iterates each column
            {
                if (flipped[i][j])//if both are flipped
                {
                    System.out.print(board[i][j] + " "); //print the number at that location
                }
                else //this code will execute if flipped[i][j] is false
                {
                    System.out.print("* ");//this indicates that the space or card has not been flipped
                }
            }
            System.out.println();//printing a space in between
        }
    }

    public static boolean pairsMatch(int[][] board, boolean[][] flipped, int firstRow, int firstCol, int secondRow, int secondCol) //this is the pairsMatch that accepts the board array, flipped array, firstRow, firstCol, secondRow and secondCol
    //compares the values of two flipped cards on the game board.
    {
        int firstValue = board[firstRow][firstCol];
        int secondValue = board[secondRow][secondCol];
        //It retrieves the values of the two cards from the board array based on the provided row and column indexes

        return firstValue == secondValue; //returning a boolean result if the pairs match

    }
}
