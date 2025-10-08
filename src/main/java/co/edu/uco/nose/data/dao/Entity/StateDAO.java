package co.edu.uco.nose.data.dao.Entity;

import co.edu.uco.nose.data.dao.CreateDAO;
import co.edu.uco.nose.data.dao.DeleteDAO;
import co.edu.uco.nose.data.dao.RetriveDAO;
import co.edu.uco.nose.data.dao.UpdateDAO;
import co.edu.uco.nose.entity.StateEntity;

import java.util.UUID;

public interface StateDAO
        extends CreateDAO<StateEntity>, RetriveDAO<StateEntity, UUID>, UpdateDAO<StateEntity>, DeleteDAO<UUID> {
}
