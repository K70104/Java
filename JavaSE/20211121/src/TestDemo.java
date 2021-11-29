import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestDemo {

    public static void main(String[] args) {
        String str = "name=zhangsan&age=22";
        String[] strings = str.split("&");
        for (String s : strings) {
            String[] ss = s.split("=");
            for (String x : ss) {
                System.out.println(x);
            }
            System.out.println(s);
        }
    }

    public static void main11(String[] args) {
        String str = "abfababcdab";
        String ret = str.replaceFirst("ab", "pp");
        System.out.println(ret); // ppfababcdab
    }

    public static void main10(String[] args) {
        String str = "absbhabcds";
        String tmp = "abc";

        System.out.println(str.endsWith("ds")); // true

        System.out.println(str.startsWith("ab", 5)); // true

        System.out.println(str.lastIndexOf(tmp, 4)); // 2

        int index = str.indexOf(tmp); // 5
        System.out.println(index);

        boolean flg = str.contains(tmp);
        System.out.println(flg); // true
    }

    public static void main9(String[] args) {
        String str1 = "abcd";
        String str2 = str1;
        System.out.println(str1.equals(str2));

        String str3 = "abC";
        String str4 = "abcdx";
        int ret = str3.compareTo(str4);
        System.out.println(ret); // -32

/*        System.out.println(str1.equals(str2)); // false
        System.out.println(str1.equalsIgnoreCase(str2)); // true*/
    }

    public static void main8(String[] args) throws UnsupportedEncodingException {
        String str = "比特";
        String str2 = "abcd";

        byte[] bytes = str.getBytes("utf-8");
        System.out.println(Arrays.toString(bytes)); // [-26, -81, -108, -25, -119, -71]
        byte[] bytes2 = str2.getBytes("utf-8");
        System.out.println(Arrays.toString(bytes2)); // [97, 98, 99, 100]

        byte[] bytes3 = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes3)); // [-79, -56, -52, -40]
        byte[] bytes4 = str2.getBytes("GBK");
        System.out.println(Arrays.toString(bytes4)); // [97, 98, 99, 100]
    }

    public static void main7(String[] args) {
        String str = "bacd";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes)); // [98, 97, 99, 100]
    }

    public static void main6(String[] args) {
        byte[] bytes = {97, 98, 99, 100};
        String str = new String(bytes, 1, 3);
        System.out.println(str); // bcd
    }

    public static boolean isNumberChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumberChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean flg = Character.isDigit(c);
            if(flg == false) {
                return false;
            }
        }
        return true;
    }

    public static void main5(String[] args) {
        String str = "12345";
        System.out.println(isNumberChar(str));


    }

    public static void main4(String[] args) {
        String str = "hello";
        char[] chars = str.toCharArray(); // 把str2指向的字符串对象 变成字符数组
        System.out.println(Arrays.toString(chars)); // [h, e, l, l, o]
    }

    public static void main3(String[] args) {
        String str = "world";
        char ch = str.charAt(3);
        System.out.println(ch); // r
    }

    public static void main2(String[] args) {
        char[] val = {'a', 'b', 'c', 'd', 'e'};
        String str = new String(val, 0, 3);
        System.out.println(str); // abc
    }

    public static void main1(String[] args) {
        char[] val = {'a', 'b', 'c'};
        String str = new String(val);
        System.out.println(str); // abc
    }
}
