import java.util.ArrayList;

public class Monotonic {
    public static boolean monotonic(ArrayList<Integer>list){
        boolean decresing  = true , incresing = true;
        for(int i = 1;i<list.size();i++){
            if(list.get(i) > list.get(i-1)){
                decresing = false;
            }
            if(list.get(i) < list.get(i-1)){
                incresing = false;
            }
        }
        return incresing || decresing;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        System.out.println(monotonic(list));
    }
    
}
