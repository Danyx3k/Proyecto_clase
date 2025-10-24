package co.edu.uco.nose.Business.assembler.entity.impl;

import co.edu.uco.nose.Business.Domain.UserDomain;
import co.edu.uco.nose.Business.assembler.entity.EntityAssambler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.UserEntity;

import java.util.List;

import static co.edu.uco.nose.Business.assembler.entity.impl.CityEntityAssembler.getCityEntityAssembler;
import static co.edu.uco.nose.Business.assembler.entity.impl.IdTypeEntityAssembler.getIdTypeEntityAssembler;


public final class UserEntityAssembler implements EntityAssambler <UserEntity, UserDomain>{

    // ✅ Instancia única (Singleton)
    private static final EntityAssambler <UserEntity, UserDomain> instance = new UserEntityAssembler();

    // 🚫 Constructor privado: evita crear instancias fuera de esta clase
    private UserEntityAssembler() { }

    // ✅ Método de acceso a la única instancia
    public static EntityAssambler<UserEntity, UserDomain> getUserEntityAssembler() {
        return instance;
    }

    @Override
    public UserEntity toEntity(final UserDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var idTytpeEntityTmp = getIdTypeEntityAssembler().toEntity(domainTmp.getIdType());
        var cityEntityTmp = getCityEntityAssembler().toEntity(domainTmp.getCity());
        
        return new UserEntity(
                domainTmp.getId(),
                idTytpeEntityTmp,
                domainTmp.getIdNumber(),
                domainTmp.getFirstName(),
                domainTmp.getSecondName(),
                domainTmp.getFirstSurname(),
                domainTmp.getSecondSurname(),
                cityEntityTmp,
                domainTmp.geteMail(),
                domainTmp.getMobileNumber(),
                domainTmp.iseMailConfirmed(),
                domainTmp.iseMailConfirmedDefaultValue(),
                domainTmp.isMobileNumberConfirmed(),
                domainTmp.isMobileNumberConfirmedDefaultValue()
        );
        
    }

    @Override
    public UserDomain toDomain(final UserEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity,new UserEntity());

        var idTypeDominTmp = getIdTypeEntityAssembler().toDomain(entityTmp.getIdType());
        var cityDomainTmp = getCityEntityAssembler().toDomain(entityTmp.getCity());

        return new UserDomain(
                entityTmp.getId(),
                idTypeDominTmp,
                entityTmp.getIdNumber(),
                entityTmp.getFirstName(),
                entityTmp.getSecondName(),
                entityTmp.getFirstSurname(),
                entityTmp.getSecondSurname(),
                cityDomainTmp,
                entityTmp.geteMail(),
                entityTmp.getMobileNumber(),
                entityTmp.iseMailConfirmed(),
                entityTmp.iseMailConfirmedDefaultValue(),
                entityTmp.isMobileNumberConfirmed(),
                entityTmp.isMobileNumberConfirmedDefaultValue()
                );
    }

    @Override
    public List toDomain(List entityList) {
        return List.of();
    }
}
