package interactors.dashboard.components.sideBar;

import domain_stuff.services.dashboard.components.sideBar.SideBarService;
import models.dashboard.components.sideBar.SideBarModel;

public class SideBarInteractor {
    private final SideBarModel model;
    private final SideBarService service = new SideBarService();
    
    public SideBarInteractor(SideBarModel model) {
        this.model = model;
    }

    
}
