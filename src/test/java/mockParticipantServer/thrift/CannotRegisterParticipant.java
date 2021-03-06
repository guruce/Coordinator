/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package tests.mockParticipantServer.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import java.util.*;

public class CannotRegisterParticipant extends TException implements org.apache.thrift.TBase<CannotRegisterParticipant, CannotRegisterParticipant._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CannotRegisterParticipant");

  private static final org.apache.thrift.protocol.TField CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("code", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField SUBCODE_FIELD_DESC = new org.apache.thrift.protocol.TField("subcode", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField REASON_FIELD_DESC = new org.apache.thrift.protocol.TField("reason", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField DETAIL_FIELD_DESC = new org.apache.thrift.protocol.TField("detail", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CannotRegisterParticipantStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CannotRegisterParticipantTupleSchemeFactory());
  }

  public String code; // required
  public String subcode; // required
  public String reason; // required
  public String detail; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CODE((short)1, "code"),
    SUBCODE((short)2, "subcode"),
    REASON((short)3, "reason"),
    DETAIL((short)4, "detail");

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
        case 1: // CODE
          return CODE;
        case 2: // SUBCODE
          return SUBCODE;
        case 3: // REASON
          return REASON;
        case 4: // DETAIL
          return DETAIL;
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
    tmpMap.put(_Fields.CODE, new org.apache.thrift.meta_data.FieldMetaData("code", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SUBCODE, new org.apache.thrift.meta_data.FieldMetaData("subcode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REASON, new org.apache.thrift.meta_data.FieldMetaData("reason", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DETAIL, new org.apache.thrift.meta_data.FieldMetaData("detail", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CannotRegisterParticipant.class, metaDataMap);
  }

  public CannotRegisterParticipant() {
  }

  public CannotRegisterParticipant(
    String code,
    String subcode,
    String reason,
    String detail)
  {
    this();
    this.code = code;
    this.subcode = subcode;
    this.reason = reason;
    this.detail = detail;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CannotRegisterParticipant(CannotRegisterParticipant other) {
    if (other.isSetCode()) {
      this.code = other.code;
    }
    if (other.isSetSubcode()) {
      this.subcode = other.subcode;
    }
    if (other.isSetReason()) {
      this.reason = other.reason;
    }
    if (other.isSetDetail()) {
      this.detail = other.detail;
    }
  }

  public CannotRegisterParticipant deepCopy() {
    return new CannotRegisterParticipant(this);
  }

  @Override
  public void clear() {
    this.code = null;
    this.subcode = null;
    this.reason = null;
    this.detail = null;
  }

  public String getCode() {
    return this.code;
  }

  public CannotRegisterParticipant setCode(String code) {
    this.code = code;
    return this;
  }

  public void unsetCode() {
    this.code = null;
  }

  /** Returns true if field code is set (has been assigned a value) and false otherwise */
  public boolean isSetCode() {
    return this.code != null;
  }

  public void setCodeIsSet(boolean value) {
    if (!value) {
      this.code = null;
    }
  }

  public String getSubcode() {
    return this.subcode;
  }

  public CannotRegisterParticipant setSubcode(String subcode) {
    this.subcode = subcode;
    return this;
  }

  public void unsetSubcode() {
    this.subcode = null;
  }

  /** Returns true if field subcode is set (has been assigned a value) and false otherwise */
  public boolean isSetSubcode() {
    return this.subcode != null;
  }

  public void setSubcodeIsSet(boolean value) {
    if (!value) {
      this.subcode = null;
    }
  }

  public String getReason() {
    return this.reason;
  }

  public CannotRegisterParticipant setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public void unsetReason() {
    this.reason = null;
  }

  /** Returns true if field reason is set (has been assigned a value) and false otherwise */
  public boolean isSetReason() {
    return this.reason != null;
  }

  public void setReasonIsSet(boolean value) {
    if (!value) {
      this.reason = null;
    }
  }

  public String getDetail() {
    return this.detail;
  }

  public CannotRegisterParticipant setDetail(String detail) {
    this.detail = detail;
    return this;
  }

  public void unsetDetail() {
    this.detail = null;
  }

  /** Returns true if field detail is set (has been assigned a value) and false otherwise */
  public boolean isSetDetail() {
    return this.detail != null;
  }

  public void setDetailIsSet(boolean value) {
    if (!value) {
      this.detail = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CODE:
      if (value == null) {
        unsetCode();
      } else {
        setCode((String)value);
      }
      break;

    case SUBCODE:
      if (value == null) {
        unsetSubcode();
      } else {
        setSubcode((String)value);
      }
      break;

    case REASON:
      if (value == null) {
        unsetReason();
      } else {
        setReason((String)value);
      }
      break;

    case DETAIL:
      if (value == null) {
        unsetDetail();
      } else {
        setDetail((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CODE:
      return getCode();

    case SUBCODE:
      return getSubcode();

    case REASON:
      return getReason();

    case DETAIL:
      return getDetail();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CODE:
      return isSetCode();
    case SUBCODE:
      return isSetSubcode();
    case REASON:
      return isSetReason();
    case DETAIL:
      return isSetDetail();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CannotRegisterParticipant)
      return this.equals((CannotRegisterParticipant)that);
    return false;
  }

  public boolean equals(CannotRegisterParticipant that) {
    if (that == null)
      return false;

    boolean this_present_code = true && this.isSetCode();
    boolean that_present_code = true && that.isSetCode();
    if (this_present_code || that_present_code) {
      if (!(this_present_code && that_present_code))
        return false;
      if (!this.code.equals(that.code))
        return false;
    }

    boolean this_present_subcode = true && this.isSetSubcode();
    boolean that_present_subcode = true && that.isSetSubcode();
    if (this_present_subcode || that_present_subcode) {
      if (!(this_present_subcode && that_present_subcode))
        return false;
      if (!this.subcode.equals(that.subcode))
        return false;
    }

    boolean this_present_reason = true && this.isSetReason();
    boolean that_present_reason = true && that.isSetReason();
    if (this_present_reason || that_present_reason) {
      if (!(this_present_reason && that_present_reason))
        return false;
      if (!this.reason.equals(that.reason))
        return false;
    }

    boolean this_present_detail = true && this.isSetDetail();
    boolean that_present_detail = true && that.isSetDetail();
    if (this_present_detail || that_present_detail) {
      if (!(this_present_detail && that_present_detail))
        return false;
      if (!this.detail.equals(that.detail))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(CannotRegisterParticipant other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    CannotRegisterParticipant typedOther = (CannotRegisterParticipant)other;

    lastComparison = Boolean.valueOf(isSetCode()).compareTo(typedOther.isSetCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.code, typedOther.code);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSubcode()).compareTo(typedOther.isSetSubcode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSubcode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.subcode, typedOther.subcode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetReason()).compareTo(typedOther.isSetReason());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReason()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reason, typedOther.reason);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDetail()).compareTo(typedOther.isSetDetail());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDetail()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.detail, typedOther.detail);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CannotRegisterParticipant(");
    boolean first = true;

    sb.append("code:");
    if (this.code == null) {
      sb.append("null");
    } else {
      sb.append(this.code);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("subcode:");
    if (this.subcode == null) {
      sb.append("null");
    } else {
      sb.append(this.subcode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("reason:");
    if (this.reason == null) {
      sb.append("null");
    } else {
      sb.append(this.reason);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("detail:");
    if (this.detail == null) {
      sb.append("null");
    } else {
      sb.append(this.detail);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    if (code == null) {
      throw new TProtocolException("Required field 'code' was not present! Struct: " + toString());
    }
    if (subcode == null) {
      throw new TProtocolException("Required field 'subcode' was not present! Struct: " + toString());
    }
    if (reason == null) {
      throw new TProtocolException("Required field 'reason' was not present! Struct: " + toString());
    }
    if (detail == null) {
      throw new TProtocolException("Required field 'detail' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CannotRegisterParticipantStandardSchemeFactory implements SchemeFactory {
    public CannotRegisterParticipantStandardScheme getScheme() {
      return new CannotRegisterParticipantStandardScheme();
    }
  }

  private static class CannotRegisterParticipantStandardScheme extends StandardScheme<CannotRegisterParticipant> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CannotRegisterParticipant struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.code = iprot.readString();
              struct.setCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SUBCODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.subcode = iprot.readString();
              struct.setSubcodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // REASON
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.reason = iprot.readString();
              struct.setReasonIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DETAIL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.detail = iprot.readString();
              struct.setDetailIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, CannotRegisterParticipant struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.code != null) {
        oprot.writeFieldBegin(CODE_FIELD_DESC);
        oprot.writeString(struct.code);
        oprot.writeFieldEnd();
      }
      if (struct.subcode != null) {
        oprot.writeFieldBegin(SUBCODE_FIELD_DESC);
        oprot.writeString(struct.subcode);
        oprot.writeFieldEnd();
      }
      if (struct.reason != null) {
        oprot.writeFieldBegin(REASON_FIELD_DESC);
        oprot.writeString(struct.reason);
        oprot.writeFieldEnd();
      }
      if (struct.detail != null) {
        oprot.writeFieldBegin(DETAIL_FIELD_DESC);
        oprot.writeString(struct.detail);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CannotRegisterParticipantTupleSchemeFactory implements SchemeFactory {
    public CannotRegisterParticipantTupleScheme getScheme() {
      return new CannotRegisterParticipantTupleScheme();
    }
  }

  private static class CannotRegisterParticipantTupleScheme extends TupleScheme<CannotRegisterParticipant> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CannotRegisterParticipant struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.code);
      oprot.writeString(struct.subcode);
      oprot.writeString(struct.reason);
      oprot.writeString(struct.detail);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CannotRegisterParticipant struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.code = iprot.readString();
      struct.setCodeIsSet(true);
      struct.subcode = iprot.readString();
      struct.setSubcodeIsSet(true);
      struct.reason = iprot.readString();
      struct.setReasonIsSet(true);
      struct.detail = iprot.readString();
      struct.setDetailIsSet(true);
    }
  }

}

