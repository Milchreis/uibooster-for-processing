/* Example for creating a system tray menu.
 *
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;

String shape;

void setup() {
  size(800, 600);
  background(10);

  UiBooster booster = new UiBooster();
  booster.createTrayMenu("Shapes", dataPath("splash.png"))
    .withPopupMenu()
    .addMenu("add random circles", new Runnable() {
      public void run() {
        shape = "circle";
      }
    })
    .addMenu("add random squares", new Runnable() {
      public void run() {
        shape = "square";
      }
    });
}

void draw() {

  textAlign(CENTER, CENTER);
  textSize(32);

  if (shape == null)
    text("Select a shape from the system tray menu", width/2, height/2);

   else if (shape.equals("square"))
    randomSquare();

  else if (shape.equals("circle"))
    randomCircle();
}


void randomCircle() {
  noStroke();
  fill(random(255), random(255), random(255), 200);
  circle(random(width), random(height), random(100));
}

void randomSquare() {
  noStroke();
  fill(random(255), random(255), random(255), 200);

  float squareSize = random(100);
  rect(random(width), random(height), squareSize, squareSize);
}
