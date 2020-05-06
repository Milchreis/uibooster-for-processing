/* Example for creating a text input dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;

UiBooster booster;
String username;

void setup() {
  size(800, 400); 
  background(10);

  booster = new UiBooster();
  username = booster.showTextInputDialog("What's your name?");
}

void draw() {
    textAlign(CENTER, CENTER);
    textSize(32);
    text(username, width/2, height/2);
}