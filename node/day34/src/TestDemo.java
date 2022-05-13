import java.util.Scanner;

public class TestDemo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String name = scanner.nextLine();
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                if (s.charAt(i) == '\"') { // 名字里有空格或逗号 找到另一个双引号
                    i++; // 跳过此双引号
                    while (i < s.length() && s.charAt(i) != '\"')
                        sb.append(s.charAt(i++));
                } else { // 普通名字 找到逗号为之
                    while (i < s.length() && s.charAt(i) != ',') {
                        sb.append(s.charAt(i++));
                    }
                }
                if (sb.toString().equals(name)) {
                    System.out.println("Ignore");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Important!");
            }
        }
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
