package com.ecom.app.ws.exceptions;

public class UserException extends RuntimeException{

    private static final long serialVersionUID = 1652215871913444700L;

    public UserException(String message)
    {
        super(message);  //initialiser le constuctuer de la classe qui est hérite
    }

}
