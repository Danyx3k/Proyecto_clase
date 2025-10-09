package co.edu.uco.nose.data.dao.Entity;

import co.edu.uco.nose.data.dao.CreateDAO;
import co.edu.uco.nose.data.dao.DeleteDAO;
import co.edu.uco.nose.data.dao.RetriveDAO;
import co.edu.uco.nose.data.dao.UpdateDAO;
import co.edu.uco.nose.entity.CountryEntity;


import java.util.UUID;

public interface CountryDAO
        extends CreateDAO<CountryEntity>, RetriveDAO<CountryEntity, UUID>, UpdateDAO<CountryEntity>, DeleteDAO<UUID> {
}
