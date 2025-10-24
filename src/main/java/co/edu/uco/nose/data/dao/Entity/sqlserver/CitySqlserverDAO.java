package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.crosscuting.helper.MessageCatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.Entity.CityDAO;
import co.edu.uco.nose.data.dao.Entity.SqlConnection;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.StateEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class CitySqlserverDAO extends SqlConnection implements CityDAO {


    public CitySqlserverDAO(final Connection connection) {
        super(connection);
    }


    @Override
    public void delete(UUID id) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql= new StringBuilder();

        sql.append("DELETE FROM proyecto_clase.ciudad");
        sql.append("WHERE id = ?;");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_DELETE_CITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_DELETE_CITY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_DELETE_CITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_DELETE_CITY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

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

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();

        sql.append("UPDATE  proyecto_clase.usuario ");
        sql.append("SET     departamento = ?, nombre = ?,");
        sql.append("WHERE   id = ?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getState().getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setObject(12, entity.getId());

            preparedStatement.executeUpdate();


        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UPDATE_CITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UPDATE_CITY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_UPDATE_CITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_UPDATE_CITY.getContent();
            throw NoseException.create(exception,userMessage,technicalMessage);
        }
    }

    private String createSentenceFindByFilter(final CityEntity filterEntity, final List<Object> parametersList){

        final var sql = new StringBuilder();

        sql.append("SELECT ");
        sql.append("     p.id        AS id_pais, ");
        sql.append("     p.nombre    AS nombre_pais, ");
        sql.append("     d.id        AS id_departamento, ");
        sql.append("     d.nombre    AS nombre_departamento,");
        sql.append("     c.id        AS id_ciudad,");
        sql.append("     c.nombre    AS nombre_ciudad");

        sql.append("FROM proyecto_clase.Pais p ");
        sql.append("INNER JOIN proyecto_clase.Departamento d ON d.id = p.id ");
        sql.append("INNER JOIN proyecto_clase.Ciudad c ON c.id = d.id ");
        sql.append("WHERE d.id = ?;");

        createWhereClauseFindByFilter(sql,parametersList, filterEntity);

        return sql.toString();

    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList, final CityEntity filterEntity) {
        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new CityEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parametersList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "c.id = ?", filterEntityValidated.getId());

        addCondition(conditions, parametersList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getState().getId()),
                "d.nombre = ?", filterEntityValidated.getState().getId());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                "c.nombre = ?", filterEntityValidated.getName());

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

    private List<CityEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement){

        var listCity = new ArrayList<CityEntity>();

        try (var resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){

                var state = new StateEntity();
                state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id_departamento")));
                state.setName(resultSet.getString("nombre_departamento"));

                var city = new CityEntity();
                city.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                city.setState(state);
                city.setName(resultSet.getString("nombre"));

                listCity.add(city);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_EXECUTE_SENTENCE_CREATE_CITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_EXECUTE_SENTENCE_CREATE_CITY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_CITY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_CITY.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
        return listCity;
    }
}
