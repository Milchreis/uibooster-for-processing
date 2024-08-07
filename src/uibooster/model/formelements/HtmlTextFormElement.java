package uibooster.model.formelements;

import uibooster.model.FormElement;
import uibooster.model.FormElementChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HtmlTextFormElement extends FormElement<String> {

    private final JEditorPane area;

    public HtmlTextFormElement(String label, String htmlContent, int width, int height) {
        super(label);
        area = new JEditorPane("text/html", htmlContent);
        area.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public JComponent createComponent(FormElementChangeListener changeListener) {

        area.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if (hasBinding())
                    binding.set(getValue());

                if (changeListener != null)
                    changeListener.onChange(HtmlTextFormElement.this, getValue(), form);
            }
        });
        return new JScrollPane(area);
    }

    @Override
    public void setEnabled(boolean enable) {
        area.setEnabled(enable);
    }

    @Override
    public String getValue() {
        return area.getText();
    }

    @Override
    public void setValue(String value) {
        area.setText(value.toString());
    }
}
