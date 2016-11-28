/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algosproject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Rohit Padma
 */
public class AlgosProjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    int n;  
    long inputArray[];
    long sortedArray[];
    int Roption;
    int Soption;
    long startTime=0;
    long stopTime=0;
    int Ooption;
    // TODO code application logic here
    Scanner sc=new Scanner(System.in);
    System.out.println("*****Welcome to Algos Experiment console!*******");
    System.out.println("How would you like input? ");
    System.out.println("1. Manual");
    System.out.println("2. File");
    System.out.println("3. Random");
    System.out.println("4. Skip");
    int inputoption=Integer.parseInt(sc.nextLine());
    
    switch(inputoption)
    {  
        case 1: {
                 System.out.println("Enter the size of array:");
                 n=Integer.parseInt(sc.nextLine());
                 inputArray=new long[n];
                 for(int j=0;j<n;j++)
                 {
                  inputArray[j]=Long.parseLong(sc.nextLine().trim());
                 }
                 }
                 break;
        case 2 :{
                  inputArray=new long[0];
                }
                break;
        case 3 :{
                 System.out.println("Options to generate random numbers");
                 System.out.println("1. Long numbers");
                 System.out.println("2. Int  numbers");
                 Roption= Integer.parseInt(sc.nextLine());
                 System.out.println("Enter the size of array:");
                 n=Integer.parseInt(sc.nextLine());
                 RandomNumber rn=new RandomNumber();
                 inputArray=rn.generateNum(n,Roption);        
                 }
                 break;
        default :{
                    inputArray=new long[0];
                 }
    }        
    
    if(inputoption==1||inputoption==2||inputoption==3)
    {
            System.out.println("Sort algorithm you want to run?");
            System.out.println("1.Selection O(N2)");
            System.out.println("2.Heap O(NlogN)");
            System.out.println("3.Radix O(N)");
            Soption=Integer.parseInt(sc.nextLine().trim());
            switch(Soption)
            {
                case 1:{
                         SelectionSort ss=new SelectionSort();
                         if(inputArray.length>0)
                         {
                         startTime=System.currentTimeMillis();    
                         sortedArray=ss.sortlong(inputArray);
                         stopTime=System.currentTimeMillis();
                         }  
                        }
                        break;
                case 2:{
                            HeapSort hs=new HeapSort();
                            if(inputArray.length>0)
                            {
                              startTime=System.currentTimeMillis();  
                              sortedArray=hs.sortlong(inputArray);
                              stopTime=System.currentTimeMillis();
                            }
                        }
                        break;
                case 3:{
                          RadixSort rs=new RadixSort();
                          if(inputArray.length>0)
                          {  
                              //System.out.println("Before sort");
                              //displaySortArray(inputArray);
                              startTime=System.currentTimeMillis();
                              sortedArray=rs.sortlong(inputArray);
                              stopTime=System.currentTimeMillis();
                              //System.out.println("After sort");
                              //displaySortArray(sortedArray);
                          }
                        }
                        break; 
                default :{
                           sortedArray=new long[0];
                         } 

            }
        

        System.out.println("How you like to see sorted results");
        System.out.println("1.Console");
        System.out.println("2.Output file");
        Ooption=Integer.parseInt(sc.nextLine().trim());
        if(Ooption==1)
        {  
            System.out.println("Sort Results:");
            System.out.println("Sorted Array Size:"+inputArray.length);
            System.out.println("Run time :"+(stopTime-startTime)+"ms");
        }
        else
        {
            System.out.println("Enter output file name:");
            String filename=sc.nextLine().trim();
            try
            {
            PrintWriter out = new PrintWriter(new FileWriter(".\\"+filename+".txt")); 
            //PrintWriter out = new PrintWriter(new FileWriter(".\\localPeaks_Output.txt"));
            String outputstring="Sort Results:"+"\n"+"Sorted Array Size:"+inputArray.length+"\n"+"Run time :"+(stopTime-startTime)+"ms";
            out.println(outputstring);
            System.out.println("Successful created! check output file for more details");
            }
            catch(IOException e)
            {
                System.out.println("Error occured :"+e.getMessage());
            }
        }    
    }
    
    
    }
    
    public static void displaySortArray(long a[])
    {
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
    
}
