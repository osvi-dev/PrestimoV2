package models.dashboard.components.topBar;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TopBarModel {
    private final BooleanProperty searchBarVisibleProperty = new SimpleBooleanProperty(true);
    private final BooleanProperty buyProperty = new SimpleBooleanProperty(false);
    private final BooleanProperty loanProperty = new SimpleBooleanProperty(false);
    private final BooleanProperty saleProperty = new SimpleBooleanProperty(false);
    private final StringProperty titleProperty = new SimpleStringProperty("Dashboard");

    public BooleanProperty searchBarVisibleProperty() {
        return searchBarVisibleProperty;
    }
    public BooleanProperty buyProperty() {
        return buyProperty;
    }
    public BooleanProperty loanProperty() {
        return loanProperty;
    }
    public BooleanProperty saleProperty() {
        return saleProperty;
    }

    public StringProperty titleProperty() {
        return titleProperty;
    }
}
