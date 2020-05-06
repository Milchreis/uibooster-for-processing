/* Example for creating a confirmation dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;

UiBooster booster;
boolean isConfirmed;

void setup() {
  size(800, 400); 
  background(10);

  booster = new UiBooster();
  booster.showConfirmDialog(
        "Do you really want this action?",
        "Are you sure?",
        new Runnable() {
            public void run() {
                isConfirmed = true;
            }
        },
        new Runnable() {
            public void run() {
                isConfirmed = false;
            }
        }
    );
}

void draw() {
    textAlign(CENTER, CENTER);
    textSize(32);

    if(isConfirmed) {
        text("You want this action :-)", width/2, height/2);
   } else {
        text("You don't want this action :-(", width/2, height/2);
   }
}