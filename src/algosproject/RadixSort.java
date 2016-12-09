package algosproject;

import java.util.Arrays;

public class RadixSort {
   public static void main(String []args)
    {
        
    }
    public long[] sortlong(long temp[])
    {
        long maxnumber= Arrays.stream(temp).max().getAsLong();
        int n=temp.length;  
        long outarray[];
        for(int i=1;maxnumber/i>0;i=i*10)
        {
            temp=sortcount(temp,i);
        }
        
        return temp;
        
    }  
    
    public  static long [] sortcount(long input[],int place)
    {
        long[] out = new long[input.length];

        long[] count = new long[10];

        for(int i=0; i < input.length; i++){
            int digit = (int)getDigit(input[i], place);
            count[digit] += 1;
        }

        for(int i=1; i < count.length; i++){
            count[i] += count[i-1];
        }

        for(int i = input.length-1; i >= 0; i--){
            int digit = (int)getDigit(input[i], place);

            out[((int)(count[digit]))-1] = input[i];
            count[digit]--;
        }

        return out;
    }
    private static long getDigit(long value, int digitPlace){
        return ((value/digitPlace ) % 10);
    }
    
    
}
