package views.loan;


import javafx.scene.layout.Region;
import models.loan.LoanModel;
import views.dashboard.ViewDashboard;

public class LoanView extends ViewDashboard {
    private final LoanModel model;

    public LoanView(Region cards, Region electronics, Region whiteGoods, Region jelwelry, LoanModel model){
       super("loan",cards,electronics,whiteGoods,jelwelry);
       this.model = model;
       this.container.getChildren().addAll(cards);
    }

}
