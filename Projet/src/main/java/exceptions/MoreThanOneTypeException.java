/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author faris
 */
public class MoreThanOneTypeException extends Exception {

    /**
     * Creates a new instance of <code>MoreThanOneTypeException</code> without
     * detail message.
     */
    public MoreThanOneTypeException() {
    }

    /**
     * Constructs an instance of <code>MoreThanOneTypeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MoreThanOneTypeException(String msg) {
        super(msg);
    }
}
