package co.edu.uco.nose.Business.business;

import co.edu.uco.nose.Business.Domain.UserDomain;

import java.util.List;
import java.util.UUID;

public interface UserBusiness {

    void resgitresNewUserInformation(UserDomain userDomain);

    void dropUserInformation(UUID id);

    void updateUserInformation(UUID id, UserDomain userDomain);

    List<UserDomain> findAllUsers();

    List<UserDomain> findAllUsersByDilters(UserDomain userFilters);

    UserDomain findSpecificUser(UUID id);

    void confirmMobileNumber(UUID id, int confirmationCode);

    void confirmEmail(UUID id, int confirmationCode);

    void sendMobileNumberConfirmation(UUID id);

    void sendEmailConfirmation(UUID id);

}
