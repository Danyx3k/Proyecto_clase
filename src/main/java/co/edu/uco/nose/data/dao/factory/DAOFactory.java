package co.edu.uco.nose.data.dao.factory;

import co.edu.uco.nose.crosscuting.helper.MessageCatalog.MessagesEnum;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.data.dao.Entity.*;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOFactory {

    protected Connection connection;
    protected static FactoryEnum factory = FactoryEnum.SQLSERVER;

    public static DAOFactory getFactory(){
        switch (factory){
            case SQLSERVER:{
                return new SqlServerDAOFactory();
            }
            default:
                var userMessage = "Factoria no iniciada";
                var technicalMessage = "Factoria no valida";
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

        try {
            connection.setAutoCommit(false);
        }catch (final SQLException exception){
            var userMessage ="";
            var technicalMessage = "";
            throw NoseException.create(exception, userMessage,technicalMessage);
        }
    };

    public void commitTransaction(){
        try {
            connection.setAutoCommit(false);
        }catch (final SQLException exception){
            var userMessage ="";
            var technicalMessage = "";
            throw NoseException.create(exception, userMessage,technicalMessage);
        }


    };

    public void rollbackTransaction(){
        try {
            connection.rollback();
        }catch (final SQLException exception){
            var userMessage ="";
            var technicalMessage = "";
            throw NoseException.create(exception, userMessage,technicalMessage);
        }

    };

    public void closeConection(){
        try {
            connection.close();
        }catch (final SQLException exception){
            var userMessage ="";
            var technicalMessage = "";
            throw NoseException.create(userMessage,technicalMessage);
        }
    };
}
