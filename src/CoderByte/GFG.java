package CoderByte;

//Java program to find the most frequent element
//in an array

// if two or more elements have the maximum frequency RETURN THE FIRST ELEMENT OF THE ARRAY
import java.util.*;

class GFG {

    static int mostFrequent(int arr[], int n)
    {

        // Sort the array
        Arrays.sort(arr);

        // find the max frequency using linear
        // traversal
        int max_count = 1, res = arr[0];
        int curr_count = 1;

        for (int i = 1; i < n; i++)
        {
            if (arr[i] == arr[i - 1])
                curr_count++;
            else
            {
                if (curr_count > max_count)
                {
                    max_count = curr_count;
                    res = arr[i - 1];
                }
                curr_count = 1;
            }
        }

        // If last element is most frequent
        if (curr_count > max_count)
        {
            max_count = curr_count;
            res = arr[n - 1];
        }

        return res;
    }

    // Driver program
    public static void main (String[] args) {

        int arr[] = {0, 5, 2,5,2};
        int n = arr.length;

        System.out.println(mostFrequent(arr,n));

    }


    /**
     * public static int maxFrequencyNumber(int[] arr){
     *     if(arr.length == 0)
     *         return -1;
     *     int maxFreq = 0;
     *     int number = -1;
     *     HashMap<Integer,Integer> map = new HashMap<>();
     *
     *     for(int i=0;i<arr.length;i++)
     *     {
     *         if(map.containsKey(arr[i]))
     *         {
     *             map.put(arr[i],map.get(arr[i])+1);
     *         }
     *         else {
     *             map.put(arr[i], 1);
     *         }
     *     }
     *     // using set data structure
     *     Set<Integer> keySet = map.keySet();
     *     for(Integer i:keySet)
     *     {
     *         if(map.get(i) > maxFreq)
     *         {
     *             number = i;
     *             maxFreq = map.get(i);
     *         }
     *     }
     *     return number;
     * }
     */
}


