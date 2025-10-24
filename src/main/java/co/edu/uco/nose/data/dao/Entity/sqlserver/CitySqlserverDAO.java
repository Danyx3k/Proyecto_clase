package co.edu.uco.nose.data.dao.Entity.sqlserver;

import co.edu.uco.nose.crosscuting.helper.MessageCatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.Entity.CityDAO;
import co.edu.uco.nose.data.dao.Entity.SqlConnection;
import co.edu.uco.nose.entity.CityEntity;

import java.sql.Connection;
import java.sql.SQLException;
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
}
