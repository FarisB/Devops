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
public class DifferentSizeException extends Exception {

    /**
     * Creates a new instance of <code>DifferentSizeException</code> without
     * detail message.
     */
    public DifferentSizeException() {
    }

    /**
     * Constructs an instance of <code>DifferentSizeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DifferentSizeException(String msg) {
        super(msg);
    }
}
