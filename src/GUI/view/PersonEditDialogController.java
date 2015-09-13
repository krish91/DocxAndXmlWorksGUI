package GUI.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;

import GUI.model.Person;
import GUI.util.DateUtil;

/**
 * Dialog to edit details of a person.
 *
 * @author Marco Jakob
 */
public class PersonEditDialogController {

    @FXML
    private TextField fullNameField;
    @FXML
    private TextField birthInfoField;
    @FXML
    private TextField passpSerialField;
    @FXML
    private TextField passpNumberField;
    @FXML
    private TextField passpIssuedField;
    @FXML
    private TextField registeredAndLiveField;
    @FXML
    private TextField amountDueField;
    @FXML
    private TextField contractNumberField;
    @FXML
    private TextField contractDateField;
    @FXML
    private TextField maturityDateField;
    @FXML
    private TextField creditSumField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.dialogStage.setResizable(false);
        this.dialogStage.getIcons().add(new Image("file:src/resources/images/court2.png"));
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        fullNameField.setText(person.getFullName());
        birthInfoField.setText(person.getBirthInfo());
        passpSerialField.setText(person.getPasspSerial());
        passpNumberField.setText(person.getPasspNumber());
        passpIssuedField.setText(person.getPasspIssued());
        registeredAndLiveField.setText(person.getRegisteredAndLive());
        amountDueField.setText(person.getAmountDue());
        contractNumberField.setText(person.getContractNumber());
        contractDateField.setText(DateUtil.format(person.getContractDate()));
        maturityDateField.setText(DateUtil.format(person.getMaturityDate()));
        creditSumField.setText(person.getСreditSum());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFullName(fullNameField.getText());
            person.setBirthInfo(birthInfoField.getText());
            person.setPasspSerial(passpSerialField.getText());
            person.setPasspNumber(passpNumberField.getText());
            person.setPasspIssued(passpIssuedField.getText());
            person.setRegisteredAndLive(registeredAndLiveField.getText());
            person.setAmountDue(amountDueField.getText());
            person.setContractNumber(contractNumberField.getText());
            person.setContractDate(DateUtil.parse(contractDateField.getText()));
            person.setMaturityDate(DateUtil.parse(maturityDateField.getText()));
            person.setCreditSum(creditSumField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */

    private boolean isInputValid() {
        String errorMessage = "";

        if (fullNameField.getText() == null || fullNameField.getText().length() == 0) {
            errorMessage += "Введите ФИО!\n";
        }
        if (birthInfoField.getText() == null || birthInfoField.getText().length() == 0) {
            errorMessage += "Поле не может быть пустым млять!\n";
        }
        if (passpSerialField.getText() == null || passpSerialField.getText().length() == 0) {
            errorMessage += "Поле не может быть пустым млять!\n";
        }
        if (passpNumberField.getText() == null || passpNumberField.getText().length() == 0) {
            errorMessage += "Поле не может быть пустым млять!\n";
        }
        if (passpIssuedField.getText() == null || passpIssuedField.getText().length() == 0) {
            errorMessage += "Поле не может быть пустым млять!\n";
        }
        if (registeredAndLiveField.getText() == null || registeredAndLiveField.getText().length() == 0) {
            errorMessage += "Поле не может быть пустым млять!\n";
        }
        if (amountDueField.getText() == null || amountDueField.getText().length() == 0) {
            errorMessage += "Поле не может быть пустым млять!\n";
        }
        if (contractNumberField.getText() == null || contractNumberField.getText().length() == 0) {
            errorMessage += "Поле не может быть пустым млять!\n";
        }
        if (contractDateField.getText() == null || contractDateField.getText().length() == 0) {
            errorMessage += "Поле не может быть пустым млять!\n";
        } else {
            if (!DateUtil.validDate(contractDateField.getText())) {
                errorMessage += "Формат должен быть: дд.мм.гггг!\n";
            }
        }
        if (maturityDateField.getText() == null || maturityDateField.getText().length() == 0) {
            errorMessage += "Поле не может быть пустым млять!\n";
        } else {
            if (!DateUtil.validDate(maturityDateField.getText())) {
                errorMessage += "Формат должен быть: дд.мм.гггг!\n";
            }
        }
        if (creditSumField.getText() == null || creditSumField.getText().length() == 0) {
            errorMessage += "Поле не может быть пустым млять!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Dialogs.create()
                    .title("Корявое заполнение")
                    .masthead("Нужно заполнить заново")
                    .message(errorMessage)
                    .showError();
            return false;
        }
    }
}