package org.wharagaradoo.dndbro.util;

import org.wharagaradoo.dndbro.exception.DiceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-03. */
public class Dice {

  private String dice;
  private int dicesCount;
  private int diceValue;
  private int k;
  private String output;
  private int result;

  public Dice(String dice) throws DiceNotFoundException {
    dice = dice.replaceAll(" ", "");
    this.dice = dice;
    validate(dice);
    parse(dice);
    validateDiceValue(diceValue);
  }

  private void validate(String dice) throws DiceNotFoundException {
    String diceRegexp = "[0-9]+d[0-9]+([+-][0-9]+)?";
    Matcher matcher = Pattern.compile(diceRegexp).matcher(dice);
    if (!matcher.matches()) {
      throw new DiceNotFoundException(dice);
    }
  }

  private void parse(String dice) {
    String[] parts = dice.split("d");
    dicesCount = Integer.valueOf(parts[0]);

    if (parts[1].contains("+")) {
      String[] diceValAndCoef = parts[1].split("\\+");
      diceValue = Integer.valueOf(diceValAndCoef[0].trim());
      k = Integer.valueOf(diceValAndCoef[1]);
    } else if (parts[1].contains("-")) {
      String[] diceValAndK = parts[1].split("-");
      diceValue = Integer.valueOf(diceValAndK[0].trim());
      k = -Integer.valueOf(diceValAndK[1]);
    } else {
      diceValue = Integer.valueOf(parts[1]);
      k = 0;
    }
  }

  private void validateDiceValue(int diceValue) throws DiceNotFoundException {
    if (diceValue != 1
        && diceValue != 4
        && diceValue != 6
        && diceValue != 8
        && diceValue != 10
        && diceValue != 12
        && diceValue != 20
        && diceValue != 100) {

      throw new DiceNotFoundException(dice);
    }
  }

  public Dice roll() {
    List<String> rolls = new ArrayList<>();

    int rollSum = 0;
    for (int i = 0; i < dicesCount; i++) {
      int roll = new Random().nextInt(diceValue) + 1;
      rolls.add(String.valueOf(roll));
      rollSum += roll;
    }
    int result = rollSum + k;

    output = "Your roll of " + dice + ": (" + String.join(", ", rolls) + ") **" + result + "**";
    this.result = result;

    return this;
  }

  public String getOutput() {

    return output;
  }

  public int getResult() {

    return result;
  }
}
