package models.buy;



import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import models.dashboard.components.option.OptionModel;

public class BuyModel extends OptionModel  {
    private final BooleanProperty cardsVisibleProperty = new SimpleBooleanProperty(true);
   private final BooleanProperty electronicsVisibleProperty = new SimpleBooleanProperty(false);
    private final BooleanProperty whiteGoodsVisibleProperty = new SimpleBooleanProperty(false);
    private final BooleanProperty jewelryVisibleProperty = new SimpleBooleanProperty(false);

    public BuyModel(){
        
    }
    public BooleanProperty cardsVisibleProperty() {
        return cardsVisibleProperty;
    }

    public BooleanProperty electronicsVisibleProperty() {
        return electronicsVisibleProperty;
    }
    public BooleanProperty whiteGoodsVisibleProperty() {
        return whiteGoodsVisibleProperty;
    }
    public BooleanProperty jewelryVisibleProperty() {
        return jewelryVisibleProperty;
    }




}
