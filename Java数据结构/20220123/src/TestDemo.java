import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;


/*class Card implements Comparable<Card>{
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        return this.rank - o.rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }
}*/

class Card {
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Card card1 = new Card(1, "♥");
        Card card2 = new Card(1, "♥");
        System.out.println(card1.equals(card2));
    }

    public static void main5(String[] args) {
        Card card1 = new Card(2, "♥");
        Card card2 = new Card(1, "♦");
        // 1、
        PriorityQueue<Card> priorityQueue =  new PriorityQueue<>(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.rank - o2.rank;
            }
        });

        // 2、lambda 表达式 -> 可读性非常差
        // PriorityQueue<Card> priorityQueue = new PriorityQueue<>((x, y) -> {return x.rank - y.rank;});

        priorityQueue.offer(card1);
        priorityQueue.offer(card2);
        System.out.println(priorityQueue); // [Card{rank=1, suit='♦'}, Card{rank=2, suit='♥'}]
    }

/*    public static void main4(String[] args) {
        Card card1 = new Card(1, "♥");
        Card card2 = new Card(2, "♦");

        RankComparator rankComparator = new RankComparator();

        PriorityQueue<Card> priorityQueue = new PriorityQueue<>(rankComparator);
        priorityQueue.offer(card1);
        priorityQueue.offer(card2);
        System.out.println(priorityQueue);
        // [Card{rank=1, suit='♥'}, Card{rank=2, suit='♦'}]
    }*/

/*    public static void main3(String[] args) {
        Card card1 = new Card(1, "♥");
        Card card2 = new Card(2, "♦");

        RankComparator rankComparator = new RankComparator();
        int ret = rankComparator.compare(card1, card2);
        System.out.println(ret); // -1

        //System.out.println(card1.compareTo(card2)); // 1 -> 第一张牌大
    }*/

    public static void main2(String[] args) {
        // 默认是小根堆
        PriorityQueue<Card> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Card(1, "♥"));
        priorityQueue.offer(new Card(2, "♥"));
        System.out.println(priorityQueue);

        // priorityQueue.offer(null); // err ->NullPointerException
    }

    public static void main1(String[] args) {
        int[] array = { 27,15,19,18,28,34,65,49,25,37 };
        TestHeap testHeap = new TestHeap();
        testHeap.createHeap(array);

        testHeap.heapSort(); // 堆排序
        System.out.println(123);
    }


    /*    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0)+o2.get(1))-(o1.get(0)+o1.get(1));
            }
        });


    }*/
}
