/* Example for creating a file selection dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;

UiBooster booster;
File file;

void setup() {
  size(800, 400);

  booster = new UiBooster();
  file = booster.showFileSelection();
}

void draw() {
    background(10);

    float fileSize = file.length() / 1024 / 1024;

    textAlign(CENTER, CENTER);
    textSize(32);
    text("Selected file: " + file.getName(), width/2, height/2);

    textSize(16);
    text("Directory: " + file.getParent(), width/2, height/2 + 32);

    textSize(16);
    text("File size in MB: " + fileSize, width/2, height/2 + 48);
}