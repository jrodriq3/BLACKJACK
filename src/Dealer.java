import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dealer {
    public static ArrayList<String> deckCards = new ArrayList<String>();
    public static ArrayList<String> referenceCards = new ArrayList<String>();
    public static ArrayList<Integer> referenceValues = new ArrayList<Integer>();
    // cardArr will be used to populate referenceCards and deckCards ArrayLists
    private static String[] cardArr = {
            "A❤️", "2❤️", "3❤️", "4❤️", "5❤️", "6❤️", "7❤️", "8❤️", "9❤️", "10❤️", "J❤️", "Q❤️", "K❤️",
            "A♦️", "2♦️", "3♦️", "4♦️", "5♦️", "6♦️", "7♦️", "8♦️", "9♦️", "10♦️", "J♦️", "Q♦️", "K♦️",
            "A♠", "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠",
            "A♣", "2♣", "3♣", "4♣", "5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣"
    };
    // totalList will be used to populate referenceValues ArrayList
    private static int[] totalList = {
            11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
            11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
            11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
            11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10
    };
    // method to populate referenceValues ArrayList
    public void populateValArr() {
        for (Integer num:totalList) {
            referenceValues.add(num);
        }
    }
    // method used to populate both deckCards and referenceValues ArrayLists
    public void populateCardArrs() {
        for (String item:cardArr) {
            deckCards.add(item);
            referenceCards.add(item);

        }
    }

    // used to add a single card to ArrayList object
    public void addCard(ArrayList<String> x) {
        Random random = new Random();
        int ranNumb = random.nextInt(52);
        String tempVar = deckCards.get(ranNumb);
        deckCards.remove(ranNumb);
        x.add(tempVar);
    }
    // uses addCard method twice in this method to simulate the start of game
    public void dealStart(ArrayList<String> x) {
        Dealer dealer = new Dealer();
        dealer.addCard(x);
        dealer.addCard(x);
    }
    // method used to calculate total given an arraylist of cards as the parameter
    public void calculateTotal(ArrayList<String> hand, Player O) {
        O.total = 0;
        for (String item:hand) {
            for (int i = 0; i < referenceCards.size(); i++) {
                if (item == referenceCards.get(i)) {
                    O.total = O.total + referenceValues.get(i);
                }

            }
        }
        // this part of the code is re-adjusting the total if over 21 and has ace in hand.
        System.out.println(O.total);
    }
}