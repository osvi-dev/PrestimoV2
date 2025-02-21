package views.buy;


import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
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
        cards.visibleProperty().bind(model.cardsVisibleProperty());
        electronics.visibleProperty().bind(model.electronicsVisibleProperty());
        whiteGoods.visibleProperty().bind(model.whiteGoodsVisibleProperty());
        jewelry.visibleProperty().bind(model.jewelryVisibleProperty());
        this.container.getChildren().add( new StackPane(cards, electronics, whiteGoods, jewelry));
        
    }
     


}
