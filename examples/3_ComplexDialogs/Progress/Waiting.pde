/* Example for creating a non blocking progress dialog.
 *
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;
import uibooster.components.*;

UiBooster booster;
ProgressDialog progressDialog;

void setup() {
  size(800, 400);

  booster = new UiBooster();
  progressDialog = new UiBooster().showProgressDialog("Please wait", "Waiting", 0, 120);

  // do you stuff

  // Update progress
  progressDialog.setProgress(10);


  for(int i = 10; i <120; i++) {
    progressDialog.setProgress(i);
    delay(50); // delay is just for presentation
  }

  progressDialog.setMessage("Ready");
  progressDialog.close();

}

void draw() {
  background(10);
}
