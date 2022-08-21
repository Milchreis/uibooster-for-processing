<p align="center">
  <img src="https://github.com/Milchreis/uibooster-for-processing/blob/master/img/logo.png?raw=true" />
</p>

> UiBooster is a lean library to create fast and easy dialogs for utility tools.

This project ports [UiBooster 1.15.2](https://github.com/Milchreis/UiBooster/) full functionally to the Processing eco-system 
as a library to create dialogs for your sketch fast as possible.
With a lot of examples you will learn to use this library in less than five minutes.

If you like this project, and you want to keep me awake 🤪, than please support me on ko-fi 

<a href='https://ko-fi.com/L4L21072C' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi1.png?v=2' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>

## Breaking changes since version 1.12.0

In version 1.12.0 of UiBooster the `ChangeListener` and the `FilledForm` are changed. Please check your code after updating if you
used UiBooster in earlier versions before.

**Breaking changes**
* Now ChangeListener in form creation has 3 parameter: current form element, new value, your form
    * you will have to add `Form form` as third parameter to your listener
    * Here you can find an [example](https://github.com/Milchreis/UiBooster/blob/master/src/test/java/de/milchreis/uibooster/FormBuilderChangeListenerTest.java#L22)
* `FilledForm` is renamed to `Form`
    * you will have to change all FilledForms to Form (also in imports)
    * Here you can find an [example](https://github.com/Milchreis/UiBooster/blob/master/src/test/java/de/milchreis/uibooster/CustomFormBuilderElementTest.java#L57)


## Supporter ❤️
A big thanks goes to the supporters of this project. I thank every single one of them for contributing to UiBooster.

 * federico-pepe ([GitHub](https://github.com/federico-pepe))
 * Devraj Joshi ([Twitter](https://twitter.com/DevrajJoshi))
 * Ralf Leggett ([Github](https://github.com/ralfleggett))
 * PlayStateWolff ([Github](https://github.com/PlayStateWolff)) 
 * leuwenn ([Github](https://github.com/leuwenn))

## Installation
If you want to use this library in your processing sketch you can download it via the integrated `Contribution Manager`. 

![alt install](https://github.com/milchreis/uibooster-for-processing/blob/master/img/install.jpg?raw=true)

# Documentation
The following examples show the usage of this library. If you interested in the javadoc documentation [look here.](https://milchreis.github.io/uibooster-for-processing/reference/uibooster/UiBooster.html)

## Components

- [Information dialogs](#information-dialogs)
- [Text input dialog](#text-input-dialog)
- [Confirmation dialog](#confirmation-dialog)
- [Password input dialog](#password-input-dialog)
- [Selection dialog](#selection-dialog)
- [Multiple selection dialog](#multiple-selection-dialog)
- [Slider dialog](#slider-dialog)
- [Colorpicker](#colorpicker)
- [FontChooser](#font-chooser)
- [Datepicker](#datepicker)
- [File and directory selection dialogs](#file-and-directory-selection-dialogs)
- [Exception dialog](#exception-dialog)
- [List dialog](#list-dialog)
- [Login dialog](#login-dialog)
- [Waiting dialog](#waiting-dialog)
- [Progress dialog](#progress-dialog)
- [Table dialog](#table-dialog)
- [Gallery dialog](#gallery-dialog)
- [Form dialog](#form-dialog)
- [Splash screen](#splash-screen)
- [System tray menu](#system-tray)
- [Notification](#notification)

### Information dialogs
![screenshot info dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/info.jpg?raw=true)
![screenshot warn dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/warn.jpg?raw=true)
![screenshot error dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/error.jpg?raw=true)
```java
new UiBooster().showInfoDialog("UiBooster is a lean library to ....");
```
```java
new UiBooster().showWarningDialog("Your computer has a low battery ....", "WARN");
```
```java
new UiBooster().showErrorDialog("The connection to SQL database is failed.", "ERROR");
```

### Text input dialog
![screenshot input dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/input.jpg?raw=true)
```java
String opinion = new UiBooster().showTextInputDialog("What do you think?");
```

### Confirmation dialog
![screenshot confirm dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/confirm.jpg?raw=true)
```java
new UiBooster().showConfirmDialog(
                "Do you really want this action?",
                "Are you sure?",
                () -> System.out.println("Action accepted"),
                () -> System.out.println("Action declined"));
```

### Password input dialog
![screenshot password dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/password.jpg?raw=true)
```java
String password = booster.showPasswordDialog("Whats your password?", "Password");
```

### Selection dialog
![screenshot selection dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/selection.jpg?raw=true)
```java
String selection = new UiBooster().showSelectionDialog(
        "What's your favorite movie?",
        "Favorite Movie?",
        Arrays.asList("Pulp Fiction", "Bambi", "The Godfather", "Hangover"));
```

### Multiple selection dialog
![screenshot multiple selection dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/multiselection.jpg?raw=true)
```java
 List<String> selectedElement = new UiBooster().showMultipleSelection(
            "What are your favorite hobbies?",
            "Your hobbies",
            "Reading", "Traveling", "Fishing", "Music", "Gardening", "Sport", "Television",
            "Video Games", "Crafting", "Bird Watching", "Collecting");
```

### Slider dialog
![screenshot slider dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/slider.jpg?raw=true)
```java
Integer numberOfHotDogs = new UiBooster().showSlider("How many HotDogs do you want?", "Your order", 
                0, 10, 2, 5, 1);
```

### Colorpicker
![screenshot color dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/color.jpg?raw=true)
```java
Color selectedColor = new UiBooster().showColorPicker("Choose your favorite color", "Color picking");
```    
_library by @dheid: [colorpicker](https://github.com/dheid/colorpicker)_

### Font Chooser
![screenshot font dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/font.png?raw=true)
```java
Font selectedFont = new UiBooster().showFontChooser("Choose your favorite font", "Font choosing");
```    
_library by @dheid: [fontchooser](https://github.com/dheid/fontchooser)_

### Datepicker
![screenshot datepicker](https://github.com/Milchreis/UiBooster/blob/master/screenshots/dateselection.jpg?raw=true)
```java
Date birthday = new UiBooster().showDatePicker("What's your birthday?", "Birthday");
```

### File and directory selection dialogs
![screenshot file dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/fileselection.jpg?raw=true)
```java
UiBooster booster = new UiBooster();
File file = booster.showFileSelection();
File directory = booster.showDirectorySelection();
File fileOrDirectory = booster.showFileOrDirectorySelection();
```

### Exception dialog
![screenshot exception dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/exception.jpg?raw=true)
```java
new UiBooster().showException(
    "An error occurred", 
    "Exception message",
    new Exception("Something went wrong ...")
);
```

### List dialog
![screenshot list dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/list.jpg?raw=true)
```java
ListElement selectedElement = new UiBooster().showList(
    "Select a robot", 
    "Avatars from RoboHash.org",
    element -> System.out.println("Selected: " + element.toString()),
    new ListElement("Robo 1", "Green and strong",         "src/test/resources/avatar1.png"),
    new ListElement("Robo 2", "Shy without an avatar!"),
    new ListElement("Robo 3", "- Crazy\n- Fast\n- Funny", "src/test/resources/avatar2.png"),
    new ListElement("Robo 4", null,                       "src/test/resources/avatar3.png")
);
```

### Login dialog
![screenshot login dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/login.jpg?raw=true)
```java
LoginCredentials credentials = new UiBooster().showLogin(
        "Login",
        "Internal area",
        "Username",
        "Password",
        "Go",
        "Cancel");
```

### Waiting dialog
![screenshot waiting dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/waiting.jpg?raw=true)
```java
WaitingDialog dialog = new UiBooster().showWaitingDialog("Starting", "Please wait");
dialog.setMessage("Ready");
dialog.close();
```
![screenshot waiting with message dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/waiting_with_message.jpg?raw=true)
```java
WaitingDialog dialog = new UiBooster().showWaitingDialog("Starting", "Please wait");
dialog.setMessage("Initializing");
dialog.setLargeMessage("Some more information...\nMaybe from log files or other resources. \nBe transparent to the user to understand long processes...");
dialog.close();
```

### Progress dialog
![screenshot progress dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/progress.jpg?raw=true)
```java
ProgressDialog dialog = new UiBooster().showProgressDialog("Please wait", "Waiting", 0, 120);
dialog.setProgress(10);
// ...
dialog.setProgress(120);
dialog.setMessage("Ready");
dialog.close();
```

### Table dialog
![screenshot table dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/table.jpg?raw=true)
```java
String[][] modifiedData = new UiBooster().showTable(    // showTableImmutable for immutable tables
        new String[][]{
                {"Jimmy Johnson", "35", "Zombieland"},
                {"Danny Durango", "23", "Hangover"},
                {"Larry Berry", "54", ""}
        },
        Arrays.asList("Name", "Age", "Favorite movie"),
        "Favorite movies");
```

### Gallery dialog
![screenshot gallery dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/gallery.jpg?raw=true)
```java
new UiBooster().showPictures(
        "My picture",
        Arrays.asList(
            new File("/home/nick/pictures/img-01.jpg"),
            new File("/home/nick/pictures/img-02.jpg")
        )
);
```

### Form dialog
![screenshot gallery dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/form.jpg?raw=true)
```java
UiBooster booster = new UiBooster();
Form form = booster.createForm("Personal information")
            .addText("Whats your first name?")
            .addTextArea("Tell me something about you")
            .addSelection(
                    "Whats your favorite movie?",
                    Arrays.asList("Pulp Fiction", "Bambi", "The Godfather", "Hangover"))
            .addLabel("Choose an action")
            .addButton("half full", () -> booster.showInfoDialog("Optimist"))
            .addButton("half empty", () -> booster.showInfoDialog("Pessimist"))
            .addSlider("How many liters did you drink today?", 0, 5, 1, 5, 1)
            .show();

// use .run() instead of show() to open the formBuilder without blocking.
```
The form is very powerful and provides a lot of features:

* add your own
  elements ([Example](https://github.com/Milchreis/UiBooster/blob/master/src/test/java/de/milchreis/uibooster/CustomFormBuilderElementTest.java))
* put multiple elements in one
  row ([Example](https://github.com/Milchreis/UiBooster/blob/master/src/test/java/de/milchreis/uibooster/FormBuilderWithRowsTest.java#L41))
* add a listener for any
  changes ([Example](https://github.com/Milchreis/UiBooster/blob/master/src/test/java/de/milchreis/uibooster/FormBuilderChangeListenerTest.java#L22))
* add a listener on window
  close ([Example](https://github.com/Milchreis/UiBooster/blob/master/src/test/java/de/milchreis/uibooster/FormBuilderTest.java#L115))
* set window setting, f.e. size and
  position ([Example](https://github.com/Milchreis/UiBooster/blob/master/src/test/java/de/milchreis/uibooster/FormBuilderTest.java#L141))

### Splash screen
![screenshot splash screen](https://github.com/Milchreis/UiBooster/blob/master/screenshots/splash.jpg?raw=true)
```java
Splashscreen splash = new UiBooster().showSplashscreen("/path/to/your/splash.png");
// do your stuff
splash.hide();
```

### System tray
![screenshot gallery dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/tray.jpg?raw=true)
```java
UiBooster booster = new UiBooster();
booster.createTrayMenu("Food", "screenshots/color.jpg")
        .withPopupMenu()
        .addMenu("Hotdogs", () -> booster.showInfoDialog("Sausage in a roll"))
        .addMenu("Fries", () -> booster.showInfoDialog("Fried potatoes"))
        .addMenu("Pizza", () -> booster.showInfoDialog("Dough with tomato sauce"));
```

### Notification
![screenshot gallery dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/notification.jpg?raw=true)
```java
new UiBooster().createNotification("It's hot and delicious", "Dinner is ready");
```

## Options
```java
UiBooster booster = new UiBooster(
    UiBoosterOptions.Theme.DARK_THEME,
    "/path/to/your/custom-window-icon.png"
);
```
See some examples for UiBoosterOptions [here](https://github.com/Milchreis/UiBooster/blob/master/src/test/java/de/milchreis/uibooster/UiBoosterOptionsTest.java)

## Contribution
Please report issues for bugs or feature requests with ideas for other useful dialogs. If you interested in the development
process, take a look to the origin project [UiBooster](https://github.com/milchreis/UiBooster/).

## Updating UiBooster for Processing
The port of UiBooster works as copy from the original project with some package adjustments. An update script pulls
the current UiBooster code and replace it with the code from this library. New features from UiBooster are 
added as examples, and the README.md has been updated.

This script updates the code. Attention: It removes the existing code!
```
cd ./update/
bash update-uibooster.sh
```
