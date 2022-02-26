import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.Objects;

class Person {
    public String ID;

    public Person(String ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(ID, person.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                '}';
    }
}

public class HashBuck2<K, V> {

    static class Node<K, V> {
        public K key;
        public V val;
        public Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K, V>[] array;
    public int usedSize;

    public HashBuck2() {
        this.array = (Node<K, V>[]) new Node[10];
    }

    /**
     * put
     * @param key
     * @param val
     */
    public void put(K key, V val) {
        // 1、找到 key 所在的位置
        int hash = key.hashCode();
        int index = hash % array.length;
        // 2、遍历这个下标的链表，看是不是有相同 key的节点，如果有，更新它的 val值
        Node<K, V> cur = array[index];
        while (cur != null) {
            if(cur.key.equals(key)) { // 通过重写的 equals 比较
                cur.val = val; // 更新完 结束
                return;
            }
            cur = cur.next;
        }
        // 3、如果没有 key 这个元素，头插法插入
        Node<K, V> node = new Node<>(key, val);
        node.next = array[index]; // 先后
        array[index] = node; // 再前
        this.usedSize++;
    }

    /**
     * 根据 key 获取 val 的值
     * @param key
     * @return
     */
    public V get(K key) {
        // 1、找到 key 所在的位置
        int hash = key.hashCode();
        int index = hash % array.length;
        // 2、遍历这个下标的链表，看是不是有相同 key的节点，如果有，更新它的 val值
        Node<K, V> cur = array[index];
        while (cur != null) {
            if(cur.key.equals(key)) { // 通过重写的 equals 比较
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Person person1 = new Person("123");
        Person person2 = new Person("123");

        HashBuck2<Person, String> hashBuck2 = new HashBuck2<>();
        hashBuck2.put(person1, "bit");

        System.out.println(hashBuck2.get(person2)); // bit
        // 以person2获取val 重写了equals方法 拿到的也是bit
    }


    public static void main1(String[] args) {
        Person person1 = new Person("123");
        Person person2 = new Person("123");
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        HashMap<Person, String> map = new HashMap<>();
    }
}

