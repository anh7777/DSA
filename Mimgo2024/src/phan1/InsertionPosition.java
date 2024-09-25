package phan1;

public class InsertionPosition{

    public static int getInsertPosition(int[] a, int x){
        int n = a.length;
        int post = 0;
        if (x <= a[0]) {
            return post;
        } else if (x > a[n-1]) {
            post = n;
        } else {
            for (int i = 0; i < n; i++) {
                if (x <= a[i]) {
                    post = i;
                    break;
                }
            }
        }
        return post;
    }



    public static void main(String[] args){



    }


}