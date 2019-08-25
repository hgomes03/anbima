package br.com.anbima.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.anbima.backend.entity.ApiErrorResponse;


@RestControllerAdvice
public class GlobalControllerExceptionHandler {
	
	//private static final Logger LOG = Logger.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(value = { ConstraintException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse constraintViolationException(ConstraintException ex) {
      //  LOG.error(ex.getCause().toString());  
        return new ApiErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(value = { NotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse noHandlerFoundException(Exception ex) {
       // LOG.error(ex.getCause().toString());
        return new ApiErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse unknownException(Exception ex) {
    	ex.printStackTrace();
       // LOG.error(ex.getCause().toString());
        return new ApiErrorResponse(ex.getMessage());
    }
    
    
}
