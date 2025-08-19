package io.stanford.tim.json_schema_poc;

import java.time.LocalDate;

public class PersonnelRecord {
    private String firstname;
    private String surname;
    private LocalDate dateOfBirth;
    private String[] addressLines;
    private String sex;
    private String notes;

    public PersonnelRecord() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String[] getAddressLines() {
        return addressLines;
    }

    public void setAddressLines(String[] addressLines) {
        this.addressLines = addressLines;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
