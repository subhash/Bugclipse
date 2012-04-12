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
 * Class Mailbox.
 * 
 * @version $Revision$ $Date$
 */
public class Mailbox implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ixMailbox.
     */
    private long _ixMailbox;

    /**
     * keeps track of state for field: _ixMailbox
     */
    private boolean _has_ixMailbox;

    /**
     * Field _sEmail.
     */
    private java.lang.String _sEmail;

    /**
     * Field _sEmailUser.
     */
    private java.lang.String _sEmailUser;

    /**
     * Field _sTemplate.
     */
    private java.lang.String _sTemplate;


      //----------------/
     //- Constructors -/
    //----------------/

    public Mailbox() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteIxMailbox(
    ) {
        this._has_ixMailbox= false;
    }

    /**
     * Returns the value of field 'ixMailbox'.
     * 
     * @return the value of field 'IxMailbox'.
     */
    public long getIxMailbox(
    ) {
        return this._ixMailbox;
    }

    /**
     * Returns the value of field 'sEmail'.
     * 
     * @return the value of field 'SEmail'.
     */
    public java.lang.String getSEmail(
    ) {
        return this._sEmail;
    }

    /**
     * Returns the value of field 'sEmailUser'.
     * 
     * @return the value of field 'SEmailUser'.
     */
    public java.lang.String getSEmailUser(
    ) {
        return this._sEmailUser;
    }

    /**
     * Returns the value of field 'sTemplate'.
     * 
     * @return the value of field 'STemplate'.
     */
    public java.lang.String getSTemplate(
    ) {
        return this._sTemplate;
    }

    /**
     * Method hasIxMailbox.
     * 
     * @return true if at least one IxMailbox has been added
     */
    public boolean hasIxMailbox(
    ) {
        return this._has_ixMailbox;
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
     * Sets the value of field 'ixMailbox'.
     * 
     * @param ixMailbox the value of field 'ixMailbox'.
     */
    public void setIxMailbox(
            final long ixMailbox) {
        this._ixMailbox = ixMailbox;
        this._has_ixMailbox = true;
    }

    /**
     * Sets the value of field 'sEmail'.
     * 
     * @param sEmail the value of field 'sEmail'.
     */
    public void setSEmail(
            final java.lang.String sEmail) {
        this._sEmail = sEmail;
    }

    /**
     * Sets the value of field 'sEmailUser'.
     * 
     * @param sEmailUser the value of field 'sEmailUser'.
     */
    public void setSEmailUser(
            final java.lang.String sEmailUser) {
        this._sEmailUser = sEmailUser;
    }

    /**
     * Sets the value of field 'sTemplate'.
     * 
     * @param sTemplate the value of field 'sTemplate'.
     */
    public void setSTemplate(
            final java.lang.String sTemplate) {
        this._sTemplate = sTemplate;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled com.bugclipse.fogbugz.api.Mailbox
     */
    public static com.bugclipse.fogbugz.api.Mailbox unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Mailbox) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Mailbox.class, reader);
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
