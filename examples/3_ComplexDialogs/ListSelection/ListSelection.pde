/* Example for creating a list selection dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;
import uibooster.model.*;

UiBooster booster;
ListElement selectedElement;

void setup() {
  size(800, 400);
  booster = new UiBooster();
}

void mousePressed() {
  selectedElement = booster.showList(
    "Select a robot",
    "Avatars from RoboHash.org",
    new ListElement("Robo 1", "Green and strong", dataPath("avatar1.png")),
    new ListElement("Robo 2", "Shy without an avatar!"),
    new ListElement("Robo 3", "- Crazy\n- Fast\n- Funny", dataPath("avatar2.png")),
    new ListElement("Robo 4", null, dataPath("avatar3.png"))
    );
}

void draw() {
  background(10);
  textAlign(CENTER, CENTER);

  if (selectedElement == null) {
    textSize(64);
    text("Please, click here", width/2, height/2);

  } else {

    if (selectedElement.getTitle() != null) {
      textSize(64);
      text(selectedElement.getTitle(), width/2, height/2 - 70);
    }
    if (selectedElement.getMessage() != null) {
      textSize(32);
      text(selectedElement.getMessage(), width/2, height/2 + 70);
    }
  }
}
