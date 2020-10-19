package com.dumbdodo.member.common;


import com.dumbdodo.member.dto.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerRequetExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(ControllerRequetExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity unhandledException(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        String message = "Something went wrong";
        BaseResponse response = new BaseResponse("error", message);
        LOGGER.error(ex.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler({BusinessException.class})
//    public ResponseEntity businessExceptionHandler(BusinessException ex) {
//        String statuscode = ex.getErrorCode();
//        String message = ex.getMessage();
//        Response response = new Response(statuscode, message);
//        return new ResponseEntity(response, ex.getHttpStatus() == null ? HttpStatus.BAD_REQUEST : ex.getHttpStatus());
//    }

//    @ExceptionHandler
//    public ResponseEntity handleException(MethodArgumentNotValidException exception) {
//        String statuscode = "";
//        String message = "Invalid Request";
//        try {
//            statuscode = exception.getBindingResult().getFieldErrors().stream()
//                    .map(DefaultMessageSourceResolvable::getDefaultMessage).findFirst().orElse(exception.getMessage());
//            message = ExceptionResourceBundle.getInstance().getErrorMessage(statuscode);
//        } catch (Exception e) {
//            message = "Invalid Request.";
//        }
//
//        BaseResponse response = new BaseResponse(statuscode, message);
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

}