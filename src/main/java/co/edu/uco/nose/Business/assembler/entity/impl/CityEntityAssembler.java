package co.edu.uco.nose.Business.assembler.entity.impl;

import co.edu.uco.nose.Business.Domain.CityDomain;
import co.edu.uco.nose.Business.Domain.StateDomain;
import co.edu.uco.nose.Business.assembler.entity.EntityAssambler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.StateEntity;

import java.util.List;

import static co.edu.uco.nose.Business.assembler.entity.impl.StateEntityAssembler.getStateEntityAssembler;

public final class CityEntityAssembler implements EntityAssambler <CityEntity, CityDomain>{

    // Instancia única (patrón Singleton)
    private static final EntityAssambler<CityEntity, CityDomain > instance = new CityEntityAssembler();

    // Constructor privado para evitar instanciación directa
    private CityEntityAssembler() { }

    // Método público estático que retorna la instancia única
    public static EntityAssambler<CityEntity, CityDomain> getCityEntityAssembler() {
        return instance;
    }

    @Override
    public CityEntity toEntity(final CityDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var stateEntityTmp = getStateEntityAssembler().toEntity(domainTmp.getState());
        return new CityEntity(domainTmp.getId(),domainTmp.getName(),stateEntityTmp);
    }

    @Override
    public CityDomain toDomain(final CityEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new CityEntity());
        var stateDomainTmp = getStateEntityAssembler().toDomain(entityTmp.getState());
        return new CityDomain (entityTmp.getId(), entityTmp.getName(),stateDomainTmp);
    }

    @Override
    public List toDomain(List entityList) {
        return List.of();
    }
}
