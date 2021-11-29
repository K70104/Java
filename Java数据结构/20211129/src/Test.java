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
    public static void main(String[] args) {
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
        /*students.add("bit", "102-1", 10.9);
        students.add("zhangsan", "102-2", 70.9);
        students.add("lisi", "102-1", 50.9);*/
    }
}



/*import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("c");
        list2.add("c");
        System.out.println(list2.indexOf("c")); // 2
        System.out.println(list2.lastIndexOf("c")); // 2
    }
}*/
