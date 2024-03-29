package uibooster.components;

import uibooster.model.DialogClosingState;
import org.drjekyll.fontchooser.FontChooser;

import java.awt.*;

public class FontChooserDialog {

    public static Font showFontChooser(String message, String title, String iconPath) {
        return showFontChooser(message, title, null, iconPath);
    }

    public static Font showFontChooser(String message, String title, Font color, String iconPath) {

        FontChooser fontChooser = createFontChooser(color);

        SimpleBlockingDialog dialog = new SimpleBlockingDialog(fontChooser);
        DialogClosingState closingState = dialog.showDialog(message, title, iconPath);

        return closingState.isClosedByUser() ? null : fontChooser.getFont();
    }

    public static FontChooser createFontChooser(Font initialFont) {
        FontChooser fontChooser;
        if (initialFont == null) {
            fontChooser = new FontChooser();
        } else {
            fontChooser = new FontChooser(initialFont);
        }
        fontChooser.setVisible(true);
        return fontChooser;
    }

}
