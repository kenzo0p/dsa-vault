public class majorityElem {
    public static int majorityElement(int arr[]){
        int candidate = arr[0];//taking first candidate as arrays first element
        int count = 1;//and that is come for 1 time
        for(int i = 1;i<arr.length;i++){
            if(arr[i] == candidate){
                count++;
            }else {
                count--;
            }
            if(count == 0){
                candidate = arr[i];
                count = 1;
            }
        }
        return candidate;
    }
    public static void main(String[]args){
        int arr[] = {6,6,6,7,7};
        System.out.println(majorityElement(arr));
    }
}
