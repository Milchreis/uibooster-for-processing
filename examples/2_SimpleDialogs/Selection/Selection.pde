/* Example for creating a selection dialog.
 * This kind of dialog is blocking and waits for confirmation.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;

UiBooster booster;
String movie;

void setup() {
  size(800, 400); 
  background(10);

  booster = new UiBooster();
  movie = booster.showSelectionDialog(
                  "What's your favorite movie?",        // Question
                  "Favorite Movie?",                    // window title
                  "Pulp Fiction", "Bambi", "The Godfather", "Hangover", "Another one"); // choices
}

void draw() {
    textAlign(CENTER, CENTER);
    textSize(32);

    if(!movie.equals("Another one")) {
        text("Your favorite movie is " + movie, width/2, height/2);
    } else {
        text("Your favorite movie is not in list", width/2, height/2);
    }
}