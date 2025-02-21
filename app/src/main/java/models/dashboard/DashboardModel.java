package models.dashboard;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Modelo para el dashboard que gestiona la vista actual del sistema.
 */
public class DashboardModel {
    private final BooleanProperty containerVisibleProperty = new SimpleBooleanProperty(true);
    private final BooleanProperty topBarViewVisibleProperty = new SimpleBooleanProperty(true);
    private final BooleanProperty buyViewVisibleProperty = new SimpleBooleanProperty(false);
    private final BooleanProperty loanViewVisibleProperty = new SimpleBooleanProperty(false);
    private final BooleanProperty saleViewVisibleProperty = new SimpleBooleanProperty(false);

    public BooleanProperty containerVisibleProperty() {
        return containerVisibleProperty;
    }
    public BooleanProperty topBarViewVisibleProperty() {
        return topBarViewVisibleProperty;
    }
    public BooleanProperty buyViewVisibleProperty() {
        return buyViewVisibleProperty;
    }
    public BooleanProperty loanViewVisibleProperty() {
        return loanViewVisibleProperty;
    }   
    public BooleanProperty saleViewVisibleProperty() {
        return saleViewVisibleProperty;
    }   
    

}
