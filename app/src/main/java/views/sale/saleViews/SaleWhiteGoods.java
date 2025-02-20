package views.sale.saleViews;

import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class SaleWhiteGoods implements Builder<Region>{
    private final VBox container = new VBox();

    @Override
    public Region build() {
        return container;
       
    }
    
}