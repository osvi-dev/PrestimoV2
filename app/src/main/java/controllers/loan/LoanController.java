package controllers.loan;

import controllers.cards.CardsOptionController;
import javafx.scene.layout.Region;
import models.loan.LoanModel;
import views.loan.LoanView;
import views.loan.loanViews.LoanElectronics;
import views.loan.loanViews.LoanJewelry;
import views.loan.loanViews.LoanWhiteGoods;

public class LoanController {
    private final LoanView view;
    private final CardsOptionController cards;
    private final LoanModel model;
    public LoanController(){
        this.model= new LoanModel();
        this.cards = new CardsOptionController();
        
        //TODO: Agregar tabla
        this.view  = new LoanView(cards.getView(),
        new LoanElectronics().build(), 
        new LoanWhiteGoods().build(),
         new LoanJewelry().build(),
         model);
    }
    public Region getView(){
        return view.build();
    }

}
