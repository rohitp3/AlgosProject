/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algosproject;

import java.io.BufferedReader;
import java.io.FileReader;
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
        
    int n; int option=1;  
    long inputArray[];
    long sortedArray[]=new long[0];
    int Roption;
    int Soption;
    long startTime=0;
    long stopTime=0;
    int Ooption;
    String Fdata="";
    int loption;
    String filename1,filename2,filename3;
    
    
    do
    {
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
                 System.out.println("Enter the numbers:");
                 for(int j=0;j<n;j++)
                 {
                  inputArray[j]=Long.parseLong(sc.nextLine().trim());
                 }
                 }
                 break;
        case 2 :{
               
                 System.out.println("Enter the filename (don't add .txt extension)");
                 String inputfilename=".\\"+sc.nextLine().trim();
                 Fdata=getdatafromfile(inputfilename);         
                 if(Fdata.length()>0)
                 {
                     inputArray=convertstringtolongarray(Fdata);
                     
                 }
                 else{
                  inputArray=new long[0];
                  }
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
                 System.out.println("Input Random file:");
                 createoutputfile(inputArray,"RandomGenerated_input");
                 
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
                         startTime=System.nanoTime();    
                         sortedArray=ss.sortlong(inputArray);
                         stopTime=System.nanoTime();
                         }  
                        }
                        break;
                case 2:{
                            HeapSort hs=new HeapSort();
                            if(inputArray.length>0)
                            {
                              startTime=System.nanoTime();  
                              sortedArray=hs.sortlong(inputArray);
                              stopTime=System.nanoTime();
                            }
                        }
                        break;
                case 3:{
                          RadixSort rs=new RadixSort();
                          if(inputArray.length>0)
                          {  
                              //System.out.println("Before sort");
                              //displaySortArray(inputArray);
                              startTime=System.nanoTime();
                              sortedArray=rs.sortlong(inputArray);
                              stopTime=System.nanoTime();
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
            System.out.println("Run time :"+(stopTime-startTime)+"ns");
            
        }
        else
        {
            System.out.println("Enter output file name:");
            String filename=sc.nextLine().trim();
            try
            {
            PrintWriter out = new PrintWriter(new FileWriter(filename+".txt"));
            String outputstring="Sort Results:"+" \n "+" Sorted Array Size:"+inputArray.length+" \n "+"Run time :"+((stopTime-startTime)/1000) +"micro seconds";
            out.println(outputstring);
            System.out.println("Successful created:"+filename+".txt");
            System.out.println("File Containing sorted number!");
            createoutputfile(sortedArray,"Output_Sorted_numbers");
            
            
            }
            catch(IOException e)
            {
                System.out.println("Error occured :"+e.getMessage());
            }
        }    
    }
    
    System.out.println("Would you like to run longest common sequence algorithm?");
    System.out.println("1. Yes");
    System.out.println("2. No");
    loption=Integer.parseInt(sc.nextLine().trim());
    if(loption==1)
    {
    System.out.println("Enter File Name1(don't add .txt extension):");
    filename1=sc.nextLine().trim();
    System.out.println("Enter File Name2(don't add .txt extension):");
    filename2=sc.nextLine().trim();
    System.out.println("Enter File Name3(don't add .txt extension):");
    filename3=sc.nextLine().trim();
    longestcommonseq(filename1,filename2,filename3);
    }
    
    System.out.println("do you want to run experiment again ?");
    System.out.println("1.No");
    System.out.println("2.Yes");
     option=Integer.parseInt(sc.nextLine());
     
    
    }while(2==option);
    
    }
    
    
    
    public static void longestcommonseq(String f1,String f2,String f3)
    {
       String fp1=f1+".txt";
       String fp2=f2+".txt";
       String fp3=f3+".txt";
       String str1,str2,str3;
       long arr1[],arr2[],arr3[];
       str1=getdatafromfile(fp1);
       arr1=convertstringtolongarray(str1);
       str2=getdatafromfile(fp2);
       arr2=convertstringtolongarray(str2);
       str3=getdatafromfile(fp3);
       arr3=convertstringtolongarray(str3);
       LCS lcs=new LCS();  
       String lcsouputbeforesort= lcs.getlcs(arr1,arr2,arr3);
       createlcsoutputfile(lcsouputbeforesort,"LCS_in"); 
       long sortarr1[],sortarr2[],sortarr3[];
       SelectionSort ss=new SelectionSort();
       sortarr1=ss.sortlong(arr1);
       createoutputfile(sortarr1,"n2SORT");
       HeapSort hs=new HeapSort();
       sortarr2=hs.sortlong(arr2);
       createoutputfile(sortarr2,"nlgnSORT");
       RadixSort rs=new RadixSort();
       sortarr3=rs.sortlong(arr3);
       createoutputfile(sortarr3,"nSORT");
 
       String lcsouputaftersort=lcs.getlcs(sortarr1,sortarr2,sortarr3);
       createlcsoutputfile(lcsouputaftersort,"LCS_out");           
    }
    public static void createlcsoutputfile(String data,String filename)
    {
       
        String ffp=filename+".txt";
              try
            {
            PrintWriter out = new PrintWriter(new FileWriter(ffp)); 
            
            String outputstring=data;
            out.println("Longest common sequence :-");
            out.println(outputstring);
            out.close();
            System.out.println("Successful created : "+ffp);
            }
            catch(IOException e)
            {
                System.out.println("Error occured :"+e.getMessage());
            }
       
        
        
    }
    
    
    public static void createoutputfile(long[] temparray,String filename)
    {
        
        String data=convertarraytostring(temparray);
        String ffp=filename+".txt";
        
              try
            {
            PrintWriter out = new PrintWriter(new FileWriter(ffp)); 
            
            String outputstring=data;
            out.println(outputstring);
            out.close();
            System.out.println("Successful created:"+ffp);
            }
            catch(IOException e)
            {
                System.out.println("Error occured :"+e.getMessage());
            }
      
        
    }
    
    public static String convertarraytostring(long[] arr)
    {
        String temp="";
        
        for(int i=0;i<arr.length;i++)
        {   
            temp=temp+ String.valueOf(arr[i])+",";
            
        }
        
        return   temp.substring(0,temp.length() - 1);
    }
    
    public static String getdatafromfile(String inputfilename)
    {
        String line,Fdata=" ";
                  try
                 {
                 FileReader fileReader = new FileReader(inputfilename);
            BufferedReader in = new BufferedReader(fileReader);  
            while((line = in.readLine()) != null)
            {
                Fdata=Fdata+line;
            }
            in.close();
                 }
                 catch(Exception e)
                 {
                     
                 }
                  
                  return Fdata;
       
    }
    
    public static void displaySortArray(long a[])
    {
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
    public static long[] convertstringtolongarray(String input)
    {
        long data[];
        String temp[]=input.split(",");
        data=new long[temp.length];
        for(int i=0;i<temp.length;i++)
        {
            data[i]=Long.parseLong(temp[i].trim());
        }
        
        return data;
        
    }
}
