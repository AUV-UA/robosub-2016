/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.auvua.visionservice;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum FilterSourceType implements org.apache.thrift.TEnum {
  RGB(0),
  BGR(1),
  HSV(2),
  HSL(3),
  BINARY(4);

  private final int value;

  private FilterSourceType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static FilterSourceType findByValue(int value) { 
    switch (value) {
      case 0:
        return RGB;
      case 1:
        return BGR;
      case 2:
        return HSV;
      case 3:
        return HSL;
      case 4:
        return BINARY;
      default:
        return null;
    }
  }
}