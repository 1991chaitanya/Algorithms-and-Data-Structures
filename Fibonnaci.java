
public class Fibonnaci {

	public static void main(String[] args) {
       int factorial = factorial(5);
       System.out.println(factorial);
       
       // fibonacci(100, 0, 1);
       
       int gcd = gcdLemma(357, 234);
       System.out.println(gcd);
       
       
	}
	
	private static int factorial(int n) {
		if (n == 1) {
			return n;
		}
		
		return n* factorial(n-1);
	}
	
	private static void fibonacci(int n, int i, int j) {
		if (n == 1) {
			return;
		}
	
		int x = i + j;
		System.out.println(x);
		fibonacci(--n, j, x);
	}
	
    private static int gcd(int a, int b) {
    	int i = 1;
    	int n = a < b ? a : b;
    	int gcd = 0;
    	while (i <= n) {
    		if (a % i == 0 && b % i == 0) {
    			gcd = i;
    		}
    		i++;
    	}
    	
    	return gcd;
    }
    
    private static int gcdLemma(int a, int b) {
       if (b == 0) {
    	   return a;
       }
    	int prime = a>b ? a % b : b %a;
      
      return gcdLemma(b, prime); 
    }
	
}
