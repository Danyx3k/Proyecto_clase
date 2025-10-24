package co.edu.uco.nose.crosscuting.helper.MessageCatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
    USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada vacia",
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está vacia. "
                    + "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),

    TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada nula",
            "La conexion requerida para llevar a cabo la operacion contra la base de datos llegó nula."
                    + "Por favor intenta de nuevo y si el problema persiste, contacte al administrador de la aplicación"),

    USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada",
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está cerrada. "
                    + "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),

    TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada",
            "La conexion requerida para llevar a cabo la operacion contra la base de datos llegó cerrada."
                    + "Por favor intenta de nuevo y si el problema persiste, contacte al administrador de la aplicación"),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado contra la fuente de informacion deseada vacia",
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está vacia. "
                    + "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),

    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS("Problema inesperado contra la fuente de informacion deseada vacia" ,
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está vacia."
                    + "Por favor intenta de nuevo y si el problema persiste, contacte al administrador de la aplicación"),

    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error técnico inesperado al validar el estado de la conexión",
            "Se presentó un error técnico inesperado al intentar validar el estado de la conexión contra la base de datos. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación"),

    USER_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción no iniciada",
            "La operación no puede completarse porque la transacción requerida no ha sido iniciada. "
                    + "Por favor inicie la transacción e intente nuevamente. Si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción no iniciada en la base de datos",
            "La operación no puede completarse porque la transacción requerida no fue iniciada correctamente en la base de datos. "
                    + "Por favor revise la lógica de inicio de transacciones y si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_TRANSACTION_IS_STARTED("Transacción no iniciada",
            "La operación no puede completarse porque la transacción requerida no ha sido iniciada. "
                    + "Por favor inicie la transacción e intente nuevamente. Si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_TRANSACTION_IS_STARTED("Transacción no iniciada en la base de datos",
            "La operación no puede completarse porque la transacción requerida no fue iniciada correctamente en la base de datos. "
                    + "Por favor revise la lógica de inicio de transacciones y si el problema persiste, contacte al administrador de la aplicación."),


    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inesperado al validar el inicio de la transacción",
            "Se presentó un problema inesperado al validar el estado de la transacción. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED("Error SQL al validar el inicio de la transacción",
            "Se produjo una excepción SQL al intentar validar el estado de la transacción. "
                    + "Por favor revise la conexión con la base de datos y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error técnico inesperado al validar el inicio de la transacción",
            "Se presentó un error técnico inesperado al intentar validar el estado de la transacción. "
                    + "Por favor revise los registros del sistema y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error SQL al validar que la transacción no ha sido iniciada",
            "Se produjo una excepción SQL al intentar validar que la transacción no fue iniciada. "
                    + "Por favor revise la conexión con la base de datos y si el problema persiste, contacte al administrador de la aplicación."
    ),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado al validar que la transacción no ha sido iniciada",
            "Se presentó un problema inesperado al validar que la transacción no ha sido iniciada. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."
    ),
    USER_ERROR_DAO_FACTORY_NOT_INITIALIZED(
            "Fábrica de base de datos no inicializada",
            "No se ha podido establecer una conexión porque la fábrica de base de datos requerida no ha sido inicializada correctamente. "
                    + "Por favor revise la configuración y vuelva a intentarlo."
    ),

    TECHNICAL_ERROR_DAO_FACTORY_NOT_INITIALIZED(
            "Fábrica DAO no válida o no configurada",
            "El valor del enumerador 'factory' no corresponde a un tipo de base de datos soportado o no ha sido inicializado correctamente. "
                    + "Verifique la configuración del método getFactory() y la asignación del tipo de fábrica."
    ),

    USER_ERROR_SQL_CREATE("No se pudo crear el usuario.",
            "Se ha presentado un error al intentar crear el usuario en la base de datos. Por favor verifique la traza completa del error."),

    TECHNICAL_ERROR_SQL_CREATE("Se ha presentado un error al intentar crear el usuario en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al ejecutar la sentencia SQL para crear el usuario."),

    USER_ERROR_UNEXPECTED_CREATE("No se pudo crear el usuario.",
            "Se ha presentado un error inesperado al intentar crear el usuario en la base de datos. Por favor verifique la traza completa del error."),

    TECHNICAL_ERROR_UNEXPECTED_CREATE("Se ha presentado un error inesperado al intentar crear el usuario en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al crear el usuario en la base de datos."),

    USER_ERROR_CRITICAL_CREATE("No se pudo crear el usuario.",
            "Se ha presentado un error crítico al intentar crear el usuario en la base de datos. Por favor verifique la traza completa del error."),

    TECHNICAL_ERROR_CRITICAL_CREATE("Se ha presentado un error crítico al intentar crear el usuario en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar crear el usuario en la base de datos."),

    USER_ERROR_FIND_BY_ID_SQL("No fue posible consultar la información solicitada",
            "Se presentó un problema con la base de datos al intentar obtener la información. "
                    + "Por favor intente nuevamente más tarde."),

    TECHNICAL_ERROR_FIND_BY_ID_SQL("Error técnico SQL al consultar por ID",
            "Ocurrió una SQLException al intentar realizar la consulta por ID en la base de datos. "
                    + "Verifique la conexión, el script SQL o los parámetros enviados."),

    USER_ERROR_FIND_BY_ID_UNEXPECTED("No fue posible completar la operación",
            "Ocurrió un error inesperado al intentar obtener la información solicitada. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador."),

    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED("Error técnico inesperado al consultar por ID",
            "Se presentó una excepción inesperada al intentar consultar la información por ID en la base de datos. "
                    + "Revise los registros del sistema y contacte al administrador."),

    USER_ERROR_FIND_BY_ID_CRITICAL("Error crítico al consultar la información solicitada",
            "Ocurrió un fallo crítico en el sistema al intentar realizar la consulta. "
                    + "Por favor contacte al administrador del sistema de inmediato."),

    TECHNICAL_ERROR_FIND_BY_ID_CRITICAL("Error técnico crítico al consultar por ID",
            "Se presentó un error grave al intentar ejecutar la operación de consulta por ID. "
                    + "Verifique la infraestructura de base de datos o el entorno de ejecución."),

    USER_ERROR_FIND_ALL_SQL("No fue posible obtener la lista de usuarios.",
            "Se presentó un error SQL al intentar ejecutar la consulta para obtener todos los registros de usuario."),

    TECHNICAL_ERROR_FIND_ALL_SQL("Error técnico al ejecutar la consulta SQL de findAll en UserPostgresqlDAO.",
            "Ocurrió un problema en la sentencia SQL o en la conexión al intentar listar los usuarios."),

    USER_ERROR_FIND_ALL_UNEXPECTED("Ocurrió un error inesperado al intentar obtener la lista de usuarios.",
            "Se detectó un error no controlado en el método findAll de UserPostgresqlDAO."),

    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED("Error técnico inesperado en findAll.",
            "Excepción general no esperada en el proceso de obtención de todos los usuarios."),

    USER_ERROR_FIND_ALL_CRITICAL("Error crítico al intentar consultar todos los usuarios.",
            "Se presentó un error severo o irrecuperable durante la ejecución del método findAll en UserPostgresqlDAO."),

    TECHNICAL_ERROR_FIND_ALL_CRITICAL("Error técnico crítico en findAll.",
            "Excepción tipo Throwable capturada en el proceso de lectura de usuarios."),

    USER_ERROR_FIND_BY_FILTER_SQL("No fue posible obtener los usuarios según el filtro indicado.",
            "Se presentó un error SQL al ejecutar la consulta filtrada en la base de datos."),

    TECHNICAL_ERROR_FIND_BY_FILTER_SQL("Error técnico al ejecutar la sentencia SQL de findByFilter en UserPostgresqlDAO.",
            "Error en la ejecución del PreparedStatement o en el acceso al ResultSet al aplicar filtros."),

    USER_ERROR_FIND_BY_FILTER_UNEXPECTED("Ocurrió un error inesperado al intentar filtrar los usuarios.",
            "Se detectó un error no controlado en el método findByFilter de UserPostgresqlDAO."),

    TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED("Error técnico inesperado en findByFilter.",
            "Excepción general no esperada durante la ejecución del método findByFilter en UserPostgresqlDAO."),

    USER_ERROR_FIND_BY_FILTER_CRITICAL("Error crítico al intentar filtrar los usuarios.",
            "Se presentó un error severo o irrecuperable durante la ejecución del método findByFilter en UserPostgresqlDAO."),

    TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL("Error técnico crítico en findByFilter.",
            "Excepción tipo Throwable capturada en el proceso de filtrado de usuarios."),

    USER_ERROR_SQL_UPDATE("No se pudo actualizar el usuario.",
            "Se ha presentado un error al intentar actualizar el usuario en la base de datos. Por favor verifique la traza completa del error."),

    TECHNICAL_ERROR_SQL_UPDATE("Se ha presentado un error al intentar actualizar el usuario en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al ejecutar la sentencia SQL para actualizar el usuario."),

    USER_ERROR_UNEXPECTED_UPDATE("No se pudo actualizar el usuario.",
            "Se ha presentado un error inesperado al intentar actualizar el usuario en la base de datos. Por favor verifique la traza completa del error."),

    TECHNICAL_ERROR_UNEXPECTED_UPDATE("Se ha presentado un error inesperado al intentar actualizar el usuario en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al actualizar el usuario en la base de datos."),

    USER_ERROR_CRITICAL_UPDATE("No se pudo actualizar el usuario.",
            "Se ha presentado un error crítico al intentar actualizar el usuario en la base de datos. Por favor verifique la traza completa del error."),

    TECHNICAL_ERROR_CRITICAL_UPDATE("Se ha presentado un error crítico al intentar actualizar el usuario en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar actualizar el usuario en la base de datos."),

    USER_ERROR_SQL_DELETE("No se pudo eliminar el usuario.",
            "Se ha presentado un error al intentar eliminar el usuario en la base de datos. Por favor verifique la traza completa del error."),

    TECHNICAL_ERROR_SQL_DELETE("Se ha presentado un error al intentar eliminar el usuario en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al ejecutar la sentencia SQL para eliminar el usuario."),

    USER_ERROR_UNEXPECTED_DELETE("No se pudo eliminar el usuario.",
            "Se ha presentado un error inesperado al intentar eliminar el usuario en la base de datos. Por favor verifique la traza completa del error."),

    TECHNICAL_ERROR_UNEXPECTED_DELETE("Se ha presentado un error inesperado al intentar eliminar el usuario en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al eliminar el usuario en la base de datos."),

    USER_ERROR_CRITICAL_DELETE("No se pudo eliminar el usuario.",
            "Se ha presentado un error crítico al intentar eliminar el usuario en la base de datos. Por favor verifique la traza completa del error."),

    TECHNICAL_ERROR_CRITICAL_DELETE("Se ha presentado un error crítico al intentar eliminar el usuario en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar eliminar el usuario en la base de datos."),

    CITY_ERROR_FIND_ALL_SQL(
            "No se pudo obtener la lista de ciudades.",
            "Se ha presentado un error al intentar consultar todas las ciudades en la base de datos."),

    TECHNICAL_ERROR_FIND_ALL_SQL_CITY(
            "Error técnico SQL al consultar todas las ciudades en la base de datos.",
            "Verifique la conexión y la sentencia SQL ejecutada."),

    CITY_ERROR_FIND_ALL_UNEXPECTED(
            "No se pudo obtener la lista de ciudades.",
            "Se ha presentado un error inesperado al intentar consultar todas las ciudades en la base de datos."),

    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED_CITY(
            "Error técnico inesperado al consultar todas las ciudades en la base de datos.",
            "Revise la traza completa del error para mayor detalle."),

    CITY_ERROR_FIND_ALL_CRITICAL(
            "No se pudo obtener la lista de ciudades.",
            "Se ha presentado un error crítico al intentar consultar todas las ciudades en la base de datos."),

    TECHNICAL_ERROR_FIND_ALL_CRITICAL_CITY(
            "Error técnico crítico al consultar todas las ciudades en la base de datos.",
            "Error grave en la operación de consulta de ciudades."),

    CITY_ERROR_FIND_BY_FILTER_SQL("No se pudo obtener la lista de ciudades filtradas.",
            "Se ha presentado un error al intentar consultar las ciudades con filtro en la base de datos."),

    TECHNICAL_ERROR_FIND_BY_FILTER_SQL_CITY("Error técnico SQL al aplicar filtros en la consulta de ciudades.",
            "Verifique los parámetros enviados al filtro de búsqueda."),

    CITY_ERROR_FIND_BY_FILTER_UNEXPECTED("No se pudo obtener la lista de ciudades filtradas.",
            "Se ha presentado un error inesperado al intentar consultar las ciudades filtradas en la base de datos."),

    TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED_CITY("Error técnico inesperado al aplicar filtros en la consulta de ciudades.",
            "Revise la traza del error y la integridad de los datos de entrada."),

    CITY_ERROR_FIND_BY_FILTER_CRITICAL("No se pudo obtener la lista de ciudades filtradas.",
            "Se ha presentado un error crítico al intentar consultar las ciudades filtradas en la base de datos."),

    TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL_CITY("Error técnico crítico al intentar filtrar las ciudades.",
            "Error grave al ejecutar la consulta con filtros de ciudad."),

    CITY_ERROR_FIND_BY_ID_SQL("No se pudo obtener la ciudad por su identificador.",
            "Se ha presentado un error al intentar consultar una ciudad específica en la base de datos."),

    TECHNICAL_ERROR_FIND_BY_ID_SQL_CITY("Error técnico SQL al consultar la ciudad por ID.",
            "Verifique la sentencia SQL y la conexión activa a la base de datos."),

    CITY_ERROR_FIND_BY_ID_UNEXPECTED("No se pudo obtener la ciudad por su identificador.",
            "Se ha presentado un error inesperado al intentar consultar una ciudad específica en la base de datos."),

    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED_CITY("Error técnico inesperado al consultar la ciudad por ID.",
            "Revise la traza completa del error para mayor detalle."),

    CITY_ERROR_FIND_BY_ID_CRITICAL("No se pudo obtener la ciudad por su identificador.",
            "Se ha presentado un error crítico al intentar consultar una ciudad específica en la base de datos."),

    TECHNICAL_ERROR_FIND_BY_ID_CRITICAL_CITY("Error técnico crítico al consultar la ciudad por ID.",
            "Error grave en la operación de consulta de ciudad por identificador."),

    COUNTRY_ERROR_FIND_ALL_SQL("No se pudieron obtener los países.",
            "Error controlado al intentar consultar la lista de países."),

    TECHNICAL_ERROR_FIND_ALL_SQL_COUNTRY("Se ha presentado un error al intentar obtener la lista de países en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar consultar la lista de países."),

    COUNTRY_ERROR_FIND_ALL_UNEXPECTED("No se pudieron obtener los países.",
            "Error inesperado al intentar consultar la lista de países."),

    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED_COUNTRY("Se ha presentado un error inesperado al intentar obtener la lista de países en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al intentar consultar la lista de países."),

    COUNTRY_ERROR_FIND_ALL_CRITICAL("No se pudieron obtener los países.",
            "Error crítico al intentar consultar la lista de países."),

    TECHNICAL_ERROR_FIND_ALL_CRITICAL_COUNTRY("Se ha presentado un error crítico al intentar obtener la lista de países en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar consultar la lista de países."),

    COUNTRY_ERROR_FIND_BY_FILTER_SQL("No se pudieron obtener los países según el filtro indicado.",
            "Error controlado al intentar consultar los países filtrados."),

    TECHNICAL_ERROR_FIND_BY_FILTER_SQL_COUNTRY("Se ha presentado un error al intentar consultar los países filtrados en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar consultar los países filtrados."),

    COUNTRY_ERROR_FIND_BY_FILTER_UNEXPECTED("No se pudieron obtener los países según el filtro indicado.",
            "Error inesperado al intentar consultar los países filtrados."),

    TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED_COUNTRY("Se ha presentado un error inesperado al intentar consultar los países filtrados en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al intentar consultar los países filtrados."),

    COUNTRY_ERROR_FIND_BY_FILTER_CRITICAL("No se pudieron obtener los países según el filtro indicado.",
            "Error crítico al intentar consultar los países filtrados."),

    TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL_COUNTRY("Se ha presentado un error crítico al intentar consultar los países filtrados en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar consultar los países filtrados."),

    COUNTRY_ERROR_FIND_BY_ID_SQL("No se pudo consultar el país solicitado.",
            "Error controlado al intentar consultar el país por su identificador."),

    TECHNICAL_ERROR_FIND_BY_ID_SQL_COUNTRY("Se ha presentado un error al intentar consultar el país por su identificador en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar consultar el país por su identificador."),

    COUNTRY_ERROR_FIND_BY_ID_UNEXPECTED("No se pudo consultar el país solicitado.",
            "Error inesperado al intentar consultar el país por su identificador."),

    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED_COUNTRY("Se ha presentado un error inesperado al intentar consultar el país por su identificador en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al intentar consultar el país por su identificador."),

    COUNTRY_ERROR_FIND_BY_ID_CRITICAL("No se pudo consultar el país solicitado.",
            "Error crítico al intentar consultar el país por su identificador."),

    TECHNICAL_ERROR_FIND_BY_ID_CRITICAL_COUNTRY("Se ha presentado un error crítico al intentar consultar el país por su identificador en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar consultar el país por su identificador."),

    ID_TYPE_ERROR_FIND_BY_ID_SQL("No se pudo consultar el tipo de identificación solicitado.",
            "Error controlado al intentar consultar el tipo de identificación por su identificador."),

    TECHNICAL_ERROR_FIND_BY_ID_SQL_ID_TYPE("Se ha presentado un error al intentar consultar el tipo de identificación por su identificador en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar consultar el tipo de identificación por su identificador."),

    ID_TYPE_ERROR_FIND_BY_ID_UNEXPECTED("No se pudo consultar el tipo de identificación solicitado.",
            "Error inesperado al intentar consultar el tipo de identificación por su identificador."),

    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED_ID_TYPE("Se ha presentado un error inesperado al intentar consultar el tipo de identificación por su identificador en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al intentar consultar el tipo de identificación por su identificador."),

    ID_TYPE_ERROR_FIND_BY_ID_CRITICAL("No se pudo consultar el tipo de identificación solicitado.",
            "Error crítico al intentar consultar el tipo de identificación por su identificador."),

    TECHNICAL_ERROR_FIND_BY_ID_CRITICAL_ID_TYPE("Se ha presentado un error crítico al intentar consultar el tipo de identificación por su identificador en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar consultar el tipo de identificación por su identificador."),

    ID_TYPE_ERROR_FIND_ALL_SQL("No se pudo consultar la lista de tipos de identificación.",
            "Error controlado al intentar consultar todos los tipos de identificación."),

    TECHNICAL_ERROR_FIND_ALL_SQL_ID_TYPE("Se ha presentado un error al intentar consultar todos los tipos de identificación en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar consultar todos los tipos de identificación."),

    ID_TYPE_ERROR_FIND_ALL_UNEXPECTED("No se pudo consultar la lista de tipos de identificación.",
            "Error inesperado al intentar consultar todos los tipos de identificación."),

    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED_ID_TYPE("Se ha presentado un error inesperado al intentar consultar todos los tipos de identificación en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al intentar consultar todos los tipos de identificación."),

    ID_TYPE_ERROR_FIND_ALL_CRITICAL("No se pudo consultar la lista de tipos de identificación.",
            "Error crítico al intentar consultar todos los tipos de identificación."),

    TECHNICAL_ERROR_FIND_ALL_CRITICAL_ID_TYPE("Se ha presentado un error crítico al intentar consultar todos los tipos de identificación en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar consultar todos los tipos de identificación."),

    ID_TYPE_ERROR_FIND_BY_FILTER_SQL("No se pudo realizar la búsqueda filtrada de tipos de identificación.",
            "Error controlado al intentar aplicar filtros en la consulta de tipos de identificación."),

    TECHNICAL_ERROR_FIND_BY_FILTER_SQL_ID_TYPE("Se ha presentado un error al intentar aplicar filtros en la consulta de tipos de identificación en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar aplicar filtros en la consulta de tipos de identificación."),

    ID_TYPE_ERROR_FIND_BY_FILTER_UNEXPECTED("No se pudo realizar la búsqueda filtrada de tipos de identificación.",
            "Error inesperado al intentar aplicar filtros en la consulta de tipos de identificación."),

    TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED_ID_TYPE("Se ha presentado un error inesperado al intentar aplicar filtros en la consulta de tipos de identificación en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al intentar aplicar filtros en la consulta de tipos de identificación."),

    ID_TYPE_ERROR_FIND_BY_FILTER_CRITICAL("No se pudo realizar la búsqueda filtrada de tipos de identificación.",
            "Error crítico al intentar aplicar filtros en la consulta de tipos de identificación."),

    TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL_ID_TYPE("Se ha presentado un error crítico al intentar aplicar filtros en la consulta de tipos de identificación en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar aplicar filtros en la consulta de tipos de identificación."),

    STATE_ERROR_FIND_BY_ID_SQL("No se pudo consultar el estado solicitado.",
            "Error controlado al intentar consultar el estado por su identificador."),

    TECHNICAL_ERROR_FIND_BY_ID_SQL_STATE("Se ha presentado un error al intentar consultar el estado por su identificador en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar consultar el estado por su identificador."),

    STATE_ERROR_FIND_BY_ID_UNEXPECTED("No se pudo consultar el estado solicitado.",
            "Error inesperado al intentar consultar el estado por su identificador."),

    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED_STATE("Se ha presentado un error inesperado al intentar consultar el estado por su identificador en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al intentar consultar el estado por su identificador."),

    STATE_ERROR_FIND_BY_ID_CRITICAL("No se pudo consultar el estado solicitado.",
            "Error crítico al intentar consultar el estado por su identificador."),

    TECHNICAL_ERROR_FIND_BY_ID_CRITICAL_STATE("Se ha presentado un error crítico al intentar consultar el estado por su identificador en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar consultar el estado por su identificador."),

    STATE_ERROR_FIND_ALL_SQL("No se pudo consultar la lista de estados.",
            "Error controlado al intentar consultar todos los estados."),

    TECHNICAL_ERROR_FIND_ALL_SQL_STATE("Se ha presentado un error al intentar consultar todos los estados en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar consultar todos los estados."),

    STATE_ERROR_FIND_ALL_UNEXPECTED("No se pudo consultar la lista de estados.",
            "Error inesperado al intentar consultar todos los estados."),

    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED_STATE("Se ha presentado un error inesperado al intentar consultar todos los estados en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al intentar consultar todos los estados."),

    STATE_ERROR_FIND_ALL_CRITICAL("No se pudo consultar la lista de estados.",
            "Error crítico al intentar consultar todos los estados."),

    TECHNICAL_ERROR_FIND_ALL_CRITICAL_STATE("Se ha presentado un error crítico al intentar consultar todos los estados en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar consultar todos los estados."),

    STATE_ERROR_FIND_BY_FILTER_SQL("No se pudo consultar la lista filtrada de estados.",
            "Error controlado al intentar consultar los estados según el filtro."),

    TECHNICAL_ERROR_FIND_BY_FILTER_SQL_STATE("Se ha presentado un error al intentar consultar los estados filtrados en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar consultar los estados según el filtro."),

    STATE_ERROR_FIND_BY_FILTER_UNEXPECTED("No se pudo consultar la lista filtrada de estados.",
            "Error inesperado al intentar consultar los estados según el filtro."),

    TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED_STATE("Se ha presentado un error inesperado al intentar consultar los estados filtrados en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico inesperado al intentar consultar los estados según el filtro."),

    STATE_ERROR_FIND_BY_FILTER_CRITICAL("No se pudo consultar la lista filtrada de estados.",
            "Error crítico al intentar consultar los estados según el filtro."),

    TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL_STATE("Se ha presentado un error crítico al intentar consultar los estados filtrados en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico crítico al intentar consultar los estados según el filtro."),

    USER_ERROR_SQL_CREATE_COUNTRY( "Se ha presentado un error inesperado al intentar crear el país en la base de datos. Por favor verifique la información ingresada no exista y que esté completa, si el error persiste comuníquese con el administrador.",
            "Error al intentar crear un país en la base de datos." ),

    TECHNICAL_ERROR_SQL_CREATE_COUNTRY("Se ha presentado un error al intentar crear el país en la base de datos. Por favor verifique la traza completa del error.",
                                                            "Error técnico al intentar crear el país en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_CREATE_COUNTRY("No se pudo crear el país con el comando seleccionado.",
                                                "Error inesperado al intentar crear un país."),

    TECHNICAL_UNEXPECTED_ERROR_CREATE_COUNTRY("Se ha presentado un error inesperado al intentar crear un país. Por favor verifique la traza completa del error.",
                                                          "Error inesperado al intentar crear un país con los datos suministrados."),

    USER_ERROR_EXECUTE_SENTENCE_CREATE_COUNTRY( "Se ha presentado un error inesperado al intentar crear los datos ingresados del país en la base de datos. Por favor verifique la información ingresada no exista y esté completa, si el error persiste comuníquese con el administrador.",
                                           "Error al intentar insertar los datos ingresados de un país en la base de datos." ),

    TECHNICAL_ERROR_EXECUTE_SENTENCE_CREATE_COUNTRY("Se ha presentado un error al intentar ejecutar el comando de inserción de datos del país en la base de datos. Por favor verifique la traza completa del error.",
                                               "Error técnico al intentar ejecutar el comando de inserción del país en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_COUNTRY("No se pudo ejecutar la creación el país con el comando seleccionado.",
                                                 "Error inesperado al intentar ejecutar la creación de un país."),

    TECHNICAL_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_COUNTRY("Se ha presentado un error inesperado al intentar ejecutar el comando de inserción de un país. Por favor verifique la traza completa del error.",
                                                      "Error inesperado al intentar ejecutar el comando de inserción del país con los datos suministrados."),

    USER_ERROR_SQL_FIND_BY_FILTER_COUNTRY( "Se ha presentado un error inesperado al intentar filtrar el país en la base de datos. Por favor verifique la información ingresada no exista y que esté completa, si el error persiste comuníquese con el administrador.",
                                           "Error al intentar filtrar un país desde la base de datos." ),

    TECHNICAL_ERROR_SQL_FIND_BY_FILTER_COUNTRY("Se ha presentado un error al intentar filtrar el país en la base de datos en la sentencia. Por favor verifique la traza completa del error.",
                                               "Error técnico al intentar filtrar el país en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_FIND_BY_FILTER_COUNTRY("No se pudo filtrar el país con el comando seleccionado.",
                                                 "Error inesperado al intentar filtrar un país."),

    TECHNICAL_UNEXPECTED_ERROR_FIND_BY_FILTER_COUNTRY("Se ha presentado un error inesperado al intentar filtrar un país. Por favor verifique la traza completa del error.",
                                                      "Error inesperado al intentar filtrar un país con los datos suministrados."),

    USER_ERROR_SQL_DELETE_COUNTRY( "Se ha presentado un error inesperado al intentar eliminar el país en la base de datos. Por favor verifique la información ingresada exista y que esté completa, si el error persiste comuníquese con el administrador.",
                                                   "Error al intentar eliminar un país desde la base de datos." ),

    TECHNICAL_ERROR_SQL_DELETE_COUNTRY("Se ha presentado un error al intentar eliminar el país en la base de datos con la sentencia configurada. Por favor verifique la traza completa del error.",
                                                       "Error técnico al intentar eliminar el país en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_DELETE_COUNTRY("No se pudo eliminar el país con el comando seleccionado.",
                                                         "Error inesperado al intentar eliminar un país."),

    TECHNICAL_UNEXPECTED_ERROR_DELETE_COUNTRY("Se ha presentado un error inesperado al intentar eliminar un país. Por favor verifique la traza completa del error.",
                                                              "Error inesperado al intentar eliminar un país con los datos suministrados."),

    USER_ERROR_SQL_UPDATE_COUNTRY( "Se ha presentado un error inesperado al intentar actualizar el país en la base de datos. Por favor verifique la información ingresada cumpla con los requisitos, si el error persiste comuníquese con el administrador.",
                                           "Error al intentar actualizar un país desde la base de datos." ),

    TECHNICAL_ERROR_SQL_UPDATE_COUNTRY("Se ha presentado un error al intentar actualizar el país en la base de datos con la sentencia configurada. Por favor verifique la traza completa del error.",
                                               "Error técnico al intentar actualizar el país en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_UPDATE_COUNTRY("No se pudo actualizar el país con el comando seleccionado.",
                                                 "Error inesperado al intentar actualizar un país."),

    TECHNICAL_UNEXPECTED_ERROR_UPDATE_COUNTRY("Se ha presentado un error inesperado al intentar actualizar un país. Por favor verifique la traza completa del error.",
                                                      "Error inesperado al intentar actualizar un país con los datos suministrados."),

    USER_ERROR_SQL_UPDATE_IDTYPE( "Se ha presentado un error inesperado al intentar actualizar el tipo de identificación en la base de datos. Por favor verifique la información ingresada cumpla con los requisitos, si el error persiste comuníquese con el administrador.",
                                           "Error al intentar actualizar tipo de identificación desde la base de datos." ),

    TECHNICAL_ERROR_SQL_UPDATE_IDTYPE("Se ha presentado un error al intentar actualizar el tipo de identificación en la base de datos con la sentencia configurada. Por favor verifique la traza completa del error.",
                                               "Error técnico al intentar actualizar el tipo de identificación en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_UPDATE_IDTYPE("No se pudo actualizar el tipo de identificación con el comando seleccionado.",
                                                 "Error inesperado al intentar actualizar el tipo de identificación."),

    TECHNICAL_UNEXPECTED_ERROR_UPDATE_IDTYPE("Se ha presentado un error inesperado al intentar actualizar el tipo de identificación. Por favor verifique la traza completa del error.",
                                                      "Error inesperado al intentar actualizar el tipo de identificación con los datos suministrados."),

    USER_ERROR_SQL_DELETE_IDTYPE( "Se ha presentado un error inesperado al intentar eliminar el tipo de identificación en la base de datos. Por favor verifique la información ingresada exista y que esté completa, si el error persiste comuníquese con el administrador.",
            "Error al intentar eliminar el tipo de identificación desde la base de datos." ),

    TECHNICAL_ERROR_SQL_DELETE_IDTYPE("Se ha presentado un error al intentar eliminar el tipo de identificación en la base de datos con la sentencia configurada. Por favor verifique la traza completa del error.",
            "Error técnico al intentar eliminar el tipo de identificación en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_DELETE_IDTYPE("No se pudo eliminar el tipo de identificación con el comando seleccionado.",
            "Error inesperado al intentar eliminar el tipo de identificación."),

    TECHNICAL_UNEXPECTED_ERROR_DELETE_IDTYPE("Se ha presentado un error inesperado al intentar eliminar el tipo de identificación. Por favor verifique la traza completa del error.",
            "Error inesperado al intentar eliminar el tipo de identificación con los datos suministrados."),

    USER_ERROR_EXECUTE_SENTENCE_CREATE_IDTYPE( "Se ha presentado un error inesperado al intentar crear los datos ingresados del tipo de identificación en la base de datos. Por favor verifique la información ingresada no exista y esté completa, si el error persiste comuníquese con el administrador.",
                                                        "Error al intentar insertar los datos ingresados del tipo de identificación en la base de datos." ),

    TECHNICAL_ERROR_EXECUTE_SENTENCE_CREATE_IDTYPE("Se ha presentado un error al intentar ejecutar el comando de inserción de datos del tipo de identificación en la base de datos. Por favor verifique la traza completa del error.",
                                                            "Error técnico al intentar ejecutar el comando de inserción del tipo de identificación en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_IDTYPE("No se pudo ejecutar la creación del tipo de identificación con el comando seleccionado.",
                                                                  "Error inesperado al intentar ejecutar la creación de un país."),

    TECHNICAL_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_IDTYPE("Se ha presentado un error inesperado al intentar ejecutar el comando de inserción del tipo de identificación. Por favor verifique la traza completa del error.",
                                                                       "Error inesperado al intentar ejecutar el comando de inserción del tipo de identificación con los datos suministrados."),

    USER_ERROR_SQL_DELETE_STATE( "Se ha presentado un error inesperado al intentar eliminar el estado en la base de datos. Por favor verifique la información ingresada exista y que esté completa, si el error persiste comuníquese con el administrador.",
            "Error al intentar eliminar el estado desde la base de datos." ),

    TECHNICAL_ERROR_SQL_DELETE_STATE("Se ha presentado un error al intentar eliminar el estado en la base de datos con la sentencia configurada. Por favor verifique la traza completa del error.",
            "Error técnico al intentar eliminar el estado en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_DELETE_STATE("No se pudo eliminar el estado con el comando seleccionado.",
            "Error inesperado al intentar eliminar el estado."),

    TECHNICAL_UNEXPECTED_ERROR_DELETE_STATE("Se ha presentado un error inesperado al intentar eliminar el estado. Por favor verifique la traza completa del error.",
            "Error inesperado al intentar eliminar el estado con los datos suministrados."),

    USER_ERROR_SQL_UPDATE_STATE( "Se ha presentado un error inesperado al intentar actualizar el estado en la base de datos. Por favor verifique la información ingresada cumpla con los requisitos, si el error persiste comuníquese con el administrador.",
                                          "Error al intentar actualizar el estado desde la base de datos." ),

    TECHNICAL_ERROR_SQL_UPDATE_STATE("Se ha presentado un error al intentar actualizar el estado en la base de datos con la sentencia configurada. Por favor verifique la traza completa del error.",
                                              "Error técnico al intentar actualizar el estado en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_UPDATE_STATE("No se pudo actualizar el estado con el comando seleccionado.",
                                                "Error inesperado al intentar actualizar el estado."),

    TECHNICAL_UNEXPECTED_ERROR_UPDATE_STATE("Se ha presentado un error inesperado al intentar actualizar el estado. Por favor verifique la traza completa del error.",
                                                     "Error inesperado al intentar actualizar el estado con los datos suministrados."),

    USER_ERROR_SQL_CREATE_STATE( "Se ha presentado un error inesperado al intentar crear el país en la base de datos. Por favor verifique la información ingresada no exista y que esté completa, si el error persiste comuníquese con el administrador.",
            "Error al intentar crear un país en la base de datos." ),

    TECHNICAL_ERROR_SQL_CREATE_STATE("Se ha presentado un error al intentar crear el país en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar crear el país en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_CREATE_STATE("No se pudo crear el país con el comando seleccionado.",
            "Error inesperado al intentar crear un país."),

    TECHNICAL_UNEXPECTED_ERROR_CREATE_STATE("Se ha presentado un error inesperado al intentar crear un país. Por favor verifique la traza completa del error.",
            "Error inesperado al intentar crear un país con los datos suministrados."),

    USER_ERROR_EXECUTE_SENTENCE_CREATE_STATE( "Se ha presentado un error al intentar crear los datos ingresados del estado en la base de datos. Por favor verifique la información ingresada no exista y esté completa, si el error persiste comuníquese con el administrador.",
            "Error al intentar insertar los datos ingresados del tipo de identificación en la base de datos." ),

    TECHNICAL_ERROR_EXECUTE_SENTENCE_CREATE_STATE("Se ha presentado un error al intentar ejecutar el comando de inserción de datos del estado en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar ejecutar el comando de inserción del estado en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_STATE("No se pudo ejecutar la creación del estado con el comando seleccionado.",
            "Error inesperado al intentar ejecutar la creación del estado"),

    TECHNICAL_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_STATE("Se ha presentado un error inesperado al intentar ejecutar el comando de inserción del estado. Por favor verifique la traza completa del error.",
            "Error inesperado al intentar ejecutar el comando de inserción del estado con los datos suministrados."),

    USER_ERROR_SQL_FIND_BY_FILTER_STATE( "Se ha presentado un error inesperado al intentar filtrar el país en la base de datos. Por favor verifique la información ingresada no exista y que esté completa, si el error persiste comuníquese con el administrador.",
            "Error al intentar filtrar un país desde la base de datos." ),

    TECHNICAL_ERROR_SQL_FIND_BY_FILTER_STATE("Se ha presentado un error al intentar filtrar el país en la base de datos en la sentencia. Por favor verifique la traza completa del error.",
            "Error técnico al intentar filtrar el país en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_FIND_BY_FILTER_STATE("No se pudo filtrar el país con el comando seleccionado.",
            "Error inesperado al intentar filtrar un país."),

    TECHNICAL_UNEXPECTED_ERROR_FIND_BY_FILTER_STATE("Se ha presentado un error inesperado al intentar filtrar un país. Por favor verifique la traza completa del error.",
            "Error inesperado al intentar filtrar un país con los datos suministrados."),

    USER_ERROR_SQL_DELETE_CITY( "Se ha presentado un error al intentar eliminar la ciudad en la base de datos. Por favor verifique la información ingresada exista y que esté completa, si el error persiste comuníquese con el administrador.",
            "Error al intentar eliminar la ciudad desde la base de datos." ),

    TECHNICAL_ERROR_SQL_DELETE_CITY("Se ha presentado un error al intentar eliminar la ciudad en la base de datos con la sentencia configurada. Por favor verifique la traza completa del error.",
            "Error técnico al intentar eliminar la ciudad en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_DELETE_CITY("No se pudo eliminar la ciudad con el comando seleccionado.",
            "Error inesperado al intentar eliminar la ciudad."),

    TECHNICAL_UNEXPECTED_ERROR_DELETE_CITY("Se ha presentado un error inesperado al intentar eliminar la ciudad. Por favor verifique la traza completa del error.",
            "Error inesperado al intentar eliminar la ciudad con los datos suministrados."),

    USER_ERROR_SQL_UPDATE_CITY( "Se ha presentado un error inesperado al intentar actualizar la ciudad en la base de datos. Por favor verifique la información ingresada cumpla con los requisitos, si el error persiste comuníquese con el administrador.",
            "Error al intentar actualizar la ciudad desde la base de datos." ),

    TECHNICAL_ERROR_SQL_UPDATE_CITY("Se ha presentado un error al intentar actualizar la ciudad en la base de datos con la sentencia configurada. Por favor verifique la traza completa del error.",
            "Error técnico al intentar actualizar la ciudad en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_UPDATE_CITY("No se pudo actualizar la ciudad con el comando seleccionado.",
            "Error inesperado al intentar actualizar la ciudad."),

    TECHNICAL_UNEXPECTED_ERROR_UPDATE_CITY("Se ha presentado un error inesperado al intentar actualizar la ciudad. Por favor verifique la traza completa del error.",
            "Error inesperado al intentar actualizar la ciudad con los datos suministrados."),

    USER_ERROR_EXECUTE_SENTENCE_CREATE_CITY( "Se ha presentado un error al intentar crear los datos ingresados de la ciudad en la base de datos. Por favor verifique la información ingresada no exista y esté completa, si el error persiste comuníquese con el administrador.",
            "Error al intentar insertar los datos ingresados de la ciudad en la base de datos." ),

    TECHNICAL_ERROR_EXECUTE_SENTENCE_CREATE_CITY("Se ha presentado un error al intentar ejecutar el comando de inserción de datos de la ciudad en la base de datos. Por favor verifique la traza completa del error.",
            "Error técnico al intentar ejecutar el comando de inserción de la ciudad en la base de datos verifique la trama."),

    USER_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_CITY("No se pudo ejecutar la creación de la ciudad con el comando seleccionado.",
            "Error inesperado al intentar ejecutar la creación de la ciudad"),

    TECHNICAL_UNEXPECTED_ERROR_EXECUTE_SENTENCE_CREATE_CITY("Se ha presentado un error inesperado al intentar ejecutar el comando de inserción dde la ciudad. Por favor verifique la traza completa del error.",
            "Error inesperado al intentar ejecutar el comando de inserción de la ciudad con los datos suministrados.");







    private String title;
    private String content;

    private MessagesEnum(final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    public static String TECHNICAL_ERROR_FIND_BY_ID_CRITICAL() {
        return null;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(final String title) {
        this.title = TextHelper.getDefaultwithTrim(title);
    }

    public String getContent() {
        return content;
    }

    private void setContent(final String content) {
        this.content = TextHelper.getDefaultwithTrim(content);
    }
}