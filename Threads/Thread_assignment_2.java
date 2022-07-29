import java.util.*;
public class Main {
  
    public static void main(String[] args)
    {
        
        Random r = new Random();
        int[] array = new int[10];
        System.out.println("Random Numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(65536)-32768;
            System.out.println(array[i]);
            
        }
            for(int i=0;i<10;i++){
               int number = array[i];
        Thread th1 = new Thread(new Runnable() {
            public void run(){
                synchronized (this)
                {
                        while (number>0 && number % 2 == 1) {
                            try {
                                System.out.println(number + " is poistive and odd.");
                                wait();
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        
                        notify();
                    
                }
            }
        });
  
        Thread th2 = new Thread(new Runnable() {
            public void run()
            {
                synchronized (this)
                {
                        while (number>0 && number % 2 == 0) {
          
                            // Exception handle
                            try {
                                System.out.println(number + " is positive and even ");
                                wait();
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        notify();
                    
                }
            }
        });
        Thread th3 = new Thread(new Runnable() {
            public void run()
            {
                synchronized (this)
                {
                        while (number<0 ) {
          
                            // Exception handle
                            try {
                                System.out.println(number + " is Negative ");
                                wait();
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        notify();
                }
            }
        });
        th1.start();
        th2.start();
        th3.start();

    }
    }
}
