package controllers.cards.card;

import javafx.scene.layout.Region;
import views.cards.card.CardOptionView;

public class CardOptionController {
    private final CardOptionView view;
    public CardOptionController(String resource, String title,String description){
        this.view = new CardOptionView(100, 200, resource, title,description);
    }

    public Region getView(){
        return view.build();
    }
    
}
