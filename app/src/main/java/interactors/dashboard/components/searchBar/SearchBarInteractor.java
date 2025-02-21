package interactors.dashboard.components.searchBar;

import domain_stuff.services.dashboard.components.searchBar.SearchBarService;
import models.dashboard.components.searchBar.SearchBarModel;
public class SearchBarInteractor {
    private final SearchBarModel model;
    private final SearchBarService service = new SearchBarService();

    public SearchBarInteractor(SearchBarModel model) {
        this.model = model;
    }

    public void performSearch() {
     
    }
}
