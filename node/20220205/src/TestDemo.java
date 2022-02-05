import java.util.HashSet;
import java.util.Set;

class Inc {
    public static void main(String[] args) {
        Inc inc = new Inc();
        int i = 0;
        inc.fermin(i);
        i= i++;
        System.out.println(i);

        int j = 0;
        j= ++j;
        System.out.println(j);
    }
    void fermin(int i){
        i++;
    }
}

public class TestDemo {

    public static void main(String[] args) {

    }
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right) {
            int mid = left + ((right - left) >> 1);
            if(isBadVersion(mid)) {
                right = mid;  // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }

    /*public double max( double a, double b) { return a; }
    public float max(float a, float b, float c){ return a; }
    public double max (double c, double d){ return c; }
    public float max(float a, float b){ return a; }
    private int max(int a, int b, int c){return a; }
*/
    public static void main8(String[] args){
        Integer var1=new Integer(1);
        Integer var2=var1;
        doSomething(var2);
        System.out.print(var1.intValue());
        System.out.print(var1==var2);
    }
    public static void doSomething(Integer integer){
        integer=new Integer(2);
    }

    public static void mai7(String[] args) {
        int i = 3;
        String result = new String();
        switch (i) {
            case 1:
                result = result + "him ";
            case 2:
                result = result + "her ";
            case 3:
                result = result + "it ";
            default:
                result = result + "me ";
        }
        System.out.println(result);
    }

    /*public int x;
    public static void main(String []args)
    {
        System. out. println("Value is" + x);
    }*/
    /*float func1(){
        int i=1;
        return;
    }
    float func2(){
        short i=2;
        return i;
    }
    float func3(){
        long i=3;
        return i;
    }
    float func4(){
        double i=4;
        return i;
    }*/

    static boolean out(char c){
        System.out.print(c);
        return true;
    }
    public static void main7(String[] argv){
        int i = 0;
        for(out('A');out('B') && (i<2);out('C')){
            i++;
            out('D');
        }
    }

    // 1、用哈希集合检测循环
    /* 算法分为两部分，我们需要设计和编写代码：
    - 给一个数字 n，它的下一个数字是什么？
    - 按照一系列的数字来判断我们是否进入了一个循环。
       第 1 部分我们按照题目的要求做数位分离，求平方和。
       第 2 部分可以使用哈希集合完成。每次生成链中的下一个数字时，我们都会检查它是否已经在哈希集合中。
        如果它不在哈希集合中，我们应该添加它。
        如果它在哈希集合中，这意味着我们处于一个循环中，因此应该返回 false。*/

    public int getNextNum(int n) {
        int num = 0;
        while(n > 0) {
            num += Math.pow(n % 10, 2);
            n /= 10;
        }
        return num;
    }

    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    // 2、快慢指针法判断是否有环  龟兔赛跑
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNextNum(n);
        while(fast != 1 && slow != fast) {
            slow = getNextNum(slow);
            fast = getNextNum(getNextNum(fast));
        }
        return fast == 1;
    }
    public static void main6(String[] args) {
        /*int x=3;
        int y=1;
        if(x=y)
            System.out.println("Not equal");
        else
            System.out.println("Equal");*/
        /*int x = 0;
        for (int z = 0; z < 5; z++) {
            if (z>=2) {
                x++;
            }
        }
        System.out.println(x);*/
    }

    public static void main5(String[] args) {
        byte a = 127;
        a += 127;
        System.out.println(a);

        System.out.println(-5 + 1/4 + 2*-3 + 5.0);
    }

    public static void main4(String[] args) {
        System.out.println(14^3);
        // 1110   8 4 2 0
        // 0011   0 0 2 1
        // 1101   8+4+0+1 = 13
    }

    public static void main3(String[] args) {
        Double o1 = true ? new Integer(1) : new Double(2.0);
        Object o2;
        if (true) {
            o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.print(o1);
        System.out.print(" ");
        System.out.print(o2);
    }

    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                k--;
            }
            if(k == 0) {
                break;
            }

            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main2(String[]args){
        int a=13;
        a=a/5;
        System.out.println(a);
    }

    public static void main1(String[] args){
        int x = 0;
        int y = 0;
        int k = 0;
        for (int z = 0; z < 5; z++) {
            if ((++x > 2) && (++y > 2) && (k++ > 2)){
                x++;
                ++y;
                k++;
            }
        }
        System.out.println(x + "" +y + "" +k);
    }
}
