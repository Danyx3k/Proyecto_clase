package co.edu.uco.nose.crosscuting.helper.MessageCatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {

    USER_ERROR_SQL_CONNECTION_IS_EMPTY ("Conexión contra la fuente de información deseada vacia","La conexión contra la fuente de información deseada está vacia, por favor contacte al administrador"),
    TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY ("Conexión contra la fuente de información nula","Conexión contra la fuente de información de la base de datos llegó nula\",\"La conexión contra la fuente de información deseada está vacia, por favor contacte al administrador\");\n" +
            "    private String title;");
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
