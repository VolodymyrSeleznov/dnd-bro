package org.wharagaradoo.dndbro.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Created by Vladimir Seleznov <v.e.seleznov@gmail.com> on 2018-12-28.
 */
public class DiceRoller {

    public static String processMessage(String msg) {
        String[] strings = parseMessage(msg);
        if (strings.length != 2) {

            return "Please specify a dice";
        }
        int[] dice = parseDice(strings[1]);

        if (null == dice) {

            return "Dice " + strings[1] + " is not found";
        }

        List<String> rolls = new ArrayList<>();
        int rollSum = 0;

        for (int i = 0; i < dice[0]; i++) {
            int roll = getRoll(dice[1]);
            rolls.add(String.valueOf(roll));
            rollSum += roll;
        }

        String joinedRolls = String.join(",", rolls);
        joinedRolls = "(" + joinedRolls + ")";

        return "Your roll of " + strings[1] + ": " + joinedRolls + " " + rollSum;
    }

    private static String[] parseMessage(String message) {

        return message.split(" ");
    }

    private static int[] parseDice(String dice) {
        String[] split = dice.split("d");
        int[] result = new int[2];

        if (split.length != 2) {

            return null;
        }

        try {
            int diceCount = Integer.valueOf(split[0]);
            int diceType = Integer.valueOf(split[1]);

            result[0] = diceCount;
            result[1] = diceType;
        } catch (NumberFormatException e) {

            return null;
        }

        return result;
    }

    private static int getRoll(int dice) {
        Random rand = new Random();
        return rand.nextInt(dice) + 1;
    }
}
