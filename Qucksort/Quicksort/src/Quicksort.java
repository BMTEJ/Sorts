import java.util.Arrays;
import java.util.Random;

public class Quicksort {
    private int[] unsorted;
    private int lstLength;
    Random randPos;

    Quicksort(int[] ulst) {
        unsorted = ulst;
        lstLength = ulst.length;
        randPos = new Random();
    }

    public int[] sort() {

        boolean sorted = false;

        while (!sorted) {

            int pivotIndex = randPos.nextInt(0, unsorted.length);
            int pivot = unsorted[pivotIndex];
            int leftPos = 0;
            int rightPos = lstLength - 1;
            int leftElement = unsorted[leftPos];
            int rightElement = unsorted[rightPos];


            while(rightPos >= leftPos){
                if(rightElement <= pivot && leftElement >= pivot){
                    unsorted[leftPos] = rightElement;
                    unsorted[rightPos] = leftElement;

                    leftPos += 1;
                    rightPos -= 1;
                    leftElement = unsorted[leftPos];
                    rightElement = unsorted[rightPos];

                } else {
                    if (rightElement >= pivot){
                        rightPos -= 1;
                        rightElement = unsorted[rightPos];
                    }
                    if (leftElement <= pivot){
                        leftPos += 1;
                        leftElement = unsorted[leftPos];
                    }
                }
            }
                if (rightPos == 0){
                    sorted = true;
                }
                pivot = unsorted[randPos.nextInt(lstLength)];
                leftPos = 0;
                rightPos = lstLength - 1;
                leftElement = unsorted[leftPos];
                rightElement = unsorted[rightPos];

        }
        return unsorted;
    }

    public static void main(String[] args) {
        String test;
        int[] lst = new int[]{9, 10000, 17, 11, 91, 77, 1, 42, 31};
        Quicksort quick = new Quicksort(lst);
        System.out.println(Arrays.asList(lst).toString());
        int[] newLst = quick.sort();
        System.out.println(Arrays.asList(newLst).toString());
    }
}