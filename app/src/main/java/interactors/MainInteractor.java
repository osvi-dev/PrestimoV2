package interactors;

import domain_stuff.objects.MainObject;
import domain_stuff.services.MainService;
import models.MainModel;

public class MainInteractor {
    private final MainModel model;
    private final MainService service = new MainService(); 


    public MainInteractor(MainModel model) {
        this.model = model;
    }   
}
