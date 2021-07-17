package uibooster.model.options;

import com.bulenkov.darcula.DarculaLaf;
import uibooster.model.UiBoosterOptions;

import javax.swing.*;

public class DarkUiBoosterOptions extends UiBoosterOptions {
    public static final String defaultLoadingImage = "/data/loading-75_darcula.gif";

    public DarkUiBoosterOptions() {
        this(defaultIconPath);
    }

    public DarkUiBoosterOptions(String iconPath) {
        super(new DarculaLaf(), iconPath, defaultLoadingImage);

        // Little hack to start working on linux
        UIManager.getFont("Label.font");
    }
}
