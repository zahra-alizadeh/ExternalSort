package sorting;
import java.util.Arrays;

public class MergeSort
{
    public static void merge(long[] s1 , long[] s2 , long[] s)
    {
        int i=0;
        int j=0;
        while(i+j<s.length)
        {
            if(j==s2.length || (i<s1.length && s1[i]<s2[j]))
                s[i+j]=s1[i++];
            else
                s[i+j]=s2[j++];
        }
    }
    public static void mergeSort(long[] a) {
        int n = a.length;
        if (n < 2)
            return;
        int mid = n / 2;
        long s1[] = Arrays.copyOfRange(a, 0, mid);
        long s2[] = Arrays.copyOfRange(a, mid, n);
        mergeSort(s1);
        mergeSort(s2);
        merge(s1, s2, a);
    }
}