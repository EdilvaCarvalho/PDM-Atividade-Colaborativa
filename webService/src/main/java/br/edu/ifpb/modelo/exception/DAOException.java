/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.modelo.exception;

/**
 *
 * @author laerton
 */
public class DAOException extends RuntimeException{
    private static final long serialVersionUID = 3965087475900464946L;
    private int code;
    
    public DAOException(String message, int code) {
        super(message);
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
}
