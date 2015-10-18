/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.auvua.visionservice;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2015-10-18")
public class Resolution implements org.apache.thrift.TBase<Resolution, Resolution._Fields>, java.io.Serializable, Cloneable, Comparable<Resolution> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Resolution");

  private static final org.apache.thrift.protocol.TField HORIZONTAL_FIELD_DESC = new org.apache.thrift.protocol.TField("horizontal", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField VERTICAL_FIELD_DESC = new org.apache.thrift.protocol.TField("vertical", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ResolutionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ResolutionTupleSchemeFactory());
  }

  public int horizontal; // required
  public int vertical; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HORIZONTAL((short)1, "horizontal"),
    VERTICAL((short)2, "vertical");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // HORIZONTAL
          return HORIZONTAL;
        case 2: // VERTICAL
          return VERTICAL;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __HORIZONTAL_ISSET_ID = 0;
  private static final int __VERTICAL_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HORIZONTAL, new org.apache.thrift.meta_data.FieldMetaData("horizontal", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.VERTICAL, new org.apache.thrift.meta_data.FieldMetaData("vertical", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Resolution.class, metaDataMap);
  }

  public Resolution() {
  }

  public Resolution(
    int horizontal,
    int vertical)
  {
    this();
    this.horizontal = horizontal;
    setHorizontalIsSet(true);
    this.vertical = vertical;
    setVerticalIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Resolution(Resolution other) {
    __isset_bitfield = other.__isset_bitfield;
    this.horizontal = other.horizontal;
    this.vertical = other.vertical;
  }

  public Resolution deepCopy() {
    return new Resolution(this);
  }

  @Override
  public void clear() {
    setHorizontalIsSet(false);
    this.horizontal = 0;
    setVerticalIsSet(false);
    this.vertical = 0;
  }

  public int getHorizontal() {
    return this.horizontal;
  }

  public Resolution setHorizontal(int horizontal) {
    this.horizontal = horizontal;
    setHorizontalIsSet(true);
    return this;
  }

  public void unsetHorizontal() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __HORIZONTAL_ISSET_ID);
  }

  /** Returns true if field horizontal is set (has been assigned a value) and false otherwise */
  public boolean isSetHorizontal() {
    return EncodingUtils.testBit(__isset_bitfield, __HORIZONTAL_ISSET_ID);
  }

  public void setHorizontalIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __HORIZONTAL_ISSET_ID, value);
  }

  public int getVertical() {
    return this.vertical;
  }

  public Resolution setVertical(int vertical) {
    this.vertical = vertical;
    setVerticalIsSet(true);
    return this;
  }

  public void unsetVertical() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __VERTICAL_ISSET_ID);
  }

  /** Returns true if field vertical is set (has been assigned a value) and false otherwise */
  public boolean isSetVertical() {
    return EncodingUtils.testBit(__isset_bitfield, __VERTICAL_ISSET_ID);
  }

  public void setVerticalIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __VERTICAL_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case HORIZONTAL:
      if (value == null) {
        unsetHorizontal();
      } else {
        setHorizontal((Integer)value);
      }
      break;

    case VERTICAL:
      if (value == null) {
        unsetVertical();
      } else {
        setVertical((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HORIZONTAL:
      return getHorizontal();

    case VERTICAL:
      return getVertical();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case HORIZONTAL:
      return isSetHorizontal();
    case VERTICAL:
      return isSetVertical();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Resolution)
      return this.equals((Resolution)that);
    return false;
  }

  public boolean equals(Resolution that) {
    if (that == null)
      return false;

    boolean this_present_horizontal = true;
    boolean that_present_horizontal = true;
    if (this_present_horizontal || that_present_horizontal) {
      if (!(this_present_horizontal && that_present_horizontal))
        return false;
      if (this.horizontal != that.horizontal)
        return false;
    }

    boolean this_present_vertical = true;
    boolean that_present_vertical = true;
    if (this_present_vertical || that_present_vertical) {
      if (!(this_present_vertical && that_present_vertical))
        return false;
      if (this.vertical != that.vertical)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_horizontal = true;
    list.add(present_horizontal);
    if (present_horizontal)
      list.add(horizontal);

    boolean present_vertical = true;
    list.add(present_vertical);
    if (present_vertical)
      list.add(vertical);

    return list.hashCode();
  }

  @Override
  public int compareTo(Resolution other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetHorizontal()).compareTo(other.isSetHorizontal());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHorizontal()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.horizontal, other.horizontal);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVertical()).compareTo(other.isSetVertical());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVertical()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.vertical, other.vertical);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Resolution(");
    boolean first = true;

    sb.append("horizontal:");
    sb.append(this.horizontal);
    first = false;
    if (!first) sb.append(", ");
    sb.append("vertical:");
    sb.append(this.vertical);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'horizontal' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'vertical' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ResolutionStandardSchemeFactory implements SchemeFactory {
    public ResolutionStandardScheme getScheme() {
      return new ResolutionStandardScheme();
    }
  }

  private static class ResolutionStandardScheme extends StandardScheme<Resolution> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Resolution struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // HORIZONTAL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.horizontal = iprot.readI32();
              struct.setHorizontalIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VERTICAL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.vertical = iprot.readI32();
              struct.setVerticalIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetHorizontal()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'horizontal' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetVertical()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'vertical' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Resolution struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(HORIZONTAL_FIELD_DESC);
      oprot.writeI32(struct.horizontal);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(VERTICAL_FIELD_DESC);
      oprot.writeI32(struct.vertical);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ResolutionTupleSchemeFactory implements SchemeFactory {
    public ResolutionTupleScheme getScheme() {
      return new ResolutionTupleScheme();
    }
  }

  private static class ResolutionTupleScheme extends TupleScheme<Resolution> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Resolution struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.horizontal);
      oprot.writeI32(struct.vertical);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Resolution struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.horizontal = iprot.readI32();
      struct.setHorizontalIsSet(true);
      struct.vertical = iprot.readI32();
      struct.setVerticalIsSet(true);
    }
  }

}

