package uibooster.model.options;

import uibooster.model.UiBoosterOptions;

import javax.swing.plaf.metal.MetalLookAndFeel;

public class SwingUiBoosterOptions extends UiBoosterOptions {

    public SwingUiBoosterOptions() {
        this(defaultIconPath);
    }

    public SwingUiBoosterOptions(String iconPath) {
        super(new MetalLookAndFeel(), iconPath == null ? defaultIconPath : iconPath, defaultLoadingImage);
    }
}
