

/*class Person implements Cloneable {
    public int age;

    public void eat() {
        System.out.println("吃！");
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}*/


class Money {
    public double m = 10.9;
}

class Person implements Cloneable {
    public int age;

    public Money money = new Money();

    public void eat() {
        System.out.println("吃！");
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person2 = (Person)person.clone();

        System.out.println(person.money.m); // 10.9
        System.out.println(person2.money.m); // 10.9

        person2.money.m = 99.9;
        System.out.println(person.money.m); // 99.9
        System.out.println(person2.money.m); // 99.9
    }

    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.age = 99;
        Person person2 = (Person)person.clone(); // 调用clone需要重写
        System.out.println(person2); // Person{age=99}

        person2.age = 199;
        System.out.println(person); // Person{age=99}
        System.out.println(person2); // Person{age=199}
    }
}
