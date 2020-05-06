package uibooster.model.formelements;

import uibooster.components.Form;
import uibooster.model.FormElement;

import javax.swing.*;

public class TextAreaFormElement extends FormElement {

    private JTextArea area;

    public TextAreaFormElement(String label) {
        super(label, Form.InputType.TEXT_AREA);
    }

    @Override
    public JComponent createComponent() {
        area = new JTextArea();
        area.setRows(3);
        return new JScrollPane(area);
    }

    @Override
    public String getValue() {
        return area.getText();
    }
}
