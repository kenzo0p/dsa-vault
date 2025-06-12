package You.easy;

public class MIssingInArray {
        // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {
         // Calculate the sum of the first n natural numbers
        int totalSum = n * (n + 1) / 2;
        
        // Calculate the sum of elements in the array
        int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }
        // The missing number is the difference between the total sum and the array sum
        return totalSum - arrSum; 
    }

    int missingNum(int arr[]) {
        // code here
        //using xor operator
        int n = arr.length + 1;
        int xor1 = 0,xor2 = 0;
        for(int i=1;i<=n;i++){
            xor1 ^= i;
        }
        for(int i=0;i<n-1;i++){
            xor2 ^= arr[i];
        }
        
        return xor1^xor2;
        
    }


    public static int missingNum(int[] arr) {
        int n = arr.length + 1;

        // Create hash array of size n+1
        int[] hash = new int[n + 1];

        // Store frequencies of elements
        for (int i = 0; i < n - 1; i++) {
            hash[arr[i]]++;
        }

        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }



       int missingNum(int arr[]) {
        // code here
        long n = arr.length+1;
        long sum = n*(n+1)/2;
        long arrSum = 0;
        for(long num : arr){
            arrSum += num;
        }
        
        return (int) (sum - arrSum);
    }

    
}
