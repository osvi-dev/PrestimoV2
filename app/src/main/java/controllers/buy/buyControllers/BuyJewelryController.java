package controllers.buy.buyControllers;

import java.util.HashMap;
import java.util.function.Supplier;

import interactors.buy.buyInteractors.BuyJewelryInteractor;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import models.buy.buyModels.BuyJewelryModel;
import views.buy.buyViews.BuyJewelryView;

public class BuyJewelryController {

    private final BuyJewelryModel model;
    private final BuyJewelryView view;
    private final BuyJewelryInteractor interactor;
    private final HashMap<String,Supplier<Void>> handlers = new HashMap<>();
    public BuyJewelryController(){
        this.model = new BuyJewelryModel();
        this.interactor = new BuyJewelryInteractor(model);
        this.handlers.put("calculate", this::calculate);
        this.view = new BuyJewelryView(model,handlers);
    }
    public Region getView(){
        return view.build();
    }
    private Void calculate(){
        Task<Void> calculateTask = new Task<Void>() {
            @Override
            protected Void call(){
                interactor.calculateJewelry();
                return null;
            }
        };
        calculateTask.setOnSucceeded(evt->{
            System.out.println("Listo!");
            interactor.printAllModel();
        });
        Thread calculateThread = new Thread(calculateTask);
        calculateThread.start();
        return null;
    }

   

    
}
