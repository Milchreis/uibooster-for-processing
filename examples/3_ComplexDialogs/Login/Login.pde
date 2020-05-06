/* Example for creating a login dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;
import uibooster.model.*;

UiBooster booster;
WaitingDialog waitingDialog;

void setup() {
  size(800, 400);

  booster = new UiBooster();
  waitingDialog = booster.showWaitingDialog("Starting", "Please wait");

  // do some stuff
  // delay is just for presentation
  delay(1500);

  dialog.setMessage("Ready");
  dialog.close();
}

void draw() {
  background(10);

  textAlign(CENTER, CENTER);
  textSize(32);

  if (credentials == null) {
    text("Login canceled", width/2, height/2);

  } else {
    text("User: " + credentials.getUsername(), width/2, height/2);
    text("Password length: " + credentials.getPassword().length(), width/2, height/2 + 32);
  }
}
