
public class Fibonnaci {

	public static void main(String[] args) {
		int n = Integer.valueOf(args[0]);
		int a[] = new int[n];
		a[0] = 0;
		a[1] = 1;
		int i = 2;
		while (i < n) {
			a[i] = a[i-1] + a[i-2];
			i++;
		}
       int nthFibonaaci =  a[--i]; 
       System.out.println(n+"th fibanaaci number is: "+nthFibonaaci);
	}
	
	
	
}
