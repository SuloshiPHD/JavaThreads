import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'maxPresentations' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY scheduleStart
     *  2. INTEGER_ARRAY scheduleEnd
     */

    public static int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {
        // Map with key as meeting start time, and value as the list of time taken values.
        Map<Integer, List<Integer>> mymapList = new LinkedHashMap<>();
        for (int i = 0; i < scheduleStart.size(); i++) {
            List<Integer> list = mymapList.get(scheduleStart.get(i));
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(scheduleEnd.get(i));
            mymapList.put(scheduleStart.get(i), list);
        }
        System.out.println(mymapList);

        // Get meetings one by one
        Set<Integer> mykeys = mymapList.keySet();
        Iterator<Integer> myiterator = mykeys.iterator();
        Integer time = myiterator.next();
        List<Integer> listofInt = mymapList.get(time);
        // Sort the time taken values so we can pick the least duration meeting
        listofInt.sort(null);
        int count = 1;

        while (myiterator.hasNext()) {
            List<Integer> myPrevList = listofInt;
            int intVal = myPrevList.get(0);
            int myPrevTime = time;

            time = myiterator.next();
            listofInt = mymapList.get(time);
            listofInt.sort(null);
            // Check if total time taken for this meeting is less than the next meeting starting time.
            if (intVal + myPrevTime <= time) {
                count++;
            } else {
                time = myPrevTime;
                listofInt = myPrevList;
            }
        }
        return count;


    }
}

    public  class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int scheduleStartCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> scheduleStart = new ArrayList<>();

            for (int i = 0; i < scheduleStartCount; i++) {
                int scheduleStartItem = Integer.parseInt(bufferedReader.readLine().trim());
                scheduleStart.add(scheduleStartItem);
            }

            int scheduleEndCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> scheduleEnd = new ArrayList<>();

            for (int i = 0; i < scheduleEndCount; i++) {
                int scheduleEndItem = Integer.parseInt(bufferedReader.readLine().trim());
                scheduleEnd.add(scheduleEndItem);
            }

            int result = Result.maxPresentations(scheduleStart, scheduleEnd);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }




