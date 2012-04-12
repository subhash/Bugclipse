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
 * Class Area.
 * 
 * @version $Revision$ $Date$
 */
public class Area implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ixArea.
     */
    private long _ixArea;

    /**
     * keeps track of state for field: _ixArea
     */
    private boolean _has_ixArea;

    /**
     * Field _sArea.
     */
    private java.lang.String _sArea;

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
    private java.lang.Object _ixPersonOwner;

    /**
     * Field _sPersonOwner.
     */
    private java.lang.Object _sPersonOwner;

    /**
     * Field _nType.
     */
    private long _nType;

    /**
     * keeps track of state for field: _nType
     */
    private boolean _has_nType;

    /**
     * Field _cDoc.
     */
    private long _cDoc;

    /**
     * keeps track of state for field: _cDoc
     */
    private boolean _has_cDoc;


      //----------------/
     //- Constructors -/
    //----------------/

    public Area() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteCDoc(
    ) {
        this._has_cDoc= false;
    }

    /**
     */
    public void deleteIxArea(
    ) {
        this._has_ixArea= false;
    }

    /**
     */
    public void deleteIxProject(
    ) {
        this._has_ixProject= false;
    }

    /**
     */
    public void deleteNType(
    ) {
        this._has_nType= false;
    }

    /**
     * Returns the value of field 'cDoc'.
     * 
     * @return the value of field 'CDoc'.
     */
    public long getCDoc(
    ) {
        return this._cDoc;
    }

    /**
     * Returns the value of field 'ixArea'.
     * 
     * @return the value of field 'IxArea'.
     */
    public long getIxArea(
    ) {
        return this._ixArea;
    }

    /**
     * Returns the value of field 'ixPersonOwner'.
     * 
     * @return the value of field 'IxPersonOwner'.
     */
    public java.lang.Object getIxPersonOwner(
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
     * Returns the value of field 'nType'.
     * 
     * @return the value of field 'NType'.
     */
    public long getNType(
    ) {
        return this._nType;
    }

    /**
     * Returns the value of field 'sArea'.
     * 
     * @return the value of field 'SArea'.
     */
    public java.lang.String getSArea(
    ) {
        return this._sArea;
    }

    /**
     * Returns the value of field 'sPersonOwner'.
     * 
     * @return the value of field 'SPersonOwner'.
     */
    public java.lang.Object getSPersonOwner(
    ) {
        return this._sPersonOwner;
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
     * Method hasCDoc.
     * 
     * @return true if at least one CDoc has been added
     */
    public boolean hasCDoc(
    ) {
        return this._has_cDoc;
    }

    /**
     * Method hasIxArea.
     * 
     * @return true if at least one IxArea has been added
     */
    public boolean hasIxArea(
    ) {
        return this._has_ixArea;
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
     * Method hasNType.
     * 
     * @return true if at least one NType has been added
     */
    public boolean hasNType(
    ) {
        return this._has_nType;
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
     * Sets the value of field 'cDoc'.
     * 
     * @param cDoc the value of field 'cDoc'.
     */
    public void setCDoc(
            final long cDoc) {
        this._cDoc = cDoc;
        this._has_cDoc = true;
    }

    /**
     * Sets the value of field 'ixArea'.
     * 
     * @param ixArea the value of field 'ixArea'.
     */
    public void setIxArea(
            final long ixArea) {
        this._ixArea = ixArea;
        this._has_ixArea = true;
    }

    /**
     * Sets the value of field 'ixPersonOwner'.
     * 
     * @param ixPersonOwner the value of field 'ixPersonOwner'.
     */
    public void setIxPersonOwner(
            final java.lang.Object ixPersonOwner) {
        this._ixPersonOwner = ixPersonOwner;
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
     * Sets the value of field 'nType'.
     * 
     * @param nType the value of field 'nType'.
     */
    public void setNType(
            final long nType) {
        this._nType = nType;
        this._has_nType = true;
    }

    /**
     * Sets the value of field 'sArea'.
     * 
     * @param sArea the value of field 'sArea'.
     */
    public void setSArea(
            final java.lang.String sArea) {
        this._sArea = sArea;
    }

    /**
     * Sets the value of field 'sPersonOwner'.
     * 
     * @param sPersonOwner the value of field 'sPersonOwner'.
     */
    public void setSPersonOwner(
            final java.lang.Object sPersonOwner) {
        this._sPersonOwner = sPersonOwner;
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
     * @return the unmarshaled com.bugclipse.fogbugz.api.Area
     */
    public static com.bugclipse.fogbugz.api.Area unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Area) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Area.class, reader);
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
