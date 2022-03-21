import java.util.*;


public class TestDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n + 1];
        for(int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        int count = 0;
        int i = 0;
        while(i < n - 1) {
            if(i < n - 1 && array[i] > array[i + 1]) {
                while(i < n - 1 && array[i] > array[i + 1]) {
                    i++;
                }
                count++;
                i++; // 下一个序列
            } else if (i < n - 1 && array[i] == array[i + 1]) {
                while(i < n - 1 && array[i] == array[i + 1]) {
                    i++;
                }
            }else if(i < n - 1 && array[i] < array[i + 1]) {
                while(i < n - 1 && array[i] < array[i + 1]) {
                    i++;
                }
                count++;
                i++; // 下一个序列
            }
        }
        System.out.println(count == 0 ? count + 1 : count);
    }

    public static boolean isAdmin(String uerId) {
        return uerId.toLowerCase() == "admin";
    }

    public static void main4(String[] args) {
        System.out.println(isAdmin("Admin"));
    }


    static void TestDemo() {
        System.out.println("TestDemo()");
    }

    public static void main3(String[] args) {
        TestDemo.TestDemo();
    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        String des = scan.nextLine();
        String src = scan.nextLine();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < src.length(); i++) {
            set.add(src.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < des.length(); i++) {
            if(!set.contains(des.charAt(i))) {
                sb.append(des.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] array = new int[3 * n];
            for(int i = 0; i < 3 * n; i++) {
                array[i] = scanner.nextInt();
            }

            Arrays.sort(array);

            if(array.length == 3) {
                System.out.println(array[1]);
                return;
            } else {
                int teams = n;
                int right = array.length - 2;
                long ans = 0;
                while(teams > 0) {
                    ans += array[right];
                    right -= 2;
                    teams--;
                }
                System.out.println(ans);
            }
        }
    }
}
