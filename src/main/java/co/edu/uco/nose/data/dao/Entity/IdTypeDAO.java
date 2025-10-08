package co.edu.uco.nose.data.dao.Entity;

import co.edu.uco.nose.data.dao.CreateDAO;
import co.edu.uco.nose.data.dao.DeleteDAO;
import co.edu.uco.nose.data.dao.RetriveDAO;
import co.edu.uco.nose.data.dao.UpdateDAO;
import co.edu.uco.nose.entity.IdTypeEntity;

import java.util.UUID;

public interface IdTypeDAO
        extends CreateDAO<IdTypeEntity>, RetriveDAO<IdTypeEntity, UUID>, UpdateDAO<IdTypeEntity>, DeleteDAO<UUID> {
}
