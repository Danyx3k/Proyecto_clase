package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.data.dao.Entity.CountryDAO;
import co.edu.uco.nose.entity.CountryEntity;

import java.util.List;
import java.util.UUID;

public final class countySqlserverDAO implements CountryDAO {
    @Override
    public void create(CountryEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<CountryEntity> findAll() {
        return List.of();
    }

    @Override
    public List<CountryEntity> findByFilter(CountryEntity filterEntity) {
        return List.of();
    }

    @Override
    public CountryEntity findById(UUID uuid) {
        return null;
    }

    @Override
    public void update(CountryEntity entity) {

    }
}
