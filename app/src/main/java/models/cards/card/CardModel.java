package models.cards.card;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class CardModel {
    private final BooleanProperty isSelected = new SimpleBooleanProperty(false);

    public BooleanProperty isSelectedProperty() {
        return isSelected;
    }
    
}
