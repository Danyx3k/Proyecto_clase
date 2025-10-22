package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.crosscuting.helper.MessageCatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.Entity.CountryDAO;
import co.edu.uco.nose.data.dao.Entity.SqlConnection;
import co.edu.uco.nose.entity.CountryEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public final class CountySqlserverDAO extends SqlConnection implements CountryDAO {

    public CountySqlserverDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(CountryEntity entity) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO proyecto_clase.pais(" +
                "id, nombre)");
        sql.append("VALUES (?, ?);");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())){

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getName());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CREATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CREATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_CREATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_CREATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
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
