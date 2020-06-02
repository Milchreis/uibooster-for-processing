/* Example for creating a login dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;
import uibooster.model.*;
import uibooster.components.*;

UiBooster booster;
WaitingDialog waitingDialog;
LoginCredentials credentials;

void setup() {
  size(800, 400);

  booster = new UiBooster();
  waitingDialog = booster.showWaitingDialog("Starting", "Please wait");

  // do some stuff
  // delay is just for presentation
  delay(1500);

  waitingDialog.setMessage("Ready");
  waitingDialog.close();
  
  credentials = new UiBooster().showLogin(
        "Login",
        "Internal area",
        "Username",
        "Password",
        "Go",
        "Cancel");
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
