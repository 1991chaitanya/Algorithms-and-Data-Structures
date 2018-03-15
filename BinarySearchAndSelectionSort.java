import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Chaitanya.Chobharkar on 2/23/2018.
 */
public class BinarySearchAndSelectionSort {


    static int binSearch(int a[], int i, int j, int k) {
        int x = (i + j) /2;
        if (a[x] == k ) {
            return x;
        }

        if (k > a[x] ) {
           return binSearch(a,x+1,j,k);
        } else {
           return binSearch(a,i,x-1,k);
        }
    }

    static void selectionSort(int a[]) {
        for (int i=0; i<a.length; i++) {
            int min = a[i];
            int z = i;
            for (int j=i; j<a.length;j++) {
                if (a[j] < min) {
                    min = a[j];
                    z = j;
                }
            }
            int temp = a[i];
            a[i] = min;
            a[z] = temp;
        }
    }


    public static void main(String[] args) {
        int a[] = {1,2,4,5,654,65,7,8,2,0};
        System.out.println("Original array: "+Arrays.toString(a));
        selectionSort(a);
        System.out.println("Sorted array: "+Arrays.toString(a));
        int i = binSearch(a, 0, (a.length - 1), 654);
        System.out.println("Found at index: "+i);

    }

}
