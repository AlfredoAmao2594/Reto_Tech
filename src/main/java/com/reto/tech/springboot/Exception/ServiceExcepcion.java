package com.reto.tech.springboot.Exception;

public class ServiceExcepcion extends RuntimeException{

	public ServiceExcepcion(String message) {
        super(message);
    }

    public ServiceExcepcion(String message, Throwable cause) {
        super(message, cause);
    }
}
