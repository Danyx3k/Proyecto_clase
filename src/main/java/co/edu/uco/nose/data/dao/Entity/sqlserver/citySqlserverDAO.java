package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.data.dao.Entity.CityDAO;
import co.edu.uco.nose.entity.CityEntity;

import java.util.List;
import java.util.UUID;

public final class citySqlserverDAO implements CityDAO {


    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<CityEntity> findAll() {
        return List.of();
    }

    @Override
    public List<CityEntity> findByFilter(CityEntity filterEntity) {
        return List.of();
    }

    @Override
    public CityEntity findById(UUID uuid) {
        return null;
    }

    @Override
    public void update(CityEntity entity) {

    }
}
