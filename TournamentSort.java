package sorting;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TournamentSort
{
    private int index;
    public long findMin(long[] num)
    {
        int length=num.length;
        long min=num[0],x=0;
        index=0;
        for(int i=1 ; i<length-1 ; i+=2)
        {
            x=Math.min(num[i],num[i+1]);
            if(x<min)
            {
                min = x;
                if(min==num[i])
                    index=i;
                else
                    index=i+1;
            }
        }
        if(length%2==0 && num[length-1]<min) {
            min = num[length - 1];
            index=length-1;
        }
        return min;
    }
    public void tournamentSort(int NumberOfChunks) throws FileNotFoundException, IOException {
        String str = "";
        int maxValueCount = 0;
        long num[] = new long[NumberOfChunks];
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("finalFile.txt"));
        BufferedReader bufferedReader[] = new BufferedReader[NumberOfChunks];

        for (int i = 0; i < NumberOfChunks; i++) {
            bufferedReader[i] = new BufferedReader(new FileReader("file" + i + ".txt"));
            num[i] = Long.parseLong(bufferedReader[i].readLine());
        }
        long min = findMin(num);
        bufferedWriter.write(min + "\r\n");
        while (maxValueCount != NumberOfChunks) {
            str = bufferedReader[index].readLine();
            if (str != null)
                num[index] = Long.parseLong(str);
            else if (str == null) {
                num[index] = Long.MAX_VALUE;
                maxValueCount++;
            }
            min = findMin(num);
            if (min != Long.MAX_VALUE) {
                bufferedWriter.write(min + "\r\n");
            }
        }
        bufferedWriter.close();
    }
}

