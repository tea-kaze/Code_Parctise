package _20260314.PokerGame02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Pokergame {

    static HashMap<Integer, String> deck = new HashMap<>();     //牌盒，用来存储牌的序号和牌面
    static ArrayList<Integer> indexList = new ArrayList<>();    //牌的序号集合，用来存储牌的序号，发牌时根据牌的序号来获取牌面

    // 1. 准备牌
    static {
        //牌型：
        //牌面：2、3、4、5、6、7、8、9、10、J、Q、K、A
        //花色：♠、♥、♣、♦

        String[] suits = {"♠", "♥", "♣", "♦"};
        String[] ranks = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};    //2最大

        int index = 1;//牌的序号，从1开始

        //存储牌(即牌盒)
        //牌的序号最为外循环，运行时会将四个花色的同一序号的牌先存储到牌盒中，再去存储下一序号的牌
        //即先存储完3的♠、♥、♣、♦，再存储4的♠、♥、♣、♦，以此类推
        for(String rank : ranks) {
            for(String suit : suits) {
                indexList.add(index);
                deck.put(index++, suit + rank);
            }
        }

        //添加大小王
        indexList.add(index);
        deck.put(index++, "小王");
        indexList.add(index);
        deck.put(index, "大王");

    }
    
    public Pokergame() {
        // 2. 洗牌(即打乱牌盒中牌的顺序，使用Collections.shuffle()方法来实现洗牌功能)
        Collections.shuffle(indexList);

        // 3. 发牌
        //斗地主游戏中有三个玩家，每人发17张牌，剩余的3张牌作为底牌
        // 4. 整理手牌(方法一：给每张牌定义一个序号，按照牌的序号进行排序，则需要使用到Map集合)
        //使用TreeSet集合来存储玩家的牌和底牌，TreeSet集合会自动对元素进行排序，这样就不需要在整理手牌时再进行一次排序了
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        TreeSet<Integer> bottomCards = new TreeSet<>();

        //由于发牌需要将牌盒中的元素添加到玩家的牌集合中，需要用到索引，故使用普通for循环遍历
        for(int i = 0; i < indexList.size(); i++) {
            Integer cardIndex = indexList.get(i);
            if(i < 3) { //开头的3张牌作为底牌
                bottomCards.add(cardIndex);
            } else { //剩下51张牌发给玩家，每人17张
                if(i % 3 == 0) {
                    player1.add(cardIndex);
                } else if(i % 3 == 1) {
                    player2.add(cardIndex);
                } else {
                    player3.add(cardIndex);
                }
            }
        }

        // 5. 看牌
        showCards("底牌", bottomCards);
        showCards("玩家1", player1);
        showCards("玩家2", player2);
        showCards("玩家3", player3);

    }
    
    public void showCards(String name,TreeSet<Integer> player) {
        System.out.print(name + "的手牌：");
        for(Integer cardIndex : player) {
            String card = deck.get(cardIndex);
            System.out.print(card + " ");
        }
        System.out.println();
    }
}