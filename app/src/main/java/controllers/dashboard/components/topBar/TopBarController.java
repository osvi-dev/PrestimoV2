package controllers.dashboard.components.topBar;

import java.util.HashMap;
import java.util.function.Function;

import controllers.dashboard.components.searchBar.SearchBarController;
import interactors.dashboard.components.topBar.TopBarInteractor;
import javafx.scene.layout.Region;
import models.dashboard.components.topBar.TopBarModel;
import views.dashboard.components.topBar.TopBarView;

public class TopBarController {
    private final TopBarView view;
    private final TopBarModel model;
    private final TopBarInteractor interactor;
    private final SearchBarController searchBarController;
    private final HashMap<String, Function<?, ?>> handlers = new HashMap<>();

    public TopBarController() {
        this.model = new TopBarModel();
        this.interactor = new TopBarInteractor(model);  
        this.searchBarController = new SearchBarController();
        this.view = new TopBarView(searchBarController.getView(), model, handlers);
        
    }
    public Region getView() {
        return view.build();
    }
}
