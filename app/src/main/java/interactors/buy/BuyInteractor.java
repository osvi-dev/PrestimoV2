package interactors.buy;

import models.buy.BuyModel;
import models.cards.CardsModel;

public class BuyInteractor {
    private final BuyModel model;
    private final CardsModel cardsModel;

    public BuyInteractor(BuyModel model, CardsModel cardsModel){
        this.model = model;
        this.cardsModel = cardsModel;
    }


    public void electronics(){
        model.electronicsVisibleProperty().bind(cardsModel.electronicsProperty());
        model.electronicsVisibleProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
             cardsModel.whiteGoodsProperty().set(false);
             cardsModel.jewelryProperty().set(false);
            }
        });

    }
    public void whiteGoods(){
        model.whiteGoodsVisibleProperty().bind(cardsModel.whiteGoodsProperty());
        model.whiteGoodsVisibleProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                cardsModel.electronicsProperty().set(false);
                cardsModel.jewelryProperty().set(false);
            }
        });
    }
    public void jewelry(){
        model.jewelryVisibleProperty().bind(cardsModel.jewelryProperty());
        model.jewelryVisibleProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                cardsModel.electronicsProperty().set(false);
                cardsModel.whiteGoodsProperty().set(false);
            }
        });
    }

    
}
