package interactors.buy;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import models.buy.BuyModel;
import models.cards.CardsModel;

public class BuyInteractor {
    private final BuyModel model;
    private final CardsModel cardsModel;

    public BuyInteractor(BuyModel model, CardsModel cardsModel){
        this.model = model;
        this.cardsModel = cardsModel;
        electronics();
        whiteGoods();
        jewelry();
        cards();
    }


    public void electronics(){
        model.electronicsVisibleProperty().bind(cardsModel.electronicsProperty());
       

    }
    public void whiteGoods(){
        model.whiteGoodsVisibleProperty().bind(cardsModel.whiteGoodsProperty());
        
    }
    public void jewelry(){
        model.jewelryVisibleProperty().bind(cardsModel.jewelryProperty());
       
    }

    public void cards(){
        BooleanBinding allFalse = Bindings.createBooleanBinding(
            () -> !cardsModel.electronicsProperty().get() && 
                  !cardsModel.whiteGoodsProperty().get() && 
                  !cardsModel.jewelryProperty().get(),
            cardsModel.electronicsProperty(),
            cardsModel.whiteGoodsProperty(),
            cardsModel.jewelryProperty()
        );
        model.cardsVisibleProperty().bind(allFalse);
    }

    
}
