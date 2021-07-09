package CoderByte;

import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {

        Scanner in  = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = in.nextInt(); //size of the array is n

        int arr[] = new int[n];
        System.out.println("Enter an array values");
        //input array values
        for (int i = 0; i<n ; i++){
            arr[i] = in.nextInt();
        }


        int temp;

        int start = 0;
        int end = n-1;


        //1,3,8,9,10
        while (start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end --;
        }
        System.out.println("Reverse array" );

        for(int j = 0; j < n ; j++){
            System.out.println(arr[j]);
        }

    }




}
