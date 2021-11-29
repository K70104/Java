import java.util.Arrays;

public class TestDemo {

    public static int[] myCopyOf(int[] array, int len) {
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = array[i];
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] copy = myCopyOf(array, array.length);

        System.out.println(Arrays.toString(copy));
    }
}
