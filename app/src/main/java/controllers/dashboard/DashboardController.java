package controllers.dashboard;

import java.util.HashMap;
import java.util.function.Function;

import controllers.buy.BuyController;
import controllers.dashboard.components.option.OptionController;
import controllers.dashboard.components.sideBar.SideBarController;
import controllers.dashboard.components.topBar.TopBarController;
import controllers.loan.LoanController;
import controllers.sale.SaleController;
import interactors.dashboard.DashboardInteractor;
import javafx.scene.layout.Region;
import models.dashboard.DashboardModel;
import views.dashboard.DashboardView;

/**
 * Controlador para gestionar el dashboard y sus vistas.
 */
public class DashboardController {
    private final DashboardView view;
    private final DashboardModel model;
    private final DashboardInteractor interactor;
    private final BuyController buyController;
    private final LoanController loanController;
    private final SaleController saleController;
    private final TopBarController topBarController;
    private final OptionController optionBuyController;
    private final OptionController optionLoanController;
    private final OptionController optionSaleController;
    private final SideBarController sideBarController;
    private final HashMap<String, Function<?, ?>> service = new HashMap<>();
    /**
     * Constructor del DashboardController. Inicializa el modelo y las vistas.
     */
    public DashboardController() {
        
        this.buyController = new BuyController();
        this.loanController = new LoanController();
        this.saleController = new SaleController();
        
        this.model = new DashboardModel();
        this.optionBuyController = new OptionController("Compra", "/dashboard/shopping-cart.png", "/dashboard/shopping-cart-h.png");
        this.optionLoanController = new OptionController("Prestamo", "/dashboard/loan.png", "/dashboard/loan-h.png");
        this.optionSaleController = new OptionController("Venta", "/dashboard/price-tag.png", "/dashboard/price-tag-h.png");
        
        this.sideBarController = new SideBarController(
                optionBuyController,
                optionLoanController,
                optionSaleController
        );
        this.topBarController = new TopBarController();
        this.interactor = new DashboardInteractor(
            model, 
            optionBuyController.getModel(), 
            optionLoanController.getModel(),
            optionSaleController.getModel(),
            sideBarController.getModel(),
            topBarController.getModel()
        );
        this.view = new DashboardView(
                sideBarController.getView(),
                topBarController.getView(),
                buyController.getView(),
                loanController.getView(),
                saleController.getView(),
                service,
                model
        );
    }

    /**
     * Obtiene la vista principal del dashboard.
     *
     * @return La vista del dashboard.
     */
    public Region getView() {
        return view.build();
    }


}
