/* Example for creating a password input dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;

UiBooster booster;
String password;

void setup() {
  size(800, 400); 
  background(10);

  booster = new UiBooster();
  password = booster.showPasswordDialog(
    "What's your password? (Displayed on the screen)",
    "Password");
}

void draw() {
    textAlign(CENTER, CENTER);
    textSize(32);
    if(password != null)
        text(password, width/2, height/2);
     else
        text("cancel clicked", width/2, height/2);
}