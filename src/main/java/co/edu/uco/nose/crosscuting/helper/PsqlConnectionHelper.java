package co.edu.uco.nose.crosscuting.helper;

import co.com.ph.capacitaciones.crosscuting.helper.excption.TrainingException;
import co.com.ph.capacitaciones.crosscuting.messagecatalog.MessagesEnum;
import org.postgresql.util.PSQLException;

import java.sql.Connection;

public final class PsqlConnectionHelper {

    private static void ensuerConnectionIsNotNull(final Connection connection){
        if (ObjectHelper.isNull(connection)){
            var userMessage = MessagesEnum.USER_ERROR_POSTGRESQL_CONNECTION_IS_EMPTY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_POSTGRESQL_CONNECTION_IS_EMPTY.getContent();
            throw TrainingException.create(userMessage,technicalMessage);
        }
    }


    public static void  ensureConnectionIsOpen(final Connection connection) {

        ensuerConnectionIsNotNull(connection);

        try {
            if (connection.isClosed()) {
                var userMessage = MessagesEnum.USER_ERROR_POSTGRESQL_CONNECTION_IS_CLOSED.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_POSTGRESQL_CONNECTION_IS_CLOSED.getContent();
                throw TrainingException.create(userMessage, technicalMessage);
            }
        } catch (final PSQLException exception){
            var userMassage = MessagesEnum.USER_ERROR_POSTGRESQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_POSTGRESQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw TrainingException.create(exception,userMassage,technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesEnum.TECHNICAL_ERROR_POSTGRESQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            var technicalMessge = MessagesEnum.TECHNICAL_ERROR_POSTGRESQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw TrainingException.create(exception, userMessage, technicalMessge);
        }
    }

    public static void ensureConnectionIsStarted(final Connection connection){
        ensureConnectionIsOpen(connection);

        try {
        if (connection.getAutoCommit()) { //auto commit,
            var userMessage = MessagesEnum.USER_ERROR_POSTGRESQL_TRANSACTION_NOT_STARTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_POSTGRESQL_TRANSACTION_NOT_STARTED.getContent();
            throw TrainingException.create(userMessage, technicalMessage);
        }
    } catch (final PSQLException exception) {
        var userMessage = MessagesEnum.USER_ERROR_POSTGRESQL_TRANSACTION_NOT_STARTED
                .getContent();
        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_POSTGRESQL_TRANSACTION_NOT_STARTED
                .getContent();
        throw TrainingException.create(exception, userMessage, technicalMessage);

    } catch (final Exception exception) {
        var userMessage = MessagesEnum.USER_ERROR_POSTGRESQL_TRANSACTION_NOT_STARTED
                .getContent();
        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_POSTGRESQL_TRANSACTION_NOT_STARTED
                .getContent();
        throw TrainingException.create(exception, userMessage, technicalMessage);
    }
}

public static void ensureTransactionIsNotStarted(final Connection connection) {

    ensureConnectionIsOpen(connection);

    try {
        if (!connection.getAutoCommit()) {
            var userMessage = MessagesEnum.USER_ERROR_POSTGRESQL_TRANSACTION_STATUS_UNKNOWN.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_POSTGRESQL_TRANSACTION_STATUS_UNKNOWN.getContent();
            throw TrainingException.create(userMessage, technicalMessage);
        }
    } catch (final PSQLException exception) {
        var userMessage = MessagesEnum.USER_ERROR_POSTGRESQL_TRANSACTION_STATUS_UNKNOWN.getContent();
        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_POSTGRESQL_TRANSACTION_STATUS_UNKNOWN.getContent();
        throw TrainingException.create(exception, userMessage, technicalMessage);

    } catch (final Exception exception) {
        var userMessage = MessagesEnum.USER_ERROR_POSTGRESQL_TRANSACTION_NOT_STARTED.getContent();
        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_POSTGRESQL_TRANSACTION_NOT_STARTED.getContent();
        throw TrainingException.create(exception, userMessage, technicalMessage);
    }
}
}