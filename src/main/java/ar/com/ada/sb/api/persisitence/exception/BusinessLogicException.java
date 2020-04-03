package ar.com.ada.sb.api.persisitence.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusinessLogicException extends RuntimeException {

    private String defaultMessage;
    private HttpStatus httpStatus;
    private List<ApiEntityError> entityErrors = new ArrayList<>();

    // este contructor recibe el defaultMessage que es el mensaje de error,
    // el httpStatus que representará el status de la respuesta, ya que no siempre será de tipo 400
    // y una lista de errores de tipo ApiEntityError, que la creamos la clase pasada.
    public BusinessLogicException(String defaultMessage, HttpStatus httpStatus, List<ApiEntityError> entityErrors) {
        this.defaultMessage = defaultMessage;
        this.httpStatus = httpStatus;
        this.entityErrors = entityErrors;
    }

    // este contructor recibe los 2 primeros parametros que el anterior, pero el 3ro solo es un objeto
    // de tipo ApiEntityError, esto es solo para cuando se quiere lanzar una Exception con un solo error.
    public BusinessLogicException(String defaultMessage, HttpStatus httpStatus, ApiEntityError apiEntityError) {
        this.defaultMessage = defaultMessage;
        this.httpStatus = httpStatus;
        this.entityErrors.add(apiEntityError);
    }
}
