package co.edu.uco.nose.dto;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class UserDTO {
    private UUID id;
    private IdTypeDTO idType;
    private String idNumber;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private CityDTO city;
    private String eMail;
    private String mobileNumber;
    private boolean eMailConfirmed;
    private boolean eMailConfirmedDefaultValue;
    private boolean mobileNumberConfirmed;
    private boolean mobileNumberConfirmedDefaultValue;

    public UserDTO(){
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setIdType(new IdTypeDTO());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setCity(new CityDTO());
        seteMail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        seteMailConfirmed(false);
        seteMailConfirmedDefaultValue(true);
        setMobileNumberConfirmed(false);
        setMobileNumberConfirmedDefaultValue(true);
    }

    public UserDTO(final UUID id){
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setIdType(new IdTypeDTO());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setCity(new CityDTO());
        seteMail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        seteMailConfirmed(false);
        seteMailConfirmedDefaultValue(true);
        setMobileNumberConfirmed(false);
        setMobileNumberConfirmedDefaultValue(true);
    }

    public UserDTO (final UUID id,
                    final IdTypeDTO idType,
                    final String idNumber,
                    final String firstName,
                    final String secondName,
                    final String firstSurname,
                    final String secondSurname,
                    final CityDTO city,
                    final String eMail,
                    final String mobileNumber,
                    final boolean eMailConfirmed,
                    final boolean eMailConfirmedDefaultValue,
                    final boolean mobileNumberConfirmed,
                    final boolean mobileNumberConfirmedDefaultValue){
        setId(id);
        setIdType(idType);
        setIdNumber(idNumber);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstSurname(firstSurname);
        setSecondSurname(secondSurname);
        setCity(city);
        seteMail(eMail);
        setMobileNumber(mobileNumber);
        seteMailConfirmed(eMailConfirmed);
        seteMailConfirmedDefaultValue(eMailConfirmedDefaultValue);
        setMobileNumberConfirmed(mobileNumberConfirmed);
        setMobileNumberConfirmedDefaultValue(mobileNumberConfirmedDefaultValue);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public IdTypeDTO getIdType() {
        return idType;
    }

    public void setIdType(final IdTypeDTO idType) {
        this.idType = (idType == null) ? new IdTypeDTO() : idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(final String idNumber) {
        this.idNumber = TextHelper.getDefaultwithTrim(idNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = TextHelper.getDefaultwithTrim(firstName);
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = TextHelper.getDefaultwithTrim(secondName);
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(final String firstSurname) {
        this.firstSurname = TextHelper.getDefaultwithTrim(firstSurname);
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(final String secondSurname) {
        this.secondSurname = TextHelper.getDefaultwithTrim(secondSurname);
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(final CityDTO city) {
        this.city = (city == null) ? new CityDTO() : city;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(final String eMail) {
        this.eMail = TextHelper.getDefaultwithTrim(eMail);
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = TextHelper.getDefaultwithTrim(mobileNumber);
    }

    public boolean iseMailConfirmed() {
        return eMailConfirmed;
    }

    public void seteMailConfirmed(final boolean eMailConfirmed) {
        this.eMailConfirmed = eMailConfirmed;
    }

    public boolean iseMailConfirmedDefaultValue() {
        return eMailConfirmedDefaultValue;
    }

    public void seteMailConfirmedDefaultValue(final boolean eMailConfirmedDefaultValue) {
        this.eMailConfirmedDefaultValue = eMailConfirmedDefaultValue;
    }

    public boolean isMobileNumberConfirmed() {
        return mobileNumberConfirmed;
    }

    public void setMobileNumberConfirmed(final boolean mobileNumberConfirmed) {
        this.mobileNumberConfirmed = mobileNumberConfirmed;
    }

    public boolean isMobileNumberConfirmedDefaultValue() {
        return mobileNumberConfirmedDefaultValue;
    }

    public void setMobileNumberConfirmedDefaultValue(final boolean mobileNumberConfirmedDefaultValue) {
        this.mobileNumberConfirmedDefaultValue = mobileNumberConfirmedDefaultValue;
    }
}
