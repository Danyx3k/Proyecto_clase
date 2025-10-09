package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.data.dao.Entity.UserDAO;
import co.edu.uco.nose.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public final class userSqlserverDAO implements UserDAO {
    @Override
    public void create(UserEntity entity) {

    }

    @Override
    public List<UserEntity> findAll() {
        return List.of();
    }

    @Override
    public List<UserEntity> findByFilter(UserEntity filterEntity) {
        return List.of();
    }

    @Override
    public UserEntity findById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UserEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

}
