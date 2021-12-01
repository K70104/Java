import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card {
    private int rank; // 数字
    private String suit; // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "[ "+this.suit+":"+this.rank+" ]";
    }
}

public class TestDemo {
    public static final String[] suits = {"♥","♠","♣","♦"};

    public static List<Card> budCard() {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                /*String suit = suits[i];
                int rank = j;
                Card card = new Card(rank, suit);
                cards.add(card);*/
                cards.add(new Card(j, suits[i]));
            }
        }
        return cards;
    }

    // 交换
    public static void swap(List<Card> cards, int i, int j) {
        Card tmp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, tmp);
    }

    // 洗牌
    public static void shuffle(List<Card> cards) {
        int size = cards.size();
        for (int i = size - 1; i > 0; i--) {
            Random random = new Random();
            int rand = random.nextInt(i);
            swap(cards, i, rand);
        }
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        // 第一行
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ret.add(list1); // 此时才把第一行的数据放到了ret中
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1); // 每行开始都是1
            List<Integer> preRow = ret.get(i-1); // 上一行
            for (int j = 1; j < i; j++) {
                int num = preRow.get(j) + preRow.get(j-1);
                list.add(num);
            }
            list.add(1); // 结尾都是1
            ret.add(list);
        }
        return ret;
    }


    public static void main(String[] args) {
        List<Card> cards =  budCard();
        System.out.println("买牌"+cards);

        shuffle(cards);
        System.out.println("洗牌"+cards);

        System.out.println("揭牌：3个人每人轮流揭5张牌");

        ArrayList<List<Card>> hand = new ArrayList<>();

        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();

        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = cards.remove(0);
                hand.get(j).add(card);
            }
        }

        System.out.println("第1个人的牌："+hand1);
        System.out.println("第2个人的牌："+hand2);
        System.out.println("第3个人的牌："+hand3);
        System.out.println("剩下的牌："+cards);
    }
}
