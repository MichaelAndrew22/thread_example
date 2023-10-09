import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Thread> threadList = new ArrayList<Thread>();

        for(int i = 0; i < 3; i++){
            threadList.add(new threadTest("Thread " + i + ""));
        }

            for(Thread thread: threadList){
                thread.start();
            }


    }
}
