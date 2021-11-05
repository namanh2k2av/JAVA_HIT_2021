package Bai5;

public class RunMain {
    public static boolean isPrime(int n){
        for (int i=2; i*i<=n; i++)
            if(n % i ==0)
                return false;
        return n > 1;
    }

    public static boolean isPrime(long n){
        for (int i=2; i*i<=n; i++)
            if(n % i ==0)
                return false;
        return n > 1;
    }

    public static boolean isPrime(float n){
        if(n == (int)n){
            for (int i=2; i*i<=n; i++)
                if (n % i ==0)
                    return false;
            return n > 1;
        }else
            return false;
    }

    public static boolean isPrime(double n){
        if(n == (int)n){
            for (int i=2; i*i<=n; i++)
                if (n % i ==0)
                    return false;
            return n > 1;
        }else
            return false;
    }

    public static void main(String[] args) {
        System.out.println("-- Int --");
        System.out.println(isPrime(3));
        System.out.println("-- Long --");
        System.out.println(isPrime(191L));
        System.out.println("-- Float -- ");
        System.out.println(isPrime(3.1f));
        System.out.println(isPrime(3.0f));
        System.out.println("-- Double -- ");
        System.out.println(isPrime(3.1));
        System.out.println(isPrime(3.0));
    }
}
