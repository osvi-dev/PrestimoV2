package views.dashboard.components.option;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Builder;
import models.dashboard.components.option.OptionModel;
import views.utils.ResourceLoader;

public class OptionView implements Builder<Region> {

    private final OptionModel  model;
    private final Text text;
    private final ImageView icon;
    private final Font font = new Font("Roboto",15);
    private final double widthContainerText = 100;
    private final double widthContainerIcon = 50;
    private final double height = 50;
    private final double width = 200;
    private final HBox container =new HBox();
    private final String resource;
    private final String selectedResource;
    public OptionView(String text, String resource, String selectedResource, OptionModel model){
        this.model = model;
        this.text = new Text(text);
        this.resource =resource;
        this.selectedResource = selectedResource;
        this.icon = ResourceLoader.makeIcon(resource, 24);
        this.container.getStylesheets().add(ResourceLoader.load("/css/dashboard/option.css"));
    }
    
    public Region build() {
        return (Region)createOption();
    }

   
    public Node createOption(){
        text.setFont(font);
        HBox containerText = new HBox(text);
        containerText.setPrefWidth(widthContainerText); 
        containerText.setPrefHeight(height);
        containerText.setAlignment(Pos.CENTER_LEFT);

        HBox containerIcon = new HBox(icon);
        containerIcon.setPrefWidth(widthContainerIcon);
        containerIcon.setPrefHeight(height);
        containerIcon.setAlignment(Pos.CENTER);
        
    


        HBox innerContainer = new HBox(containerIcon,containerText);
        this.container.setOnMouseEntered(event ->{
            containerIcon.getChildren().clear();
            containerIcon.getChildren().add(ResourceLoader.makeIcon(selectedResource, 24));
            text.setFill(Color.WHITE);
        });
        container.setOnMouseExited(event -> {
            containerIcon.getChildren().clear();
            containerIcon.getChildren().add(ResourceLoader.makeIcon(resource,24));
            text.setFill(Color.BLACK);
        });
       this.container.getStyleClass().add("container");
       this.container.getChildren().clear();
       this.container.getChildren().add(innerContainer);
       this.container.setPrefWidth(width);
       createClickHandler();
        return container;

    }

    private void createClickHandler(){
        
        container.setOnMouseClicked(event -> {
            model.isSelected().set(true);
        });
    }



    

    
}
