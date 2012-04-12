/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1.2.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.bugclipse.fogbugz.api;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Settings.
 * 
 * @version $Revision$ $Date$
 */
public class Settings implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sTimeZoneKey.
     */
    private java.lang.String _sTimeZoneKey;

    /**
     * Field _nTimeZoneOffset.
     */
    private long _nTimeZoneOffset;

    /**
     * keeps track of state for field: _nTimeZoneOffset
     */
    private boolean _has_nTimeZoneOffset;

    /**
     * Field _cols.
     */
    private java.lang.String _cols;


      //----------------/
     //- Constructors -/
    //----------------/

    public Settings() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteNTimeZoneOffset(
    ) {
        this._has_nTimeZoneOffset= false;
    }

    /**
     * Returns the value of field 'cols'.
     * 
     * @return the value of field 'Cols'.
     */
    public java.lang.String getCols(
    ) {
        return this._cols;
    }

    /**
     * Returns the value of field 'nTimeZoneOffset'.
     * 
     * @return the value of field 'NTimeZoneOffset'.
     */
    public long getNTimeZoneOffset(
    ) {
        return this._nTimeZoneOffset;
    }

    /**
     * Returns the value of field 'sTimeZoneKey'.
     * 
     * @return the value of field 'STimeZoneKey'.
     */
    public java.lang.String getSTimeZoneKey(
    ) {
        return this._sTimeZoneKey;
    }

    /**
     * Method hasNTimeZoneOffset.
     * 
     * @return true if at least one NTimeZoneOffset has been added
     */
    public boolean hasNTimeZoneOffset(
    ) {
        return this._has_nTimeZoneOffset;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'cols'.
     * 
     * @param cols the value of field 'cols'.
     */
    public void setCols(
            final java.lang.String cols) {
        this._cols = cols;
    }

    /**
     * Sets the value of field 'nTimeZoneOffset'.
     * 
     * @param nTimeZoneOffset the value of field 'nTimeZoneOffset'.
     */
    public void setNTimeZoneOffset(
            final long nTimeZoneOffset) {
        this._nTimeZoneOffset = nTimeZoneOffset;
        this._has_nTimeZoneOffset = true;
    }

    /**
     * Sets the value of field 'sTimeZoneKey'.
     * 
     * @param sTimeZoneKey the value of field 'sTimeZoneKey'.
     */
    public void setSTimeZoneKey(
            final java.lang.String sTimeZoneKey) {
        this._sTimeZoneKey = sTimeZoneKey;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled com.bugclipse.fogbugz.api.Settings
     */
    public static com.bugclipse.fogbugz.api.Settings unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Settings) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Settings.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
