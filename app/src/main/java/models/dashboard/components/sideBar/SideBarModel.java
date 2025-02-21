package models.dashboard.components.sideBar;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class SideBarModel {
    private final BooleanProperty buyViewVisibleProperty = new SimpleBooleanProperty(false);
    private final BooleanProperty loanViewVisibleProperty = new SimpleBooleanProperty(false);  
    private final BooleanProperty saleViewVisiBooleanProperty = new SimpleBooleanProperty(false);


    public BooleanProperty buyViewVisibleProperty() {
        return buyViewVisibleProperty;
    }
    public BooleanProperty loanViewVisibleProperty() {
        return loanViewVisibleProperty;
    }
    public BooleanProperty saleViewVisibleProperty() {
        return saleViewVisiBooleanProperty;
    }
    
}
