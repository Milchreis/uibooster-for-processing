/* Example for creating a color selection dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;

UiBooster booster;
color favoriteColor;

void setup() {
  size(800, 400); 
  background(10);

  booster = new UiBooster();
  favoriteColor = booster.showColorPickerAndGetRGB("Choose your favorite color", "Color picking");
}

void draw() {
    background(favoriteColor);
}