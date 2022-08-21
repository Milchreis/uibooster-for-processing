package uibooster.model.formelements;

import com.bric.colorpicker.ColorPicker;
import uibooster.components.ColorPickerDialog;
import uibooster.model.FormElement;
import uibooster.model.FormElementChangeListener;

import javax.swing.*;
import java.awt.*;

public class ColorPickerElement extends FormElement {

    private final ColorPicker picker;

    public ColorPickerElement(String label) {
        this(label, null);
    }

    public ColorPickerElement(String label, Color initialColor) {
        super(label);
        picker = ColorPickerDialog.createColorPicker(initialColor);
    }

    @Override
    public JComponent createComponent(FormElementChangeListener changeListener) {
        if (changeListener != null) {
            picker.addColorListener(e -> changeListener.onChange(ColorPickerElement.this, getValue(), form));
        }
        return picker;
    }

    @Override
    public void setEnabled(boolean enable) {
        picker.setEnabled(enable);
    }

    @Override
    public Color getValue() {
        return picker.getColor();
    }

    @Override
    public void setValue(Object value) {
        if (!(value instanceof Color) && !(value instanceof Integer))
            throw new IllegalArgumentException("The given value has to be of type 'Color' or 'int'");

        if (value instanceof Integer)
            picker.setColor(new Color((int) value));
        else
            picker.setColor((Color) value);
    }
}
