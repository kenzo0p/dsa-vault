public class MoveAllZeroesToEnd {
    public static void move(int arr[]){
        /*
         * Approach ->
         * 
         *  two pointers approach 
         * take var j initialise with 0 then run a loop i ro n where n = arr.length
         * then check arr[i] != 0 if its not equal 0 then arr[j] = arr[i] why this dry run it you will understand and j++
         * then all non zeros will stored in array but if array have zeros then again take a while loop then iterate it and fill arr[j] = 0 at last  and j++
         */

         int j = 0; //pointer to fill the arrat
         for(int i = 0;i<arr.length;i++){ //for this input [1,2,4,3,5,_ ,_ ,_]  we have three spaces left fill them with zeroes in  while loop
            if(arr[i]!=0){ //  1!=0 then add simi;
                arr[j] = arr[i];
                j++;
            }
         }

         while(j<arr.length){ //if non zeros are filled but in array we still have space i.e for zeros 
            arr[j] = 0;
            j++;
         }

    }
    public static void main(String[]args){
        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        move(arr);
       for(int num : arr){
        System.out.print(num+ " ");
       }

    }    
}
