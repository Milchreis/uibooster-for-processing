/* Example for creating an exception dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;

UiBooster booster;

void setup() {
  size(800, 400);
  booster = new UiBooster();

  try {
    // This raises an exception
    image(null, 0, 0);
  }
  catch(Exception e) {
    booster.showException("The following went wrong", "Error", e);
  }
}
