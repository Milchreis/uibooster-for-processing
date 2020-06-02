package uibooster.model.formelements;

import uibooster.components.Form;
import uibooster.model.FormElement;
import uibooster.model.FormElementChangeListener;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextAreaFormElement extends FormElement {

    private JTextArea area;

    public TextAreaFormElement(String label, int formIndex) {
        super(label, Form.InputType.TEXT_AREA, formIndex);
    }

    @Override
    public JComponent createComponent(FormElementChangeListener changeListener) {
        area = new JTextArea();
        area.setRows(3);

        if (changeListener != null) {
            area.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    super.keyReleased(e);
                    changeListener.onChange(TextAreaFormElement.this, getValue());
                }
            });
        }
        return new JScrollPane(area);
    }

    @Override
    public String getValue() {
        return area.getText();
    }
}
