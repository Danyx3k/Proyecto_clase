package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.crosscuting.helper.MessageCatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.Entity.SqlConnection;
import co.edu.uco.nose.data.dao.Entity.StateDAO;
import co.edu.uco.nose.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class StateSqlserverDAO extends SqlConnection implements StateDAO {

    public StateSqlserverDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(StateEntity entity) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO proyecto_clase.departamento(" +
                "id, pais, nombre)");
        sql.append("VALUES ?,?,?");
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getCountry().getId());
            preparedStatement.setString(3, entity.getName());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CREATE_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CREATE_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_CREATE_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_CREATE_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(UUID id) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql= new StringBuilder();

        sql.append("DELETE FROM proyecto_clase.departamento ");
        sql.append("WHERE id = ?;");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_DELETE_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_DELETE_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_DELETE_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_DELETE_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<StateEntity> findAll() {
        return findByFilter(new StateEntity());
    }

    @Override
    public List<StateEntity> findByFilter(StateEntity filterEntity) {

        var parametersList = new ArrayList<Object>();
        var sql = createSentenceFindByFilter(filterEntity, parametersList);

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {

            for (int index = 0; index < parametersList.size(); index++) {
                preparedStatement.setObject(index + 1, parametersList.get(index));
            }
            return executeSentenceFindByFilter(preparedStatement);

        } catch (final NoseException exception) {
            throw exception;
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_FIND_BY_FILTER_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_FIND_BY_FILTER_STATE.getContent();
            throw NoseException.create(exception,userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_FIND_BY_FILTER_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_FIND_BY_FILTER_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public StateEntity findById(UUID id) {
        return findByFilter(new StateEntity(id)).stream().findFirst().orElse(new StateEntity());
    }

    @Override
    public void update(StateEntity entity) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("UPDATE proyecto_clase.departamento");
        sql.append("SET pais = ? ,");
        sql.append("nombre  = ?");
        sql.append("WHERE id = ?;");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())){

            preparedStatement.setObject(1, entity.getCountry().getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setObject(3, entity.getId());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UPDATE_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UPDATE_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_UPDATE_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_UPDATE_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter(final StateEntity filterEntity, final List<Object> parametersList){

        final var sql = new StringBuilder();

        sql.append("SELECT ");
        sql.append("    p.nombre AS nombre_pais, ");
        sql.append("    d.id AS id_departamento, ");
        sql.append("    d.nombre AS nombre_departamento ");
        sql.append("FROM proyecto_clase.Pais p ");
        sql.append("INNER JOIN proyecto_clase.Departamento d ON d.id = p.id; ");
        sql.append("WHERE d.id = ?;");

        createWhereClauseFindByFilter(sql,parametersList, filterEntity);

        return sql.toString();

    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList, final StateEntity filterEntity) {
        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new StateEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parametersList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "d.id = ?", filterEntityValidated.getId());

        addCondition(conditions, parametersList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getCountry().getId()),
                "p.nombre = ?", filterEntityValidated.getCountry().getId());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                "u.nombre = ?", filterEntityValidated.getName());

        if (!conditions.isEmpty()){
            sql.append("WHERE");
            sql.append((String.join(" AND ", conditions)));
        }

    }

    private void addCondition(final List<String> conditions, final List<Object> parametersList,
                              final boolean condition, final String clause, final Object value) {
        if (condition) {
            conditions.add(clause);
            parametersList.add(value);
        }
    }

    private List<StateEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement){

        var listState = new ArrayList<StateEntity>();

        try (var resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){

                var country = new CountryEntity();
                country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id_Pais")));
                country.setName(resultSet.getString("nombre_pais"));

                var state = new StateEntity();
                state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                state.setCountry(country);
                state.setName(resultSet.getString("nombre"));

                listState.add(state);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_EXECUTE_SENTENCE_CREATE_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_EXECUTE_SENTENCE_CREATE_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
        return listState;
    }


}
