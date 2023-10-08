public class Main {
    public static void main(String[] args) {

        threadTest[] threads = new threadTest[10];


        for(int i = 0; i < 10; i++){
            threads[i] = new threadTest();
            threads[i].register(String.valueOf(i));
            threads[i].start();
            threads[i].run();
        }


    }
}
