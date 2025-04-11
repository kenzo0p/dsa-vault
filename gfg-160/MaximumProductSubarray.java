public class MaximumProductSubarray {
    public static int mpopti(int arr[]){
        int pref = 1;
        int suff = 1;
        int n = arr.length;
        int result = 0;
        for(int i=0;i<arr.length;i++){
            if(pref == 0) pref =1;
            if(suff == 0) suff =1;
            pref*=arr[i];
            suff*=arr[n-i-1];
            result =Math.max(result , Math.max(pref , suff));
        }
        return result;
    }

    public static int mp(int arr[]) {
        int prod1 = arr[0], prod2 = arr[0], result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(arr[i], Math.max(prod1 * arr[i], prod2 * i));
            prod2 = Math.min(arr[i], Math.min(prod1 * arr[i], prod2 * arr[i]));
            prod1 = temp;
            result = Math.max(result, prod1);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
