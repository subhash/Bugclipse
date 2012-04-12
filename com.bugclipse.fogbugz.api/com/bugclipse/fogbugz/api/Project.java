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
 * Class Project.
 * 
 * @version $Revision$ $Date$
 */
public class Project implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ixProject.
     */
    private long _ixProject;

    /**
     * keeps track of state for field: _ixProject
     */
    private boolean _has_ixProject;

    /**
     * Field _sProject.
     */
    private java.lang.String _sProject;

    /**
     * Field _ixPersonOwner.
     */
    private long _ixPersonOwner;

    /**
     * keeps track of state for field: _ixPersonOwner
     */
    private boolean _has_ixPersonOwner;

    /**
     * Field _sPersonOwner.
     */
    private java.lang.String _sPersonOwner;

    /**
     * Field _sEmail.
     */
    private java.lang.String _sEmail;

    /**
     * Field _sPhone.
     */
    private java.lang.String _sPhone;

    /**
     * Field _fInbox.
     */
    private boolean _fInbox;

    /**
     * keeps track of state for field: _fInbox
     */
    private boolean _has_fInbox;

    /**
     * Field _iType.
     */
    private long _iType;

    /**
     * keeps track of state for field: _iType
     */
    private boolean _has_iType;

    /**
     * Field _ixGroup.
     */
    private long _ixGroup;

    /**
     * keeps track of state for field: _ixGroup
     */
    private boolean _has_ixGroup;

    /**
     * Field _sGroup.
     */
    private java.lang.String _sGroup;


      //----------------/
     //- Constructors -/
    //----------------/

    public Project() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteFInbox(
    ) {
        this._has_fInbox= false;
    }

    /**
     */
    public void deleteIType(
    ) {
        this._has_iType= false;
    }

    /**
     */
    public void deleteIxGroup(
    ) {
        this._has_ixGroup= false;
    }

    /**
     */
    public void deleteIxPersonOwner(
    ) {
        this._has_ixPersonOwner= false;
    }

    /**
     */
    public void deleteIxProject(
    ) {
        this._has_ixProject= false;
    }

    /**
     * Returns the value of field 'fInbox'.
     * 
     * @return the value of field 'FInbox'.
     */
    public boolean getFInbox(
    ) {
        return this._fInbox;
    }

    /**
     * Returns the value of field 'iType'.
     * 
     * @return the value of field 'IType'.
     */
    public long getIType(
    ) {
        return this._iType;
    }

    /**
     * Returns the value of field 'ixGroup'.
     * 
     * @return the value of field 'IxGroup'.
     */
    public long getIxGroup(
    ) {
        return this._ixGroup;
    }

    /**
     * Returns the value of field 'ixPersonOwner'.
     * 
     * @return the value of field 'IxPersonOwner'.
     */
    public long getIxPersonOwner(
    ) {
        return this._ixPersonOwner;
    }

    /**
     * Returns the value of field 'ixProject'.
     * 
     * @return the value of field 'IxProject'.
     */
    public long getIxProject(
    ) {
        return this._ixProject;
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
     * Returns the value of field 'sGroup'.
     * 
     * @return the value of field 'SGroup'.
     */
    public java.lang.String getSGroup(
    ) {
        return this._sGroup;
    }

    /**
     * Returns the value of field 'sPersonOwner'.
     * 
     * @return the value of field 'SPersonOwner'.
     */
    public java.lang.String getSPersonOwner(
    ) {
        return this._sPersonOwner;
    }

    /**
     * Returns the value of field 'sPhone'.
     * 
     * @return the value of field 'SPhone'.
     */
    public java.lang.String getSPhone(
    ) {
        return this._sPhone;
    }

    /**
     * Returns the value of field 'sProject'.
     * 
     * @return the value of field 'SProject'.
     */
    public java.lang.String getSProject(
    ) {
        return this._sProject;
    }

    /**
     * Method hasFInbox.
     * 
     * @return true if at least one FInbox has been added
     */
    public boolean hasFInbox(
    ) {
        return this._has_fInbox;
    }

    /**
     * Method hasIType.
     * 
     * @return true if at least one IType has been added
     */
    public boolean hasIType(
    ) {
        return this._has_iType;
    }

    /**
     * Method hasIxGroup.
     * 
     * @return true if at least one IxGroup has been added
     */
    public boolean hasIxGroup(
    ) {
        return this._has_ixGroup;
    }

    /**
     * Method hasIxPersonOwner.
     * 
     * @return true if at least one IxPersonOwner has been added
     */
    public boolean hasIxPersonOwner(
    ) {
        return this._has_ixPersonOwner;
    }

    /**
     * Method hasIxProject.
     * 
     * @return true if at least one IxProject has been added
     */
    public boolean hasIxProject(
    ) {
        return this._has_ixProject;
    }

    /**
     * Returns the value of field 'fInbox'.
     * 
     * @return the value of field 'FInbox'.
     */
    public boolean isFInbox(
    ) {
        return this._fInbox;
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
     * Sets the value of field 'fInbox'.
     * 
     * @param fInbox the value of field 'fInbox'.
     */
    public void setFInbox(
            final boolean fInbox) {
        this._fInbox = fInbox;
        this._has_fInbox = true;
    }

    /**
     * Sets the value of field 'iType'.
     * 
     * @param iType the value of field 'iType'.
     */
    public void setIType(
            final long iType) {
        this._iType = iType;
        this._has_iType = true;
    }

    /**
     * Sets the value of field 'ixGroup'.
     * 
     * @param ixGroup the value of field 'ixGroup'.
     */
    public void setIxGroup(
            final long ixGroup) {
        this._ixGroup = ixGroup;
        this._has_ixGroup = true;
    }

    /**
     * Sets the value of field 'ixPersonOwner'.
     * 
     * @param ixPersonOwner the value of field 'ixPersonOwner'.
     */
    public void setIxPersonOwner(
            final long ixPersonOwner) {
        this._ixPersonOwner = ixPersonOwner;
        this._has_ixPersonOwner = true;
    }

    /**
     * Sets the value of field 'ixProject'.
     * 
     * @param ixProject the value of field 'ixProject'.
     */
    public void setIxProject(
            final long ixProject) {
        this._ixProject = ixProject;
        this._has_ixProject = true;
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
     * Sets the value of field 'sGroup'.
     * 
     * @param sGroup the value of field 'sGroup'.
     */
    public void setSGroup(
            final java.lang.String sGroup) {
        this._sGroup = sGroup;
    }

    /**
     * Sets the value of field 'sPersonOwner'.
     * 
     * @param sPersonOwner the value of field 'sPersonOwner'.
     */
    public void setSPersonOwner(
            final java.lang.String sPersonOwner) {
        this._sPersonOwner = sPersonOwner;
    }

    /**
     * Sets the value of field 'sPhone'.
     * 
     * @param sPhone the value of field 'sPhone'.
     */
    public void setSPhone(
            final java.lang.String sPhone) {
        this._sPhone = sPhone;
    }

    /**
     * Sets the value of field 'sProject'.
     * 
     * @param sProject the value of field 'sProject'.
     */
    public void setSProject(
            final java.lang.String sProject) {
        this._sProject = sProject;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled com.bugclipse.fogbugz.api.Project
     */
    public static com.bugclipse.fogbugz.api.Project unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Project) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Project.class, reader);
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
