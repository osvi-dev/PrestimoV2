package controllers.sale;

import controllers.cards.CardsOptionController;
import javafx.scene.layout.Region;
import models.sale.SaleModel;
import views.sale.SaleView;
import views.sale.saleViews.SaleElectronics;
import views.sale.saleViews.SaleJewelry;
import views.sale.saleViews.SaleWhiteGoods;

public class SaleController {
    private final SaleView view;
    private final CardsOptionController cards;
    private final SaleModel model;
    public SaleController(){
        this.model = new SaleModel();
        this.cards = new CardsOptionController();
        //TODO: Agregar tabla
        this.view  = new SaleView(cards.getView(), new Region()/*Table */,
        new SaleElectronics().build(), new SaleWhiteGoods().build(), new SaleJewelry().build(), model);
    }
    private Void nihao(){
        System.out.println("Nihao");
        return null;
    }
    public Region getView(){
        return view.build();
    }
}
