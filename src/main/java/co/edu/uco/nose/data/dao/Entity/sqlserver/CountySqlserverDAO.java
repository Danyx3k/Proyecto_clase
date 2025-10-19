package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.data.dao.Entity.CountryDAO;
import co.edu.uco.nose.data.dao.Entity.SqlConnection;
import co.edu.uco.nose.entity.CountryEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public final class CountySqlserverDAO extends SqlConnection implements CountryDAO {

    public CountySqlserverDAO(final Connection connection) {
        super(connection);
    }

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
