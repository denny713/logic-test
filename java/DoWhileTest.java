public class DoWhileTest{

    public static void main(String[] args) {
        String pinCacheValue = "";
        boolean isSuccessGetValue = false;
        int maxRetry = 5;
        do {
            maxRetry--;
            if(maxRetry == 0){
                pinCacheValue = "123456";
            }
            if (!isEmpty(pinCacheValue)) {
                isSuccessGetValue = true;
            }
            if(maxRetry == 0){
                isSuccessGetValue = true;
            }
            System.out.println("Max retry: "+maxRetry);
            System.out.println("Value: "+pinCacheValue);
            System.out.println("Is success: "+isSuccessGetValue);
        } while (!isSuccessGetValue);
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
}