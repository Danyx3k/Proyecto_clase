package co.edu.uco.nose.Business.assembler.entity.impl;

import co.edu.uco.nose.Business.Domain.UserDomain;
import co.edu.uco.nose.Business.assembler.entity.EntityAssambler;
import co.edu.uco.nose.entity.UserEntity;

import java.util.List;


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
        return null;
    }

    @Override
    public UserDomain toDomain(final UserEntity entity) {
        return null;
    }

    @Override
    public List toDomain(List entityList) {
        return List.of();
    }
}
