public class InsuranceDecorator extends CardDecorator {
    public InsuranceDecorator(Card card) {
        super(card);
    }

    @Override
    public void useCard() {
        super.useCard();
        System.out.println("Функция страхового полиса добавлена.");
    }
}