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
public class Filter implements org.apache.thrift.TBase<Filter, Filter._Fields>, java.io.Serializable, Cloneable, Comparable<Filter> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Filter");

  private static final org.apache.thrift.protocol.TField SOURCE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("sourceType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SINK_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("sinkType", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField FILTER_FIELD_DESC = new org.apache.thrift.protocol.TField("filter", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PARAMS_FIELD_DESC = new org.apache.thrift.protocol.TField("params", org.apache.thrift.protocol.TType.MAP, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FilterStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FilterTupleSchemeFactory());
  }

  /**
   * 
   * @see FilterSourceType
   */
  public FilterSourceType sourceType; // required
  /**
   * 
   * @see FilterSinkType
   */
  public FilterSinkType sinkType; // required
  public String filter; // required
  public Map<String,Double> params; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see FilterSourceType
     */
    SOURCE_TYPE((short)1, "sourceType"),
    /**
     * 
     * @see FilterSinkType
     */
    SINK_TYPE((short)2, "sinkType"),
    FILTER((short)3, "filter"),
    PARAMS((short)4, "params");

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
        case 1: // SOURCE_TYPE
          return SOURCE_TYPE;
        case 2: // SINK_TYPE
          return SINK_TYPE;
        case 3: // FILTER
          return FILTER;
        case 4: // PARAMS
          return PARAMS;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SOURCE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("sourceType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, FilterSourceType.class)));
    tmpMap.put(_Fields.SINK_TYPE, new org.apache.thrift.meta_data.FieldMetaData("sinkType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, FilterSinkType.class)));
    tmpMap.put(_Fields.FILTER, new org.apache.thrift.meta_data.FieldMetaData("filter", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARAMS, new org.apache.thrift.meta_data.FieldMetaData("params", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Filter.class, metaDataMap);
  }

  public Filter() {
  }

  public Filter(
    FilterSourceType sourceType,
    FilterSinkType sinkType,
    String filter,
    Map<String,Double> params)
  {
    this();
    this.sourceType = sourceType;
    this.sinkType = sinkType;
    this.filter = filter;
    this.params = params;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Filter(Filter other) {
    if (other.isSetSourceType()) {
      this.sourceType = other.sourceType;
    }
    if (other.isSetSinkType()) {
      this.sinkType = other.sinkType;
    }
    if (other.isSetFilter()) {
      this.filter = other.filter;
    }
    if (other.isSetParams()) {
      Map<String,Double> __this__params = new HashMap<String,Double>(other.params);
      this.params = __this__params;
    }
  }

  public Filter deepCopy() {
    return new Filter(this);
  }

  @Override
  public void clear() {
    this.sourceType = null;
    this.sinkType = null;
    this.filter = null;
    this.params = null;
  }

  /**
   * 
   * @see FilterSourceType
   */
  public FilterSourceType getSourceType() {
    return this.sourceType;
  }

  /**
   * 
   * @see FilterSourceType
   */
  public Filter setSourceType(FilterSourceType sourceType) {
    this.sourceType = sourceType;
    return this;
  }

  public void unsetSourceType() {
    this.sourceType = null;
  }

  /** Returns true if field sourceType is set (has been assigned a value) and false otherwise */
  public boolean isSetSourceType() {
    return this.sourceType != null;
  }

  public void setSourceTypeIsSet(boolean value) {
    if (!value) {
      this.sourceType = null;
    }
  }

  /**
   * 
   * @see FilterSinkType
   */
  public FilterSinkType getSinkType() {
    return this.sinkType;
  }

  /**
   * 
   * @see FilterSinkType
   */
  public Filter setSinkType(FilterSinkType sinkType) {
    this.sinkType = sinkType;
    return this;
  }

  public void unsetSinkType() {
    this.sinkType = null;
  }

  /** Returns true if field sinkType is set (has been assigned a value) and false otherwise */
  public boolean isSetSinkType() {
    return this.sinkType != null;
  }

  public void setSinkTypeIsSet(boolean value) {
    if (!value) {
      this.sinkType = null;
    }
  }

  public String getFilter() {
    return this.filter;
  }

  public Filter setFilter(String filter) {
    this.filter = filter;
    return this;
  }

  public void unsetFilter() {
    this.filter = null;
  }

  /** Returns true if field filter is set (has been assigned a value) and false otherwise */
  public boolean isSetFilter() {
    return this.filter != null;
  }

  public void setFilterIsSet(boolean value) {
    if (!value) {
      this.filter = null;
    }
  }

  public int getParamsSize() {
    return (this.params == null) ? 0 : this.params.size();
  }

  public void putToParams(String key, double val) {
    if (this.params == null) {
      this.params = new HashMap<String,Double>();
    }
    this.params.put(key, val);
  }

  public Map<String,Double> getParams() {
    return this.params;
  }

  public Filter setParams(Map<String,Double> params) {
    this.params = params;
    return this;
  }

  public void unsetParams() {
    this.params = null;
  }

  /** Returns true if field params is set (has been assigned a value) and false otherwise */
  public boolean isSetParams() {
    return this.params != null;
  }

  public void setParamsIsSet(boolean value) {
    if (!value) {
      this.params = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SOURCE_TYPE:
      if (value == null) {
        unsetSourceType();
      } else {
        setSourceType((FilterSourceType)value);
      }
      break;

    case SINK_TYPE:
      if (value == null) {
        unsetSinkType();
      } else {
        setSinkType((FilterSinkType)value);
      }
      break;

    case FILTER:
      if (value == null) {
        unsetFilter();
      } else {
        setFilter((String)value);
      }
      break;

    case PARAMS:
      if (value == null) {
        unsetParams();
      } else {
        setParams((Map<String,Double>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SOURCE_TYPE:
      return getSourceType();

    case SINK_TYPE:
      return getSinkType();

    case FILTER:
      return getFilter();

    case PARAMS:
      return getParams();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SOURCE_TYPE:
      return isSetSourceType();
    case SINK_TYPE:
      return isSetSinkType();
    case FILTER:
      return isSetFilter();
    case PARAMS:
      return isSetParams();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Filter)
      return this.equals((Filter)that);
    return false;
  }

  public boolean equals(Filter that) {
    if (that == null)
      return false;

    boolean this_present_sourceType = true && this.isSetSourceType();
    boolean that_present_sourceType = true && that.isSetSourceType();
    if (this_present_sourceType || that_present_sourceType) {
      if (!(this_present_sourceType && that_present_sourceType))
        return false;
      if (!this.sourceType.equals(that.sourceType))
        return false;
    }

    boolean this_present_sinkType = true && this.isSetSinkType();
    boolean that_present_sinkType = true && that.isSetSinkType();
    if (this_present_sinkType || that_present_sinkType) {
      if (!(this_present_sinkType && that_present_sinkType))
        return false;
      if (!this.sinkType.equals(that.sinkType))
        return false;
    }

    boolean this_present_filter = true && this.isSetFilter();
    boolean that_present_filter = true && that.isSetFilter();
    if (this_present_filter || that_present_filter) {
      if (!(this_present_filter && that_present_filter))
        return false;
      if (!this.filter.equals(that.filter))
        return false;
    }

    boolean this_present_params = true && this.isSetParams();
    boolean that_present_params = true && that.isSetParams();
    if (this_present_params || that_present_params) {
      if (!(this_present_params && that_present_params))
        return false;
      if (!this.params.equals(that.params))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_sourceType = true && (isSetSourceType());
    list.add(present_sourceType);
    if (present_sourceType)
      list.add(sourceType.getValue());

    boolean present_sinkType = true && (isSetSinkType());
    list.add(present_sinkType);
    if (present_sinkType)
      list.add(sinkType.getValue());

    boolean present_filter = true && (isSetFilter());
    list.add(present_filter);
    if (present_filter)
      list.add(filter);

    boolean present_params = true && (isSetParams());
    list.add(present_params);
    if (present_params)
      list.add(params);

    return list.hashCode();
  }

  @Override
  public int compareTo(Filter other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSourceType()).compareTo(other.isSetSourceType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSourceType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sourceType, other.sourceType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSinkType()).compareTo(other.isSetSinkType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSinkType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sinkType, other.sinkType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFilter()).compareTo(other.isSetFilter());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFilter()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.filter, other.filter);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetParams()).compareTo(other.isSetParams());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParams()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.params, other.params);
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
    StringBuilder sb = new StringBuilder("Filter(");
    boolean first = true;

    sb.append("sourceType:");
    if (this.sourceType == null) {
      sb.append("null");
    } else {
      sb.append(this.sourceType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sinkType:");
    if (this.sinkType == null) {
      sb.append("null");
    } else {
      sb.append(this.sinkType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("filter:");
    if (this.filter == null) {
      sb.append("null");
    } else {
      sb.append(this.filter);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("params:");
    if (this.params == null) {
      sb.append("null");
    } else {
      sb.append(this.params);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (sourceType == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sourceType' was not present! Struct: " + toString());
    }
    if (sinkType == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'sinkType' was not present! Struct: " + toString());
    }
    if (filter == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'filter' was not present! Struct: " + toString());
    }
    if (params == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'params' was not present! Struct: " + toString());
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FilterStandardSchemeFactory implements SchemeFactory {
    public FilterStandardScheme getScheme() {
      return new FilterStandardScheme();
    }
  }

  private static class FilterStandardScheme extends StandardScheme<Filter> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Filter struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SOURCE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sourceType = org.auvua.visionservice.FilterSourceType.findByValue(iprot.readI32());
              struct.setSourceTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SINK_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sinkType = org.auvua.visionservice.FilterSinkType.findByValue(iprot.readI32());
              struct.setSinkTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FILTER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.filter = iprot.readString();
              struct.setFilterIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PARAMS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map10 = iprot.readMapBegin();
                struct.params = new HashMap<String,Double>(2*_map10.size);
                String _key11;
                double _val12;
                for (int _i13 = 0; _i13 < _map10.size; ++_i13)
                {
                  _key11 = iprot.readString();
                  _val12 = iprot.readDouble();
                  struct.params.put(_key11, _val12);
                }
                iprot.readMapEnd();
              }
              struct.setParamsIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Filter struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sourceType != null) {
        oprot.writeFieldBegin(SOURCE_TYPE_FIELD_DESC);
        oprot.writeI32(struct.sourceType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.sinkType != null) {
        oprot.writeFieldBegin(SINK_TYPE_FIELD_DESC);
        oprot.writeI32(struct.sinkType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.filter != null) {
        oprot.writeFieldBegin(FILTER_FIELD_DESC);
        oprot.writeString(struct.filter);
        oprot.writeFieldEnd();
      }
      if (struct.params != null) {
        oprot.writeFieldBegin(PARAMS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.DOUBLE, struct.params.size()));
          for (Map.Entry<String, Double> _iter14 : struct.params.entrySet())
          {
            oprot.writeString(_iter14.getKey());
            oprot.writeDouble(_iter14.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FilterTupleSchemeFactory implements SchemeFactory {
    public FilterTupleScheme getScheme() {
      return new FilterTupleScheme();
    }
  }

  private static class FilterTupleScheme extends TupleScheme<Filter> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Filter struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.sourceType.getValue());
      oprot.writeI32(struct.sinkType.getValue());
      oprot.writeString(struct.filter);
      {
        oprot.writeI32(struct.params.size());
        for (Map.Entry<String, Double> _iter15 : struct.params.entrySet())
        {
          oprot.writeString(_iter15.getKey());
          oprot.writeDouble(_iter15.getValue());
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Filter struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.sourceType = org.auvua.visionservice.FilterSourceType.findByValue(iprot.readI32());
      struct.setSourceTypeIsSet(true);
      struct.sinkType = org.auvua.visionservice.FilterSinkType.findByValue(iprot.readI32());
      struct.setSinkTypeIsSet(true);
      struct.filter = iprot.readString();
      struct.setFilterIsSet(true);
      {
        org.apache.thrift.protocol.TMap _map16 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.DOUBLE, iprot.readI32());
        struct.params = new HashMap<String,Double>(2*_map16.size);
        String _key17;
        double _val18;
        for (int _i19 = 0; _i19 < _map16.size; ++_i19)
        {
          _key17 = iprot.readString();
          _val18 = iprot.readDouble();
          struct.params.put(_key17, _val18);
        }
      }
      struct.setParamsIsSet(true);
    }
  }

}

