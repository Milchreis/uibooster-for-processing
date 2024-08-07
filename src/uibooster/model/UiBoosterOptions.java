package uibooster.model;

import javax.swing.plaf.basic.BasicLookAndFeel;

/**
 *  Base class for user defined look and feel of the application.
 */
public class UiBoosterOptions {

    public enum Theme {
        DARK_THEME, LIGHT_THEME, SWING, OS_NATIVE, DEFAULT;
    }

    public static final String defaultIconPath = "/data/uibooster-default-icon.png";
    public static final String defaultLoadingImage = "/data/loading-75.gif";

    protected final BasicLookAndFeel lookAndFeel;
    protected final String iconPath;
    protected final String loadingImage;

    public UiBoosterOptions(BasicLookAndFeel lookAndFeel, String iconPath, String loadingImage) {
        this.lookAndFeel = lookAndFeel;
        this.iconPath = iconPath == null ? defaultIconPath : iconPath;
        this.loadingImage = loadingImage;
    }

    public BasicLookAndFeel getLookAndFeel() {
        return lookAndFeel;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getLoadingImage() {
        return loadingImage;
    }
}
