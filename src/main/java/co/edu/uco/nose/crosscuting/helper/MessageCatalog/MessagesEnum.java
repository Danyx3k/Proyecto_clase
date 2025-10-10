package co.edu.uco.nose.crosscuting.helper.MessageCatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {

    USER_ERROR_SQL_CONNECTION_IS_EMPTY ("Conexión contra la fuente de información deseada vacia","La conexión contra la fuente de información deseada está vacia, por favor contacte al administrador."),
    TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY ("Conexión contra la fuente de información deseada nula","la conexión requerida para llevar a cabo la operación contra la base de datos llego nula."),
    USER_ERROR_SQL_CONNECTION_IS_CLOSED ("Conexión contra la fuente de información deseada cerrada","La conexión contra la fuente de información deseada está cerrada, por favor contacte al administrador."),
    TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED ("Conexión contra la fuente de información deseada cerrada","Problema inesperado, validando el estado de la conexión contra la fuente de datos deseada"),
    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado, validando el estado de la conexión contra la fuente de datos deseada","Se ha presentado un problema inesperado tratando de validar la operación contra la fuente de información deseada.Intente de nuevo y si el problema persisite contacte al administrador de la aplicación"),
    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS ("Error inesperado, validando si la conexión contra la base de datos está abierta","Se presentó un error de tipo SQLException validar si la conexión contra la base de datos estaba o no abierta. POr favor valide la consola de errores para validar con detalle el problema presentado");

    private String title;
    private String content;

    private MessagesEnum(final String title, final String content) {
        setTitle(title);
        setContent(content);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = TextHelper.getDefaultwithTrim(title);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = TextHelper.getDefaultwithTrim(content);
    }
}
