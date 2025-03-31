public class Main {
    public static void main(String[] args) {
        Card myCard = new BaseCard();
        myCard = new PassportDecorator(myCard);
        myCard = new InsuranceDecorator(myCard);
        myCard = new BankCardDecorator(myCard);

        myCard.useCard();
    }
}