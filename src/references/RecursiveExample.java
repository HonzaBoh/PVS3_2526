package references;

public class RecursiveExample {

    static void saharaCount(long a){
        System.out.println(a);
        if (a == Long.MAX_VALUE){
            return;
        }
        saharaCount(a+1);
    }

    static long factorial(long n){
        if ( n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        try{
            saharaCount(1);
        } catch (StackOverflowError se){
            System.out.println("Dosla stack pamet");
            System.out.println("Chyba: " + se.getMessage());
            se.printStackTrace();
        }
//        System.out.println(factorial(5));
        System.out.println("happy ending!");
    }
}
