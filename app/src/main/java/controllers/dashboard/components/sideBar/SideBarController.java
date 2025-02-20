package controllers.dashboard.components.sideBar;

import java.util.HashMap;
import java.util.function.Function;

import controllers.dashboard.components.option.OptionController;
import interactors.dashboard.components.sideBar.SideBarInteractor;
import javafx.scene.layout.Region;
import models.dashboard.components.sideBar.SideBarModel;
import views.dashboard.components.sideBar.SideBarView;

public class SideBarController {
    private final SideBarView view;
    private final SideBarModel model;
    private final SideBarInteractor interactor;
    private final OptionController optionBuyController;
    private final OptionController optionLoanController;    
    private final OptionController optionSaleController;
    private final HashMap<String, Function<?, ?>> handlers  =new HashMap<>();

    public SideBarController(OptionController optionBuyController, OptionController optionLoanController, OptionController optionSaleController) {
        this.optionBuyController = optionBuyController;
        this.optionLoanController = optionLoanController;
        this.optionSaleController = optionSaleController;
        this.model = new SideBarModel();
        this.interactor = new SideBarInteractor(model);
        this.view = new SideBarView(
            optionBuyController.getView(),
            optionLoanController.getView(),
            optionSaleController.getView(),
            model,
            handlers);
    }
    public Region getView() {
        return view.build();
    }


    
}