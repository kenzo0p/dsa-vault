public class SmallestInArray {
    static int smallest(int arr[]){
        int small = Integer.MAX_VALUE;
        for(int i =0;i<arr.length;i++){
            if(arr[i] < small){
                small = arr[i];
            }
        }
        return small;
    }
    public static void main(String [] args){
        int arr[] = {-1,-2,-3,5,100};
        System.out.print(smallest(arr));
    }
}
