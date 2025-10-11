import co.edu.uco.nose.crosscuting.helper.MessageCatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

protected void openConnectionWithDataSource(final String host,
                                            final int port,
                                            final String database,
                                            final String user,
                                            final String password,
                                            final boolean trustServerCertificate) {
    try {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName(host);
        ds.setPortNumber(port);
        ds.setDatabaseName(database);
        ds.setTrustServerCertificate(trustServerCertificate);
        // Si usas autenticación SQL:
        ds.setUser("Dany");
        ds.setPassword("Vanadi64");

        this.connection = ds.getConnection();

        if (connection.isClosed()) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
            throw NoseException.create(userMessage, technicalMessage);
        }
    } catch (final SQLException exception) {
        var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_NOT_STARTED.getContent();
        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_NOT_STARTED.getContent();
        throw NoseException.create(exception, userMessage, technicalMessage);
    } catch (final Exception exception) {
        var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
        throw NoseException.create(exception, userMessage, technicalMessage);
    }
}
private Connection connection;

void main() {
}

