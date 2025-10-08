package co.edu.uco.nose.entity;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.StateDTO;

import java.util.UUID;

public final class CityEntity {
    private UUID id;
    private String name;
    private StateDTO state;

    public CityEntity (){
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setState(new StateDTO());
    }

    public CityEntity(final UUID id){
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setState(new StateEntity());
    }

    public CityDTO(final UUID id, final String name, final StateEntity state){
        setId(id);
        setName(name);
        setState(state);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefault(name);
    }

    public StateDTO getState() {
        return state;
    }

    public void setState(final StateDTO state) {
        this.state = (state == null) ? new StateEntity() : state;
    }
}
