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
 * Class DiscussionContained.
 * 
 * @version $Revision$ $Date$
 */
public class DiscussionContained implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sFullName.
     */
    private java.lang.String _sFullName;

    /**
     * Field _sURL.
     */
    private java.lang.String _sURL;

    /**
     * Field _sTagLineHTML.
     */
    private java.lang.String _sTagLineHTML;

    /**
     * Field _ixDiscussGroup.
     */
    private long _ixDiscussGroup;

    /**
     * keeps track of state for field: _ixDiscussGroup
     */
    private boolean _has_ixDiscussGroup;


      //----------------/
     //- Constructors -/
    //----------------/

    public DiscussionContained() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteIxDiscussGroup(
    ) {
        this._has_ixDiscussGroup= false;
    }

    /**
     * Returns the value of field 'ixDiscussGroup'.
     * 
     * @return the value of field 'IxDiscussGroup'.
     */
    public long getIxDiscussGroup(
    ) {
        return this._ixDiscussGroup;
    }

    /**
     * Returns the value of field 'sFullName'.
     * 
     * @return the value of field 'SFullName'.
     */
    public java.lang.String getSFullName(
    ) {
        return this._sFullName;
    }

    /**
     * Returns the value of field 'sTagLineHTML'.
     * 
     * @return the value of field 'STagLineHTML'.
     */
    public java.lang.String getSTagLineHTML(
    ) {
        return this._sTagLineHTML;
    }

    /**
     * Returns the value of field 'sURL'.
     * 
     * @return the value of field 'SURL'.
     */
    public java.lang.String getSURL(
    ) {
        return this._sURL;
    }

    /**
     * Method hasIxDiscussGroup.
     * 
     * @return true if at least one IxDiscussGroup has been added
     */
    public boolean hasIxDiscussGroup(
    ) {
        return this._has_ixDiscussGroup;
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
     * Sets the value of field 'ixDiscussGroup'.
     * 
     * @param ixDiscussGroup the value of field 'ixDiscussGroup'.
     */
    public void setIxDiscussGroup(
            final long ixDiscussGroup) {
        this._ixDiscussGroup = ixDiscussGroup;
        this._has_ixDiscussGroup = true;
    }

    /**
     * Sets the value of field 'sFullName'.
     * 
     * @param sFullName the value of field 'sFullName'.
     */
    public void setSFullName(
            final java.lang.String sFullName) {
        this._sFullName = sFullName;
    }

    /**
     * Sets the value of field 'sTagLineHTML'.
     * 
     * @param sTagLineHTML the value of field 'sTagLineHTML'.
     */
    public void setSTagLineHTML(
            final java.lang.String sTagLineHTML) {
        this._sTagLineHTML = sTagLineHTML;
    }

    /**
     * Sets the value of field 'sURL'.
     * 
     * @param sURL the value of field 'sURL'.
     */
    public void setSURL(
            final java.lang.String sURL) {
        this._sURL = sURL;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * com.bugclipse.fogbugz.api.DiscussionContained
     */
    public static com.bugclipse.fogbugz.api.DiscussionContained unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.DiscussionContained) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.DiscussionContained.class, reader);
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
