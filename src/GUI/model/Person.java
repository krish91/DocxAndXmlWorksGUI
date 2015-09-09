package GUI.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final ObjectProperty<LocalDate> birthInfo;
    private final StringProperty passpSerial;
    private final StringProperty passpNumber;
    private final StringProperty passpIssued;
    private final StringProperty registeredAndLive;
    private final StringProperty amountDue;
    private final StringProperty contractNumber;
    private final ObjectProperty<LocalDate> contractDate;
    private final ObjectProperty<LocalDate> maturityDate;
    private final StringProperty creditSum;

    public Person() {
        this(null, null);
    }

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        this.birthInfo = new SimpleObjectProperty<LocalDate>(LocalDate.of(1990, 1, 1));
        this.passpSerial = new SimpleStringProperty("75 04");
        this.passpNumber = new SimpleStringProperty("12345678");
        this.passpIssued = new SimpleStringProperty("Орджоникидзевским РОВД, тра-ла-ла, тро-ло-ло 02.02.2000");
        this.registeredAndLive = new SimpleStringProperty("Бомж из под коробки");
        this.amountDue = new SimpleStringProperty("30 000 руб (тридцать тысяч рублей, 00 коп)");
        this.contractNumber = new SimpleStringProperty("НЧ0001986-10/05");
        this.contractDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(2014, 4, 12));
        this.maturityDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(2014, 6, 12));
        this.creditSum = new SimpleStringProperty("24000,00 руб (двадцать четыре тысячи, 00 коп)");
    }

    //firstName
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    //lastName
    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    //birthInfo
    public LocalDate getBirthInfo() {
        return birthInfo.get();
    }

    public void setBirthInfo(LocalDate birthday) {
        this.birthInfo.set(birthday);
    }

    public ObjectProperty<LocalDate> birthInfoProperty() {
        return birthInfo;
    }

    //passpSerial
    public String getPasspSerial() {
        return passpSerial.get();
    }

    public void setPasspSerial(String passpSerial) {
        this.passpSerial.set(passpSerial);
    }

    public StringProperty passpSerialProperty() {
        return passpSerial;
    }

    //passpNumber
    public String getPasspNumber() {
        return passpNumber.get();
    }

    public void setPasspNumber(String passpNumber) {
        this.passpNumber.set(passpNumber);
    }

    public StringProperty passpNumberProperty() {
        return passpNumber;
    }

    //passpIssued
    public String getPasspIssued() {
        return passpIssued.get();
    }

    public void setPasspIssued(String passpIssued) {
        this.passpIssued.set(passpIssued);
    }

    public StringProperty passpIssuedProperty() {
        return passpIssued;
    }

    //registeredAndLive
    public String getRegisteredAndLive() {
        return registeredAndLive.get();
    }

    public void setRegisteredAndLive(String registeredAndLive) {
        this.registeredAndLive.set(registeredAndLive);
    }

    public StringProperty registeredAndLiveProperty() {
        return registeredAndLive;
    }

    //amountDue
    public String getAmountDue() {
        return amountDue.get();
    }

    public void setAmountDue(String amountDue) {
        this.amountDue.set(amountDue);
    }

    public StringProperty amountDueProperty() {
        return amountDue;
    }

    //contractNumber
    public String getContractNumber() {
        return contractNumber.get();
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber.set(contractNumber);
    }

    public StringProperty contractNumberProperty() {
        return contractNumber;
    }

    //contractDate
    public LocalDate getContractDate() {
        return contractDate.get();
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate.set(contractDate);
    }

    public ObjectProperty<LocalDate> contractDateProperty() {
        return contractDate;
    }

    //maturityDate
    public LocalDate getMaturityDate() {
        return maturityDate.get();
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate.set(maturityDate);
    }

    public ObjectProperty<LocalDate> maturityDateProperty() {
        return maturityDate;
    }

    //creditSum
    public String getСreditSum() {
        return creditSum.get();
    }

    public void setСreditSum(String creditSum) {
        this.creditSum.set(creditSum);
    }

    public StringProperty creditSumProperty() {
        return creditSum;
    }
}
