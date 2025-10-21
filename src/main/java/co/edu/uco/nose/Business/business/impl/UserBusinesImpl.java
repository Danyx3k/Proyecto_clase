package co.edu.uco.nose.Business.business.impl;

import co.edu.uco.nose.Business.Domain.UserDomain;
import co.edu.uco.nose.Business.business.UserBusiness;
import co.edu.uco.nose.Business.assembler.entity.impl.UserEntityAssembler;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.dao.factory.DAOFactory;


import java.util.List;
import java.util.UUID;

public final class UserBusinesImpl implements UserBusiness {

    private DAOFactory daoFactory;

    public UserBusinesImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void resgitresNewUserInformation(UserDomain userDomain) {
        var id = UUIDHelper.getUUIDHelper().genetareNewUUID();
        var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);

        userEntity.setId(id);

        daoFactory.getUserDAO().create(userEntity);
    }

    @Override
    public void dropUserInformation(UUID id) {

    }

    @Override
    public void updateUserInformation(UUID id, UserDomain userDomain) {

    }

    @Override
    public List<UserDomain> findAllUsers() {
        return List.of();
    }

    @Override
    public List<UserDomain> findAllUsersByDilters(UserDomain userFilters) {
        return List.of();
    }

    @Override
    public UserDomain findSpecificUser(UUID id) {
        return null;
    }

    @Override
    public void confirmMobileNumber(UUID id, int confirmationCode) {

    }

    @Override
    public void confirmEmail(UUID id, int confirmationCode) {

    }

    @Override
    public void sendMobileNumberConfirmation(UUID id) {

    }

    @Override
    public void sendEmailConfirmation(UUID id) {

    }
}
