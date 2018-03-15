import java.util.Arrays;

/**
 * Created by Chaitanya.Chobharkar on 2/28/2018.
 */
public class InsertionSort {

    public static void main(String[] args) {

            int a[] = {80,70,10,130,100};
            insertionSort(a);
        System.out.println(Arrays.toString(a));

    }


    private static void insertionSort(int a[]) {
        for (int i=0; i<a.length; i++) {
            int temp = a[i];
            int j = i-1;
            if (j == -1) {
                continue;
            }
            while (j >= 0 && a[j] > temp ) {
              a[j+1] = a[j];
              j--;
            }
            j++;
            a[j] = temp;
        }
    }

}
