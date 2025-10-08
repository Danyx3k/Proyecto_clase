package co.edu.uco.nose.data.dao.Entity;

import co.edu.uco.nose.data.dao.CreateDAO;
import co.edu.uco.nose.data.dao.DeleteDAO;
import co.edu.uco.nose.data.dao.RetriveDAO;
import co.edu.uco.nose.data.dao.UpdateDAO;
import co.edu.uco.nose.entity.UserEntity;

import java.util.UUID;

public interface UserDAO
        extends CreateDAO<UserEntity>, RetriveDAO<UserEntity, UUID>, UpdateDAO<UserEntity>, DeleteDAO<UUID> {
}
