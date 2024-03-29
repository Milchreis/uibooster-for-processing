package uibooster.model.formelements;

import uibooster.components.FontChooserDialog;
import uibooster.model.FormElement;
import uibooster.model.FormElementChangeListener;
import org.drjekyll.fontchooser.FontChooser;

import javax.swing.*;
import java.awt.*;

public class FontChooserElement extends FormElement {

    private final FontChooser fontChooser;

    public FontChooserElement(String label) {
        this(label, null);
    }

    public FontChooserElement(String label, Font initialFont) {
        super(label);
        fontChooser = FontChooserDialog.createFontChooser(initialFont);
    }

    @Override
    public JComponent createComponent(FormElementChangeListener changeListener) {
        if (changeListener != null) {
            fontChooser.addChangeListener(e -> changeListener.onChange(FontChooserElement.this, getValue(), form));
        }
        return fontChooser;
    }

    @Override
    public void setEnabled(boolean enable) {
        fontChooser.setEnabled(enable);
    }

    @Override
    public Font getValue() {
        return fontChooser.getSelectedFont();
    }

    @Override
    public void setValue(Object value) {
        if (!(value instanceof Font)) {
            throw new IllegalArgumentException("The given value has to be of type 'Font'");
        }
        fontChooser.setFont((Font) value);
    }
}
