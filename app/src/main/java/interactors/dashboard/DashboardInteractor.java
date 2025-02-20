package interactors.dashboard;

import domain_stuff.objects.dashboard.DashboardObject;
import domain_stuff.services.dashboard.DashboardService;
import models.dashboard.DashboardModel;

public class DashboardInteractor {
    private final DashboardModel model;
    private final DashboardService service = new DashboardService();

    public DashboardInteractor(DashboardModel model) {
        this.model = model;
    }
    
}
