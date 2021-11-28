package uibooster.model.options;

import com.formdev.flatlaf.FlatDarculaLaf;
import uibooster.model.UiBoosterOptions;

import javax.swing.*;

public class DarkUiBoosterOptions extends UiBoosterOptions {
    public static final String defaultLoadingImage = "/data/loading-75_darcula.gif";

    public DarkUiBoosterOptions() {
        this(defaultIconPath);
    }

    public DarkUiBoosterOptions(String iconPath) {
        super(new FlatDarculaLaf(), iconPath, defaultLoadingImage);

        // Little hack to start working on linux
        UIManager.getFont("Label.font");
    }
}
