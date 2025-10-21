package co.edu.uco.nose.Business.assembler.entity.impl;

import co.edu.uco.nose.Business.Domain.CountryDomain;
import co.edu.uco.nose.Business.assembler.entity.EntityAssambler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

import co.edu.uco.nose.entity.CountryEntity;

import java.util.List;


public final class CountryEntityAssembler implements EntityAssambler<CountryEntity, CountryDomain> {

    // Instancia única (patrón Singleton)
    private static final EntityAssambler<CountryEntity, CountryDomain> instance = new CountryEntityAssembler();

    // Constructor privado para evitar instanciación directa
    private CountryEntityAssembler() { }

    // Método público estático que retorna la instancia única
    public static EntityAssambler<CountryEntity, CountryDomain> getCountryEntityAssembler() {
        return instance;
    }

    @Override
    public CountryEntity toEntity (final CountryDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new CountryEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public CountryDomain toDomain (final CountryEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new CountryEntity());
        return new CountryDomain(entityTmp.getId(),entityTmp.getName());
    }

    @Override
    public List toDomain(List entityList) {
        return List.of();
    }
}
