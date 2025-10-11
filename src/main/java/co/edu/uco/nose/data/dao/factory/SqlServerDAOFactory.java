package co.edu.uco.nose.data.dao.factory;

import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.Entity.*;
import co.edu.uco.nose.data.dao.Entity.sqlserver.*;

import java.sql.DriverManager;

public final class SqlServerDAOFactory extends DAOFactory{

    @Override
    protected void openConection() {
        try {
            this.connection = DriverManager.getConnection("");
        } catch (final Exception exception){
            var usserMessage = "";
            var technicalMassage = "";
            throw NoseException.create(exception, usserMessage, technicalMassage);
        }catch (final Exception exception){
            var usserMessage = "";
            var technicalMassage = "";
            throw NoseException.create(exception, usserMessage, technicalMassage);
        }
    }

    @Override
    public CityDAO getCityDAO() {
        return new citySqlserverDAO(connection);
    }

    @Override
    public CountryDAO getCountryDAO() {
        return new countySqlserverDAO(connection);
    }

    @Override
    public IdTypeDAO getIdTipeDAO() {
        return new idTypeSqlserverDAO(connection);
    }

    @Override
    public StateDAO getStateDAO() {
        return new stateSqlserverDAO(connection);
    }

    @Override
    public UserDAO getUserDAO() {
        return new userSqlserverDAO(connection);
    }


}
