package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.crosscuting.helper.MessageCatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.Entity.SqlConnection;
import co.edu.uco.nose.data.dao.Entity.UserDAO;
import co.edu.uco.nose.entity.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public final class UserSqlserverDAO extends SqlConnection implements UserDAO {

    public UserSqlserverDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(final UserEntity entity) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO proyecto_clase.usuario(id, tipoIdentificacion, numeroIdentificacion, primerNombre, segundoNombre," +
                "primerApellido, segundoApellido, ciudadResidencia, correoElectronico, numeroTelefonoMovil," +
                "correoElectronicoConfirmado, numeroTelefonoMovilConfirmado)");
        sql.append("VALUES ?,?,?,?,?,?,?,?,?,?,?,?");
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getIdType().getId());
            preparedStatement.setString(3, entity.getIdNumber());
            preparedStatement.setString(4, entity.getFirstName());
            preparedStatement.setString(5, entity.getSecondName());
            preparedStatement.setString(6, entity.getFirstSurname());
            preparedStatement.setString(7, entity.getSecondSurname());
            preparedStatement.setObject(8, entity.getCity().getId());
            preparedStatement.setString(9, entity.geteMail());
            preparedStatement.setString(10, entity.getMobileNumber());
            preparedStatement.setBoolean(11, entity.iseMailConfirmed());
            preparedStatement.setBoolean(12, entity.isMobileNumberConfirmed());

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
    public List<UserEntity> findAll() {
        return findByFilter(new UserEntity());
    }
    @Override
    public UserEntity findById(final UUID id) {
        return findByFilter(new UserEntity(id)).stream().findFirst().orElse((new UserEntity()));
    }

    @Override
    public void update(final UserEntity entity) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();

        sql.append("UPDATE  proyecto_clase.usuario ");
        sql.append("SET     tipoIdentificacion = ?,");
        sql.append("        numeroIdentificacion = ?,");
        sql.append("        primerNombre = ?,");
        sql.append("        segundoNombre = ?,");
        sql.append("        primerApellido = ?,");
        sql.append("        segundoApellido = ?,");
        sql.append("        ciudadResidencia = ?,");
        sql.append("        correoElectronico = ?,");
        sql.append("        numeroTelefonoMovil = ?,");
        sql.append("        correoElectronicoConfirmado = ?,");
        sql.append("        numeroTelefonoMovilConfirmado = ?");
        sql.append("WHERE   id = ?");


        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getIdType().getId());
            preparedStatement.setString(2, entity.getIdNumber());
            preparedStatement.setString(3, entity.getFirstName());
            preparedStatement.setString(4, entity.getSecondName());
            preparedStatement.setString(5, entity.getFirstSurname());
            preparedStatement.setString(6, entity.getSecondSurname());
            preparedStatement.setObject(7, entity.getCity().getId());
            preparedStatement.setString(8, entity.geteMail());
            preparedStatement.setString(9, entity.getMobileNumber());
            preparedStatement.setBoolean(10, entity.iseMailConfirmed());
            preparedStatement.setBoolean(11, entity.isMobileNumberConfirmed());
            preparedStatement.setObject(12, entity.getId());

            preparedStatement.executeUpdate();


        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UPDATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UPDATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_UPDATE.getContent();
            var technicalMessage = MessagesEnum.USER_ERROR_UNEXPECTED_UPDATE.getContent();
            throw NoseException.create(exception,userMessage,technicalMessage);
        }
    }

    @Override
    public void delete(final UUID id) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql= new StringBuilder();

        sql.append("DELETE FROM proyecto_clase.usuario ");
        sql.append("WHERE id=?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_DELETE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_DELETE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_DELETE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_DELETE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<UserEntity> findByFilter(final UserEntity filterEntity) {

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
            var userMessage = MessagesEnum.USER_ERROR_FIND_BY_FILTER_SQL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_BY_FILTER_SQL.getContent();
            throw NoseException.create(exception,userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }


    private String createSentenceFindByFilter(final UserEntity filterEntity, final List<Object> parametersList){

        final var sql = new StringBuilder();

        sql.append("SELECT ");
        sql.append("    u.id, ");
        sql.append("    ti.id     AS idTipoIdentificacion, ");
        sql.append("    ti.nombre AS nombretipoidentificacion, ");
        sql.append("    u.numeroIdentificacion, ");
        sql.append("    u.primerNombre, ");
        sql.append("    u.segundoNombre, ");
        sql.append("    u.primerApellido, ");
        sql.append("    u.segundoApellido, ");
        sql.append("    c.id      AS idCiudadResidencia, ");
        sql.append("    c.nombre  AS nombreCiudadResidencia, ");
        sql.append("    d.id      AS idDepartamentoCiudadResidencia, ");
        sql.append("    d.nombre  AS nombreDepartamentoCiudadResidencia, ");
        sql.append("    p.id      AS idPaisDepartamentoCiudadResidencia, ");
        sql.append("    p.nombre  AS nombrePaisDepartamentoCiudadResidencia, ");
        sql.append("    u.correoElectronico, ");
        sql.append("    u.numeroTelefonoMovil, ");
        sql.append("    u.correoElectronicoConfirmado, ");
        sql.append("    u.numeroTelefonoMovilConfirmado ");
        sql.append("FROM proyecto_clase.usuario AS u ");
        sql.append("INNER JOIN proyecto_clase.tipoIdentificacion AS ti ON u.tipoIdentificacion = ti.id ");
        sql.append("INNER JOIN proyecto_clase.ciudad AS c ON u.ciudadResidencia = c.id ");
        sql.append("INNER JOIN proyecto_clase.departamento AS d ON c.departamento = d.id ");
        sql.append("INNER JOIN proyecto_clase.pais AS p ON d.pais = p.id ");
        sql.append("WHERE u.id = ?;");

        createWhereClauseFindByFilter(sql,parametersList, filterEntity);

        return sql.toString();

    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList, final UserEntity filterEntity) {
        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new UserEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parametersList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "u.id = ?", filterEntityValidated.getId());

        addCondition(conditions, parametersList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getIdType().getId()),
                "u.tipoIdentificacion = ?", filterEntityValidated.getIdType().getId());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getIdNumber()),
                "u.numeroIdentificacion = ?", filterEntityValidated.getIdNumber());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getFirstName()),
                "u.primerNombre = ?", filterEntityValidated.getFirstName());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getSecondName()),
                "u.segundoNombre = ?", filterEntityValidated.getSecondName());

        addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getFirstSurname()),
                "u.primerApellido = ?", filterEntityValidated.getFirstSurname());

        addCondition(conditions, parametersList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getSecondSurname()),
                "u.segundoApellido = ?", filterEntityValidated.getSecondSurname());

        addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getCity().getId()),
                "u.ciudadResidencia = ?", filterEntityValidated.getCity().getId());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.geteMail()),
                "u.correoElectronico = ?", filterEntityValidated.geteMail());

        addCondition(conditions, parametersList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getMobileNumber()),
                "u.numeroTelefonoMovil = ?", filterEntityValidated.getMobileNumber());

        addCondition(conditions, parametersList,
                !filterEntityValidated.iseMailConfirmedDefaultValue(),
                "u.correoElectronicoConfirmado = ?", filterEntityValidated.iseMailConfirmedDefaultValue());

        addCondition(conditions, parametersList,
                !filterEntityValidated.isMobileNumberConfirmedDefaultValue(),
                "u.correoElectronicoConfirmado = ?", filterEntityValidated.isMobileNumberConfirmedDefaultValue());

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

    private List<UserEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement){

        var listUser = new ArrayList<UserEntity>();

        try (var resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){
                var idType = new IdTypeEntity();
                idType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idTipoIdentificacion")));
                idType.setName(resultSet.getString("nombreTipoIdentificacion"));

                var country = new CountryEntity();
                country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idPaisDepartamentoCiudadResidencia")));
                country.setName(resultSet.getString("nombrePaisDepartamentoCiudadResidencia"));

                var state = new StateEntity();
                state.setCountry(country);
                state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idDepartamentoCiudadResidencia")));
                state.setName(resultSet.getString("nombreDepartamentoCiudadResidencia"));

                var city = new CityEntity();
                city.setState(state);
                city.setId(UUIDHelper.getUUIDHelper().getFromString("idCiudadResidencia"));
                city.setName(resultSet.getString("nombreCiudadResidencia"));

                var user = new UserEntity();
                user.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                user.setIdType(idType);
                user.setFirstName(resultSet.getString("primerNombre"));
                user.setSecondName(resultSet.getString("segundoNombre"));
                user.setFirstSurname(resultSet.getString("primerApellido"));
                user.setSecondSurname(resultSet.getString("segundoApellido"));
                user.setCity(city);
                user.seteMail(resultSet.getString("correoElectronico"));
                user.setMobileNumber(resultSet.getString("numeroTelefonoMovil"));
                user.seteMailConfirmed(resultSet.getBoolean("correoElectronicoConfirmado"));
                user.setMobileNumberConfirmed(resultSet.getBoolean("numeroTelefonoMovilConfirmado"));

                listUser.add(user);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_FIND_BY_ID_SQL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_SQL.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_FIND_BY_ID_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
        return listUser;
    }
}
