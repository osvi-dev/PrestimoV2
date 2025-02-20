package models.dashboard.components.option;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class OptionModel {
    private final BooleanProperty isSelected = new SimpleBooleanProperty(false);
    
    public BooleanProperty isSelected() {
        return isSelected;
    }
}
