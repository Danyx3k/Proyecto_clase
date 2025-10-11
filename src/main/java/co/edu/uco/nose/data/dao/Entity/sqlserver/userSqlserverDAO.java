package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.Entity.SqlConnection;
import co.edu.uco.nose.data.dao.Entity.UserDAO;
import co.edu.uco.nose.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import static co.edu.uco.nose.crosscuting.helper.UUIDHelper.getUUIDHelper;

public final class userSqlserverDAO extends SqlConnection implements UserDAO {

    userSqlserverDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(final UserEntity entity) {
        final var sql = new StringBuilder();
        sql.append("INSERT INTO USER id, idType, idNumber, firstName, secondName,firstSurname, secondSurname, city, eMail, mobileNumber, eMailConfirmed, mobileNumberConfirmed");
        sql.append("SELECT ?,?,?,?,?,?,?,?,?,?,?,?");
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())){

            preparedStatement.setObject(1,entity.getId());
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
            var userMessage = "Se ha presentado un problema tratando de inertar un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
            var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }catch(final Exception exception) {
            var userMessage = "Se ha presentado un problema inesperado tratando de insertar un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
            var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
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
    public UserEntity findById(final UUID id) {
        var user = new UserEntity();
        final var sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  u.id, ");
        sql.append("  it.id   AS idTypeId, ");
        sql.append("  it.name AS idTypeName, ");
        sql.append("  u.idNumber, ");
        sql.append("  u.firstName, ");
        sql.append("  u.secondName, ");
        sql.append("  u.firstSurname, ");
        sql.append("  u.secondSurname, ");
        sql.append("  c.id    AS cityId, ");
        sql.append("  c.name  AS cityName, ");
        sql.append("  s.id    AS stateId, ");
        sql.append("  s.name  AS stateName, ");
        sql.append("  p.id    AS contryId, ");
        sql.append("  p.name  AS contryName, ");
        sql.append("  u.eMail, ");
        sql.append("  u.mobileNumber, ");
        sql.append("  u.eMailConfirmed, ");
        sql.append("  u.mobileNumberConfirmed ");
        sql.append("FROM user AS u ");
        sql.append("INNER JOIN IdType AS it ");
        sql.append("  ON u.idType = it.id ");
        sql.append("INNER JOIN City AS c ");
        sql.append("  ON u.city = c.id ");
        sql.append("INNER JOIN State AS s ");
        sql.append("  ON c.state = s.id ");
        sql.append("INNER JOIN Contry AS p ");
        sql.append("  ON s.contry = p.id;");
        sql.append("WHERE u.id = ?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, id);
            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Tipo de Identificacion
                    var idType =new IdTypeEntity();

                    var country = new CountryEntity();
                    country.setId(
                            getUUIDHelper().getFromString(
                                    resultSet.getString("CountryId")
                            )
                    );
                    country.setName(resultSet.getString("countryName"));

                    var state = new StateEntity();
                    state.setCountry(country);
                    state.setId(
                            getUUIDHelper().getFromString(
                                    resultSet.getString("StateId")
                            )
                    );
                    state.setName(resultSet.getString("StateName"));

                    var city = new CityEntity();
                    city.setId(
                            getUUIDHelper().getFromString(
                                    resultSet.getString("CityId")
                            )
                    );
                    city.setName(resultSet.getString("CityName"));

                    user.setId(getUUIDHelper().getFromString(resultSet.getString("id")));
                    user.setIdType(idType);
                    user.setFirstName(resultSet.getString("firstName"));
                    user.setSecondName(resultSet.getString("secondNAme"));
                    user.setFirstSurname(resultSet.getString("firstSurname"));
                    user.setSecondSurname(resultSet.getString("secondSurname"));
                    user.setCity(city);
                    user.seteMail(resultSet.getString("eMail"));
                    user.setMobileNumber(resultSet.getString("mobileNumber"));
                    user.seteMailConfirmed(resultSet.getBoolean("eMailConfirm"));
                    user.setMobileNumberConfirmed(resultSet.getBoolean("mobileNumberConfirm"));
                }

            }
        } catch (final SQLException exception) {
            var userMessage =
                    "Se ha presentado un problema tratando de consultar la información del usuario deseado. " +
                            "Por favor inténtelo de nuevo más tarde.";
            var technicalMessage =
                    "Se ha presentado un problema al tratar de ejecutar el proceso de consulta del usuario deseado. " +
                            exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage =
                    "Se ha presentado un problema INESPERADO tratando de consultar la información del usuario deseado. " +
                            "Por favor inténtelo de nuevo más tarde.";
            var technicalMessage =
                    "Se ha presentado un problema inesperado al tratar de ejecutar el proceso de consulta del usuario deseado. " +
                            exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return user;
    }

    @Override
    public void update(final UserEntity entity) {
        final var sql = new StringBuilder();
        sql.append("UPDATE USER SET idType = ?, idNumber = ?, firstName= ?, secondName= ?,firstSurname = ?, secondSurname = ?, city= ?, eMail= ?, mobileNumber= ?, eMailConfirmed= ?, mobileNumberConfirmed= ?");
        sql.append("WHERE id =?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.executeUpdate();


        } catch (final Exception exception) {
            var userMessage = "Se ha presentado un problema tratando de actualizar la información en la base de datos";
            var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar el Script de actualización, revise el log de errores";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(final UUID id) {
        final var sql= new StringBuilder();
        sql.append("DELETE FROM User ");
        sql.append("WHERE id=?");
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = "Se ha presentado un problema tratando de eliminar un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
            var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }catch(final Exception exception) {
            var userMessage = "Se ha presentado un problema inesperado tratando de eliminar un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema...";
            var technicalMessage = "Se ha presentado un problema inesperado al tratar de ejecutar " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
}
