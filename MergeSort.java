import java.util.Arrays;

/**
 * Created by Chaitanya.Chobharkar on 2/27/2018.
 */
public class MergeSort {

    public static void main(String[] args) {
       int a[] = {-51,-14,-3,-32,-1,0};
        int b[] = new int[a.length];
        mergeSort(a, 0,a.length-1,b);
        System.out.println(Arrays.toString(a));
    }


    private static void mergeSort(int a[], int l, int r, int b[]) {
        if (l >= r) {
            return;
        }

        int m = (l+ r) / 2;
        mergeSort(a, l, m,b);
        mergeSort(a, m+1, r, b);

        System.out.println(m);
        merge(a,l,r,m,b);
    }

    private static void merge(int a[], int l, int r, int m, int b[]) {
        //System.out.println("l="+l+" r="+r+" m="+m);
        //int temp[] = new int[a.length];
        for (int i=l; i<=r; i++) {
            b[i] = a[i];
        }

        int n1= m;
        int n2 = r;
        int i = l;
        int j = m+1;
        int k = l;
        while (i <= n1 && j <= n2 ) {
            if (b[i] <= b[j]) {
                a[k] = b[i];
                i++;
                k++;
            } else {
                a[k] = b[j];
                j++;
                k++;
            }

        }
        while (i <= n1) {
            a[k] = b[i];
            i++;
            k++;
        }
       /* while (j <= n2) {
            b[k] = a[j];
            j++;
            k++;
        }*/
        //merge(a,l,r,m,b);
    }


}
