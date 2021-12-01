import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Student {
    private String name;
    private String  classes;
    private double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}

public class Test {
    // 2
    public static void main(String[] args) {
        // 用ArrayList
        String str1 = "welcome to CVTE";
        String str2 = "come";
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")) {
                list.add(ch);
            }
        }
        // System.out.println(list); // [w, l,  , t,  , C, V, T, E]
        for (char ch : list) {
            System.out.print(ch);
        }
    }

    // 1
    public static void main3(String[] args) {
        String str1 = "welcome to CVTE";
        String str2 = "come";
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")) {
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }

    public static void main2(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(12);
        integers.add(53);
        integers.add(37);
        Collections.sort(integers); // [12, 37, 53]
        System.out.println(integers);
        Collections.reverse(integers);
        System.out.println(integers); // [53, 37, 12]
    }

    public static void main1(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("bit", "102-1", 10.9));
        students.add(new Student("zhangsan", "102-2", 70.9));
        students.add(new Student("lisi", "102-1", 50.9));
        System.out.println(students);
    }
}
