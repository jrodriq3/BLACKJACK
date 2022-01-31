public class Main {
    public static void main(String[] args) {
        System.out.println("Hello welcome to blackjack!");
        Dealer myDealer = new Dealer();
        myDealer.populateValArr();
        myDealer.populateCardArrs();
        Player playerJason = new Player();
        myDealer.dealStart(playerJason.playerCards);
        System.out.println("Your cards: " + playerJason.playerCards);
        myDealer.dealStart(myDealer.dealerCards);
        for (int i = 1; i < myDealer.dealerCards.size(); i++) {
            System.out.println("Dealers cards: " + myDealer.dealerCards.get(i));
        }
        myDealer.calculateTotal(playerJason, null);
        System.out.println("Your total is: " + playerJason.total);
        myDealer.promptUserAndHit(playerJason);
        if (playerJason.total > 21) {
            playerJason.isBusted = true;
        }
        if (playerJason.isBusted == false) {
            myDealer.dealersTurn(myDealer);
        }
        else {
            System.out.println("Sorry you busted the dealer won.");
        }
        if (playerJason.total > myDealer.total && playerJason.total < 22) {
            System.out.println("You win!");
        }
        }
    }

