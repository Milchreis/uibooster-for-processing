/* Example for creating a date selection dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;
import java.util.Date;

UiBooster booster;
Date birthday;

void setup() {
  size(800, 400); 

  booster = new UiBooster();
  birthday = booster.showDatePicker("What's your next birthday?", "Next birthday");
}

void draw() {
    long secondsUntilBirthday = (birthday.getTime() - new Date().getTime()) / 1000;

    background(10);
    textAlign(CENTER, CENTER);
    textSize(32);
    text("Your next birthday is in " + secondsUntilBirthday + " seconds.", width/2, height/2);

    textSize(16);
    text(birthday.toString(), width/2, height/2 + 32);
}