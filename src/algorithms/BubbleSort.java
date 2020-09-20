package algorithms;


public class BubbleSort {
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;

        for(int i = 0; i < n; i++) {
            for(int j=1; j < (n-i); j++) {
                if(arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }

            for (int num: arr) {
                System.out.print(num + " ");
            }
            System.out.println("=> i="+ i);



        }
    }
    public static void main(String[] args) {
        int arr[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };

        System.out.println();
        bubbleSort(arr);

    }
}