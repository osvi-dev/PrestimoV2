package controllers.cards;


import controllers.cards.card.CardOptionController;
import interactors.cards.CardsInteractor;
import javafx.scene.layout.Region;
import models.cards.CardsModel;
import views.cards.CardsOptionView;

public class CardsOptionController {

    private final CardsOptionView view;
    private final CardsModel model;
    private final CardsInteractor interactor;

    /**
     *  Data referente a Electronica
     */
    private final CardOptionController electronics;
    private final String electroncisResource  ="/option/electronics.png";
    private final String electronicsTitle = "Electrónica";
    private final String electroncisDescription  ="🔹 Smartphones\n"+ //
"🔹 Tablets\n"+ //
"🔹 Computadoras de escritorio\n"+ //
"🔹 Televisores (LED, OLED, QLED)\n"+ //
"🔹 Consolas de videojuegos (PlayStation, Xbox, Nintendo)";


 /**
     *  Data referente a Linea Blanca
     */
    private final CardOptionController whiteGoods;
    private final String whiteGoodsResource  ="/option/whiteGoods.png";
    private final String whiteGoodsTitle = "Línea Blanca";
    private final String whiteGoodsDescription  ="🔹 Refrigeradores\n" + //
                "🔹 Lavadoras\n" + //
                "🔹 Secadoras\n" + //
                "🔹 Estufas\n" + //
                "🔹 Hornos de microondas";


    
    /**
     *  Data referente a Joyería
     */
    private final CardOptionController jewelry;
    private final String jewelryResource  ="/option/jewelry.png";
    private final String jewelryTitle = "Joyería";
    private final String jewelryDescription  ="🔹 Collares\n" + //
                "🔹 Pulseras\n" + //
                "🔹 Anillos\n" + //
                "🔹 Cadenas\n" + //
                "🔹 Joyas personalizadas";
                

    public CardsOptionController(){
        this.model = new CardsModel();
        this.electronics = new CardOptionController(electroncisResource, electronicsTitle,electroncisDescription);

        this.whiteGoods = new CardOptionController(whiteGoodsResource, whiteGoodsTitle, whiteGoodsDescription);
       
        this.jewelry = new CardOptionController(jewelryResource, jewelryTitle, jewelryDescription);
        this.interactor = new CardsInteractor(model, electronics.getModel(), whiteGoods.getModel(), jewelry.getModel());
        this.view = new CardsOptionView(electronics.getView(), whiteGoods.getView(), jewelry.getView(),model);
        
        
        
    }

    public Region getView(){
        return view.build();
    }
    public CardsModel getModel(){
        return model;
    }
    
}
