package models.cards;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class CardsModel {
    private final BooleanProperty electronics = new SimpleBooleanProperty(false);
    private final BooleanProperty whiteGoods = new SimpleBooleanProperty(false);
    private final BooleanProperty jewelry = new SimpleBooleanProperty(false);

    public BooleanProperty electronicsProperty() {
        return electronics;
    }
    public BooleanProperty whiteGoodsProperty() {
        return whiteGoods;
    }
    public BooleanProperty jewelryProperty() {
        return jewelry;
    }
    
    
}
