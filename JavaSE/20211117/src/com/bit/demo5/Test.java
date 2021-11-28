package com.bit.demo5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Chloe
 * Date: 2021-11-19
 * Time: 11:55
 */

/*class Student implements Comparable<Student>{
    public int age;
    public String name;
    public double score;

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    // 谁调用compareTo 谁就是this
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}*/

class Student {
    public int age;
    public String name;
    public double score;

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}

class ScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int)(o1.score - o2.score);
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class Test {
    public static void main1(String[] args) {
        Student student2 = new Student(12, "bit", 93.5);
        Student student3 = new Student(7, "abc", 13.5);

        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(student2, student3)); // 5
    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(12, "bit", 93.5);
        students[1] = new Student(7, "abc", 13.5);
        students[2] = new Student(38, "zhangsan", 56.5);

        System.out.println(Arrays.toString(students));

        // 根据age比较
        AgeComparator ageComparator = new AgeComparator();
        Arrays.sort(students, ageComparator); // 根据此比较器比较
        System.out.println(Arrays.toString(students));

        // 根据score比较
        ScoreComparator scoreComparator = new ScoreComparator();
        Arrays.sort(students, scoreComparator);
        System.out.println(Arrays.toString(students));

        NameComparator nameComparator = new NameComparator();
        Arrays.sort(students, nameComparator);
        System.out.println(Arrays.toString(students));
    }
}


/*public class Test {
    public static void main1(String[] args) {
        Student student2 = new Student(12, "bit", 93.5);
        Student student3 = new Student(7, "abc", 13.5);

        //System.out.println(student2.compareTo(student3));
    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(12, "bit", 93.5);
        students[1] = new Student(7, "abc", 13.5);
        students[2] = new Student(38, "zhangsan", 56.5);

        System.out.println(Arrays.toString(students));
        Arrays.sort(students); // 默认从小到大排序
        System.out.println(Arrays.toString(students));
    }
}*/
