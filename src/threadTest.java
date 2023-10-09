import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class threadTest extends Thread{
    private String name;
    private Thread t;
    private LazyInitializedSingleton instance;

    public threadTest(String name){
        this.name = name;
        System.out.println("Creating " + this.name);
    }

    public void run() {

        // Creating fields that will contain date info
        Date rightNow;
        Locale currentLocale;
        DateFormat timeFormatter;
        DateFormat dateFormatter;
        String timeOutput;
        String dateOutput;

        int count = 0;

        // Output the current date and time 3 times
        for (int i = 1; i <= 3; i++) {

            // A Date object contains date and time data
            rightNow = new Date();

            // Locale defines time formats depending on location
            currentLocale = new Locale("en", "US");

            // DateFormat allows you to define dates / times using predefined
            // styles DEFAULT, SHORT, MEDIUM, LONG, or FULL
            // getTimeInstance only outputs time information

            timeFormatter = DateFormat.getTimeInstance(DateFormat.SHORT, currentLocale);

            // getDateInstance only outputs time information
            dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT, currentLocale);

            // Convert the time and date into Strings
            timeOutput = timeFormatter.format(rightNow);
            dateOutput = dateFormatter.format(rightNow);

            System.out.println(timeOutput);
            System.out.println(dateOutput);
            System.out.println();


            ////////////////////////////////
            // LazyInitializedSingleton

            instance = LazyInitializedSingleton.getInstance();
            System.out.println(this.name + ": " + "hash: " + instance.hashCode());

            // You must wrap the sleep method in error handling
            // code to catch the InterruptedException exception
            // sleep pauses thread execution for 2 seconds below

            try {
                if(count==0){
                    System.out.println("notice the different hashes");
                    Thread.sleep(6000);
                    count++;
                }
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                //System.out.println("Thread has been interrupted");
            }
        }
    }



}
