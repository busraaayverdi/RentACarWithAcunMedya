package com.acunmedya.jsfs2.RentACar.common.entity.exceptions.handlers;

import com.acunmedya.jsfs2.RentACar.common.entity.exceptions.details.BusinessProblemDetails;
import com.acunmedya.jsfs2.RentACar.common.entity.exceptions.details.InternalServerProblemDetails;
import com.acunmedya.jsfs2.RentACar.common.entity.exceptions.types.BusinessException;
import com.acunmedya.jsfs2.RentACar.common.entity.exceptions.types.InternalServerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //http isteği atınca araya dahil eder
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException) {
        BusinessProblemDetails details = new BusinessProblemDetails();
        details.setDetail(businessException.getMessage());
        return details;
    }
    @ExceptionHandler({InternalServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalServerProblemDetails handleInternalServerException(InternalServerException internalServerException) {
        InternalServerProblemDetails details = new InternalServerProblemDetails();
        details.setDetail(internalServerException.getMessage());
        return details;
    }

}
