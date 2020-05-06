package uibooster.model.formelements;

import com.bric.colorpicker.ColorPicker;
import uibooster.components.ColorPickerDialog;
import uibooster.components.Form;
import uibooster.model.FormElement;

import javax.swing.*;
import java.awt.*;

public class ColorPickerElement extends FormElement {

    private ColorPicker picker;

    public ColorPickerElement(String label) {
        super(label, Form.InputType.COLOR_PICKER);
        picker = ColorPickerDialog.createColorPicker();
    }

    @Override
    public JComponent createComponent() {
        return picker;
    }

    @Override
    public Color getValue() {
        return picker.getColor();
    }
}
