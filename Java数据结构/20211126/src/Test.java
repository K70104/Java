

class MyArrayList<E> {
    private E[] elem;
    private int usedSize;
    public MyArrayList() {
        this.elem = (E[])new Object[10];
    }
    public void add(E val) {
        this.elem[usedSize] = val;
        usedSize++;
    }
    public E get(int pos) {
        return this.elem[pos];
    }
}

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList1 = new MyArrayList<>();
        System.out.println(myArrayList1);
        MyArrayList<String> myArrayList2 = new MyArrayList<>();
        System.out.println(myArrayList2);
        MyArrayList<String> myArrayList3 = new MyArrayList<>();
        System.out.println(myArrayList3);
    }

    public static void main2(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("ABC");
        myArrayList.add("bit");
        String ret = myArrayList.get(1);
        System.out.println(ret); // bit

        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        myArrayList1.add(11);
        myArrayList1.add(22);
        int ret2 = myArrayList1.get(1);
        System.out.println(ret2); // 22
    }

    public static void main1(String[] args) {
        // 把类型 参数化了
        MyArrayList<String> myArrayList1 = new MyArrayList<>();
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        MyArrayList<Boolean> myArrayList3 = new MyArrayList<>();
    }
}
