package _20260314.PokerGame01;

import java.util.ArrayList;
import java.util.Collections;

public class Pokergame {
    //牌盒只有一个，所以可以将牌盒定义为静态成员变量，这样在创建斗地主对象时就不需要重复创建牌盒了
    static ArrayList<String> deck = new ArrayList<>();

    // 1. 准备牌(游玩多局游戏时，一般只用一副牌，准备牌的过程只需要执行一次，可以使用静态代码块来完成牌的准备工作)
    //静态代码块特点：在类加载时执行，并且只执行一次。
    static {
        //牌型：
        //牌面：2、3、4、5、6、7、8、9、10、J、Q、K、A
        //花色：♠、♥、♣、♦

        String[] suits = {"♠", "♥", "♣", "♦"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        //存储牌(即牌盒)
        for(String suit : suits) {
            for(String rank : ranks) {
                deck.add(suit + rank);
            }
        }

        //添加大小王
        deck.add("大王");
        deck.add("小王");
    }


    public Pokergame() {
        // 2. 洗牌(即打乱牌盒中牌的顺序，使用Collections.shuffle()方法来实现洗牌功能)
        Collections.shuffle(deck);

        // 3. 发牌
        //斗地主游戏中有三个玩家，每人发17张牌，剩余的3张牌作为底牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> bottomCards = new ArrayList<>();

        //由于发牌需要将牌盒中的元素添加到玩家的牌集合中，需要用到索引，故使用普通for循环遍历
        for(int i = 0; i < deck.size(); i++) {
            String card = deck.get(i);
            if(i < 3) { //开头的3张牌作为底牌
                bottomCards.add(card);
            } else { //剩下51张牌发给玩家，每人17张
                if(i % 3 == 0) {
                    player1.add(card);
                } else if(i % 3 == 1) {
                    player2.add(card);
                } else {
                    player3.add(card);
                }
            }
        }

        // 4. 看牌
        showCards("底牌", bottomCards);
        showCards("玩家1", player1);
        showCards("玩家2", player2);
        showCards("玩家3", player3);
    }

    public void showCards(String name,ArrayList<String> player) {
        System.out.print(name + "的手牌：");
        for(String card : player) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
