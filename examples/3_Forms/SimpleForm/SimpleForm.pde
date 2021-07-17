/* Example for creating a basic form with text inputs, selections and color picker.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;
import uibooster.model.*;

Form form;

void setup() {
  size(800, 400); 
  background(10);

  rectMode(CENTER);
  textAlign(CENTER, CENTER);

  form = new UiBooster()
    .createForm("Your settings")
    .addText("Whats your first name?")
    .addSlider("Snowflake size", 10, 50, 10, 5, 1)
    .addSelection("Which Shape?", "Circle", "Square", "Rectangle")
    .addColorPicker("Which color?")
    .run();
}

void draw() {

  // Get values from form
  String name = form.getByIndex(0).asString();
  float size = form.getByLabel("Snowflake size").asFloat();
  String shape = form.getByIndex(2).asString();
  Integer colour = form.getByLabel("Which color?").asColor().getRGB();

  // Draw shape
  noStroke();
  fill(colour, 30);
  
  if (shape == null || shape.equals("Circle")) 
    circle(random(width), random(height), random(size));

  else if (shape.equals("Square")) {
    float rectSize = random(size);
    rect(random(width), random(height), rectSize, rectSize);
    
  } else if (shape.equals("Rectangle"))
    rect(random(width), random(height), random(size), random(size));

  // Draw text
  if (name != null && !name.isEmpty()) {
    fill(222);

    rect(width/2, height/2, 200, 60);
    fill(200, 30, 123);
    textSize(32);

    text(name, width/2, height/2);
  }
}