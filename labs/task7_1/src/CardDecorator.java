public abstract class CardDecorator implements Card {
    protected Card wrappedCard;

    public CardDecorator(Card card) {
        this.wrappedCard = card;
    }

    @Override
    public void useCard() {
        wrappedCard.useCard();
    }
}
