package algorithms;

public class MergeSortTutorial {

    static int count = 0;

    private static void printArray(int[] array) {
        System.out.print("i =>" + count + ": ");
        for(int i: array) {
            System.out.print(i + ", ");
        }
        System.out.println();
        count +=1;
    }

    private static int[] mergeSort(int[] array) {
        // array only has one value or need to sort
        if(array.length <= 1) {
            return array;
        }

        // midpoint index of the initial array passed
        int midpoint = array.length / 2;

        // subarray #1 of array: total legnth is: 0 to middle nth elements
        int[] left = new int[midpoint];
        int[] right;

        // check if array has even elements or odd - that determines the midpoint index for right
        // create sub array #2 of array
        if(array.length % 2 == 0) {
            right = new int[midpoint]; // say array[4] then right[2] and left[2] evenly.
        } else {
            right = new int[midpoint + 1]; // odd elements so e.g say 5 array[5] then left[2] and right[3] of lengths
        }

        // populate the left array with - to middle nth elmements of array (i.e. we're sorting)
        for(int i = 0; i < midpoint; i++) {
            left[i] = array[i]; // so adds [5, 4] of [5, 4, 3, 2, 1]
        }

        // popular the right array with - middle (+1 for odd parent elements) to last element in array (parent)
        for(int j = 0; j < right.length; j++) {
            right[j] = array[midpoint+j]; // so adds [3, 2, 1] of [5, 4, 3, 2, 1]
        }

        int[] result;

        /* print array */

        printArray(left);
        printArray(right);

        // recursive part of the mergeSort
        // recursion over once line 13 of function is true, and returns array.
        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right);

        return result;

    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int leftPointer, rightPointer, resultPointer;

        leftPointer = rightPointer = resultPointer = 0;

        while(leftPointer < left.length || rightPointer < right.length) {

            // checking if both left AND right arrays have elements to be sorted/tested - sort final as follows:
            if(leftPointer < left.length && rightPointer < right.length) {

                // check which element in greater in the right/left arrays
                if(left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else { // right pointer is less than left
                    result[resultPointer++] = right[rightPointer++];

                }
            } else if(leftPointer < left.length) { // only left array has elements to be sorted/tested
                result[resultPointer++] = left[leftPointer++];
            }

            else if(rightPointer < right.length) { // only right array has elements to be sorted/tested
                result[resultPointer++] = right[rightPointer++];
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int[] array = { 5, 4, 3, 2, 1 };

//        System.out.println("Initial Array: ");
//        printArray(array);

        array = mergeSort(array); // mergeSort sort the array in asc oder

        System.out.println("Sorted Array: ");
        printArray(array);
    }
}
