/* Example for creating a non-blocking splash screen.
 *
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;
import uibooster.components.*;

void setup() {
  size(10, 10);

  UiBooster booster = new UiBooster();

  String splashImage = dataPath("splash.png");
  Splashscreen splash = booster.showSplashscreen(splashImage);

   // do your stuff

   delay(1500); // delay for presentation

   splash.hide();
}

void draw() {
  background(10);
}