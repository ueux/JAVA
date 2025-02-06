import java.util.HashMap;
import java.util.Scanner;
class A{
    public void show1(){
        System.out.println("In A class");
    }
}
class B extends A{
    public void show2(){
        System.out.println("In B class");
    }
}
class Mobile{
    int price;
    static String os;
    //static block executes only one time independent of no of objects
    static{
        os="Android";
        System.out.println("inside static block");
    }
    public Mobile(int p){
        price=p;
        System.out.println("inside constructor");
    }
}
class  Counter{
    int count;
    public synchronized void count(){
        count++;
    }
}
public class Intermediate {
    public static void main(String []args){

        Scanner sc=new Scanner(System.in);
        //jacked array
        int[][] jack =new int[3][];
        jack[0]=new int[3];
        jack[1]=new int[4];
        jack[2]=new int[5];
        for(int p=0;p<jack.length;p++){
            for(int q=0;q<jack[p].length;q++){
                jack[p][q]=sc.nextInt();
            }
        }
        for(int[] row_arr:jack){
            for(int c:row_arr){
                System.out.print(c);
            }
            System.out.println();
        }

        //String constant pool - strings are immutable strings by default
        String str1="Har";
        String str2="Har";
        System.out.println(str1==str2);

        //StringBuffer - mutable strings
//        StringBuffer sb=new StringBuffer();
//        System.out.println(sb.capacity());
        StringBuffer sb=new StringBuffer("Harsh");
        System.out.println(sb.capacity()); //extra 16 space
        System.out.println(sb.length());
        sb.append(" Kumar");
        sb.deleteCharAt(2);
        sb.insert(5,"_");
        sb.setLength(20);
        //StringBuffer is thread saved but StringBuilder is not

        //first class is loaded then the objects are instantiated thus static block executes first
        Mobile mb1=new Mobile(12000);
        Mobile mb2=new Mobile(22000);
        // static method cant access instance variables as it gets confusing which instance variable is used but we can pass objects to use them
        //Class - loads the class without making objects
        try{
            Class.forName("Mobile");
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }

        //package keyword
        //packages - are folders -> packages-> classes
        //by default java.lang.* is imported having System, String classes
        //* -> all files not folder
        //when class is in diff package we use public access specifiers to access data and methods

        //extends
        // we can create object of sub class of supper class type
        //supper obj=new sub()

        //final - with class-> stops inheritance , with methods -> stops overriding

        //up casting
        A obj=new B();  //with reference of A
        obj.show1();
        //down casting
        B obj1=(B)obj;
        obj1.show2();

        //inner class
        //A.B obj1=obj.new B();


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
//       Runnable obj2=()->{
//       };
//       Runnable obj3=new Runnable(){
//           @Override
//           public void run() {
//
//           }
//       };
       thread1.setDaemon(true); // ends as main thread ends
        System.out.println("You have 5 sec to enter name");
        System.out.println("Game Starts");
        thread1.start();
        thread2.start();
        //Treads with mutation
        Counter c=new Counter();
        Runnable obj2=()->{
            for (int i=0;i<100000;i++){
                c.count();
            }
        };
        Runnable obj3=()->{
            for (int i=0;i<100000;i++){
                c.count();
            }
        };
        Thread t1=new Thread(obj3);
        Thread t2=new Thread(obj2);
        t1.start();
        t2.start();
        // to make one thread to wait for another thread before incrementing the value we use synchronized keyword
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            System.out.println("The Main Thread was Interrupted");
        }
        System.out.println("counter"+c.count);
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
