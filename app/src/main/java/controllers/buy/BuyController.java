package controllers.buy;


import controllers.buy.buyControllers.BuyJewelryController;
import controllers.cards.CardsOptionController;
import interactors.buy.BuyInteractor;
import javafx.scene.layout.Region;
import models.buy.BuyModel;
import views.buy.BuyView;
import views.buy.buyViews.BuyElectronics;
import views.buy.buyViews.BuyWhiteGoods;

public class BuyController {

    private final BuyView view;
    private final BuyModel model;
    private final BuyInteractor interactor;
    private final CardsOptionController cardsController;
    private final BuyJewelryController buyJewelryController;

    public BuyController(){
        this.model =new BuyModel();
        this.buyJewelryController = new BuyJewelryController();
        this.cardsController = new CardsOptionController();
        this.interactor = new BuyInteractor(model, cardsController.getModel());
        this.view  = new BuyView(
            cardsController.getView(),
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

