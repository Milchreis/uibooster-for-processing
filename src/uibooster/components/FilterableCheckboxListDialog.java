package uibooster.components;

import uibooster.model.DialogClosingState;
import uibooster.model.formelements.FilterableCheckboxListFormElement;

import java.util.List;

public class FilterableCheckboxListDialog {


    public static List<String> show(String message, String title, List<String> items, boolean hideFilter, String iconPath) {

        FilterableCheckboxListFormElement element = new FilterableCheckboxListFormElement(message, hideFilter, items);

        SimpleBlockingDialog dialog = new SimpleBlockingDialog(element.createComponent(null));
        DialogClosingState closingState = dialog.showDialog(message, title, iconPath);

        return closingState.isClosedByUser() ? null : (List<String>) element.getValue();
    }
}
