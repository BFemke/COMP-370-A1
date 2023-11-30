import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class ArraysTest {
    public static void testCreation() {
        final int N = 2000000000;
        int MAX_VALUE = 9;
        Random rnd= new Random(System.currentTimeMillis());
        System.out.println("--- Date: " + new Date() + " ---");
        System.out.println("--- Sample size = " + N + " ---");
        {
            // Measure ArrayList
            long startTime = System.currentTimeMillis(); //timer is initiated, logging begins
            ArrayList<Integer> a = new ArrayList<>();
            for(int i = 0; i < N; ++i) {
                a.add(rnd.nextInt(MAX_VALUE));

            }
            long stopTime = System.currentTimeMillis(); //timer is halted, logging stops
            long elapsedTime = stopTime - startTime; //computes time difference - reports the difference
            System.out.println(String.format("%-30s  %d", "ArrayList", elapsedTime));
        }

        {
            // Measure ArrayList with initial size
            long startTime = System.currentTimeMillis(); //timer is initiated, logging begins
            ArrayList<Integer> a = new ArrayList<>(N);
            for(int i = 0; i < N; ++i) {
                a.add(rnd.nextInt(MAX_VALUE));

            }
            long stopTime = System.currentTimeMillis();     //timer is halted, logging stops
            long elapsedTime = stopTime - startTime;        //computes time difference - reports the difference
            System.out.println(String.format("%-30s  %d", "ArrayList with initial size", elapsedTime));
		}

        {
            // Measure Vector
            long startTime = System.currentTimeMillis(); //timer is initiated, logging begins
            Vector<Integer> v = new Vector<>();
            for(int i = 0; i < N; ++i) {
                v.add(rnd.nextInt(MAX_VALUE));
            }
            long stopTime = System.currentTimeMillis(); //timer is halted, logging stops
            long elapsedTime = stopTime - startTime; //computes time difference - reports the difference
            System.out.println(String.format("%-30s  %d", "Vector", elapsedTime));
        }

        {
            // Measure Vector with initial size
            long startTime = System.currentTimeMillis(); //timer is initiated, logging begins
            Vector<Integer> v = new Vector<>(N);
            for(int i = 0; i < N; ++i) {
                v.add(rnd.nextInt(MAX_VALUE));
            }
            long stopTime = System.currentTimeMillis();  //timer is halted, logging stops
            long elapsedTime = stopTime - startTime;     //computes time difference - reports the difference
            System.out.println(String.format("%-30s  %d", "Vector with initial size", elapsedTime));
        }

        {
            // Measure array
            long startTime = System.currentTimeMillis(); //timer is initiated, logging begins
            int[] arr = new int[N];
            for(int i = 0; i < N; ++i) { arr[i] = rnd.nextInt(MAX_VALUE); }
            long stopTime = System.currentTimeMillis(); //timer is halted, logging stops
            long elapsedTime = stopTime - startTime; //computes time difference - reports the difference
            System.out.println(String.format("%-30s  %d", "array", elapsedTime));
        }
    }

    public static void testSum() {
        final int N = 2000000000;
        int MAX_VALUE = 9;
        Random rnd= new Random();
        System.out.println("--- Date: " + new Date() + " ---");
        System.out.println("--- Sample size = " + N + " ---");
        {
            // Measure ArrayList
            ArrayList<Integer> a = new ArrayList<>();
            for(int i = 0; i < N; ++i) { a.add(rnd.nextInt(MAX_VALUE)); }
            Iterator<Integer> it = a.iterator();
            long s = 0;
            long startTime = System.currentTimeMillis(); //timer is initiated, logging begins
            while(it.hasNext()) {
                s += it.next();
            }
            long stopTime = System.currentTimeMillis(); //timer is halted, logging stops
            long elapsedTime = stopTime - startTime; //computes time difference - reports the difference
            System.out.println(String.format("%-30s  %d", "ArrayList", elapsedTime));
		}

        {
            // Measure Vector
            Vector<Integer> v = new Vector<>();
            for(int i = 0; i < N; ++i) { v.add(rnd.nextInt(MAX_VALUE)); }
            long startTime = System.currentTimeMillis(); //timer is initiated, logging begins
            Iterator<Integer> it = v.iterator();
            long s = 0;
            while(it.hasNext()) {
                s += it.next();
            }
            long stopTime = System.currentTimeMillis(); //timer is halted, logging stops
            long elapsedTime = stopTime - startTime; //computes time difference - reports the difference
            System.out.println(String.format("%-30s  %d", "Vector", elapsedTime));
		}

        {
            // Measure array
            int[] arr = new int[N];
            for(int i = 0; i < N; ++i) { arr[i] = rnd.nextInt(MAX_VALUE); }
            long startTime = System.currentTimeMillis(); //timer is initiated, logging begins
            long s = 0;
            for(int i = 0; i < N; ++i) s += arr[i];
            long stopTime = System.currentTimeMillis(); //timer is halted, logging stops
            long elapsedTime = stopTime - startTime; //computes time difference - reports the difference
            System.out.println(String.format("%-30s  %d", "array", elapsedTime));
		}
    }

    public static void main(String[] args) {
        testCreation();
        //testSum();
    }

}
