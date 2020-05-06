/* Example for creating a system notification.
 *
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;

UiBooster booster;
int numberOfShapes = 0;

void setup() {
  size(800, 600);
  background(10);

  booster = new UiBooster();
}

void draw() {

  if(numberOfShapes % 100 == 0)
    booster.createNotification(
      "Now on screen are more than " + numberOfShapes + " circles.",
      "Number of circles");

  noStroke();
  fill(random(255), random(255), random(255), 200);
  circle(random(width), random(height), random(100));

  numberOfShapes++;
}