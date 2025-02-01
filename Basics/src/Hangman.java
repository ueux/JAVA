import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
public class Hangman {
    public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    String filePath="C:\\Users\\HARSH\\IdeaProjects\\first\\src\\Words.txt";
    ArrayList<String>words=new ArrayList<>();
    try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
        String line;
        while((line=br.readLine())!=null){
            words.add(line.trim());
        }
    }
    catch (FileNotFoundException e){
        System.out.println("Could not find file");
    }
    catch (IOException e) {
        System.out.println("Something went wrong");
    }
    Random r=new Random();
    System.out.println(words);
    String word=words.get(r.nextInt(words.size()));
    ArrayList<Character> wordState=new ArrayList<>();
    int wrong=0;
        for(int i=0;i<word.length();i++){
        wordState.add('_');
    }
        System.out.println("Welcome to Java Hangman");
        while(wrong<6){
        System.out.println(getHngmanArt(wrong));
        System.out.print("Word: ");
        for (char ch:wordState){
            System.out.print(ch+" ");
        }
        System.out.println();
        System.out.println("Guess a letter: ");
        char guess=sc.next().toLowerCase().charAt(0);
        if(word.indexOf(guess)>=0){
            System.out.println("Correct Guess");
            for (int i=0;i<word.length();i++){
                if(word.charAt(i)==guess){
                    wordState.set(i,guess);
                }
            }
            if(!wordState.contains('_')){
                System.out.println((getHngmanArt(wrong)));
                System.out.println("You Win");
                System.out.println("The Word Was : "+word);
                break;
            }
        }else{
            System.out.println("Wrong Guess");
            wrong++;
        }
    }
        if(wrong>=6){
            System.out.println((getHngmanArt(wrong)));
            System.out.println("Game Over");
            System.out.println("The Word Was : "+word);
        }


        sc.close();
}
static  String getHngmanArt(int w){
    return switch (w){
        case 0-> """
                    
                     """;
        case 1-> """
                       o
                     """;
        case 2-> """
                       o
                       |
                     """;
        case 3-> """
                       o
                      /|
                     """;
        case 4-> """
                       o
                      /|\\
                     """;
        case 5-> """
                       o
                      /|\\
                      /
                     """;
        case 6-> """
                       o
                      /|\\
                      / \\
                     """;
        default -> """
                    """;

    };

 }
}