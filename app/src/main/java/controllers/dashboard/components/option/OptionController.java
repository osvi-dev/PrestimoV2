package controllers.dashboard.components.option;    

import javafx.scene.layout.Region;
import models.dashboard.components.option.OptionModel;
import views.dashboard.components.option.OptionView;

public class OptionController {

    private final OptionView view;
    private final OptionModel model;

    public OptionController(String text, String resource, String selectedResource){
        this.model = new OptionModel();
        this.view = new OptionView(text,resource,selectedResource,model);
    }

    public Region getView() {
        return view.build();
    }
}
