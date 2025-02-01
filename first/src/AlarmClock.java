import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable{
    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner sc;
    AlarmClock(LocalTime aT, String fP, Scanner sc){
        alarmTime=aT;
        filePath=fP;
        this.sc=sc;
    }
    @Override
    public void run() {
        LocalTime now=LocalTime.now();
        while(now.isBefore(alarmTime)){
            try {
                Thread.sleep(1000);
                now=LocalTime.now();
                int hrs=now.getHour();
                int min=now.getMinute();
                int sec=now.getSecond();
                System.out.printf("\r%02d:%02d:%02d",hrs,min,sec);
            }
            catch(InterruptedException e){
                System.out.println("Alarm Thread is Interrupted");
            }
        }
        System.out.println();
        playSound(filePath);
    }
    private void playSound(String filePath){
        File audioFile=new File(filePath);
        try(AudioInputStream audioStream= AudioSystem.getAudioInputStream(audioFile);){
            Clip clip=AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();;
//            try{
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                System.out.println("Thread is interrupted");
//            }
            System.out.println("*Alarm Noise");
            System.out.println("Press enter to stop the alarm");
            sc.nextLine();
            clip.stop();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("File not supported");
        }
        catch (LineUnavailableException e){
            System.out.println("Audio is Unavailable");
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }
        finally {
            sc.close();
        }
    }
}
