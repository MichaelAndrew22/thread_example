public class threadTest extends Thread{
    private String name;
    private Thread t;
    private LazyInitializedSingleton instance;

    public void run(){
        System.out.println("Thread "+ this.name +" is running   ");

        try{
            int rand = (int)(Math.random() * 1000);
            Thread.sleep(rand);
            instance = LazyInitializedSingleton.getInstance();


        }catch(InterruptedException e){
            System.out.println("Thread " +  this.name + " interrupted");

        } finally {
            System.out.print("Thread " + this.name + ": ");
            System.out.print("hash: " + instance.hashCode());

            System.out.println(" exiting.");
        }


    }
    public void start(){
        System.out.println("Thread " + this.name + " is starting");
        if(t == null){
            t = new Thread(this, this.name);
            t.start();
        }
    }

    public void register(String name){
        this.name = name;
    }
}
