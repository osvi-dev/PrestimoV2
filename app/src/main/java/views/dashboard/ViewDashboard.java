package views.dashboard;

import javafx.geometry.Pos;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import views.utils.ResourceLoader;

public abstract class ViewDashboard  implements  Builder<Region>   {
     protected final VBox container;
     private final Region electroncis;
     private final Region whiteGoods;
     private final Region jelwelry;
     private final Region cards;

     public ViewDashboard(String styleSheet,Region cards ,Region electronics, Region whiteGoods, Region jelwelry){
        this.container = new VBox();
        this.container.getStylesheets().add(ResourceLoader.load("/css/dashboard/views/"+styleSheet+".css"));
        this.container.getStyleClass().add("container");
        this.container.setAlignment(Pos.CENTER);
        this.electroncis = electronics;
        this.whiteGoods = whiteGoods;
        this.jelwelry = jelwelry;
        this.cards = cards;
     }

     @Override
    public Region build() {
       return container;
    }





}
