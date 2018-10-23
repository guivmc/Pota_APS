package pota_aps_21002514;

//Guilherme (21002514)

import java.util.Random;


public class POTA_APS_21002514
{

   public static int[] media = new int[6];
    
   public static float Media()
   {
       float result = 0;
       for (int i = 0; i < media.length; i++)
       {
           result += media[i];
       }
       
       result /=  6;
       
       return result;
   }
    
   public static String BubbleSort(int[] vector, int pos)
    {
        double start = System.currentTimeMillis();
        int n = vector.length;
        int novoN;
        
        do 
        {
            novoN = 0;
            for (int i = 1; i <= n - 1; i++) 
            {
                if (vector[i - 1] > vector[i])
                {

                    vector[i] = vector[i - 1] + vector[i];
                    
                    vector[i - 1] = vector[i] - vector[i - 1];
                    
                    vector[i] = vector[i] - vector[i - 1];

                    novoN = i;
                    
                    media[pos]++;
                }
            }
            n = novoN;
        } while (n > 0);
        
        double fim = System.currentTimeMillis() - start;
        

        return "\nTempo Bubble " + fim;
    }
    
    public static String InsertionSort(int[] vector, int pos)
    {
        double start = System.currentTimeMillis();
        
        int size = vector.length;
        
        for (int i = 1; i <= size - 1; i++)
        {
           int j = i;
           
           while(j > 0 && vector[j - 1] > vector[j])
           {
               int aux = vector[j - 1];
               
               vector[j - 1] = vector[j];
               
               vector[j] = aux;
               
               j--;
               
               media[pos]++;
           }
        }
        
        double fim = System.currentTimeMillis() - start;
        

        return "\nTempo Insert " + fim;
    }
    
    public static String SelectionSort(int[] vector, int pos)
    {
        int smallest = 0;
        
        double start = System.currentTimeMillis();
        
        for (int i = 0; i < vector.length - 1; i++)
        {
            smallest = i;
            
            for (int j = i + 1; j < vector.length; j++) 
            {
                if (vector[j] < vector[smallest]) 
                {
                    smallest = j;
                    
                    media[pos]++;
                }
            }

            int aux = vector[i];
            
            vector[i] = vector[smallest];
            
            vector[smallest] = aux;
        }
        
        double fim = System.currentTimeMillis() - start;
        

        
        return "\nTempo Select " + fim;
    }
    
    public static String CallMergeSort(int vector[], int pos)
    {
        
        double start = System.currentTimeMillis();
        
        
         MergeSort(vector, 0, (vector.length - 1), pos);
        
        double fim = System.currentTimeMillis() - start;
        

        
        return "\nTempo Merge " + fim;
    }
    
    public static int[] MergeSort(int vector[], int head, int tail, int pos)
    {
        if (head < tail) 
        {
            int middle = (head + tail) / 2;
            
            MergeSort(vector, head, middle, pos);
            
            MergeSort(vector, middle + 1, tail, pos);
            
            InterimMergeSort(vector, head, middle, tail, pos);
            
        }
        
        return vector;
    }

    public static void InterimMergeSort(int[] vector, int head, int middle, int tail, int pos) 
    {
        int[] vectorB = vector.clone();
        
        int i, j;

        for (i = head; i <= middle; i++) 
        {
            vectorB[i] = vector[i];
        }

        for (j = middle + 1; j <= tail; j++) 
        {
            vectorB[tail + middle + 1 - j] = vector[j];
        }

        i = head;
        
        j = tail;

        for (int k = head; k <= tail; k++)
        {
            if (vectorB[i] <= vectorB[j]) 
            {
                vector[k] = vectorB[i];
                
                i++;
                
                media[pos]++;
            } 
            else 
            {
                vector[k] = vectorB[j];
                
                j--;
                
                media[pos]++;
            }
        }
    }
    
    public static String CallQuickSort(int[] vector, int pos)
    {
        double start = System.currentTimeMillis();
                
        QuickSort(vector, 0, (vector.length - 1), pos);
        
        double fim = System.currentTimeMillis() - start;
        
        return "\nTempo Quick " + fim;
    }

    public static int[] QuickSort(int[] vector, int head, int tail, int pos)
    {
        if(head < tail)
        {
            int middle = IterimQuickSort(vector, head, tail, pos);
            QuickSort(vector, head, middle - 1, pos);
            QuickSort(vector, middle + 1, tail, pos);
        }
        
        return vector;
    }
    
    public static int IterimQuickSort(int[] vector, int head, int tail, int pos)
    {
        int i = head + 1, j = tail, aux = vector[head];
        
        while(i <= j)
        {
            if(vector[i] <= aux) 
            {
                i++;
                media[pos]++;
            }
            else if(aux < vector[j])
            {
                j--;
                media[pos]++;
            }
            else
            {
                int swap = vector[i];
                vector[i] = vector[j];
                vector[j] = swap;
                i++;
                j--;
                media[pos]++;
            }
        }
        vector[head] = vector[j];
        vector[j] = aux;
        return j;
    }
    
    public static int[] random (int length)
    {
        int [] vector = new int[length];
        
        Random r = new Random();
        
        for (int i = 0; i < length; i++)
        {
            vector[i] = r.nextInt(50);    
        }
        
        return vector;
    }
    public static void main(String[] args)
    {
//        int[] Arr = {3, 54, 6, 7, 5, 9};
//        
//        CallQuickSort(Arr);
//        
//        for (int i = 0; i < Arr.length; i++) 
//        {
//            System.out.println(Arr[i] + " - ");
//        }
        
//        for (int i = 100; i < 1000000; i *= 10) 
//        {
//            
//            System.out.println(BubbleSort(random(i)) + " - quantidade:" + i + "\n");
//            System.out.println(CallMergeSort(random(i)) + " - quantidade:" + i + "\n");
//            //System.out.println(CocktailSort(random(i))+ " - quantidade:" + i + "\n");
//            System.out.println(InsertionSort(random(i))+ " - quantidade:" + i + "\n");
//            System.out.println(SelectionSort(random(i))+ " - quantidade:" + i + "\n");
//            //System.out.println(ShellSort(random(i))+ " - quantidade:" + i + "\n");
//            System.out.println(CallQuickSort(random(i)) + " - quantidade:" + i + "\n");
//        }
        
        for (int i = 0; i < media.length; i++) 
        {
               BubbleSort(random(5), i);
        }
     
        System.out.println("Bubble media 5 = " + Media());
        
        media = new int[6];
        
        
        for (int i = 0; i < media.length; i++) 
        {
               BubbleSort(random(10), i);
        }
        
        System.out.println("Bubble media 10 = " + Media());
        
        media = new int[6];
        
        for (int i = 0; i < media.length; i++) 
        {
               BubbleSort(random(50), i);
        }

        System.out.println("Bubble media 50 = " + Media());
        
        media = new int[6];
                
        for (int i = 0; i < media.length; i++) 
        {
               BubbleSort(random(100), i);
        }
      
        System.out.println("Bubble media 100 = " + Media());
        
        media = new int[6];
        
        for (int i = 0; i < media.length; i++) 
        {
               BubbleSort(random(1000), i);
        }

        System.out.println("Bubble media 1000 = " + Media());
        
        media = new int[6];
        
        for (int i = 0; i < media.length; i++) 
        {
               BubbleSort(random(10000), i);
        }
        System.out.println("Bubble media 1000 = " + Media());
        
        media = new int[6];
        
    }
    
}
