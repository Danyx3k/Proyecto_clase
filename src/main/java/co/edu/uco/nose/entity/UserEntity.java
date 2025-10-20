package co.edu.uco.nose.entity;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class UserEntity {
    private UUID id;
    private IdTypeEntity idType;
    private String idNumber;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private CityEntity city;
    private String eMail;
    private String mobileNumber;
    private boolean eMailConfirmed;
    private boolean eMailConfirmedDefaultValue;
    private boolean mobileNumberConfirmed;
    private boolean mobileNumberConfirmedDefaultValue;

    public UserEntity(){
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setIdType(new IdTypeEntity());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setCity(new CityEntity());
        seteMail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        seteMailConfirmed(false);
        seteMailConfirmedDefaultValue(true);
        setMobileNumberConfirmed(false);
        setMobileNumberConfirmedDefaultValue(true);
    }

    public UserEntity(final UUID id){
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setIdType(new IdTypeEntity());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setCity(new CityEntity());
        seteMail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        seteMailConfirmed(false);
        seteMailConfirmedDefaultValue(true);
        setMobileNumberConfirmed(false);
        setMobileNumberConfirmedDefaultValue(true);
    }

    public UserEntity (final UUID id,
                    final IdTypeEntity idType,
                    final String idNumber,
                    final String firstName,
                    final String secondName,
                    final String firstSurname,
                    final String secondSurname,
                    final CityEntity city,
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

    public IdTypeEntity getIdType() {
        return idType;
    }

    public void setIdType(final IdTypeEntity idType) {
        this.idType = ObjectHelper.getDefault(idType, new IdTypeEntity());
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

    public CityEntity getCity() {
        return city;
    }

    public void setCity(final CityEntity city) {
        this.city = ObjectHelper.getDefault(city, new CityEntity());
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
        seteMailConfirmedDefaultValue(false);
    }

    public boolean iseMailConfirmedDefaultValue() {
        return eMailConfirmedDefaultValue;
    }

    private void seteMailConfirmedDefaultValue(final boolean eMailConfirmedDefaultValue) {
        this.eMailConfirmedDefaultValue = eMailConfirmedDefaultValue;
    }

    public boolean isMobileNumberConfirmed() {
        return mobileNumberConfirmed;
    }

    public void setMobileNumberConfirmed(final boolean mobileNumberConfirmed) {
        this.mobileNumberConfirmed = mobileNumberConfirmed;
        setMobileNumberConfirmedDefaultValue(false);
    }

    public boolean isMobileNumberConfirmedDefaultValue() {
        return mobileNumberConfirmedDefaultValue;
    }

    private void setMobileNumberConfirmedDefaultValue(final boolean mobileNumberConfirmedDefaultValue) {
        this.mobileNumberConfirmedDefaultValue = mobileNumberConfirmedDefaultValue;
    }

}
