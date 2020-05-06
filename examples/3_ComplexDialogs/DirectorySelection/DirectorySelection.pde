/* Example for creating a directory selection dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;

UiBooster booster;
File directory;

void setup() {
  size(800, 400);

  booster = new UiBooster();
  directory = booster.showDirectorySelection();
}

void draw() {
    background(10);

    textAlign(CENTER, CENTER);
    textSize(32);
    text("Selected directory: " + directory.getName(), width/2, height/2);

    textSize(16);
    text(directory.getAbsolutePath(), width/2, height/2 + 32);
}