package algosproject;

public class SelectionSort {
   
    public static void main(String[] args)
    {
        
    }
    
    public long[] sortlong(long temp[])
    {
        int min=0;
        for(int j=0;j<temp.length;j++)
        {
            min=j;
            
            for(int i=j+1;i<temp.length;i++)
            {
                if(temp[i]<temp[min])
                {
                    min=i;
                }
            }
            if(min!=j)
            {
                long tem=temp[min];
                temp[min]=temp[j];
                temp[j]=tem;
            }
        }
        
        return temp;
    }
    
}
    
