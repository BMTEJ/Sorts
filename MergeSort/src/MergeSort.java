import java.io.PrintStream;
import java.util.Arrays;

public class MergeSort {

    public static void mergeSplit(int[] arr, int leng){
        if (leng < 2){
            return;
        }
        int mid = leng / 2;
        int[] left = new int[mid];
        int[] right = new int[leng - mid];

        for (int i = 0; i < mid; i++){
            left[i] = arr[i];
        }

        for (int j = mid; j < leng; j++){
            right[j - mid] = arr[j];
        }

        mergeSplit(left, mid);
        mergeSplit(right, leng - mid);

        merge(arr, left, right, mid, leng - mid);
    }

    public static void merge(int[] arr,int[] left,int[] right,
                       int leftEnd, int rightEnd){
        int i = 0, j = 0, k = 0;
        while (i < leftEnd && j < rightEnd){
            if (left[i] <= right[j]){
                arr[k] = left[i];
                k++;
                i++;
            } else{
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < leftEnd){
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < rightEnd){
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] newArr = new int[]{10, 11, 2, 60, 21, 5, 9, 18};
        System.out.println("unsorted: " + Arrays.toString(newArr));
        mergeSplit(newArr, newArr.length);
        System.out.println("sorted: " + Arrays.toString(newArr));
    }
}
