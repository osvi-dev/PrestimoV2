package views.buy;


import java.util.function.Predicate;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.layout.Region;
import models.buy.BuyModel;
import views.dashboard.ViewDashboard;


public class BuyView extends ViewDashboard {
    private final BuyModel model;


    public BuyView(Region cards, 
                  Region electronics, 
                  Region whiteGoods, 
                  Region jewelry,
                  BuyModel model) {
        super("buy", cards,electronics, whiteGoods, jewelry);
        this.model = model;
        this.container.getChildren().addAll(cards);
        
    }
     


}
