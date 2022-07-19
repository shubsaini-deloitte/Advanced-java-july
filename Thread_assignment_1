import java.util.*;

class Processor{
    private List<Integer> elements = new ArrayList<>();
    private static final int UPPER = 10;
    private static final int LOWER = 0;
    private final Object lock = new Object();
    private int value  = 0 ;
    
    public void producer() throws InterruptedException{
        synchronized(lock){
            while(true){
                if(elements.size() == UPPER){
                    System.out.println("Removing items...");
                    lock.wait();
                } else {
                    System.out.println("Adding:"+value);
                    elements.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }
    }
    public void consumer() throws InterruptedException{
        synchronized(lock){
            while(true){
                if(elements.size() == LOWER){
                    System.out.println("Adding items...");
                    value = 0;
                    lock.wait();
                } else {
                    System.out.println("Removing:"+elements.remove(elements.size()-1));
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }
    }
}

class Entry {
    public static void main(String[] args) {
        Processor process = new Processor();
        
        Thread th1 = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    process.producer();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        
        Thread th2 = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    process.consumer();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        
        th1.start();
        th2.start();
    }
}
