/* Example for creating a slider selection dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;

UiBooster booster;
Integer numberOfHotDogs;

void setup() {
  size(800, 400); 
  background(10);

  booster = new UiBooster();
  numberOfHotDogs = booster.showSlider(
    "How many HotDogs do you want?",    // question
    "Your order",                       // title
    0,                                  // range: start value
    10,                                 // range: end value
    2,                                  // initial value
    5,                                  // steps for ticks with value
    1);                                 // steps for ticks
}

void draw() {
    textAlign(CENTER, CENTER);
    textSize(32);
    text("You want " + numberOfHotDogs + " HotDogs", width/2, height/2);
}