package co.edu.uco.nose.data.dao.factory;

import co.edu.uco.nose.crosscuting.helper.MessageCatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.Entity.*;
import co.edu.uco.nose.data.dao.Entity.sqlserver.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class SqlServerDAOFactory extends DAOFactory{

    public SqlServerDAOFactory(){
        openConection();
    }

    @Override
    protected void openConection() {
        try {
            // Datos de conexión
            String url = "jdbc:postgresql://localhost:3333/proyecto_clase";
            String user = "postgres";
            String password = "Vanadi64";

            // Conexión
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conexión establecida correctamente a PostgreSQL");

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception,userMessage,technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public CityDAO getCityDAO() {
        return new CitySqlserverDAO(connection);
    }

    @Override
    public CountryDAO getCountryDAO() {
        return new CountySqlserverDAO(connection);
    }

    @Override
    public IdTypeDAO getIdTipeDAO() {
        return new IdTypeSqlserverDAO(connection);
    }

    @Override
    public StateDAO getStateDAO() {
        return new StateSqlserverDAO(connection);
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserSqlserverDAO(connection);
    }

}
