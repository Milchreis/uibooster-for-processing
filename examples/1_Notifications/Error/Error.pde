/* Example for creating an error dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;

UiBooster booster;

void setup() {
  size(800, 400); 
  background(10);

  booster = new UiBooster();
  booster.showErrorDialog("Something went wrong", "ERROR");
}

void draw() {
}