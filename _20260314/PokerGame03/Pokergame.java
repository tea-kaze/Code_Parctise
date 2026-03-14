package _20260314.PokerGame03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;

public class Pokergame {

    static HashMap<String, Integer> cardValue = new HashMap<>();     //存储牌的权值，key是牌面，value是牌的权值
    static ArrayList<String> deck = new ArrayList<>();              //牌盒，用来存储牌的序号和牌面

    // 1. 准备牌
    static {
        //牌型：
        //牌面：2、3、4、5、6、7、8、9、10、J、Q、K、A
        //花色：♠、♥、♣、♦

        String[] suits = {"♠", "♥", "♣", "♦"};
        String[] ranks = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};    //2最大

        //存储牌(即牌盒)
        for(String suit : suits) {
            for(String rank : ranks) {
                deck.add(suit + rank);
            }
        }

        //添加大小王
        deck.add(" 大王");   //由于小王和大王没有花色，所以在后面截取牌面数字来找权值时会出现报错，即截取出的字符时“王”，而HashMap
        deck.add(" 小王");   //中不存在这个key，解决方法是在添加大小王时加上一个空字符作为前缀
        

        //定义牌的权值，3~10的权值就是数字本身，不需要往里面存，需要用到时直接转为int类型即可
        //由于排序是在创建玩家牌集合时进行的，此时拿着牌面到Map集合中查看是否存在
        //若存在，则直接获取权值
        //若不存在，则说明是数字牌3~10，直接将牌面转为int类型即可
        cardValue.put("J", 11);
        cardValue.put("Q", 12);
        cardValue.put("K", 13);
        cardValue.put("A", 14);
        cardValue.put("2", 15);
        cardValue.put("小王", 50);
        cardValue.put("大王", 100);


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

        // 4. 整理手牌(方法二：给每张牌定义一个权值，按照牌的权值进行排序，则需要使用到Map集合)
        //细节：可以定义3~10的权值就是数字本身，J、Q、K、A的权值分别为11、12、13、14，2的权值为15，
        //      小王的权值为16或更大，大王的权值为17或更大
        sortHandCards(player1);
        sortHandCards(player2);
        sortHandCards(player3);

        // 5. 看牌
        showCards("底牌", bottomCards);
        showCards("玩家1", player1);
        showCards("玩家2", player2);
        showCards("玩家3", player3);
    }

    
    public void sortHandCards(ArrayList<String> handCards) {
        //使用Collections.sort()方法来对玩家的牌进行排序，排序时需要传入一个Comparator接口的实现类对象来指定排序规则
        
        Collections.sort(handCards, new Comparator<String>() {
            //Collections.sort()底层使用的是二分查找+插入排序
            @Override
            public int compare(String card1, String card2) {
                //card1表示当前要插入到有序序列中的牌
                //card2表示有序序列中存在的牌
            
                //负数：表示card1的权值小于card2的权值，card1应该排在card2的前面
                //正数：表示card1的权值大于card2的权值，card1应该排在card2的后面
                //0：表示card1的权值等于card2的权值，根据花色进行排序

                //计算card1的花色和权值
                String suit1 = card1.substring(0, 1);    //截取第一个字符，即花色
                int value1 = getValue(card1);    //牌面
                
                //计算card2的花色和权值
                String suit2 = card2.substring(0, 1);    //截取第一个字符，花色
                int value2 = getValue(card2);       //牌面

                int i = value1 - value2;    //比较牌的权值
                return i == 0 ? suit1.compareTo(suit2) : i;    //如果牌的权值相等，则根据花色进行排序 
            }
        });
    }

    public int getValue(String card) {
        //获取牌面的数字
        String rank = card.substring(1);    //截取第二个及以后的字符，即牌面，此时遇到大小王时也可正常截取
        //判断牌面是否在Map集合中存在
        if(cardValue.containsKey(rank)) {
            return cardValue.get(rank);
        } else {
            //说明是数字牌3~10，直接将牌面转为int类型即可
            return Integer.parseInt(rank);
        }
    }


    public void showCards(String name,ArrayList<String> player) {
        System.out.print(name + "的手牌：");
        for(String card : player) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
