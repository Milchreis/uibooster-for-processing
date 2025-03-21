package uibooster.model;

import uibooster.components.SimpleBlockingDialog;
import uibooster.components.SimpleDialog;
import uibooster.components.WindowSetting;
import uibooster.model.formelements.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static uibooster.utils.FormPanel.createPanel;

public class FormBuilder {

    protected final String title;
    protected final List<FormElement> formElements;
    protected final List<String> initialElementsDisabled;
    private final UiBoosterOptions options;
    private FormElementChangeListener changeListener;
    private FormCloseListener formCloseListener;
    private FormInitializedListener formInitializedListener;
    private WindowSetting windowSetting;
    private RowFormBuilder rowFormBuilder;

    protected FormBuilder parent;

    protected int defaultMarginLeft = 0;
    protected int defaultMarginTop = 0;
    protected int defaultMarginRight = 0;
    protected int defaultMarginBottom = 10;

    public FormBuilder(String title, UiBoosterOptions options) {
        this.title = title;
        this.options = options;
        this.formElements = new ArrayList<>();
        this.initialElementsDisabled = new ArrayList<>();
    }

    public FormBuilder(FormBuilder formBuilder) {
        this.title = formBuilder.title;
        this.formElements = formBuilder.formElements;
        this.initialElementsDisabled = formBuilder.initialElementsDisabled;
        this.options = formBuilder.options;
        this.changeListener = formBuilder.changeListener;
        this.formCloseListener = formBuilder.formCloseListener;
        this.formInitializedListener = formBuilder.formInitializedListener;
        this.windowSetting = formBuilder.windowSetting;
        this.rowFormBuilder = formBuilder.rowFormBuilder;
        this.defaultMarginLeft = formBuilder.defaultMarginLeft;
        this.defaultMarginTop = formBuilder.defaultMarginTop;
        this.defaultMarginRight = formBuilder.defaultMarginRight;
        this.defaultMarginBottom = formBuilder.defaultMarginBottom;
        this.parent = formBuilder.parent;
    }

