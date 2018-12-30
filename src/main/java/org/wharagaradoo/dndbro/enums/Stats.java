package org.wharagaradoo.dndbro.enums;

/**
 * @author Created by Vladimir Seleznov <v.e.seleznov@gmail.com> on 2018-12-30.
 */
public enum Stats {
    STR,
    DEX,
    CON,
    INT,
    WIS,
    CHA;

    public static Stats getByIndex(int index) {
        for (Stats e : values()) {
            if (e.getIndex() == index) {

                return e;
            }
        }

        throw new IndexOutOfBoundsException();
    }

    public int getIndex() {

        return ordinal() + 1;
    }
}
