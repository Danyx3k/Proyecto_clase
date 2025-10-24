package co.edu.uco.nose.data.dao.Entity;


import co.edu.uco.nose.data.dao.DeleteDAO;
import co.edu.uco.nose.data.dao.RetriveDAO;
import co.edu.uco.nose.data.dao.UpdateDAO;
import co.edu.uco.nose.entity.CityEntity;


import java.util.UUID;

public interface CityDAO
        extends RetriveDAO<CityEntity, UUID>, UpdateDAO<CityEntity>, DeleteDAO<UUID> {
}
