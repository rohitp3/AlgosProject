/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algosproject;

/**
 *
 * @author Rohit Padma
 */
public class RandomNumber {
    
    public static void main(String[] args)
    {
    
}
    public long[] generateNum(int n,int roption)
    {
        long temp[];
        temp = new long[n];
        long range;
        if(roption==1)
        {
            range=100000000;
        }
        else
        {
            range=10000;
        }
        
        for(int i=0;i<n;i++)
        {
         temp[i]= (long)(Math.random()*range);
        }
        return temp;
    }
   
}
