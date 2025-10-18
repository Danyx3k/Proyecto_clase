package co.edu.uco.nose.Business.business.impl;

import co.edu.uco.nose.Business.Domain.UserDomain;
import co.edu.uco.nose.Business.business.UserBusiness;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public final class userBusinesImpl implements UserBusiness {

    private DAOFactory daoFactory;

    public userBusinesImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void resgitresNewUserInformation(UserDomain userDomain) {

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
}
