/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.java.training.kovtamas.data.dao;

/**
 *
 * @author Joey
 */
public class SaveUnsuccessfulException extends RuntimeException {

    public SaveUnsuccessfulException() {
    }

    public SaveUnsuccessfulException(String message, Throwable cause) {
        super(message, cause);
    }

}
