package GUI.view;

import GUI.MainApp;
import GUI.model.Person;
import GUI.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.controlsfx.dialog.Dialogs;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> fullNameColumn;

    @FXML
    private Label fullNameLabel;
    @FXML
    private Label birthInfoLabel;
    @FXML
    private Label passpSerialLabel;
    @FXML
    private Label passpNumberLabel;
    @FXML
    private Label passpIssuedLabel;
    @FXML
    private Label registeredAndLiveLabel;
    @FXML
    private Label amountDueLabel;
    @FXML
    private Label contractNumberLabel;
    @FXML
    private Label contractDateLabel;
    @FXML
    private Label maturityDateLabel;
    @FXML
    private Label creditSumLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        fullNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().fullNameProperty());

        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }

    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param person the person or null
     */
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            fullNameLabel.setText(person.getFullName());
            birthInfoLabel.setText(person.getBirthInfo());
            passpSerialLabel.setText(person.getPasspSerial());
            passpNumberLabel.setText(person.getPasspNumber());
            passpIssuedLabel.setText(person.getPasspIssued());
            registeredAndLiveLabel.setText(person.getRegisteredAndLive());
            amountDueLabel.setText(person.getAmountDue());
            contractNumberLabel.setText(person.getContractNumber());
            contractDateLabel.setText(DateUtil.format(person.getContractDate()));
            maturityDateLabel.setText(DateUtil.format(person.getMaturityDate()));
            creditSumLabel.setText(person.getСreditSum());

            // TODO: We need a way to convert the birthInfo into a String!
            //http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
            fullNameLabel.setText("");
            birthInfoLabel.setText("");
            passpSerialLabel.setText("");
            passpNumberLabel.setText("");
            passpIssuedLabel.setText("");
            registeredAndLiveLabel.setText("");
            amountDueLabel.setText("");
            contractNumberLabel.setText("");
            contractDateLabel.setText("");
            maturityDateLabel.setText("");
            creditSumLabel.setText("");
        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Dialogs.create()
                    .title("Ошибка")
                    .masthead("Выберите должника в таблице")
                    .message("Чтобы удалить кого-то - нужно сначала его выбрать в таблице.")
                    .showWarning();
        }
    }

    /**
     * Called when user clicks the NEW button.
     * Opens dialog to edit details for a new person
     */
    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    /**
     * Called when user clicks the EDIT button.
     * Opens dialog to edit details fot the selected person
     */

    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            } else {
                //Nothing selected
                Dialogs.create()
                        .title("Ничего не выбрано")
                        .masthead("Никто не выбран")
                        .message("Выберите уголовника в таблице")
                        .showWarning();
            }
        }
    }
}
