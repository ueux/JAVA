import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class OOPS {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        Car car1 = new Car(); //object created
        System.out.println(car1.isRunning);
        car1.start();
        System.out.println(car1.isRunning);
        car1.stop();
        System.out.println(car1.isRunning);
        Car car2 = new Car(); // have same attribute as car1

        Student std1 = new Student("Harsh", 20, 9.1); //Class with constructor
        std1.study();

        Student std2 = new Student("Anami", 19, 9.5);
        Student[] students = {std1, std2};
        for (Student std : students) {
            System.out.println(std.name);
        }
        Student[] studs = new Student[2];

        System.out.println(Student.numsOfStuds); // use class name for static members
        Student.showStuds();
        //Example of static function
        long round = Math.round(67.55);

        //For INHERITANCE use extends keyword
        Person p1 = new Person("Harsh", "Kumar");
        p1.showName();

        //super keyword
        std1.showTeacher();

        //Method Overriding
        //.toString()
        System.out.println(std1);
        System.out.println(std2);

        //
//        Encapsulation - wraping of data inside metods to access data we use getters and setters
//        Abstraction
//        Abstract class
//        Can't be instantiated directly (No object)
//        can contain 'abstract' methods (which must be implemented)
//        can contain 'concrete' methods(which are inherited)

//        Shape sh=new Shape(); //error
        Circle circle = new Circle(10);
        Rectangle rectangle = new Rectangle(10, 20);

//        Interface - a blueprint of a class with abstract methods
//        supports multiple-inheritance like behavior
        Rabbit rab = new Rabbit();
        Fish fish = new Fish();

        //lambda expression works with functional interface
        Prey obj=()-> System.out.println("lambda exp");
        obj.flee();

//        Polymorphism - an object can identify as other objects
//        like a dog can be identified as an animal, organism , dog
        Car car = new Car();
        Bike bike = new Bike();
//        Car[] cars={car,bike}; //error
        Vehicle[] vehicles = {car, bike};
        for (Vehicle vehicle : vehicles) {
            vehicle.go();
        }
        //also implemented by interface

        //Runtime Polymorphism - The executing method is decided at runtime
//      Animal animal=new Animal(); //error
        Animal animal;
        System.out.println("Enter your Choice (1=Dog , 2=Cat):");
        int choice = sc.nextInt();
        if (choice == 1) {
            animal = new Dog();
        } else {
            animal = new Cat();
        }
        animal.speek();

        //Aggregation - Objects inside Objects
        Book b1 = new Book("The Fellow of the Ring", 432);
        Book b2 = new Book("The two Tower", 352);
        Book b3 = new Book("The Return of the King", 416);
//        Book[] books = {b1, b2, b3};
        Book[] books=new Book[3];
        books[0]=b1;
        books[1]=b2;
        books[2]=b3;
        Library library = new Library("NYC Public Library", 1897, books);
        library.displayInfo();
        System.out.println(library.books[0].page);

//        Composition - Objects parts of Objects
        Cars c1 = new Cars("Corvette", 2025, "V8");

//        Wrapper classes - Allow primitive value(int,char,souble,boolean) to be used as objects.
//        Generally , don't wrap primitive unless you need an object.
//        Allow use of Collections Framework and Static Utility Methods
//        int a=123;
//        Integer a=new Integer(123);  //Depreciated
        // Moder Method - Autoboxing
        Integer a = 123;
        String s = "Harsh";
        // Unboxing
        int b = a;
        //have many utility methods
        String c = Integer.toString(123);
        //String to primitive type - parsing
        int d = Integer.parseInt("123");
        //Char doesn't have parse method
        System.out.println(Character.isLetter(b)); //Check a-z A-Z
        System.out.println(Character.isUpperCase(c.charAt(0)));

//        ArrayList - a resizable array that stores objects or primitive types(Autoboxing)
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.remove(0);
        list.add(17);
        list.set(0, 10);
        System.out.println(list);
        System.out.println(list.get(0) + list.size());
        list.add(30);
        list.add(50);
        list.add(25);
        Collections.sort(list);
        System.out.println(list);

        //Exception
        try {
            int[] arr = new int[3];
            Arrays.fill(arr, 1);
            System.out.println(arr[4]);
            System.out.println("Enter a number :");
            int num = sc.nextInt();
            System.out.println(num);
            if(num==0)
                throw new InputMismatchException("Do not put 0");
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            System.out.println(("You Can't divide by zero"));
        } catch (InputMismatchException e) {
            System.out.println(("Please enter integer type"+e));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("index Out of bound");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        } finally { //always executed like normal  flow of code
            System.out.println("Final block");
        }

        //Navin Exceptions- custom exceptions

        System.out.println("out of try catch finally");

        // write file
        String fileName = "C:\\Users\\HARSH\\OneDrive\\Desktop\\Text.txt";
        String fileContent = """
                “Do what you can, with what you have, where you are.” – Theodore Roosevelt\s
                “Never regret anything that made you smile.” – Mark Twain\s
                “Re-examine all you have been told. Dismiss what insults your soul.” – Walt Whitman\s
                “Every day that you open your eyes is a new day and another day to get it right.”
                """;
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(fileContent);
            System.out.println("File has been Written");
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate file location");
        } catch (IOException e) {
            System.out.println("could not write file");
        }

        //read file
