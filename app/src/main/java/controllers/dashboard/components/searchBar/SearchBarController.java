package controllers.dashboard.components.searchBar;

import java.util.HashMap;
import java.util.function.Function;

import interactors.dashboard.components.searchBar.SearchBarInteractor;
import javafx.scene.layout.Region;
import models.dashboard.components.searchBar.SearchBarModel;
import views.dashboard.components.searchBar.SearchBarView;

public class SearchBarController {
    private final SearchBarView view;
    private final SearchBarModel model;
    private final SearchBarInteractor interactor;
    private final HashMap<String, Function<?, ?>> handlers = new HashMap<>();

    public SearchBarController() {
        this.model = new SearchBarModel();
        this.interactor = new SearchBarInteractor(model);
        this.view = new SearchBarView(model, handlers);
    }

    public Region getView() {
        return view.build();
    }   
}
