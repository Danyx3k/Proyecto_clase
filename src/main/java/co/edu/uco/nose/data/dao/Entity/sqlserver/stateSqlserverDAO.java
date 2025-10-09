package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.data.dao.Entity.StateDAO;
import co.edu.uco.nose.entity.StateEntity;

import java.util.List;
import java.util.UUID;

public final class stateSqlserverDAO implements StateDAO {
    @Override
    public void create(StateEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<StateEntity> findAll() {
        return List.of();
    }

    @Override
    public List<StateEntity> findByFilter(StateEntity filterEntity) {
        return List.of();
    }

    @Override
    public StateEntity findById(UUID uuid) {
        return null;
    }

    @Override
    public void update(StateEntity entity) {

    }
}
