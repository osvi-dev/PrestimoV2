package controllers.buy;


import controllers.buy.buyControllers.BuyJewelryController;
import controllers.cards.CardsOptionController;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Region;
import models.buy.BuyModel;
import views.buy.BuyView;
import views.buy.buyViews.BuyElectronics;
import views.buy.buyViews.BuyWhiteGoods;

public class BuyController {

    private final BuyView view;
    private final BuyModel model;
    private final CardsOptionController cards;
    private final BuyJewelryController buyJewelryController;

    public BuyController(){
        this.model =new BuyModel();
        this.buyJewelryController = new BuyJewelryController();
        this.cards = new CardsOptionController();
        
        this.view  = new BuyView(
            cards.getView(),
            new BuyElectronics().build(), 
            new BuyWhiteGoods().build(), 
            buyJewelryController.getView(),
            model
            );

        
    
    }
    
 
   
    public Region getView(){
        return view.build();
    }


}

