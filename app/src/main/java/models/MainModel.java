package models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class MainModel {
    private final BooleanProperty dashboardVisibleProperty = new SimpleBooleanProperty(false);
    
    public BooleanProperty dashboardVisibleProperty() {
        return dashboardVisibleProperty;
    }




    


}
