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
 * Class WorkingSchedule.
 * 
 * @version $Revision$ $Date$
 */
public class WorkingSchedule implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ixPerson.
     */
    private long _ixPerson;

    /**
     * keeps track of state for field: _ixPerson
     */
    private boolean _has_ixPerson;

    /**
     * Field _nHoursPerDay.
     */
    private long _nHoursPerDay;

    /**
     * keeps track of state for field: _nHoursPerDay
     */
    private boolean _has_nHoursPerDay;

    /**
     * Field _nWorkdayStarts.
     */
    private long _nWorkdayStarts;

    /**
     * keeps track of state for field: _nWorkdayStarts
     */
    private boolean _has_nWorkdayStarts;

    /**
     * Field _nWorkdayEnds.
     */
    private long _nWorkdayEnds;

    /**
     * keeps track of state for field: _nWorkdayEnds
     */
    private boolean _has_nWorkdayEnds;

    /**
     * Field _fHasLunch.
     */
    private boolean _fHasLunch;

    /**
     * keeps track of state for field: _fHasLunch
     */
    private boolean _has_fHasLunch;

    /**
     * Field _nLunchStarts.
     */
    private long _nLunchStarts;

    /**
     * keeps track of state for field: _nLunchStarts
     */
    private boolean _has_nLunchStarts;

    /**
     * Field _hrsLunchLength.
     */
    private float _hrsLunchLength;

    /**
     * keeps track of state for field: _hrsLunchLength
     */
    private boolean _has_hrsLunchLength;

    /**
     * Field _dtLastUpdated.
     */
    private org.exolab.castor.types.Date _dtLastUpdated;

    /**
     * Field _rgWorkDays.
     */
    private com.bugclipse.fogbugz.api.RgWorkDays _rgWorkDays;


      //----------------/
     //- Constructors -/
    //----------------/

    public WorkingSchedule() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteFHasLunch(
    ) {
        this._has_fHasLunch= false;
    }

    /**
     */
    public void deleteHrsLunchLength(
    ) {
        this._has_hrsLunchLength= false;
    }

    /**
     */
    public void deleteIxPerson(
    ) {
        this._has_ixPerson= false;
    }

    /**
     */
    public void deleteNHoursPerDay(
    ) {
        this._has_nHoursPerDay= false;
    }

    /**
     */
    public void deleteNLunchStarts(
    ) {
        this._has_nLunchStarts= false;
    }

    /**
     */
    public void deleteNWorkdayEnds(
    ) {
        this._has_nWorkdayEnds= false;
    }

    /**
     */
    public void deleteNWorkdayStarts(
    ) {
        this._has_nWorkdayStarts= false;
    }

    /**
     * Returns the value of field 'dtLastUpdated'.
     * 
     * @return the value of field 'DtLastUpdated'.
     */
    public org.exolab.castor.types.Date getDtLastUpdated(
    ) {
        return this._dtLastUpdated;
    }

    /**
     * Returns the value of field 'fHasLunch'.
     * 
     * @return the value of field 'FHasLunch'.
     */
    public boolean getFHasLunch(
    ) {
        return this._fHasLunch;
    }

    /**
     * Returns the value of field 'hrsLunchLength'.
     * 
     * @return the value of field 'HrsLunchLength'.
     */
    public float getHrsLunchLength(
    ) {
        return this._hrsLunchLength;
    }

    /**
     * Returns the value of field 'ixPerson'.
     * 
     * @return the value of field 'IxPerson'.
     */
    public long getIxPerson(
    ) {
        return this._ixPerson;
    }

    /**
     * Returns the value of field 'nHoursPerDay'.
     * 
     * @return the value of field 'NHoursPerDay'.
     */
    public long getNHoursPerDay(
    ) {
        return this._nHoursPerDay;
    }

    /**
     * Returns the value of field 'nLunchStarts'.
     * 
     * @return the value of field 'NLunchStarts'.
     */
    public long getNLunchStarts(
    ) {
        return this._nLunchStarts;
    }

    /**
     * Returns the value of field 'nWorkdayEnds'.
     * 
     * @return the value of field 'NWorkdayEnds'.
     */
    public long getNWorkdayEnds(
    ) {
        return this._nWorkdayEnds;
    }

    /**
     * Returns the value of field 'nWorkdayStarts'.
     * 
     * @return the value of field 'NWorkdayStarts'.
     */
    public long getNWorkdayStarts(
    ) {
        return this._nWorkdayStarts;
    }

    /**
     * Returns the value of field 'rgWorkDays'.
     * 
     * @return the value of field 'RgWorkDays'.
     */
    public com.bugclipse.fogbugz.api.RgWorkDays getRgWorkDays(
    ) {
        return this._rgWorkDays;
    }

    /**
     * Method hasFHasLunch.
     * 
     * @return true if at least one FHasLunch has been added
     */
    public boolean hasFHasLunch(
    ) {
        return this._has_fHasLunch;
    }

    /**
     * Method hasHrsLunchLength.
     * 
     * @return true if at least one HrsLunchLength has been added
     */
    public boolean hasHrsLunchLength(
    ) {
        return this._has_hrsLunchLength;
    }

    /**
     * Method hasIxPerson.
     * 
     * @return true if at least one IxPerson has been added
     */
    public boolean hasIxPerson(
    ) {
        return this._has_ixPerson;
    }

    /**
     * Method hasNHoursPerDay.
     * 
     * @return true if at least one NHoursPerDay has been added
     */
    public boolean hasNHoursPerDay(
    ) {
        return this._has_nHoursPerDay;
    }

    /**
     * Method hasNLunchStarts.
     * 
     * @return true if at least one NLunchStarts has been added
     */
    public boolean hasNLunchStarts(
    ) {
        return this._has_nLunchStarts;
    }

    /**
     * Method hasNWorkdayEnds.
     * 
     * @return true if at least one NWorkdayEnds has been added
     */
    public boolean hasNWorkdayEnds(
    ) {
        return this._has_nWorkdayEnds;
    }

    /**
     * Method hasNWorkdayStarts.
     * 
     * @return true if at least one NWorkdayStarts has been added
     */
    public boolean hasNWorkdayStarts(
    ) {
        return this._has_nWorkdayStarts;
    }

    /**
     * Returns the value of field 'fHasLunch'.
     * 
     * @return the value of field 'FHasLunch'.
     */
    public boolean isFHasLunch(
    ) {
        return this._fHasLunch;
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
     * Sets the value of field 'dtLastUpdated'.
     * 
     * @param dtLastUpdated the value of field 'dtLastUpdated'.
     */
    public void setDtLastUpdated(
            final org.exolab.castor.types.Date dtLastUpdated) {
        this._dtLastUpdated = dtLastUpdated;
    }

    /**
     * Sets the value of field 'fHasLunch'.
     * 
     * @param fHasLunch the value of field 'fHasLunch'.
     */
    public void setFHasLunch(
            final boolean fHasLunch) {
        this._fHasLunch = fHasLunch;
        this._has_fHasLunch = true;
    }

    /**
     * Sets the value of field 'hrsLunchLength'.
     * 
     * @param hrsLunchLength the value of field 'hrsLunchLength'.
     */
    public void setHrsLunchLength(
            final float hrsLunchLength) {
        this._hrsLunchLength = hrsLunchLength;
        this._has_hrsLunchLength = true;
    }

    /**
     * Sets the value of field 'ixPerson'.
     * 
     * @param ixPerson the value of field 'ixPerson'.
     */
    public void setIxPerson(
            final long ixPerson) {
        this._ixPerson = ixPerson;
        this._has_ixPerson = true;
    }

    /**
     * Sets the value of field 'nHoursPerDay'.
     * 
     * @param nHoursPerDay the value of field 'nHoursPerDay'.
     */
    public void setNHoursPerDay(
            final long nHoursPerDay) {
        this._nHoursPerDay = nHoursPerDay;
        this._has_nHoursPerDay = true;
    }

    /**
     * Sets the value of field 'nLunchStarts'.
     * 
     * @param nLunchStarts the value of field 'nLunchStarts'.
     */
    public void setNLunchStarts(
            final long nLunchStarts) {
        this._nLunchStarts = nLunchStarts;
        this._has_nLunchStarts = true;
    }

    /**
     * Sets the value of field 'nWorkdayEnds'.
     * 
     * @param nWorkdayEnds the value of field 'nWorkdayEnds'.
     */
    public void setNWorkdayEnds(
            final long nWorkdayEnds) {
        this._nWorkdayEnds = nWorkdayEnds;
        this._has_nWorkdayEnds = true;
    }

    /**
     * Sets the value of field 'nWorkdayStarts'.
     * 
     * @param nWorkdayStarts the value of field 'nWorkdayStarts'.
     */
    public void setNWorkdayStarts(
            final long nWorkdayStarts) {
        this._nWorkdayStarts = nWorkdayStarts;
        this._has_nWorkdayStarts = true;
    }

    /**
     * Sets the value of field 'rgWorkDays'.
     * 
     * @param rgWorkDays the value of field 'rgWorkDays'.
     */
    public void setRgWorkDays(
            final com.bugclipse.fogbugz.api.RgWorkDays rgWorkDays) {
        this._rgWorkDays = rgWorkDays;
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
     * com.bugclipse.fogbugz.api.WorkingSchedule
     */
    public static com.bugclipse.fogbugz.api.WorkingSchedule unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.WorkingSchedule) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.WorkingSchedule.class, reader);
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
