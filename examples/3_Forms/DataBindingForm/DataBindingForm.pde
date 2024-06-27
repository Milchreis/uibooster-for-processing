/* Example for creating a basic form using a ChangeListener.
 *
 * The DataBinding allows you to create variables which are automatically updated when the user changes the input. In
 * that way it is much easier the current value of form element.
 *
 * Each form element provides a .bind()-method which needs Data-object with a specific type.
 *
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;
import uibooster.model.*;
import java.awt.Color;

// Values from form
Data<String> name = new Data<>("peter");
Data<Color> fontColor = new Data<>(Color.GREEN);

void setup() {
  size(800, 400);
  background(10);

  rectMode(CENTER);
  textAlign(CENTER, CENTER);

  new UiBooster()
    .createForm("Your settings")
    .addText("Whats your first name?")
      .bind(name)
    .addColorPicker("Which background color?")
      .bind(fontColor)
    .run();
}


void draw() {
  textSize(64);

  // Change the font color by the current value of the bound variable
  fill(fontColor.getValue().getRGB(), 30);

  // Draw the current name of the bound variable
  text(name.getValue(), width/2, height/2);
}