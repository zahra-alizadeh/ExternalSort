package sorting;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
public class Chunks
{
    private final int capacity=30_000_000;
    public void divide(String fileName) throws IOException
    {
        long num[]=new long[capacity];
        MergeSort sort=new MergeSort();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        int numberCount=0,fileCount=0;
        String number=bufferedReader.readLine();
        while(number!=null)
        {
            while(numberCount<capacity && number!=null)
            {
                num[numberCount] = Long.parseLong(number);
                number = bufferedReader.readLine();
                numberCount++;
            }
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("file"+fileCount+".txt"));
            if(numberCount==num.length)
            {
                sort.mergeSort(num);
                for(int j=0 ; j<numberCount; j++)
                    bufferedWriter.write(num[j]+"\r\n");
            }
            else
            {
                long a[]= Arrays.copyOfRange(num, 0, numberCount);
                sort.mergeSort(a);
                for(int j=0 ; j<numberCount ; j++)
                    bufferedWriter.write(a[j] + "\r\n");
            }
            numberCount=0;
            fileCount++;
            bufferedWriter.close();
        }
        if(fileCount==1)
        {
            File oldFile=new File("file0.txt");
            File newFile=new File("finalFile.txt");
            oldFile.renameTo(newFile);
        }
        else
        {
            TournamentSort tournamentSort = new TournamentSort();
            tournamentSort.tournamentSort(fileCount);
        }
    }
}
