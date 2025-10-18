package co.edu.uco.nose.Business.Domain;

import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

import java.util.UUID;

class Domain {
    private UUID id;
    protected Domain(final UUID id){
        setId(id);
    }

    Domain() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
}
