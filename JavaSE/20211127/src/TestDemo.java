import java.util.Scanner;

public class TestDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            StringBuffer s = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                String tmp = s.toString();
                if(!tmp.contains(ch+"")) {
                    s.append(ch);
                }
            }
            System.out.println(s);
        }
    }
}
