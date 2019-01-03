package org.wharagaradoo.dndbro.exception;

/**
 * @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-03.
 */
public class DiceNotFoundException extends Exception {

    public DiceNotFoundException(String dice) {
        super("Dice " + dice + " is not found");
    }
}
