package co.edu.uco.nose.Business.Domain;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class CountryDomain extends Domain {
    private String name;

    public CountryDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public CountryDomain(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public CountryDomain(final UUID id, final String name){
        super(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultwithTrim(name);
    }
}
