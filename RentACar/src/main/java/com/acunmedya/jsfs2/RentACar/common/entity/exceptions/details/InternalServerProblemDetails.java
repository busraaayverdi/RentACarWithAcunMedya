package com.acunmedya.jsfs2.RentACar.common.entity.exceptions.details;

import org.springframework.http.HttpStatus;

public class InternalServerProblemDetails extends ProblemDetails{

    public InternalServerProblemDetails(){
        setTitle("Internal Server Error");
        setType("http://acunmedya.com/exception/internal");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());

    }
}
