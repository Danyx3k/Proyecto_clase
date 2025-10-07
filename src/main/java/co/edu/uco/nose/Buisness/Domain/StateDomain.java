package co.edu.uco.nose.Buisness.Domain;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class StateDomain extends Domain {
    private String name;
    private CountryDomain country;

    public StateDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setCountry(new CountryDomain());
    }

    public StateDomain(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
        setCountry(new CountryDomain());
    }

    public StateDomain(final UUID id, final String name, final CountryDomain country){
        super(id);
        setName(name);
        setCountry(country);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultwithTrim(name);
    }

    public CountryDomain getCountry() {
        return country;
    }

    public void setCountry(CountryDomain country) {
        this.country = (country == null) ? new CountryDomain() : country;
    }
}

