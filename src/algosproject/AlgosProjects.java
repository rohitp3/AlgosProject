/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algosproject;

import java.util.Collection;
import java.util.Scanner;
/**
 *
 * @author Rohit
 */
public class AlgosProjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // TODO code application logic here
    System.out.println("Options to generate random numbers");
    System.out.println("1. Long numbers");
    System.out.println("2. Int  numbers");
    Scanner sc=new Scanner(System.in);
    int options= Integer.parseInt(sc.nextLine());
    clearScreen();
    System.out.println("Enter the number :");
    int n =Integer.parseInt(sc.nextLine());
    long m[];
    int ni[];
    long Ssort[];
    long Hsort[];
    switch(options)
    {
        case 1 :  { 
                      RandomNumber rn=new RandomNumber();
                      m=rn.generateLongNum(n);
                      System.out.println("Before selection sort");
                      displayLongSort(m);
                  //   SelectionSort ss=new SelectionSort();
                    //  Ssort=ss.sortlong(m);
                      HeapSort fs=new HeapSort();
                      long insertstartTime = System.currentTimeMillis();
                      Hsort=fs.sortlong(m);
                      long insertendTime = System.currentTimeMillis();
                      System.out.println("After selection sort");
                      
                      displayLongSort(Hsort);
                      System.out.println("Sort time in millisecond:"+(insertendTime-insertstartTime));
                      
                  
                   }
                   break;
        case 2  : {
                      RandomNumber rn=new RandomNumber();
                      ni=rn.generateIntNum(n);   
                      displayIntSort(ni);
                      
                      
                   }
               
            default: 
                      break;
    }
    
     

    
}
    
    public static void displayIntSort(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }

    public static void displayLongSort(long a[])
    {
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   }  
}
