import java.util.Arrays;

/**
 * Created by Chaitanya.Chobharkar on 2/27/2018.
 */
public class QuickSort {

    public static void main(String[] args) {
        int a[] = {90,0,-170,-60,50,40,-10};
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int a[], int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(a, l, r);

        quickSort(a, l, p-1);
        quickSort(a, p+1, r);
    }


    private static int partition(int a[], int l, int r) {
       int p = r;
        int i = l;
        int j = r-1;
        while (i <= j) {
            if (a[i] > a[p]) {
                if (a[j] <= a[p]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }

        int temp = a[i];
        a[i] = a[p];
        a[p] = temp;
        return  i;
    }

}
