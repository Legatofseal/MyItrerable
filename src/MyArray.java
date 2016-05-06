import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Legat on 28.04.2016.
 */
public class MyArray {
    private Integer[] arr;
    private int size;

    public MyArray(int size) {
        this.size = size;
        this.arr = new Integer[size];

    }

    public void generateArr(int max) {
        for (int i = 0; i < size; i++) {
            arr[i] = ((int) (Math.random() * max));
            System.out.print(arr[i]+" ");
        }


    }
    public ArrayList<Integer> arrToList (){
        ArrayList<Integer> arraylist= new ArrayList<Integer>(Arrays.asList(arr));
        return arraylist;
    }
}
