package net.alterapp.miniproject.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceException extends Exception{

    protected String message;
    protected ErrorCode errorCode;
    protected HttpStatus httpStatus;

}