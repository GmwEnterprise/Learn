package cn.edu.cqut.myapp.enums;

public enum SexEnum {

  MAN(1), WOMAN(2);

  private int index;

  SexEnum(int index) {
    this.index = index;
  }

  public static SexEnum getSexEnum(int index) {
    for (SexEnum value : values()) {
      if (value.index == index) {
        return value;
      }
    }
    return null;
  }

  public int getIndex() {
    return index;
  }
}
