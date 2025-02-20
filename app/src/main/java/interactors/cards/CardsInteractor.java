package interactors.cards;

import models.cards.CardsModel;
import models.cards.card.CardModel;

public class CardsInteractor {
    private final CardsModel model;
    private final CardModel electronicsModel;
    private final CardModel whiteGoodsModel;
    private final CardModel jewelryModel;
    
    public CardsInteractor( CardsModel model, CardModel electronicsModel, CardModel whiteGoodsModel, CardModel jewelryModel){
        this.model = model;
        this.electronicsModel = electronicsModel;
        this.whiteGoodsModel = whiteGoodsModel;
        this.jewelryModel = jewelryModel;
    }

    public void electronics(){
       model.electronicsProperty().bind(electronicsModel.isSelectedProperty());
       model.electronicsProperty().addListener((observable, oldValue, newValue) -> {
           if(newValue){
            whiteGoodsModel.isSelectedProperty().set(false);
            jewelryModel.isSelectedProperty().set(false);
           }
       });
    }

    public void whiteGoods(){
        model.whiteGoodsProperty().bind(whiteGoodsModel.isSelectedProperty());
        model.whiteGoodsProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                electronicsModel.isSelectedProperty().set(false);
                jewelryModel.isSelectedProperty().set(false);
            }
        });
    }
    public void jewelry(){
        model.jewelryProperty().bind(jewelryModel.isSelectedProperty());
        model.jewelryProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                electronicsModel.isSelectedProperty().set(false);
                whiteGoodsModel.isSelectedProperty().set(false);
            }
        });
    }
    
}
