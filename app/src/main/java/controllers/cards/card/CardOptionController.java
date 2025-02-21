package controllers.cards.card;

import javafx.scene.layout.Region;
import models.cards.card.CardModel;
import views.cards.card.CardOptionView;

public class CardOptionController {
    private final CardOptionView view;
    private final CardModel model;
    public CardOptionController(String resource, String title,String description){
        this.model = new CardModel();
        this.view = new CardOptionView(100, 200, resource, title,description, model);
    }

    public Region getView(){
        return view.build();
    }
    public CardModel getModel(){
        return model;
    }   
    
}
