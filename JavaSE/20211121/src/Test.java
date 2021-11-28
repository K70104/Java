

public class Test {
    /**
     * StringBuffer或者StringBuilder-》String
     * 调用toString方法
     * @return
     */
    public static String func2() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

    /**
     * String->StringBuffer或者StringBuilder
     * 使用构造方法
     * @return
     */
    public static StringBuffer func() {
        String str2 = "abcdef";
        StringBuffer sb = new StringBuffer();
        sb.append(str2);
        return sb;
        //return new StringBuffer(str);
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdef");
        sb.reverse();
        System.out.println(sb);
        StringBuffer sb2 = new StringBuffer();
        sb2.reverse();
        String str = "abcdef";
    }

    public static void main12(String[] args) {
        String str = "abcdef";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        str = sb.toString();
        System.out.println(str); // abcdef0123456789
    }

    public static void main11(String[] args) {
        String str = "abcdef";
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str).append(i);
            str = sb.toString();
            // str += i;
        }
        System.out.println(str);
    }

    public static void main10(String[] args) {
        //String str = "abcdef";
        StringBuilder sb = new StringBuilder();
        sb.append("abcdef");
        //str += "123";//str = str + "123"
        sb.append("123");
        //str = sb.toString();
        System.out.println(sb);
    }

    public static void main9(String[] args) {
        /*StringBuilder sb = new StringBuilder("abcd");
        // sb.append("abcdef").append("123456");
        System.out.println(sb); // abcd
        System.out.println(sb.toString()); // 同上*/

        StringBuilder sb = new StringBuilder("");
        /*sb.append("abcd");
        sb.append("1234");*/
        sb.append("abcd").append("123");
        System.out.println(sb.toString()); // abcd123
    }

    public static void main8(String[] args) {
        String str1 = "abc";
        System.out.println(str1.length()); // 需加括号

        int[] array = {1,2,3,4,5};
        System.out.println(array.length);

        String str = "";
        System.out.println(str.isEmpty()); // true
    }

    public static void main7(String[] args) {
        String str = "abc";
        String ret = str.concat("bit");
        System.out.println(ret); // abcbit
    }

    public static void main6(String[] args) {
        String str = "abcDEF123高";

        String ret1 = str.toUpperCase();
        System.out.println(ret1); // ABCDEF123高

        String ret2 = str.toLowerCase();
        System.out.println(ret2); // abcdef123高
    }

    public static void main5(String[] args) {
        String str = "    abc     def     ";
        String ret = str.trim();
        System.out.print(ret);
        System.out.println("=============="); // abc     def==============
    }

    public static void main4(String[] args) {
        String str = "abcddef";
        String sub = str.substring(2, 5); // 左闭右开
        System.out.println(sub); // cdd
    }

    public static void main3(String[] args) {
        String str = "zhang san#he&llo";
        String[] strings = str.split(" |&|#");
        for (String x : strings) {
            System.out.println(x);
        }
        // zhang
        // san
        // he
        // llo
    }

    public static void main2(String[] args) {
        String str = "192\\168\\1\\1";
        String[] strings = str.split("\\\\");
        for (String x : strings) {
            System.out.println(x);
        }
        // 192
        // 168
        // 1
        // 1
    }

    public static void main1(String[] args) {
        String str = "192.168.1.1";
        String[] strings = str.split("\\.", 2);
        for (String x : strings) {
            System.out.println(x);
        }
        // 192
        // 168.1.1
    }
}
