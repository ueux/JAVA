import java.util.HashMap;
import java.util.Scanner;

public class Intermediate {
    public static void main(String []args){

        //HashMap - key-value pair, unique keys
        HashMap<String,Double> map=new HashMap<>();
        map.put("Apple",10.40);
        map.put("Banana",5.60);
        map.put("Banana",10.60);
        map.remove("Apple");
        map.get("Banana");
        map.containsKey("Banana");
        map.containsValue(10.6);
        map.size();
        System.out.println(map);
        for(String key:map.keySet()){
            System.out.println(key+" "+map.get(key));
        }

        //Enums - special class with fixed set of constants , more effective when comparing strings
        Days day=Days.SUNDAY;
        System.out.println(day);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a day :");
        String response=sc.nextLine().toUpperCase();
       try{
           Days day1=Days.valueOf(response);
           switch(day1){
               case MONDAY-> System.out.println("This is Monday");
               case TUESDAY-> System.out.println("This is Tuesday");
               case SUNDAY-> System.out.println("This is Sunday");
           }
       }
       catch(IllegalArgumentException e){
           System.out.println("Enter a week day");
       }

       //Threading - run a time-consuming operation(File I/O, network communications in parallel
//        1- by thread class   2- Runnable interface(better)
        //Multithreading - running multiple threads concurrently
        MyRunnable myRunnable=new MyRunnable("Ping");
       Thread thread1 =new Thread(myRunnable);
       Thread thread2=new Thread(new MyRunnable("Pong"));
       thread1.setDaemon(true); // ends as main thread ends
        System.out.println("You have 5 sec to enter name");
        System.out.println("Game Starts");
        thread1.start();
        thread2.start();
        /*
                main
         thread1 || thread2
                main
         */
        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("The Main Thread was Interrupted");
        }
        System.out.println("Gmae Ends"); //main threads continues without waiting for threads to complete
        /*
        main || thread1 || thread2
        */
       System.out.println("Enter your name: ");
       String name=sc.nextLine();
       System.out.println("Hello "+ name);

       sc.close();
    }
}
