package uibooster.model.formelements;

import uibooster.components.Form;
import uibooster.model.FormElement;

import javax.swing.*;

public class TextFormElement extends FormElement {

    private JTextField textfield;

    public TextFormElement(String label) {
        super(label, Form.InputType.TEXT);
    }

    @Override
    public JComponent createComponent() {
        textfield = new JTextField();
        return textfield;
    }

    @Override
    public String getValue() {
        return textfield.getText();
    }
}
