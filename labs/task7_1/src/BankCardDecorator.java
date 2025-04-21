public class BankCardDecorator extends CardDecorator {
    public BankCardDecorator(Card card) {
        super(card);
    }

    @Override
    public void useCard() {
        super.useCard();
        System.out.println("Функция банковской карты добавлена.");
    }
}