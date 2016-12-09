package algosproject;

public class HeapSort {
    
     long arraytemp[];
    public static void main(String []args)
    {
        
    }
    
    public  long[] sortlong(long temp[])
    {
     this.arraytemp=temp;
     buildheap(arraytemp);
     for(int i = temp.length-1;i>=0;i--)
     {
         swap(0,i);
         maxheapify(temp,i,0);
     }
     
     
        return temp;
    }
    
    public void buildheap(long tempheap[])
    {
        int n=tempheap.length;
        
        for(int i=n/2-1;i>=0;i--)
        {
            maxheapify(tempheap,n,i);
        }
    }
   
    public void maxheapify(long temparr[],int n,int i)
    { 
        int largest=i;
        int lchild=2*i+1;
        int rchild=2*i+2;
        
      if(lchild<n && temparr[lchild]>temparr[largest])
      {
        largest=lchild;   
      }
      if(rchild<n&& temparr[rchild]>temparr[largest])
      {
          largest=rchild;
      }
      if(largest!=i)
      {
          swap(i,largest);
          maxheapify(temparr,n,largest); 
      
      }
    }
      
      private void swap(int i,int j)
      {
          long tempv=arraytemp[i];
          arraytemp[i]=arraytemp[j];
          arraytemp[j]=tempv;
      }
      
      
     
    
    
    
}
