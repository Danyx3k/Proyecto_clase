package co.edu.uco.nose.Business.assembler.entity.impl;

import co.edu.uco.nose.Business.Domain.CountryDomain;
import co.edu.uco.nose.Business.Domain.IdTypeDomain;
import co.edu.uco.nose.Business.assembler.entity.EntityAssambler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.IdTypeEntity;

import java.util.List;

public final class IdTypeEntityAssembler implements EntityAssambler <IdTypeEntity, IdTypeDomain> {

    // Instancia única (patrón Singleton)
    private static final EntityAssambler<IdTypeEntity, IdTypeDomain> instance = new IdTypeEntityAssembler();

    // Constructor privado para evitar instanciación directa
    private IdTypeEntityAssembler() { }

    // Método público estático que retorna la instancia única
    public static EntityAssambler<IdTypeEntity, IdTypeDomain> getIdTypeEntityAssembler() {
        return instance;
    }

    @Override
    public IdTypeEntity toEntity(final IdTypeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new IdTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new IdTypeEntity(domainTmp.getId(),domainTmp.getName());
    }

    @Override
    public IdTypeDomain toDomain(final IdTypeEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new IdTypeEntity());
        return new IdTypeDomain(entityTmp.getId(),entityTmp.getName());
    }

    @Override
    public List toDomain(List entityList) {
        return List.of();
    }
}
