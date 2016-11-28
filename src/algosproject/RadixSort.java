/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algosproject;

import java.util.Arrays;

/**
 *
 * @author Rohit
 */
public class RadixSort {
   public static void main(String []args)
    {
        
    }
    public long[] sortlong(long temp[])
    {
        long maxnumber= Arrays.stream(temp).max().getAsLong();
        int n=temp.length;   
        for(int i=1;maxnumber/i>0;i=i*10)
        {
        long output[] = new long[n]; // output array
        int j;
        long count[] = new long[10];
        Arrays.fill(count,0);
        for ( j = 0; j < n; j++)
            count[ (temp[j]/i)%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (j = n - 1; j >= 0; j--)
        {
            output[count[ (temp[j]/i)%10 ] - 1] =  temp[i];
            count[ (temp[i]/i)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            temp[i] = output[i];
 
        }
        
        return temp;
        
    }  
}