//        3 options
//        BufferReader+FileReader
//        FileInputStream(image, audio)
//        RandomAccessFile
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File can't find");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

        //Play audio with java(.wav,.au,.aiff)
        String filePath = "C:\\Users\\HARSH\\Downloads\\Across Seas And Lands - Asher Fulero.wav";
        File file = new File(filePath);
        //Auto closable interface -> Scanner and audioStream supports
        try (Scanner sc2 = new Scanner(System.in);
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);) {
            Clip clip = AudioSystem.getClip();  // like aa audio player
            clip.open(audioStream);
//            clip.start();// play for brief moment - we can use threading in while loop
            String response = "";
            while (!response.equals("Q")) {
                System.out.println("P- Play");
                System.out.println("S- Stop");
                System.out.println("R- Reset");
                System.out.println("Q- Quit");
                System.out.println("Enter your choice:");
                response = sc.next().toUpperCase();
                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> {
                        clip.stop();
                        clip.setMicrosecondPosition(0);
                    }
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid Choice");
                }
            }
            System.out.println("No Problem Detected");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (LineUnavailableException e) {
            System.out.println("Unable to access Audio Resource");
        } catch (UnsupportedAudioFileException e) {
            System.out.println("this Audio file not supported");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        } finally {
            System.out.println("Bye");
        }


        //Hangman game

        //Date and Time
        LocalDate date=LocalDate.now();
        System.out.println(date);
        LocalTime time =LocalTime.now();
        System.out.println(time);
        LocalDateTime dateTime=LocalDateTime.now();
        System.out.println(dateTime);
        //custom format
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String newDateTime=dateTime.format(formatter);
        System.out.println(newDateTime);

        LocalDateTime dateTime1=LocalDateTime.of(2024,12,25,12,0,0);
        LocalDateTime dateTime2=LocalDateTime.of(2024,12,25,12,0,0);
        if(dateTime1.isBefore(dateTime2)){
            System.out.println(dateTime1+ " is earlier thar "+dateTime2);
        }else if(dateTime1.isAfter(dateTime2)){
            System.out.println(dateTime1+ " is later thar "+dateTime2);
        }

        //Anonymous class - no name, cannot be reused,(TimerTask, Runnable, Callbacks)
        Dog dog=new Dog();
        dog.speek();
        //Suppose we have scooby which speaks english then we have to make an another class and override the speek function
        // so instead of creating an another class for a single exception we use anonymous class
        Dog dog2=new Dog(){
            @Override
            void speek() {
                System.out.println("Scooby says *Ruh Roh*");
            }
        };
        dog2.speek();

        //Timer
        int response=10;
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            int count=0;
            @Override
            public void run() {
                System.out.println(count);
                count++;
                if(count>response){
                    System.out.println("Task Completed");
                    timer.cancel();
                }
            }
        };
//        timer.schedule(task,0,1000);

        //Countdown
        timer.scheduleAtFixedRate(task,0,1000);

        //Generics - code compatible with different data types
//        <T>- type parameters
//        <Integer>or <String> ... - type arguments
        Product<String,Double> product=new Product<>("Apple",10.2);


        sc.close();
    }
}
