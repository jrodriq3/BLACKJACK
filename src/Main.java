public class Main {
    public static void main(String[] args) {
        System.out.println("Hello welcome to blackjack!");
        Dealer myDealer = new Dealer();
        myDealer.populateValArr();
        myDealer.populateCardArrs();
        Player playerJason = new Player();
        myDealer.dealStart(playerJason.playerCards);
        System.out.println(playerJason.playerCards);
        myDealer.calculateTotal(playerJason.playerCards, playerJason);
    }
}
