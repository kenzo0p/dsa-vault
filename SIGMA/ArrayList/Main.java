import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void swap(ArrayList<Integer> list, int idx, int idx2) {
        int temp = list.get(idx);
        list.set(idx, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();
        ArrayList<Float> list4 = new ArrayList<>();

        // operation on ArrayList
        for (int i = 0; i <= 10; i++) {
            list1.add(i);// o(1)
        }
        // System.out.println(list1);

        // list2.add("Om");// o(1)
        // System.out.println(list2);

        // // get operation => o(1)
        // int elem = list1.get(0); // o(1)
        // System.out.println(elem);

        // // delete
        // int relem = list1.remove(0);// o(n)

        // // set elem at index => o(n)
        // list1.set(2, 10);
        // System.out.println(list1);

        // // contains elem => o(n)
        // boolean isThere = list1.contains(10);
        // System.out.println(isThere);

        // list1.add(10, 9);// o(n)
        // System.out.println(list1);

        // // size of arrayList
        // System.out.println(list1.size());
        // for (int i = 0; i < list1.size(); i++) {
        // // System.out.println(list1.get(i));
        // }

        // reverse of an arraylist

        int n = list1.size();
        // for (int i = n; i >= 0; i--) {
        // System.out.print(list1.get(i) + " ");
        // }

        // maximum in arraylist
        // int num = list1.get(0);
        // for(int i = 1 ;i<n;i++){
        // if(list1.get(i) > num){
        // num = list1.get(i);
        // }
        // }
        // System.out.println( " Max elem is : " + num);

        System.out.println(list1);
        swap(list1, 1, 3);
        System.out.println(list1);

        // sorting in ArrayList
        Collections.sort(list1);
        System.out.println(list1);

        // descending order
        Collections.sort(list1, Collections.reverseOrder());
        // comparator - fnx logic
        System.out.println(list1);

        // multidimensional arraylist
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        mainList.add(list);
        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(4);
        list5.add(5);
        list5.add(6);
        mainList.add(list5);
        System.out.println(mainList);
        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.println(currList.get(j));
            }
        }
    }
}
