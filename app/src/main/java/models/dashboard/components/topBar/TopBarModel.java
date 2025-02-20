package models.dashboard.components.topBar;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class TopBarModel {
    private final BooleanProperty searchBarVisibleProperty = new SimpleBooleanProperty(true);

    public BooleanProperty searchBarVisibleProperty() {
        return searchBarVisibleProperty;
    }
}
