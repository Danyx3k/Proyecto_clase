package co.edu.uco.nose.data.dao.factory;

import co.edu.uco.nose.crosscuting.helper.MessageCatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.Entity.*;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOFactory {

    protected Connection connection;
    protected static FactoryEnum factory = FactoryEnum.POSTGRESQL;

    public static DAOFactory getFactory(){
        switch (factory){
            case POSTGRESQL:{
                return new SqlServerDAOFactory();
            }
            default:
                var userMessage = MessagesEnum.USER_ERROR_DAO_FACTORY_NOT_INITIALIZED.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_FACTORY_NOT_INITIALIZED.getContent();
                throw NoseException.create(userMessage, technicalMessage);
        }
    }

    public abstract CityDAO getCityDAO();

    public abstract CountryDAO getCountryDAO();

    public abstract IdTypeDAO getIdTipeDAO();

    public abstract StateDAO getStateDAO();

    public abstract UserDAO getUserDAO();

    protected abstract void openConection();

    public void initTransaction(){

        SqlConnectionHelper.ensureTransactionIsNotStarted(connection);

        try {
            connection.setAutoCommit(false);
        }catch (final SQLException exception){
            var userMessage =MessagesEnum.USER_ERROR_TRANSACTION_IS_NOT_STARTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED.getContent();
            throw NoseException.create(exception, userMessage,technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    };

    public void commitTransaction(){

        SqlConnectionHelper.ensureTransactionIsStarted(connection);

        try {
            connection.commit();
        }catch (final SQLException exception){
            var userMessage = MessagesEnum.USER_ERROR_TRANSACTION_IS_STARTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_IS_STARTED.getContent();
            throw NoseException.create(exception, userMessage,technicalMessage);
        }catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    };

    public void rollbackTransaction(){

        SqlConnectionHelper.ensureTransactionIsStarted(connection);

        try {
            connection.rollback();
        }catch (final SQLException exception){
            var userMessage = "MessagesEnum.";
            var technicalMessage = "";
            throw NoseException.create(exception, userMessage,technicalMessage);
        }catch (final Exception exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

    };

    public void closeConection(){

        SqlConnectionHelper.ensureConnectionIsOpen(connection);

        try {
            connection.close();
        }catch (final SQLException exception){
            var userMessage =MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
            throw NoseException.create(exception, userMessage,technicalMessage);
        }catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            var technicalMessage =MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    };
}
