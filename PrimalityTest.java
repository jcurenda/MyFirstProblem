import java.util.Scanner;

public class PrimalityTest {
    public static void main(String args[]){
        System.out.println("Enter a number positive n number to create");
        System.out.println("a list of the first n primes.");

        int listSize;
        Scanner in = new Scanner(System.in);
        listSize = in.nextInt();
        in.close();

        if(listSize < 1){
            System.out.println("Unable to proceed.");
            return;
        }

        //create list of primes using a prime sieve
        System.out.println("The first " + listSize + " primes are:");
        printArray(sieve(listSize));
    }

    private static int [] sieve(int n){
        int[] primes = new int[n];
        primes[0] = 2;
        if(n >= 2){
            primes[1] = 3;
        }
        int candidate,maxTest, j;
        boolean compositeFound, primeFound;
        for(int i = 2; i < n; i++){

            primeFound = false;
            candidate = primes[i-1] + 2; //after 2 all primes are prime
            while(!primeFound){
                //test for primality of candidate
                compositeFound = false;
                j = 1;
                maxTest = (int)Math.sqrt((double)candidate);
                while(primes[j] <= maxTest && (j <= i-1) && !compositeFound){
                    if(candidate % primes[j] == 0){
                        compositeFound = true;
                    }
                    j++;
                }
                if(compositeFound){
                    // go to next candidate and retest
                    candidate+=2;

                }
                else{
                    //prime was found
                    primeFound = true;
                    primes[i] = candidate;
                }
            }
            // next prime is stored in candidate



        }

        return primes;

    }

    private static void printArray(int [] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
