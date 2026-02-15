public class SumByElimMInMax {
    static int  digitSum(int n){
        int ans = 0;

        while (n>0) {
            int ld = n%10;
            ans+=ld;
            n= n/10;
            
        }
        return ans;

    }
 
    static int filterDigit(int n){
        // 1223
        StringBuilder sb = new StringBuilder();

        String str = String.valueOf(n);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i = 0; i<str.length(); i++){
            int curr =str.charAt(i)-'0' ;

            min = Math.min(min, curr);
            max = Math.max(max, curr);

        }

        System.out.println(min+"  "+ max);

        for(int i = 0; i<str.length(); i++){
              int curr =str.charAt(i)-'0';

              if(curr!=min && curr!=max){
                sb.append(curr);

              }
              
            
        }

        return Integer.parseInt(sb.toString());

    }
    static void question(int[] arr){
        int n = arr.length;
        int sum = 0;

        for(int i = 0; i<n; i++){
            int curr  = arr[i];

           int actulDigit =  filterDigit(curr);
           System.out.println(actulDigit);
            int temp = digitSum(actulDigit);
            sum+=temp;

           
        }

        System.out.println(sum);
    }




 static int digitSum1(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }

    static int filterDigit1(int n) {
          String str = String.valueOf(n);
        int min = 9, max = 0;

        for (int i = 0; i < str.length(); i++) {
            int curr = str.charAt(i) - '0';
            min = Math.min(min, curr);
            max = Math.max(max, curr);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int curr = str.charAt(i) - '0';
            if (curr != min && curr != max) {
                sb.append(curr);
            }
        }

        if (sb.length() == 0) return 0;

        return Integer.parseInt(sb.toString());
    }

    static void question1(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int actualDigit = filterDigit1(arr[i]);
            sum += digitSum1(actualDigit);
        }

        System.out.println(sum);
    }






    public static void main(String[] args) {
        int[] arr = {1223,234,3445,456};
        question(arr);
        
    }
    
}
