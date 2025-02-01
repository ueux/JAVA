/*
exceptions - array out of bound, incorrect data type
*/
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class Basics {
    static int x=3; // Class variables
    static Scanner sc=new Scanner(System.in); // In Case Of more Methods
    public static void main(String []args) throws InterruptedException {
        int i=2147483647;
        long l=2147483647;
        float f=2.33f;
        double d=2.33;
        char ch='1';
        boolean bool=true;
        String str="Hello";

        //Scanner sc=new Scanner(System.in);
        sc.nextLine();
        sc.next();
        sc.nextInt();
        sc.nextDouble();
        sc.nextBoolean();

        int age=sc.nextInt();
        sc.nextLine();
        String color=sc.nextLine();

        //ORDER OF OPERATIONS [ P-E-M-D-A-S ]

        str.isEmpty();
        str.length();
        str.charAt(0);
        str.toUpperCase();
        str.indexOf('a');
        str.trim();
        str.replace('a','r');
        str.contains("s");
        str.equals("bjw");
        String email="xyz@gmail.com";
        String user=email.substring(0,email.indexOf("@"));

        Random r=new Random();
        r.nextInt(1,7); // 7 not included
        r.nextDouble(); //0-1 decimals
        r.nextBoolean();
        System.out.println(r.nextInt());

        double pi = Math.PI;
        double e = Math.E;
        double pow = Math.pow(2, 2);
        double sqrt = Math.sqrt(9);
        long round = Math.round(3.45);

        System.out.printf("%.4f\n",pi);
        /* %[flag][width][.precision][specifier-character]
        * [specifiers]
        * s-String
        * c-char
        * d-int
        * f-float, double
        * [flags]
        * + = Output with plus for positive numbers
        * , = Comma after thousands -> for amount
        * space = display a space if positive number
        * [width]
        * number = right justified padding
        * */

        //variable=(condition)? ifTrue : ifFalse;

        sc.next().toUpperCase();

        //Enhanced Switch
        switch(str){
            case "mon","tue","wed"-> {
                System.out.println("day");
            }
            default ->
                System.out.println("not a day");
        }
        // if("har"=='h'){}

        while(email.isEmpty()){
            System.out.println("Enter the email");
            email=sc.nextLine();
        }

        //Arithmetic operations
        System.out.println("Enter first number:");
        int x=sc.nextInt();
        System.out.println("Enter Operation(+,-,*,/,%):");
        int op=sc.next().charAt(0);
        System.out.println("Enter Second number:");
        int y=sc.nextInt();
        switch(op){
            case '+'->System.out.println("x+y="+(x+y));
            case '-'->System.out.println("x-y="+(x-y));
            case '*'->System.out.println("x*y="+(x*y));
            case '/'->System.out.println("x/y="+(x/y));
            case '%'->System.out.println("x%y="+(x%y));
            default->System.out.println("Invalid Operation");
        }

        //guess game
        int guess,atmp=0;
        int min=1,max=100;
        int rand=r.nextInt(min,max+1);
        System.out.printf("Enter a guess between %d-%d",min,max);
        do
        {
            guess=sc.nextInt();
            atmp++;
            if(guess<rand){
                System.out.println("Guess Higher");
            } else if (guess>rand) {
                System.out.println("Guess Lower");
            }else {
                System.out.println("Correct");
                System.out.println("# Attempts :"+atmp);
            }
        }while (guess!=rand);

        Thread.sleep(1000);

        String character; //Local

        //method are unfamiliar with the variables in another method so we use arguments and parameters
        method(str);

        //DICE ROLLING
        int roll=r.nextInt(1,7);
        printDie(roll);

        //int arr=1;
//        int[]arr={1,454,64,45};
//        int[]arr={};// Array of size 0 but no value can be assign
        int[]arr=new int[4]; //Empty Array of size 4
        System.out.println(arr); //address of array
        System.out.println(arr[0]);
        arr[0]=100;
        int len = arr.length;
        for(int j=0;j<arr.length;j++){
            arr[j]=sc.nextInt();
        }
        //enhanced for loop
        for(int elm:arr){
            System.out.print(elm+" ");
        }
        System.out.println();
//        for(int elm:arr){
//            elm=sc.nextInt();
//        }
        //Arrays class
        Arrays.sort(arr);
        Arrays.fill(arr,1);
        for(int elm:arr){
            System.out.print(elm+" ");
        }
        System.out.println();
        //FOR SEARCHING AN ELEMENT USE A FLAG VARIBLE
        //FOR STRINGS "==" DOESN'T WORKS , WE USE  if(arr[i].equals("hello"))

        // varargs = allows a method to accept a varying arguments , no need for overloaded methods, all arguments are packed into an array
        // we use ...(ellipses) for this
        add(1,2,3);

        //2d array
        int[]N={1,2,3,4};
        int[]W={0,1,2,3};
        int[]Z={-2,-1,0,1};
        int[][]num={{1,2,3,4},W,Z};
        for(int[] no:num){
            for(int p:no){
                System.out.print(p+" ");
            }
            System.out.println();
        }
        num[1][0]=7;

        //QUIZ GAME
        String[] Questions={"What is the main function of a router?",
        "Which part of the computer is considered as the  brain of computer",
        "What year was Fecebook launched?"};
        String[][]Options={{"1.Storing files","2.Encrypting data","3.Directing internet traffic"},
                {"1.CPU","2.Hard Drive","3.RAM"},
                {"1.2000","2.2004","3.2006"}};
        int[] ans={3,1,2};
        int score=0;
        for(int j=0;j<Questions.length;j++){
            System.out.println(Questions[j]);
            for(String option:Options[j]){
                System.out.println(option);
            }
            System.out.print("Enter your Guess:");
            int gue=sc.nextInt();
            if(gue==ans[j]){
                score+=1;
            }
        }
        System.out.println("Your Score="+score);

        //Rock Paper Scissors
        sc.nextLine();
        String[]choices={"rock","paper","scissors"};
        String playerChoice;
        String compChoice;
        String playAgain="yes";
        do{
            System.out.println("Enter your choice(rock,paper,scissors):");
            playerChoice=sc.nextLine().toLowerCase();
            if(!playerChoice.equals("rock")&&
                    !playerChoice.equals("paper")&&
                    !playerChoice.equals("scissors")){
                System.out.println("Invalid Choice");
                continue;
            }
            compChoice=choices[r.nextInt(4)];
            System.out.println("Computer Chooses: "+compChoice);
            if(playerChoice.equals(compChoice)){
                System.out.println("It's a TIE");
            }
            else if((playerChoice.equals("rock")&&compChoice.equals("scissors"))||
                    (playerChoice.equals("paper")&&compChoice.equals("rock"))||
                    (playerChoice.equals("scissors")&&compChoice.equals("paper"))){
                System.out.println("You WON");
            }
            else{
                System.out.println("You LOOSE");
            }
            System.out.println("Play Again (yes/no) ?");
            playAgain=sc.nextLine().toLowerCase();
        }while(playAgain.equals("yes"));


        //Slot Machine
        int balance=100,bet,payout;
        String[]row;
        System.out .println("Symbols:🍋 🍒 🍑 🔔 💰");
        while(balance>0){
            System.out .println("Current Balance: ₹"+balance);
            System.out.print("Enter your bet: ");
            bet=sc.nextInt();
            sc.nextLine();
            if(bet>balance){
                System.out.println("INSUFFICIENT AMOUNT");
                continue;
            }
            else if(bet<0){
                System.out.println("AMOUNT should be greater than 0");
                continue;
            }
            else{
                balance-=bet;
            }
            System.out.println("Spinning...");
            row=spinRow();
            printRow(row);
            payout=getPayout(row,bet);
            if(payout>0){
                System.out.println("Yow won ₹"+payout);
                balance+=payout;
            }
            else{
                System.out.println("Sorry You Lose");
            }
            System.out.print("Play Again (Y,N)?:");
            playAgain=sc.nextLine().toUpperCase();
            if(!playAgain.equals("Y")){
                break;
            }
        }
        System.out.println("Game Over! Your Final Balance: ₹"+balance);




        sc.close();
    }
    static void method(String str){
        String character; //Local
        character=sc.nextLine();
    }
    static double method(int x,int y){
        return 2.5;
    }

    static void printDie(int roll){
        String dice1= """
                 -------
                | ●     |
                |   ●   |
                |     ● |
                 -------
                """;
        switch(roll){
            case 1->System.out.println(dice1);
        }
    }
    static void add(int ... numbers){
        for(int no : numbers){
            System.out.println(no);
        }
    }
    static String[] spinRow(){
        String[] symbols={"🍋", "🍒", "🍑" ,"🔔" ,"💰"};
        Random r=new Random();
        String[] row=new String[3];
        for(int i=0;i<3;i++){
            row[i]=symbols[r.nextInt(symbols.length)];
        }
        return row;
    }
    static void printRow(String[] row){
        System.out.println(" "+String.join(" | ",row));
    }
    static int getPayout(String[] row,int bet){
        if(row[0].equals(row[1])&&row[1].equals(row[2])){
            return switch(row[0]){
                case "🍋"->bet*2;
                case "🍒"->bet*3;
                case "🍑"->bet*5;
                case "🔔"->bet*7;
                case "💰"->bet*10;
                default -> 0;
            };
        }
        else if(row[1].equals(row[2])){
            return switch(row[1]){
                case "🍋"->bet*2;
                case "🍒"->bet*3;
                case "🍑"->bet*4;
                case "🔔"->bet*6;
                case "💰"->bet*9;
                default -> 0;
            };
        }
        else if(row[0].equals(row[1])){
            return switch(row[1]){
                case "🍋"->bet*2;
                case "🍒"->bet*3;
                case "🍑"->bet*4;
                case "🔔"->bet*6;
                case "💰"->bet*9;
                default -> 0;
            };
        }
        else
         return 0;

    }
}
