package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.crosscuting.helper.MessageCatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.Entity.CountryDAO;
import co.edu.uco.nose.data.dao.Entity.SqlConnection;
import co.edu.uco.nose.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
            var userMessage = MessagesEnum.USER_ERROR_SQL_CREATE_COUNTRY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CREATE_COUNTRY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_CREATE_COUNTRY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_CREATE_COUNTRY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(final UUID id) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql= new StringBuilder();

        sql.append("DELETE FROM proyecto_clase.pais ");
        sql.append("WHERE id = ?;");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_DELETE_COUNTRY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_DELETE_COUNTRY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_DELETE_COUNTRY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_DELETE_COUNTRY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

    }

    @Override
    public List<CountryEntity> findAll() {
        return findByFilter(new CountryEntity());
    }

    @Override
    public List<CountryEntity> findByFilter(final CountryEntity filterEntity) {

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
            var userMessage = MessagesEnum.USER_ERROR_SQL_FIND_BY_FILTER_COUNTRY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_FIND_BY_FILTER_COUNTRY.getContent();
            throw NoseException.create(exception,userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_FIND_BY_FILTER_COUNTRY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_FIND_BY_FILTER_COUNTRY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public CountryEntity findById(final UUID id) {
        return findByFilter(new CountryEntity(id)).stream().findFirst().orElse(new CountryEntity());
    }

    @Override
    public void update(final CountryEntity entity) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("UPDATE proyecto_clase.pais");
        sql.append("SET nombre=?");
        sql.append("WHERE id = ?;");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())){

            preparedStatement.setString(1, entity.getName());
            preparedStatement.setObject(2, entity.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UPDATE_COUNTRY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UPDATE_COUNTRY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_UPDATE_COUNTRY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_UPDATE_COUNTRY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

    }

    private String createSentenceFindByFilter(final CountryEntity filterEntity, final List<Object> parametersList){

        final var sql = new StringBuilder();

        sql.append("SELECT ");
        sql.append("   id, nombre");
        sql.append("FROM proyecto_clase.pais");

        createWhereClauseFindByFilter(sql,parametersList, filterEntity);

        return sql.toString();

    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList, final CountryEntity filterEntity) {
        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new CountryEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parametersList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "id = ?", filterEntityValidated.getId());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                "Nombre = ?", filterEntityValidated.getName());

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

    private List<CountryEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement){

        var listCountry = new ArrayList<CountryEntity>();

        try (var resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){

                var country = new CountryEntity();
                country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                country.setName(resultSet.getString("Nombre"));

                listCountry.add(country);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_EXECUTE_SENTENCE_CREATE_COUNTRY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_EXECUTE_SENTENCE_CREATE_COUNTRY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_COUNTRY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_COUNTRY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
        return listCountry;
    }
}
