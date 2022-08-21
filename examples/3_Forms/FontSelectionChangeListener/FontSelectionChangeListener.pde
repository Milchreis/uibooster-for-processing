/* Example for creating a basic form with color picker and font selection.
 *
 * Author: Nick 'Milchreis' Müller
 */

import uibooster.*;
import uibooster.model.*;

import java.awt.Font;

Form form;
PFont font;
Integer colour = #C81E7B;
String text;
int textSize = 32;

void setup() {
  size(800, 400);
  background(10);

  rectMode(CENTER);
  textAlign(CENTER, CENTER);

  form = new UiBooster()
    .createForm("Your settings")
    .addText("Some text ...")
    .addColorPicker("Which color?")
    .addFontChooser("Which font?")
    .setChangeListener(new FormElementChangeListener() {
      public void onChange(FormElement element, Object value, Form form) {

        // Get text on change
        if(element.getIndex() == 0) {
          text = element.asString();
        }

        // Get font on change and create a PFont
        if(element.getLabel().equals("Which font?")) {
          Font selectedFont = (Font) element.getValue();
          textSize = selectedFont.getSize();
          font = createFont(selectedFont.getName(), 128);
        }

        // Get color on change
        if(element.getLabel().equals("Which color?")) {
          colour = form.getByLabel("Which color?").asColor().getRGB();
        }
      }
    })
    .run();
}

void draw() {
  background(30);

  // Draw text
  if (text != null && !text.isEmpty()) {
    fill(colour);

    if(font != null)
      textFont(font);

    textSize(textSize);

    text(text, width/2, height/2);
  }
}