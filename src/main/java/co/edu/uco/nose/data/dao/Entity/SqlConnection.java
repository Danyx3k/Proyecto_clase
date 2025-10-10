package co.edu.uco.nose.data.dao.Entity;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;

import java.sql.Connection;

public abstract class SqlConnection {

    private Connection connection;

    protected SqlConnection{
        setConnection(connection);
    }

    public Connection getConnection() {
        return connection;
    }

    private void setConnection(final Connection connection) {
        if (ObjectHelper.isNull(connection)){
            var userMessage = "";
            var technicalMessage = "";
            throw NoseException.create(null,null);
        }
        this.connection = connection;
    }
}
