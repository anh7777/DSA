package Phan5;

public class QuickSort{


    public int partition(int[] a) {
        int pivot = a[a.length - 1];
        int i = -1;

        for (int j = 0; j < a.length - 1; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[a.length - 1];
        a[a.length - 1] = temp;

        return i + 1;
    }
    public static void main(String[] args)
    {
        QuickSort q = new QuickSort();
        
        int[] a = {1,2,5,3,4,1,3,4,5,6,10};
        
        int key = q.partition(a);
        
        System.out.println("key = "+a[key]+" index = "+key);
        System.out.print("Array a = ");
        for(int i = 0 ; i < a.length ; i++)
            System.out.print(a[i]+" ");
    }
    
}