    /**
     * Adds an input text field to the form.
     *
     * @param label expects the label for this input element
     */
    public FormBuilderElementTyped<String> addText(String label) {
        addElement(new TextFormElement(label, null, false));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds an input text field to the form with an initial text.
     *
     * @param label       expects the label for this input element
     * @param initialText expects a text which will be set into the text field
     */
    public FormBuilderElementTyped<String> addText(String label, String initialText) {
        addElement(new TextFormElement(label, initialText, false));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds an input text field to the form with an initial text.
     *
     * @param label       expects the label for this input element
     * @param initialText expects a text which will be set into the text field.
     * @param readonly    if readonly is set to true, the input field is not changable for the user
     */
    public FormBuilderElementTyped<String> addText(String label, String initialText, boolean readonly) {
        addElement(new TextFormElement(label, initialText, readonly));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds an input text area with 3 lines to the form.
     *
     * @param label expects the label for this input element
     */
    public FormBuilderElementTyped<String> addTextArea(String label) {
        addElement(new TextAreaFormElement(label, 3, "", false));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds an input text area with specified number of lines to the form.
     *
     * @param label expects the label for this input element
     * @param rows  expects the number of lines
     */
    public FormBuilderElementTyped<String> addTextArea(String label, int rows) {
        addElement(new TextAreaFormElement(label, rows, "", false));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds an input text area with 3 lines to the form and an initial text.
     *
     * @param label       expects the label for this input element
     * @param initialText expects a text which will be set into the text area
     */
    public FormBuilderElementTyped<String> addTextArea(String label, String initialText) {
        addElement(new TextAreaFormElement(label, 3, initialText, false));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds an input text area with specified number of lines to the form and an initial text.
     *
     * @param label       expects the label for this input element
     * @param rows        expects the number of lines
     * @param initialText expects a text which will be set into the text area
     */
    public FormBuilderElementTyped<String> addTextArea(String label, int rows, String initialText) {
        addElement(new TextAreaFormElement(label, rows, initialText, false));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds an input text area with specified number of lines to the form and an initial text.
     *
     * @param label       expects the label for this input element
     * @param rows        expects the number of lines
     * @param initialText expects a text which will be set into the text area
     * @param readonly    if readonly is set to true, the input field is not changable for the user
     */
    public FormBuilderElementTyped<String> addTextArea(String label, int rows, String initialText, boolean readonly) {
        addElement(new TextAreaFormElement(label, rows, initialText, readonly));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a selection list to the form, which allows to choose one option.
     *
     * @param label         expects the label for this input element
     * @param possibilities expects a list of possible texts options
     */
    public FormBuilderElementTyped<String> addSelection(String label, List<String> possibilities) {
        addElement(new SelectionFormElement(label, possibilities));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a selection list to the form, which allows to choose one option.
     *
     * @param label         expects the label for this input element
     * @param possibilities expects a list of possible texts options
     * @return
     */
    public FormBuilderElementTyped<String> addSelection(String label, String... possibilities) {
        addSelection(label, Arrays.asList(possibilities));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a selection with checkboxes to the form, which allows to choose multiple options.
     *
     * @param label         expects the label for this input element
     * @param possibilities expects a list of possible texts options
     */
    public FormBuilderElementTyped<String> addSelectionWithCheckboxes(String label, List<String> possibilities) {
        addElement(new CheckboxSelectionFormElement(label, possibilities, null));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a selection with checkboxes to the form, which allows to choose multiple options.
     *
     * @param label                        expects the label for this input element
     * @param possibilities                expects a list of possible texts options
     * @param initialSelectedPossibilities expects the initial
     */
    public FormBuilderElementTyped<String> addSelectionWithCheckboxes(String label, List<String> possibilities, List<String> initialSelectedPossibilities) {
        addElement(new CheckboxSelectionFormElement(label, possibilities, initialSelectedPossibilities));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a selection with checkboxes to the form, which allows to choose multiple options.
     *
     * @param label         expects the label for this input element
     * @param possibilities expects a list of possible texts options
     */
    public FormBuilderElementTyped<String> addSelectionWithCheckboxes(String label, String... possibilities) {
        addSelectionWithCheckboxes(label, Arrays.asList(possibilities));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds the given self implemented FormElement to the form.
     *
     * @param element expects an implementation of FormElement
     */
    public <T> FormBuilderElementTyped<T> addCustomElement(FormElement<T> element) {
        addElement(element);
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds just a label to the form.
     *
     * @param label expects the label
     */
    public FormBuilderElementTyped<String> addLabel(String label) {
        addElement(new LabelFormElement(label));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a button to the form.
     *
     * @param buttonLabel expects the text which is shown on the button
     * @param onClick     expects an implementation of Runnable, which is executed when the button is clicked
     */
    public FormBuilderElementTyped<String> addButton(String buttonLabel, Runnable onClick) {
        return addButton(null, buttonLabel, (element, form) -> {
            if (onClick != null) {
                onClick.run();
            }
        });
    }

    /**
     * Adds a button to the form.
     *
     * @param buttonLabel expects the text which is shown on the button
     * @param onClick     expects an implementation of Runnable, which is executed when the button is clicked
     */
    public FormBuilderElementTyped<String> addButton(String buttonLabel, ButtonClickListener onClick) {
        return addButton(null, buttonLabel, onClick);
    }

    /**
     * Adds a button to the form.
     *
     * @param buttonLabel     expects the text which is shown on the button
     * @param onClick         expects an implementation of Runnable, which is executed when the button is clicked
     * @param backgroundColor expects a color for the tint of this button background
     */
    public FormBuilderElementTyped<String> addButton(String buttonLabel, ButtonClickListener onClick, Color backgroundColor) {
        addElement(new ButtonFormElement(buttonLabel, buttonLabel, onClick, backgroundColor, null));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a button to the form.
     *
     * @param buttonLabel     expects the text which is shown on the button
     * @param onClick         expects an implementation of Runnable, which is executed when the button is clicked
     * @param backgroundColor expects a color for the tint of this button background
     * @param textColor       expects a color for the text in this button
     */
    public FormBuilderElementTyped<String> addButton(String buttonLabel, ButtonClickListener onClick, Color backgroundColor, Color textColor) {
        addElement(new ButtonFormElement(buttonLabel, buttonLabel, onClick, backgroundColor, textColor));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a button to the form.
     *
     * @param label       expects the label for this input element
     * @param buttonLabel expects the text which is shown on the button
     * @param onClick     expects an implementation of Runnable, which is executed when the button is clicked
     */
    public FormBuilderElementTyped<String> addButton(String label, String buttonLabel, Runnable onClick) {
        addElement(new ButtonFormElement(label, buttonLabel, (element, form) -> onClick.run()));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a button to the form.
     *
     * @param label       expects the label for this input element
     * @param buttonLabel expects the text which is shown on the button
     * @param onClick     expects an implementation of Runnable, which is executed when the button is clicked
     */
    public FormBuilderElementTyped<String> addButton(String label, String buttonLabel, ButtonClickListener onClick) {
        addElement(new ButtonFormElement(label, buttonLabel, onClick));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a button to the form.
     *
     * @param label           expects the label for this input element
     * @param buttonLabel     expects the text which is shown on the button
     * @param onClick         expects an implementation of Runnable, which is executed when the button is clicked
     * @param backgroundColor expects a color for the tint of this button background
     * @param textColor       expects a color for the text in this button
     */
    public FormBuilderElementTyped<String> addButton(String label, String buttonLabel, ButtonClickListener onClick, Color backgroundColor, Color textColor) {
        addElement(new ButtonFormElement(label, buttonLabel, onClick, backgroundColor, textColor));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a button to the form.
     *
     * @param label           expects the label for this input element
     * @param buttonLabel     expects the text which is shown on the button
     * @param onClick         expects an implementation of Runnable, which is executed when the button is clicked
     * @param backgroundColor expects a color for the tint of this button background
     */
    public FormBuilderElementTyped<String> addButton(String label, String buttonLabel, ButtonClickListener onClick, Color backgroundColor) {
        addElement(new ButtonFormElement(label, buttonLabel, onClick, backgroundColor, null));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a progress bar to the form.
     *
     * @param label   expects the label for this input element
     * @param min     expects the minimum value of the progress bar
     * @param max     expects the maximum value of the progress bar
     * @param initial expects the current value of the progress bar
     */
    public FormBuilderElementTyped<Integer> addProgress(String label, int min, int max, int initial) {
        addElement(new ProgressElement(label, min, max, initial));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a slider to the form, which allows to choose a value in between some bounds.
     *
     * @param label     expects the label for this input element
     * @param min       expects the minimum value of the slider
     * @param max       expects the maximum value of the slider
     * @param init      expects the current value of the slider
     * @param majorTick expects the step size for the bigger major tick
     * @param minorTick expects the step size for the smaller minor tick
     */
    public FormBuilderElementTyped<Integer> addSlider(String label, int min, int max, int init, int majorTick, int minorTick) {
        addElement(new SliderFormElement(label, min, max, init, majorTick, minorTick));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a date picker to the form.
     *
     * @param label expects the label for this input element
     */
    public FormBuilderElementTyped<Date> addDatePicker(String label) {
        addElement(new DatePickerElement(label));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a color picker to the form.
     *
     * @param label expects the label for this input element
     */
    public FormBuilderElementTyped<Color> addColorPicker(String label) {
        addElement(new ColorPickerElement(label));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a color picker to the form.
     *
     * @param label        expects the label for this input element
     * @param initialColor expects a color which is set to the picker as default
     */
    public FormBuilderElementTyped<Color> addColorPicker(String label, Color initialColor) {
        addElement(new ColorPickerElement(label, initialColor));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a font chooser to the form.
     *
     * @param label expects the label for this input element
     */
    public FormBuilderElementTyped<Font> addFontChooser(String label) {
        addElement(new FontChooserElement(label));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a font chooser to the form.
     *
     * @param label       expects the label for this input element
     * @param initialFont expects a font which is set to the chooser as default
     */
    public FormBuilderElementTyped<Font> addFontChooser(String label, Font initialFont) {
        addElement(new FontChooserElement(label, initialFont));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a scrollable and searchable list of elements to the form, which allows to choose multiple elements.
     *
     * @param label    expects the label for this input element
     * @param elements expects a list of options as text
     */
    public FormBuilderElementTyped<List<String>> addMultipleSelection(String label, String... elements) {
        addElement(new FilterableCheckboxListFormElement(label, false, Arrays.asList(elements)));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a scrollable and searchable list of elements to the form, which allows to choose multiple elements.
     *
     * @param label      expects the label for this input element
     * @param hideFilter if set to true, the input text field for the search will be not shown
     * @param elements   expects a list of options as text
     */
    public FormBuilderElementTyped<List<String>> addMultipleSelection(String label, boolean hideFilter, String... elements) {
        addElement(new FilterableCheckboxListFormElement(label, hideFilter, Arrays.asList(elements)));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a scrollable and searchable list of elements to the form, which allows to choose multiple elements.
     *
     * @param label    expects the label for this input element
     * @param elements expects a list of options as text
     */
    public FormBuilderElementTyped<List<String>> addMultipleSelection(String label, List<String> elements) {
        addElement(new FilterableCheckboxListFormElement(label, false, elements));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a scrollable and searchable list of elements to the form, which allows to choose multiple elements.
     *
     * @param label      expects the label for this input element
     * @param hideFilter if set to true, the input text field for the search will be not shown
     * @param elements   expects a list of options as text
     */
    public FormBuilderElementTyped<List<String>> addMultipleSelection(String label, boolean hideFilter, List<String> elements) {
        addElement(new FilterableCheckboxListFormElement(label, hideFilter, elements));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a list with more complex elements to the form.
     *
     * @param label    expects the label for this input element
     * @param elements expects a list of objects with type ListElement
     */
    public FormBuilderElementTyped<ListElement> addList(String label, ListElement... elements) {
        addElement(new ListFormElement(label, elements));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds table with custom data to the form.
     *
     * @param label      expects the label for this input element
     * @param header     expects a list of column names
     * @param data       expects the data as two-dimensional array of Strings. It has to match with the number of column names
     * @param isEditable true if the data should changeable by the user, otherwise set false for immutable data
     */
    public FormBuilderElementTyped<TableData> addTable(String label, List<String> header, String[][] data, boolean isEditable) {
        addElement(new TableFormElement(label, header, data, isEditable));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds an editable table with custom data to the form.
     *
     * @param label  expects the label for this input element
     * @param header expects a list of column names
     * @param data   expects the data as two-dimensional array of Strings. It has to match with the number of column names
     */
    public FormBuilderElementTyped<TableData> addTable(String label, List<String> header, String[][] data) {
        addElement(new TableFormElement(label, header, data, true));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds an image to the form.
     *
     * @param imagePath expects the path to the image file
     */
    public FormBuilderElementTyped<String> addImage(String imagePath) {
        return addImage(null, imagePath, false);
    }

    /**
     * Adds an image centered to the form.
     *
     * @param imagePath expects the path to the image file
     */
    public FormBuilder addImageCentered(String imagePath) {
        return addImage(null, imagePath, true);
    }

    /**
     * Adds an image to the form.
     *
     * @param label     expects the label for this input element
     * @param imagePath expects the path to the image file
     * @param centered  true if the image should be centered, false it's aligned to the left
     */
    public FormBuilderElementTyped<String> addImage(String label, String imagePath, boolean centered) {
        addElement(new ImageFormElement(label, imagePath, centered));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds true/false option as checkbox to the form.
     *
     * @param label expects a text which is displayed next to the checkbox
     */
    public FormBuilderElementTyped<Boolean> addCheckbox(String label) {
        addElement(new CheckboxFormElement(label));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds true/false option as checkbox to the form.
     *
     * @param headline expects a text for this input element, which is displayed over the input element
     * @param label    expects a text which is displayed next to the checkbox
     */
    public FormBuilderElementTyped<Boolean> addCheckbox(String headline, String label) {
        addElement(new CheckboxFormElement(label, headline));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds true/false option as checkbox to the form.
     *
     * @param headline     expects a text for this input element, which is displayed over the input element
     * @param label        expects a text which is displayed next to the checkbox
     * @param initialValue executes a value which is set up for the checkbox
     */
    public FormBuilderElementTyped<Boolean> addCheckbox(String headline, String label, boolean initialValue) {
        addElement(new CheckboxFormElement(label, headline, initialValue));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds true/false option as checkbox to the form.
     *
     * @param label        expects a text which is displayed next to the checkbox
     * @param initialValue executes a value which is set up for the checkbox
     */
    public FormBuilderElementTyped<Boolean> addCheckbox(String label, boolean initialValue) {
        addElement(new CheckboxFormElement(label, null, initialValue));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a html interpreted text to the form. It supports HTML 3.2
     *
     * @param label       expects the label for this input element
     * @param htmlContent expected html content
     */
    public FormBuilderElementTyped<String> addHtmlText(String label, String htmlContent) {
        addElement(new HtmlTextFormElement(label, htmlContent, 600, 600));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Adds a html interpreted text to the form. It supports HTML 3.2
     *
     * @param label       expects the label for this input element
     * @param htmlContent expects html content
     * @param width       expects the width in pixel which the component has to used preferred
     * @param height      expects the height in pixel which the component has to used preferred
     */
    public FormBuilderElementTyped<String> addHtmlText(String label, String htmlContent, int width, int height) {
        addElement(new HtmlTextFormElement(label, htmlContent, width, height));
        return new FormBuilderElementTyped<>(this);
    }

    /**
     * Defines a listener which detects all changes in this form. It allows to react to different events for the
     * added form elements.
     *
     * @param onChange expects an implementation of FormElementChangeListener
     */
    public FormBuilder setChangeListener(FormElementChangeListener onChange) {
        this.changeListener = onChange;
        return this;
    }

    /**
     * Defines a listener which detects the closing of the window of form. It allows to react on f.e. exit
     *
     * @param closeListener expects an implementation of FormElementCloseListener
     */
    public FormBuilder setCloseListener(FormCloseListener closeListener) {
        formCloseListener = closeListener;
        return this;
    }

    /**
     * Defines a listener which is called onced after the creation of the form.
     *
     * @param formInitializedListener expects an implementation of FormInitializedListener
     */
    public FormBuilder setInitListener(FormInitializedListener formInitializedListener) {
        this.formInitializedListener = formInitializedListener;
        return this;
    }

    /**
     * Defines a margin for the lastly added element to set the space around this element in pixel.
     * If setMargin is called before any element is added the given margin will set as default values for upcoming elements.
     *
     * @param elementLeft   expects a margin space to the left in pixel
     * @param elementTop    expects a margin space to top in pixel
     * @param elementRight  expects a margin space to the right in pixel
     * @param elementBottom expects a margin space to bottom in pixel
     */
    public FormBuilder setMargin(int elementLeft, int elementTop, int elementRight, int elementBottom) {
        if (formElements.isEmpty()) {
            defaultMarginLeft = Math.max(0, elementLeft);
            defaultMarginTop = Math.max(0, elementTop);
            defaultMarginRight = Math.max(0, elementRight);
            defaultMarginBottom = Math.max(0, elementBottom);
        } else {
            final FormElement element = getLatestElement();
            element.setMargin(
                Math.max(0, elementLeft),
                Math.max(0, elementTop),
                Math.max(0, elementRight),
                Math.max(0, elementBottom)
            );
        }

        return this;
    }

    /**
     * Allows to define some settings for the created window of the form. The settings have to be closed with save()-method
     */
    public WindowSetting andWindow() {
        windowSetting = new WindowSetting(this);
        return windowSetting;
    }

    /**
     * Creates the previous defined form as blocking dialog and shows the window. It blocks the process until the
     * window is closed. After that it returns the user input as Form.
     *
     * @return an object with the user filled data
     */
    public Form show() {

        final Form form = new Form(null, formElements);

        JPanel panel = createPanel(formElements, changeListener, 5);
        form.setElementsDisableById(initialElementsDisabled);

        SimpleBlockingDialog dialog = new SimpleBlockingDialog(panel);
        dialog.setDialogCreatedListener(form::setWindow);

        if (this.formInitializedListener != null)
            this.formInitializedListener.onInit(form);

        dialog.showDialog(null, title,
            windowSetting,
            options.getIconPath(),
            new FormCloseListenerWrapper(form, formCloseListener),
            true);

        form.setClosedByUser(false);

        return form;
    }

    /**
     * Creates the previous defined form as non-blocking dialog and shows the window. The window is started in a new thread and allows to run the following code.
     * It returns an object which is synchronized with the form. This form-object contains every user input as long as the dialog runs.
     *
     * @return an object which allows access to the user filled data.
     */
    public Form run() {
        JPanel panel = createPanel(formElements, changeListener, 5);

        SimpleDialog dialog = new SimpleDialog(title, panel, windowSetting, options.getIconPath());
        final Form form = new Form(dialog, formElements, initialElementsDisabled, formCloseListener);

        if (this.formInitializedListener != null)
            this.formInitializedListener.onInit(form);

        return form;
    }

    /**
     * Starts a new row to set multiple elements next to each other. It allows to set elements in the same row.
     * The row has to end with the endRow()-method.
     */
    public RowFormBuilder startRow() {
        return startRow(null);
    }

    /**
     * Starts a new row to set multiple elements next to each other. It allows to set elements in the same row.
     * The row has to end with the endRow()-method. The gap params allow to set some space for the row in
     * horizontal and vertical direction.
     *
     * @param hGap expects a space in horizontal direction in pixel. The space is the sum of left und right spacing.
     * @param vGap expects a space in vertical direction in pixel. The space is the sum of left und right spacing.
     */
    public RowFormBuilder startRow(int hGap, int vGap) {
        return startRow(null, hGap, vGap);
    }

    /**
     * Starts a new row to set multiple elements next to each other. It allows to set elements in the same row.
     * The row has to end with the endRow()-method. The margin defines the space around this row in pixel.
     *
     * @param elementLeft   expects a margin space to the left in pixel
     * @param elementTop    expects a margin space to top in pixel
     * @param elementRight  expects a margin space to the right in pixel
     * @param elementBottom expects a margin space to bottom in pixel
     */
    public RowFormBuilder startRow(int elementLeft, int elementTop, int elementRight, int elementBottom) {
        return startRow(null, elementLeft, elementTop, elementRight, elementBottom);
    }

    /**
     * Starts a new row to set multiple elements next to each other. It allows to set elements in the same row.
     * The row has to end with the endRow()-method.
     *
     * @param label expects the label for this input element
     */
    public RowFormBuilder startRow(String label) {
        rowFormBuilder = new RowFormBuilder(label, options, this, 0, 0);
        return rowFormBuilder;
    }

    /**
     * Starts a new row to set multiple elements next to each other. It allows to set elements in the same row.
     * The row has to end with the endRow()-method. The gap params allow to set some space for the row in
     * horizontal and vertical direction.
     *
     * @param label expects the label for this input element
     * @param hGap  expects a space in horizontal direction in pixel. The space is the sum of left und right spacing.
     * @param vGap  expects a space in vertical direction in pixel. The space is the sum of left und right spacing.
     */
    public RowFormBuilder startRow(String label, int hGap, int vGap) {
        rowFormBuilder = new RowFormBuilder(label, options, this, hGap, vGap);
        return rowFormBuilder;
    }

    /**
     * Starts a new row to set multiple elements next to each other. It allows to set elements in the same row.
     * The row has to end with the endRow()-method. The margin defines the space around this row in pixel.
     *
     * @param label         expects the label for this input element
     * @param elementLeft   expects a margin space to the left in pixel
     * @param elementTop    expects a margin space to top in pixel
     * @param elementRight  expects a margin space to the right in pixel
     * @param elementBottom expects a margin space to bottom in pixel
     */
    public RowFormBuilder startRow(String label, int elementLeft, int elementTop, int elementRight, int elementBottom) {
        rowFormBuilder = new RowFormBuilder(label, options, this, elementLeft, elementTop, elementRight, elementBottom);
        return rowFormBuilder;
    }

    /**
     * Stops the current created row. It has to be used after startRow()-method.
     */
    public FormBuilder endRow() {
        parent.rowFormBuilder.endRow();
        return parent;
    }

    protected <T> void addElement(FormElement<T> e) {
        e.setFormIndex(formElements.size());

        if (e.getId() == null)
            e.setId(String.valueOf(e.hashCode()));

        // Set default margins for non-RowFormElements only
        if (!(e instanceof RowFormElement)) {
            e.setMargin(defaultMarginLeft, defaultMarginTop, defaultMarginRight, defaultMarginBottom);
        }

        formElements.add(e);
    }

    protected <T> FormElement<T> getLatestElement() {
        final List<FormElement> elements = formElements;
        return elements.get(elements.size() - 1);
    }
}
