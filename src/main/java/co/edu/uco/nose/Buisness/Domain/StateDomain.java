package co.edu.uco.nose.Buisness.Domain;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class StateDomain extends Domain {
    private String name;

    public StateDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public StateDomain(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public StateDomain(final UUID id, final String name){
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

}
