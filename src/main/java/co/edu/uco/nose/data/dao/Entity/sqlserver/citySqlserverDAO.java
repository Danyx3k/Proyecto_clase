package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.data.dao.Entity.CityDAO;
import co.edu.uco.nose.data.dao.Entity.SqlConnection;
import co.edu.uco.nose.entity.CityEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public final class citySqlserverDAO extends SqlConnection implements CityDAO {

    public CitySqlServerDAO(final Connection connection){
        super(connection);
    }


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
