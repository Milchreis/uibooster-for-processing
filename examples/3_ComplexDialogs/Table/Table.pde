/* Example for creating a table dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;

UiBooster booster;

void setup() {
  size(800, 400);

  booster = new UiBooster();

  // user showTableImmutable() for immutable tables
  String[][] modifiedData = booster.showTable(
      new String[][]{                                       // data in 2d array
              {"Jimmy Johnson", "35", "Zombieland"},
              {"Danny Durango", "23", "Hangover"},
              {"Larry Berry", "54", ""}
      },
      new String[] {"Name", "Age", "Favorite movie" },      // header
      "Favorite movies");                                   // window title
}

void draw() {
  background(10);
}
