package workshop4;
/*
CAB301 Workshop 4 Questions
        Exercise 1: Simulating and Iterative Binary Search
        Exercise 2: Simulating Sorting Algorithms
        Exercise 3: Implementing Sorting Algorithms
*/
public class Main {
    public static void main(String args[]) {
        int[] sortedList= { 1, 2, 3, 4, 5};

        // find target value in array
        int index = binarySearch(sortedList, 3) ;
        System.out.println("result "+ sortedList[index]);

    }
    /*

           Binary search steps
          1. Start with the middle element 6 - if its equal to target otherwise of left to right
          2. 6 < 10, so 10 must be to the right
          3. remaining range in which we should search from 8 to 12
          4. repeat

          1.1 start with middle element 10 - if its equal to target - yes!

          note: use formula for middle element (floor value): m = l + [ r - l / 2 ]

       */
public static int binarySearch(int[] sortedArray, int target) {

    int l = 0;
    int r = sortedArray.length - 1;
    int midpoint = -1;

    while (l <= r) {
        midpoint = l + (r - l)/2;

        if(sortedArray.length == 0) {
            return -2; // list and divided to the point all elements check, and not found.
        }

        if (sortedArray[midpoint] == target) { // eventually the only element left after recursive elimination will be midpoint  i.e. target
            return midpoint;
        } else if (midpoint > target) { // midpoint greater than target
            r = midpoint - 1;
        } else { // midpoint is less than target
            l = midpoint + 1;
        }
    }

    return -1; // array given is length 0 or 1 element.
}

}

