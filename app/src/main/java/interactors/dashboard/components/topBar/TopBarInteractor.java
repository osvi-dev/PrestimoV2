package interactors.dashboard.components.topBar;

import domain_stuff.services.dashboard.components.topBar.TopBarService;
import models.dashboard.components.topBar.TopBarModel;

public class TopBarInteractor {
    private final TopBarModel model;
    private final TopBarService service = new TopBarService();
    
    public TopBarInteractor(TopBarModel model) {
        this.model = model;
    }
}
