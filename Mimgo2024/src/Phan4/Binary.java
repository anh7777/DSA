package Phan4;

@SuppressWarnings("unchecked")
public class Binary{
    
    public static String toBinary(int n)
    {
        if (n < 2) {
            return Integer.toString(n);
        }
        return toBinary(n / 2) + (n%2);
    }
    
    public static void main(String[] args)
    {
        int n =  6;
        
        System.out.println("So "+ n+" co dang nhi phan la: "+toBinary(n));
    }
}