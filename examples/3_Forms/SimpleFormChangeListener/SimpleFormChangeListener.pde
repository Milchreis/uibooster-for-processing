/* Example for creating a basic form using a ChangeListener.
 *
 * The ChangeListener allows you to get notified when a form element is changed.
 * In that way you can use global variables and doesn't have to check the form in
 * each draw loop.
 *  
 * Author: Nick 'Milchreis' Müller
 */
 
import uibooster.*;
import uibooster.model.*;

// Values from form
String name;
float size = 10;
String shape = "Circle";
Integer colour = 123;

void setup() {
  size(800, 400);
  background(10);

  rectMode(CENTER);
  textAlign(CENTER, CENTER);

  new UiBooster()
    .createForm("Your settings")
    .addText("Whats your first name?")
    .addSlider("Snowflake size", 10, 50, 10, 5, 1)
    .addSelection("Which Shape?", "Circle", "Square", "Rectangle")
    .addColorPicker("Which color?")
    .setChangeListener(new FormElementChangeListener() {

      public void onChange(FormElement element, Object value, Form form) {
        if(element.getIndex() == 0) {
          name = element.asString();
          println("Your name changed to " + name);
        }

        if(element.getLabel().equals("Snowflake size")) {
          size = element.asFloat();
          println("Snowflake size changed to " + size);
        }

        if(element.getLabel().equals("Which Shape?")) {
          shape = element.asString();
          println("Changed shape to " + shape);
        }

        if(element.getIndex() == 3) {
          colour = element.asColor().getRGB();
          println("Changed color to " + element.asColor().toString());
        }
      }
    })
    .run();
}


void draw() {

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