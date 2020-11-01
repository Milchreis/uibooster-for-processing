package uibooster.model.formelements;

import com.bric.colorpicker.ColorPicker;
import uibooster.components.ColorPickerDialog;
import uibooster.components.Form;
import uibooster.model.FormElement;
import uibooster.model.FormElementChangeListener;

import javax.swing.*;
import java.awt.*;

public class ColorPickerElement extends FormElement {

    private final ColorPicker picker;

    public ColorPickerElement(String label, int formIndex) {
        super(label, Form.InputType.COLOR_PICKER, formIndex);
        picker = ColorPickerDialog.createColorPicker();
    }

    @Override
    public JComponent createComponent(FormElementChangeListener changeListener) {
        if (changeListener != null) {
            picker.addColorListener(e -> changeListener.onChange(ColorPickerElement.this, getValue()));
        }
        return picker;
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
