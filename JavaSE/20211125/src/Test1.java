import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            StringBuffer ret = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i); // 'a'
                String tmp = ret.toString(); // contains
                if(!tmp.contains(ch+"")) { // "a"
                    ret.append(ch);
                }
            }
            System.out.println(ret);
        }
    }
}
