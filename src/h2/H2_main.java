package h2;

public class H2_main {

    
    static long[] cache = new long[1001];

    public static void main(String[] args) {
        int n = 45; 
        System.out.println("Berechne Fibonacci für n = " + n);
        
        benchmark(n);
    }

    
    public static long fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    
    public static long fibonacciCached(int n) {
        if (n <= 2) {
            return 1;
        }
        
       
        if (cache[n] != 0) {
            return cache[n];
        }
        long result = fibonacciCached(n - 1) + fibonacciCached(n - 2);
        cache[n] = result;
        
        return result;
    }

   
    public static long fibonacciIterative(int n) {
        if (n <= 2) {
            return 1;
        }
        
        long f1 = 1;
        long f2 = 1;
        long current = 0;

        for (int i = 3; i <= n; i++) {
            current = f1 + f2;
            f1 = f2;
            f2 = current;
        }
        return current;
    }

    public static void benchmark(int n) {
     
        long start = System.nanoTime();
        long resA = fibonacci(n);
        long end = System.nanoTime();
        System.out.println("Ergebnis (rekursiv): " + resA);
        System.out.println("Elapsed nanoseconds (fibonacci): " + (end - start));

        cache = new long[1001]; 
        start = System.nanoTime();
        long resB = fibonacciCached(n);
        end = System.nanoTime();
        System.out.println("Ergebnis (cached): " + resB);
        System.out.println("Elapsed nanoseconds (fibonacciCached): " + (end - start));

        start = System.nanoTime();
        long resC = fibonacciIterative(n);
        end = System.nanoTime();
        System.out.println("Ergebnis (iterativ): " + resC);
        System.out.println("Elapsed nanoseconds (fibonacciIterative): " + (end - start));
    }
}
