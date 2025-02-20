package views.dashboard.components.topBar;


import java.util.HashMap;
import java.util.function.Function;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Builder;
import models.dashboard.components.topBar.TopBarModel;
import views.utils.ResourceLoader;
import views.utils.Responsive;

public class TopBarView implements Builder<Region> {
    private final TopBarModel model;
    private final Region searchBarView;
    private final double height = 60;
    private final HBox container;
    private final HashMap<String, Function<?, ?>> handlers;

    public TopBarView(Region searchBarView,TopBarModel model,HashMap<String, Function<?, ?>> handlers){
        this.model = model;
        this.handlers = handlers;
        this.searchBarView = searchBarView;
        this.container = new HBox();
        container.getStylesheets().add(ResourceLoader.load("/css/dashboard/topbar.css"));
    }
    @Override
    public Region build() {
        return (Region)createTopBar();
    }

    public Node createTopBar(){
       container.getStyleClass().add("container");
       container.setPrefHeight(height);
       
       container.getChildren().addAll(createTitleContainer(),searchBarView);
       container.setHgrow(searchBarView, Priority.ALWAYS);

       //container.setSpacing(200);
       
        return container;
    }

    private Node createTitleContainer(){
        Text title = new Text("Algo");
        title.setFont(new Font("Roboto", 25));
        title.setFill(Color.rgb(72, 76, 82));
        HBox container = new HBox(title);
        container.setPrefHeight(height);
        Responsive.bindingToParentWidth(container, 0.15);
        container.getStyleClass().add("title-container");
        container.setAlignment(Pos.CENTER);
        return container;
    }
    
}
