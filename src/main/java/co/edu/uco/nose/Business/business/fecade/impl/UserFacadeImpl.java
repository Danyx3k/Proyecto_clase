package co.edu.uco.nose.Business.business.fecade.impl;

import co.edu.uco.nose.Business.assembler.dto.impl.UserDTOAssembler;
import co.edu.uco.nose.Business.business.UserBusiness;
import co.edu.uco.nose.Business.business.fecade.UserFacade;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public final class UserFacadeImpl implements UserFacade {

    @Override
    public void resgitresNewUserInformation(final UserDTO userDomain) {

        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();

            var domain = UserDTOAssembler.getUserDTOAssembler().toDomain(UserDTO);
            business.registerNewUserInformation(domain);

            daoFactory.commitTransaction();
        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var UserMgs ="";
            var TechMsg = "";
            throw NoseException.create(Exception,UserMgs,TechMsg);

        } finally {
            daoFactory.closeConection();
        }

    }

    @Override
    public void dropUserInformation(UUID id) {

    }

    @Override
    public void updateUserInformation(UUID id, UserDTO userDTO) {

    }

    @Override
    public List<UserDTO> findAllUsers() {
        return List.of();
    }

    @Override
    public List<UserDTO> findAllUsersByDilters(UserDTO userFilters) {
        return List.of();
    }

    @Override
    public UserDTO findSpecificUser(UUID id) {
        return null;
    }
}
