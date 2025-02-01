public class MyRunnable implements Runnable {

    private final String text;

    MyRunnable(String text){
        this.text=text;
    }

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            try{
                Thread.sleep(1000);
//                System.out.println(i);
                System.out.println(Thread.currentThread().getName()+" "+i);
                System.out.println(text);
            }
            catch(InterruptedException e){
                System.out.println("Thread was Interrupted");
            }
            if(i==5){
                System.out.println("Times up");
                System.exit(0);// ends the main thread
            }
        }
    }
}
