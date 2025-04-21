public class PassportDecorator extends CardDecorator {
    public PassportDecorator(Card card) {
        super(card);
    }

    @Override
    public void useCard() {
        super.useCard();
        System.out.println("Функция паспорта добавлена.");
    }
}