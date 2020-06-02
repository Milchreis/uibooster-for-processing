package uibooster.model.formelements;

import uibooster.components.Form;
import uibooster.model.FormElement;
import uibooster.model.FormElementChangeListener;

import javax.swing.*;

public class LabelFormElement extends FormElement {

    private final String label;

    public LabelFormElement(String label, int formIndex) {
        super(null, Form.InputType.LABEL, formIndex);
        this.label = label;
    }

    @Override
    public JComponent createComponent(FormElementChangeListener onChange) {
        return new JLabel(label);
    }

    @Override
    public String getValue() {
        return label;
    }
}
