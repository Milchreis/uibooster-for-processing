<p align="center">
  <img src="https://github.com/Milchreis/uibooster-for-processing/blob/master/img/logo.png?raw=true" />
</p>

> UiBooster is a lean library to create fast and easy dialogs for utility tools.

This project ports [UiBooster 1.7](https://github.com/Milchreis/UiBooster/) full functionally to the Processing eco-system 
as a library to create dialogs for your sketch fast as possible.
With a lot of examples you will learn to use this library in less than five minutes.

If you like this project, and you want to keep me awake 🤪, than please support me on ko-fi 

<a href='https://ko-fi.com/L4L21072C' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi1.png?v=2' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>

## Installation
If you want to use this library in your processing sketch you can download it via the integrated `Contribution Manager`. 
![alt install](https://github.com/milchreis/uibooster-for-processing/blob/master/img/install.jpg?raw=true)

# Documentation
The following examples show the usage of this libary. If you interessted in the javadoc documentation [look here.](https://milchreis.github.io/uibooster-for-processing/reference/uibooster/UiBooster.html)

## Components

 - [Information dialogs](#information-dialogs)
 - [Text input dialog](#text-input-dialog)
 - [Confirmation dialog](#confirmation-dialog)
 - [Selection dialog](#selection-dialog)
 - [Slider dialog](#slider-dialog)
 - [Colorpicker](#colorpicker)
 - [Datepicker](#datepicker)
 - [File and directory selection dialogs](#file-and-directory-selection-dialogs)
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

### Selection dialog
![screenshot selection dialog](https://github.com/Milchreis/UiBooster/blob/master/screenshots/selection.jpg?raw=true)
```java
String selection = new UiBooster().showSelectionDialog(
        "What's your favorite movie?",
        "Favorite Movie?",
        Arrays.asList("Pulp Fiction", "Bambi", "The Godfather", "Hangover"));
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
FilledForm form = booster.createForm("Personal information")
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

// use .run() instead of show() to open the form without blocking.
```

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
    new UiBoosterOptions(
        UiBoosterOptions.Theme.DARK_THEME,
        "/path/to/your/custom-window-icon.png"
    )
);
```

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
