package algorithms;

/*
Analysis:
Worst complexity: n^2
Average complexity: n^2
Best complexity: n^2
Space complexity: 1

NOT STABLE ALGO - not sorted in relative positions of elements that are same [5(1st), 5(2ns)...]

Inefficient on large lists, and generally performs worse than the similar insertion sort.

    [10]  6   3   7     2       1. start with [i] = 10

    {2}   6   3   7   [10]      2. find a {j} smaller than [i] swap (at the end of innerloop j)

    2    [6]  {3}   7   10      3. Repeat step (1)

    2    3     6   7   10                Step (2)

                                Remember: We only swap once after end of inner loop (j)



 */


public class SelectionSort {

    public static void main(String[] args) {
        int[] numbers = {10, 6, 3, 7, 2};

        System.out.println("Unsorted: ");
        printArray(numbers);

        System.out.println("\nSelection Sorted: ");
        int[] sorted = selectionSort(numbers);
//        printArray(sorted);

    }

    public static int[] selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int minIndex = i;   // first - starting element in the array

            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIndex]) {   // j < i (if next value is > than current value)
                    minIndex = j;
                }
            }
            int temp = A[minIndex]; // store (smallest) value in temp
            A[minIndex] = A[i]; // swap current ith value at A[i] (bigger value) to where the smallest value was
            A[i] = temp;    // swap the next jth (smallest value) found to current index i

            for (int num:A) {
                System.out.print(" " + num + " ");
            }
            System.out.println( " => i = " + i+": ");        }
        return A;   // sorted
    }

    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
    }
}