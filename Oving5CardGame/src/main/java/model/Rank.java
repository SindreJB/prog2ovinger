package model;

public enum Rank {
  ACE(1, "Ace"),
  TWO(2, "Two"),
  THREE(3, "Three"),
  FOUR(4, "Four"),
  FIVE(5, "Five"),
  SIX(6, "Six"),
  SEVEN(7, "Seven"),
  EIGHT(8, "Eight"),
  NINE(9, "Nine"),
  TEN(10, "Ten"),
  JACK(11, "Jack"),
  QUEEN(12, "Queen"),
  KING(13, "King");

  private final int value;
  private final String name;

  Rank(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }
}
