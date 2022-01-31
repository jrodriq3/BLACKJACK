import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dealer {
    public int total = 0;
    public ArrayList<String> dealerCards = new ArrayList<String>();
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
        int ranNumb = random.nextInt(deckCards.size());
        String tempVar = deckCards.get(ranNumb);
        deckCards.remove(ranNumb);
        x.add(tempVar);
    }
    public void dealersTurn(Dealer o) {
        System.out.println("Dealers cards are: " + o.dealerCards);
        o.calculateTotal(null, o);
        System.out.println("Dealers total: " + o.total);
        while (o.total < 16) {
            o.addCard(o.dealerCards);
            o.calculateTotal(null, o);
            System.out.println("Dealers cards: " + o.dealerCards);
            System.out.println("Dealers total: " + o.total);
        }
    }
    public void promptUserAndHit(Player O) {
        if (O.total == 21) {
            System.out.println("Congrats, you got 21!");
            O.isDone = true;
        }
        else {
            while (O.total < 21 && O.isDone == false && O.isBusted == false) {
                System.out.println("Enter 1 for another card. or 2 to stay.");
                Scanner scanner = new Scanner(System.in);
                int answer = scanner.nextInt();
                if (answer == 1) {
                    addCard(O.playerCards);
                    System.out.println(O.playerCards);
                    calculateTotal(O, null);
                    System.out.println(O.total);
                    if (O.total > 21) {
                        System.out.println("Sorry, you busted.");
                    }
                }
                else {
                    System.out.println("Your turn is over.");
                    break;
                }
            }
        }
    }
    // uses addCard method twice in this method to simulate the start of game
    public void dealStart(ArrayList<String> x) {
        Dealer dealer = new Dealer();
        dealer.addCard(x);
        dealer.addCard(x);
    }
    // method used to calculate total given an arraylist of cards as the parameter
    public void calculateTotal(Player Pobj, Dealer Dobj) {
        if (Dobj == null) {
            Pobj.total = 0;
            for (String item:Pobj.playerCards) {
                for (int i = 0; i < referenceCards.size(); i++) {
                    if (item == referenceCards.get(i)) {
                        Pobj.total = Pobj.total + referenceValues.get(i);
                    }
                }
            }
        }
        else {
            Dobj.total = 0;
            for (String item:Dobj.dealerCards) {
                for (int i = 0; i < referenceCards.size(); i++) {
                    if (item == referenceCards.get(i)) {
                        Dobj.total = Dobj.total + referenceValues.get(i);
                    }
                }
            }
        }
        // this part of the code is re-adjusting the total if over 21 and has ace in hand.
        if (Dobj == null) {
            if (Pobj.total > 21) {
                for (String item:Pobj.playerCards) {
                    if (item.contains("A") && Pobj.total > 21) {
                        Pobj.total -= 10;
                    }
                }
            }
        }
        else {
            if (Dobj.total > 21) {
                for (String item:Dobj.dealerCards) {
                    if (item.contains("A") && Dobj.total > 21) {
                        Dobj.total -= 10;
                    }
                }
            }
        }
        //System.out.println(O.total);
    }
}