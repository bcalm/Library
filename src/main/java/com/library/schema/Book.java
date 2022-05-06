/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.library.schema;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Book extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8800301639744581353L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Book\",\"namespace\":\"com.library.schema\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"isBorrowed\",\"type\":\"boolean\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Book> ENCODER =
      new BinaryMessageEncoder<Book>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Book> DECODER =
      new BinaryMessageDecoder<Book>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Book> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Book> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Book>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Book to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Book from a ByteBuffer. */
  public static Book fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public int id;
  @Deprecated public java.lang.CharSequence name;
  @Deprecated public boolean isBorrowed;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Book() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   * @param isBorrowed The new value for isBorrowed
   */
  public Book(java.lang.Integer id, java.lang.CharSequence name, java.lang.Boolean isBorrowed) {
    this.id = id;
    this.name = name;
    this.isBorrowed = isBorrowed;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return isBorrowed;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Integer)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: isBorrowed = (java.lang.Boolean)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.Integer getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Integer value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'isBorrowed' field.
   * @return The value of the 'isBorrowed' field.
   */
  public java.lang.Boolean getIsBorrowed() {
    return isBorrowed;
  }

  /**
   * Sets the value of the 'isBorrowed' field.
   * @param value the value to set.
   */
  public void setIsBorrowed(java.lang.Boolean value) {
    this.isBorrowed = value;
  }

  /**
   * Creates a new Book RecordBuilder.
   * @return A new Book RecordBuilder
   */
  public static com.library.schema.Book.Builder newBuilder() {
    return new com.library.schema.Book.Builder();
  }

  /**
   * Creates a new Book RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Book RecordBuilder
   */
  public static com.library.schema.Book.Builder newBuilder(com.library.schema.Book.Builder other) {
    return new com.library.schema.Book.Builder(other);
  }

  /**
   * Creates a new Book RecordBuilder by copying an existing Book instance.
   * @param other The existing instance to copy.
   * @return A new Book RecordBuilder
   */
  public static com.library.schema.Book.Builder newBuilder(com.library.schema.Book other) {
    return new com.library.schema.Book.Builder(other);
  }

  /**
   * RecordBuilder for Book instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Book>
    implements org.apache.avro.data.RecordBuilder<Book> {

    private int id;
    private java.lang.CharSequence name;
    private boolean isBorrowed;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.library.schema.Book.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.isBorrowed)) {
        this.isBorrowed = data().deepCopy(fields()[2].schema(), other.isBorrowed);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Book instance
     * @param other The existing instance to copy.
     */
    private Builder(com.library.schema.Book other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.isBorrowed)) {
        this.isBorrowed = data().deepCopy(fields()[2].schema(), other.isBorrowed);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.Integer getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.library.schema.Book.Builder setId(int value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.library.schema.Book.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.library.schema.Book.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.library.schema.Book.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'isBorrowed' field.
      * @return The value.
      */
    public java.lang.Boolean getIsBorrowed() {
      return isBorrowed;
    }

    /**
      * Sets the value of the 'isBorrowed' field.
      * @param value The value of 'isBorrowed'.
      * @return This builder.
      */
    public com.library.schema.Book.Builder setIsBorrowed(boolean value) {
      validate(fields()[2], value);
      this.isBorrowed = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'isBorrowed' field has been set.
      * @return True if the 'isBorrowed' field has been set, false otherwise.
      */
    public boolean hasIsBorrowed() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'isBorrowed' field.
      * @return This builder.
      */
    public com.library.schema.Book.Builder clearIsBorrowed() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Book build() {
      try {
        Book record = new Book();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.isBorrowed = fieldSetFlags()[2] ? this.isBorrowed : (java.lang.Boolean) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Book>
    WRITER$ = (org.apache.avro.io.DatumWriter<Book>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Book>
    READER$ = (org.apache.avro.io.DatumReader<Book>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
