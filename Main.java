package sorting;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        String filePath=input.next();
        long startTime= System.currentTimeMillis();
        Chunks chunk = new Chunks();
        chunk.divide(filePath);
        long endTime = System.currentTimeMillis();
        System.out.println("time" + (endTime - startTime));
    }
}