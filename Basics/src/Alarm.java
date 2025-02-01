import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Alarm {
    public  static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
        String filePath="C:\\Users\\HARSH\\Downloads\\Sound The Alarm - TrackTribe.wav";
        LocalTime alarmTime=null;
        while(alarmTime==null){
            try{
                System.out.println("Enter the alarm time(HH:MM:SS):");
                String inputTime=sc.nextLine();
                alarmTime=LocalTime.parse(inputTime,formatter);
                System.out.println("Alarm set for "+alarmTime);
            }
            catch(DateTimeParseException e){
                System.out.println("Invalid format");
            }
        }
        AlarmClock alarmClock=new AlarmClock(alarmTime,filePath,sc);
        Thread alarmThread=new Thread(alarmClock);
        alarmThread.start();
//        sc.close();// closes all scanner objects
    }
}
