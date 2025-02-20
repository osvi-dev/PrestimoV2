package views.sale;


import javafx.scene.layout.Region;
import models.sale.SaleModel;
import views.dashboard.ViewDashboard;

public class SaleView extends ViewDashboard {
    private final SaleModel model;  

    public SaleView(Region cards, Region table, Region electronics, Region whiteGoods, Region jelwelry, SaleModel model){
        super("sale",cards,electronics,whiteGoods,jelwelry);
        this.model = model;
        this.container.getChildren().addAll(cards, table);
    }


}
