package co.edu.uco.nose.data.dao.factory;

import co.edu.uco.nose.data.dao.Entity.*;

import java.sql.Connection;

public abstract class DAOFactory {

    protected Connection connection;

    public abstract CityDAO getCityDAO();

    public abstract CountryDAO getCountryDAO();

    public abstract IdTypeDAO getIdTipeDAO();

    public abstract StateDAO getStateDAO();

    public abstract UserDAO getUserDAO();

    protected abstract void openConection();

    protected void initTransaction(){

    };

    protected void commitTransaction(){

    };

    protected void rollbackTransaction(){

    };

    protected void closeConection(){

    };
}
