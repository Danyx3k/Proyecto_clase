package co.edu.uco.nose.Business.assembler.entity.impl;

import co.edu.uco.nose.Business.Domain.CountryDomain;
import co.edu.uco.nose.Business.Domain.StateDomain;
import co.edu.uco.nose.Business.assembler.entity.EntityAssambler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.StateEntity;

import java.util.List;

public final class StateEntityAssembler implements EntityAssambler <StateEntity, StateDomain> {

    // Instancia única (patrón Singleton)
    private static final EntityAssambler<StateEntity, StateDomain> instance = new StateEntityAssembler();

    // Constructor privado para evitar instanciación directa
    private StateEntityAssembler() { }

    // Método público estático que retorna la instancia única
    public static EntityAssambler<StateEntity, StateDomain> getStateEntityAssembler() {
        return instance;
    }

    @Override
    public StateEntity toEntity(final StateDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new StateDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var countryEntityTmp = CountryEntityAssembler.getCountryEntityAssembler().toEntity(domainTmp.getCountry());
        return new StateEntity(domainTmp.getId(), domainTmp.getName(),countryEntityTmp);
    }

    @Override
    public StateDomain toDomain(final StateEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new StateEntity());
        var countryDomainTmp = CountryEntityAssembler.getCountryEntityAssembler().toDomain(entityTmp.getCountry());
        return new StateDomain(entityTmp.getId(),entityTmp.getName(),countryDomainTmp);
    }

    @Override
    public List toDomain(List entityList) {
        return List.of();
    }
}
