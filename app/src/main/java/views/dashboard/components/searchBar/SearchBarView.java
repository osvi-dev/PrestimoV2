package views.dashboard.components.searchBar;

import java.util.HashMap;
import java.util.function.Function;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import models.dashboard.components.searchBar.SearchBarModel;
import views.utils.ResourceLoader;

public class SearchBarView implements javafx.util.Builder<Region> {
    private final SearchBarModel model;
    private final HashMap<String, Function<?, ?>> handlers;

    private final double height = 100;
    private final double widthButton = 50;
    private final double widthField = 500;
    private final String resource = "search.png";
    private final String selectedResource = "search-h.png";
    private final HBox  container;
    private final TextField textField;
    

    public SearchBarView(SearchBarModel model,HashMap<String, Function<?, ?>> handlers ){
        this.model = model; 
        this.handlers = handlers;
        this.container = new HBox();
        this.textField = new TextField();

        container.getStylesheets().add(ResourceLoader.load("/css/dashboard/searchbar.css"));
    }
    @Override
    public Region build() {
        return (Region)createSearchBar();
    }

    public Node createSearchBar(){
        
       
        container.getChildren().addAll(createTextField(), createButton());
        
        container.setPadding(new Insets(8, 0, 8, 10));
        container.getStyleClass().add("container");

        
        return container;
    }

    private Node createTextField(){
        textField.getStyleClass().add("text-field");
        textField.setPrefHeight(height);
        textField.setPrefWidth(widthField);
        return textField;
    }

    private Node createButton(){
       VBox containerIcon =  new VBox(makeIcon(resource));
       containerIcon.setAlignment(Pos.CENTER);
        HBox button = new HBox(containerIcon);

        button.setOnMouseEntered(event ->{
           
            containerIcon.getChildren().clear();
            containerIcon.getChildren().add(makeIcon(selectedResource));
           
        });

        
        button.setOnMouseExited(event ->{
           
            containerIcon.getChildren().clear();
            containerIcon.getChildren().add(makeIcon(resource));
           
        });
        button.setAlignment(Pos.CENTER);
        button.setPrefWidth(widthButton);
        button.setPrefHeight(height-10);
        button.getStyleClass().add("button");
        return button;
    }
     private ImageView makeIcon(String resource){
         Image image = new Image(ResourceLoader.load("/images/dashboard/"+resource), 
        24, 
        24,
         true, 
         true);
         return new ImageView(image);
    }

    public TextField getTextField() {
        return textField;
    }

    
    
}
