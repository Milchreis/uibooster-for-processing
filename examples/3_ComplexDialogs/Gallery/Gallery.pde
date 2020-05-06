/* Example for creating a gallery dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;

UiBooster booster;

void setup() {
  size(800, 400);

  booster = new UiBooster();

  booster.showPictures(
       "My pictures",
       new String[] {
            dataPath("example.jpg"),
            dataPath("example1.jpg"),
            dataPath("example2.jpg")
       }
   );
}

void draw() {
  background(10);
}
