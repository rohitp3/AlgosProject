/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algosproject;

/**
 *
 * @author Rohit
 */
public class RandomNumber {
    
    public static void main(String[] args)
    {
    
}
    public long[] generateLongNum(int n)
    {
        long temp[];
        temp = new long[n];
        for(int i=0;i<n;i++)
        {
         temp[i]= (long)(Math.random()*100000000);
        }
        return temp;
    }
   
    public int[] generateIntNum(int n)
    {
        int temp[];
        temp=new int[n];
        for(int j=0;j<n;j++)
        {
          temp[j]=(int)(Math.random()*10000);  
        }
        return temp;
    }
}
