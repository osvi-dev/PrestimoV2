package interactors.dashboard.components.topBar;

import domain_stuff.services.dashboard.components.topBar.TopBarService;
import javafx.beans.binding.Binding;
import models.dashboard.components.topBar.TopBarModel;

public class TopBarInteractor {
    private final TopBarModel model;
    private final TopBarService service = new TopBarService();
    
    public TopBarInteractor(TopBarModel model) {
        this.model = model;
        buyBindigs();
        loanBindigs();
        saleBindigs();
    }

    private void buyBindigs (){
        model.buyProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                model.titleProperty().set("Compra");
            }
        });
    }
    private void loanBindigs (){
        model.loanProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                model.titleProperty().set("Préstamo");
            }
        });
    }
    private void saleBindigs (){
        model.saleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                model.titleProperty().set("Venta");
            }
        });
    }

}
