package uibooster.model.formelements;

import uibooster.model.FormElement;
import uibooster.model.FormElementChangeListener;

import javax.swing.*;

public class LabelFormElement extends FormElement<String> {

    private final JLabel label;

    public LabelFormElement(String label) {
        super(null);
        this.label = new JLabel(label);
    }

    @Override
    public JComponent createComponent(FormElementChangeListener onChange) {
        return label;
    }

    @Override
    public void setEnabled(boolean enable) {
        label.setEnabled(enable);
    }

    @Override
    public String getValue() {
        return label.getText();
    }

    @Override
    public void setValue(String value) {
        label.setText(value);
    }

}
