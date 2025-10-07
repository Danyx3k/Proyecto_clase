package co.edu.uco.nose.Buisness.Domain;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class UserDomain extends Domain{
    private IdTypeDomain idType;
    private String idNumber;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private CityDomain city;
    private String eMail;
    private String mobileNumber;
    private boolean eMailConfirmed;
    private boolean eMailConfirmedDefaultValue;
    private boolean mobileNumberConfirmed;
    private boolean mobileNumberConfirmedDefaultValue;

    public UserDomain (){
        super (UUIDHelper.getUUIDHelper().getDefault());
        setIdType(new IdTypeDomain());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setCity(new CityDomain());
        seteMail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        seteMailConfirmed(false);
        seteMailConfirmedDefaultValue(true);
        setMobileNumber(false);
        seteMailConfirmedDefaultValue(true);
    }

    public UserDomain(final UUID id){
        super(id);
        setIdType(new IdTypeDomain());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setCity(new CityDomain());
        seteMail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        seteMailConfirmed(false);
        seteMailConfirmedDefaultValue(true);
        setMobileNumber(false);
        seteMailConfirmedDefaultValue(true);
    }

    public UserDomain(final UUID id,
                      final IdTypeDomain idType,
                      final String idNumber,
                      final String firstName,
                      final String secondName,
                      final String firstSurname,
                      final String secondSurname,
                      final CityDomain city,
                      final String eMail,
                      final String mobileNumber,
                      final boolean eMailConfirmed,
                      final boolean eMailConfirmedDefaultValue,
                      final boolean mobileNumberConfirmed,
                      final boolean mobileNumberConfirmedDefaultValue){
        super(id);
        setIdType(idType);
        setIdNumber(idNumber);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstSurname(firstSurname);
        setSecondSurname(secondSurname);
        setCity(city);
        seteMail(eMail);
        seteMailConfirmed(eMailConfirmed);
        seteMailConfirmedDefaultValue(eMailConfirmedDefaultValue);
        setMobileNumberConfirmed(mobileNumberConfirmed);
        setMobileNumberConfirmedDefaultValue(mobileNumberConfirmedDefaultValue);
    }

    public boolean iseMailConfirmedDefaultValue() {
        return eMailConfirmedDefaultValue;
    }

    public void seteMailConfirmedDefaultValue(final boolean eMailConfirmedDefaultValue) {
        this.eMailConfirmedDefaultValue = eMailConfirmedDefaultValue;
    }

    public boolean isMobileNumberConfirmedDefaultValue() {
        return mobileNumberConfirmedDefaultValue;
    }

    public void setMobileNumberConfirmedDefaultValue(final boolean mobileNumberConfirmedDefaultValue) {
        this.mobileNumberConfirmedDefaultValue = mobileNumberConfirmedDefaultValue;
    }

    public IdTypeDomain getIdType() {
        return idType;
    }

    public void setIdType(final IdTypeDomain idType) {
        this.idType = (idType == null) ? new IdTypeDomain() : idType;
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

    public CityDomain getCity() {
        return city;
    }

    public void setCity(final CityDomain city) {
        this.city = (city == null) ? new CityDomain() : city;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(final String eMail) {
        this.eMail = TextHelper.getDefaultwithTrim(eMail);
    }

    public String getMobileNumbre() {
        return mobileNumber;
    }

    public void setMobileNumber(final String mobileNumbre) {
        this.mobileNumber = TextHelper.getDefaultwithTrim(mobileNumbre);
    }

    public boolean iseMailConfirmed() {
        return eMailConfirmed;
    }

    public void seteMailConfirmed(boolean eMailConfirmed) {
        this.eMailConfirmed = eMailConfirmed;
    }

    public boolean isMobileNumberConfirmed() {
        return mobileNumberConfirmed;
    }

    public void setMobileNumberConfirmed(boolean mobileNumberConfirmed) {
        this.mobileNumberConfirmed = mobileNumberConfirmed;
    }
}
