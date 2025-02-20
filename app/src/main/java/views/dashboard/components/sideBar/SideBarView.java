package views.dashboard.components.sideBar;


import java.util.HashMap;
import java.util.function.Function;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import models.dashboard.components.sideBar.SideBarModel;
import views.utils.ResourceLoader;
import views.utils.Responsive;

public class SideBarView implements Builder<Region> {
    private final Region buyOptionView;
    private final Region loanOptionView;
    private final Region saleOptionView;
    private final SideBarModel model;
    private final HashMap<String, Function<?, ?>> handlers;
    private final VBox container = new VBox();
    private final double width = 0.15;
    private final double height = 1;
    public SideBarView(Region buyOptionView, Region loanOptionView, Region saleOptionView, SideBarModel model, HashMap<String, Function<?, ?>> handlers) {
        this.buyOptionView = buyOptionView;
        this.loanOptionView = loanOptionView;
        this.saleOptionView = saleOptionView;
        this.model = model;
        this.handlers = handlers;

    
        container.getStylesheets().add(ResourceLoader.load("/css/dashboard/sidebar.css"));
        container.getStyleClass().add("container");
    }
    @Override
    public Region build() {
        return (Region)createSideBar();
    }

    public Node createSideBar(){
        container.getChildren().addAll(buyOptionView, loanOptionView, saleOptionView);
        Responsive.bindingToParent(container, width, height);
             container.setPadding(new Insets(10, 10, 10, 10));
        container.setSpacing(10);
        return container;
    }

  

 
    
}
