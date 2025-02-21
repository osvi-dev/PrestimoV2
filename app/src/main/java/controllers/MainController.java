package controllers;

import controllers.dashboard.DashboardController;
import interactors.MainInteractor;
import javafx.scene.layout.Region;
import models.MainModel;
import views.MainView;

public class MainController {
    private final MainModel model;
    private final MainView view;
    private final MainInteractor interactor;
    private final DashboardController dashboardController;

    public MainController(){
        this.model = new MainModel();
        this.interactor = new MainInteractor(model);
        this.dashboardController = new DashboardController();
        this.view = new MainView(
           dashboardController.getView()
        );
    }


    public Region getView(){
        return view.build();
    }
    
}
