package interactors.dashboard;

import domain_stuff.services.dashboard.DashboardService;
import javafx.geometry.Side;
import models.dashboard.DashboardModel;
import models.dashboard.components.option.OptionModel;
import models.dashboard.components.sideBar.SideBarModel;
import models.dashboard.components.topBar.TopBarModel;

public class DashboardInteractor {
    private final DashboardModel model;
    private final OptionModel buyOptionModel;
    private final OptionModel loanOptionModel;
    private final OptionModel saleOptionModel;
    private final SideBarModel sideBarModel;
    private final TopBarModel topBarModel;
    private final DashboardService service = new DashboardService();

    public DashboardInteractor(DashboardModel model, OptionModel buyOptionModel, OptionModel loanOptionModel, 
    OptionModel saleOptionModel, 
    SideBarModel sideBarModel,
    TopBarModel topBarModel)  {
        this.model = model;
        this.buyOptionModel = buyOptionModel;
        this.loanOptionModel = loanOptionModel;
        this.saleOptionModel = saleOptionModel;
        this.sideBarModel = sideBarModel;
        this.topBarModel = topBarModel;
        buyOptionBindings();
        loanOptionBindings();
        saleOptionBindings();
        topBarBindings();


    }
    private void topBarBindings(){
        topBarModel.buyProperty().bind(model.buyViewVisibleProperty());
        topBarModel.loanProperty().bind(model.loanViewVisibleProperty());
        topBarModel.saleProperty().bind(model.saleViewVisibleProperty());
    }

    private void buyOptionBindings(){
        model.buyViewVisibleProperty().bind(buyOptionModel.isSelected());
       
        buyOptionModel.isSelected().addListener((observable, oldValue, newValue) -> {
            if(newValue){
               
                loanOptionModel.isSelected().set(false);
                saleOptionModel.isSelected().set(false);
            }
        });
    }
    private void loanOptionBindings(){
        model.loanViewVisibleProperty().bind(loanOptionModel.isSelected());
        loanOptionModel.isSelected().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                buyOptionModel.isSelected().set(false);
                saleOptionModel.isSelected().set(false);
            }
        });
    }
    private void saleOptionBindings(){
        model.saleViewVisibleProperty().bind(saleOptionModel.isSelected());
        saleOptionModel.isSelected().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                buyOptionModel.isSelected().set(false);
                loanOptionModel.isSelected().set(false);
            }
        });
    }
    
}
