/* Example for creating a non blocking waiting dialog.
 *
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;
import uibooster.components.*;

UiBooster booster;
WaitingDialog waitingDialog;

void setup() {
  size(800, 400);

  booster = new UiBooster();
  waitingDialog = booster.showWaitingDialog("Starting", "Please wait");

  // do some stuff

  delay(1500); // delay is just for presentation

  // You can change the message
  waitingDialog.setMessage("Please, still wait a little more");

  delay(1500); // delay is just for presentation

  // Or add some bigger texts
  waitingDialog.setLargeMessage("Some more information...\nMaybe from log files or other resources. \nBe transparent to the user to understand long processes...");

  delay(1500);  // delay is just for presentation

  waitingDialog.close();
}

void draw() {
  background(10);
}
