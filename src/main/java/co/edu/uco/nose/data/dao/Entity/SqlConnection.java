package co.edu.uco.nose.data.dao.Entity;

import co.edu.uco.nose.crosscuting.helper.MessageCatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class SqlConnection {

    private Connection connection;


protected SqlConnection(final Connection connection) {
    setConnection(connection);
}

protected Connection getConnection() {
    return connection;
}

private void setConnection(final Connection connection) {
    if (ObjectHelper.isNull(connection)){
        var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
        throw NoseException.create(userMessage,technicalMessage);
    }try {
        if (connection.isClosed()){
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
            throw NoseException.create(userMessage,technicalMessage);

        }
    } catch (final SQLException exception){
        var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
        throw NoseException.create(exception,userMessage,technicalMessage);
    }

    this.connection = connection;
}

    protected final boolean isTransactionActive() {
        try {
            return !getConnection().getAutoCommit();
        } catch (SQLException ex) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_STATUS_UNKNOWN.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_STATUS_UNKNOWN.getContent();
            throw NoseException.create(ex, userMessage, technicalMessage);
        }
    }
    /**
     * Lanza NoseException si NO hay transacción activa.
     * Se usa ntes de cualquier operación DML (INSERT/UPDATE/DELETE).
     */
    protected final void assertTransactionActiveOrThrow() {
        if (!isTransactionActive()) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_NOT_STARTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_NOT_STARTED.getContent();
            throw NoseException.create(userMessage, technicalMessage);
        }
    }
}