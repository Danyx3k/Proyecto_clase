package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.data.dao.Entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.Entity.SqlConnection;
import co.edu.uco.nose.entity.IdTypeEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public final class IdTypeSqlserverDAO extends SqlConnection implements IdTypeDAO {

    public IdTypeSqlserverDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(IdTypeEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<IdTypeEntity> findAll() {
        return List.of();
    }

    @Override
    public List<IdTypeEntity> findByFilter(IdTypeEntity filterEntity) {
        return List.of();
    }

    @Override
    public IdTypeEntity findById(UUID uuid) {
        return null;
    }

    @Override
    public void update(IdTypeEntity entity) {

    }
}
