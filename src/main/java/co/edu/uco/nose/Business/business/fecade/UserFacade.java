package co.edu.uco.nose.Business.business.fecade;

import co.edu.uco.nose.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserFacade {

    void resgitresNewUserInformation(UserDTO userDomain);

    void dropUserInformation(UUID id);

    void updateUserInformation(UUID id, UserDTO userDTO);

    List<UserDTO> findAllUsers();

    List<UserDTO> findAllUsersByDilters(UserDTO userFilters);

    UserDTO findSpecificUser(UUID id);
}
