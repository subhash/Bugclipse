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
 * Class RgWorkDays.
 * 
 * @version $Revision$ $Date$
 */
public class RgWorkDays implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sunday.
     */
    private boolean _sunday;

    /**
     * keeps track of state for field: _sunday
     */
    private boolean _has_sunday;

    /**
     * Field _monday.
     */
    private boolean _monday;

    /**
     * keeps track of state for field: _monday
     */
    private boolean _has_monday;

    /**
     * Field _tuesday.
     */
    private boolean _tuesday;

    /**
     * keeps track of state for field: _tuesday
     */
    private boolean _has_tuesday;

    /**
     * Field _wednesday.
     */
    private boolean _wednesday;

    /**
     * keeps track of state for field: _wednesday
     */
    private boolean _has_wednesday;

    /**
     * Field _thursday.
     */
    private boolean _thursday;

    /**
     * keeps track of state for field: _thursday
     */
    private boolean _has_thursday;

    /**
     * Field _friday.
     */
    private boolean _friday;

    /**
     * keeps track of state for field: _friday
     */
    private boolean _has_friday;

    /**
     * Field _saturday.
     */
    private boolean _saturday;

    /**
     * keeps track of state for field: _saturday
     */
    private boolean _has_saturday;


      //----------------/
     //- Constructors -/
    //----------------/

    public RgWorkDays() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteFriday(
    ) {
        this._has_friday= false;
    }

    /**
     */
    public void deleteMonday(
    ) {
        this._has_monday= false;
    }

    /**
     */
    public void deleteSaturday(
    ) {
        this._has_saturday= false;
    }

    /**
     */
    public void deleteSunday(
    ) {
        this._has_sunday= false;
    }

    /**
     */
    public void deleteThursday(
    ) {
        this._has_thursday= false;
    }

    /**
     */
    public void deleteTuesday(
    ) {
        this._has_tuesday= false;
    }

    /**
     */
    public void deleteWednesday(
    ) {
        this._has_wednesday= false;
    }

    /**
     * Returns the value of field 'friday'.
     * 
     * @return the value of field 'Friday'.
     */
    public boolean getFriday(
    ) {
        return this._friday;
    }

    /**
     * Returns the value of field 'monday'.
     * 
     * @return the value of field 'Monday'.
     */
    public boolean getMonday(
    ) {
        return this._monday;
    }

    /**
     * Returns the value of field 'saturday'.
     * 
     * @return the value of field 'Saturday'.
     */
    public boolean getSaturday(
    ) {
        return this._saturday;
    }

    /**
     * Returns the value of field 'sunday'.
     * 
     * @return the value of field 'Sunday'.
     */
    public boolean getSunday(
    ) {
        return this._sunday;
    }

    /**
     * Returns the value of field 'thursday'.
     * 
     * @return the value of field 'Thursday'.
     */
    public boolean getThursday(
    ) {
        return this._thursday;
    }

    /**
     * Returns the value of field 'tuesday'.
     * 
     * @return the value of field 'Tuesday'.
     */
    public boolean getTuesday(
    ) {
        return this._tuesday;
    }

    /**
     * Returns the value of field 'wednesday'.
     * 
     * @return the value of field 'Wednesday'.
     */
    public boolean getWednesday(
    ) {
        return this._wednesday;
    }

    /**
     * Method hasFriday.
     * 
     * @return true if at least one Friday has been added
     */
    public boolean hasFriday(
    ) {
        return this._has_friday;
    }

    /**
     * Method hasMonday.
     * 
     * @return true if at least one Monday has been added
     */
    public boolean hasMonday(
    ) {
        return this._has_monday;
    }

    /**
     * Method hasSaturday.
     * 
     * @return true if at least one Saturday has been added
     */
    public boolean hasSaturday(
    ) {
        return this._has_saturday;
    }

    /**
     * Method hasSunday.
     * 
     * @return true if at least one Sunday has been added
     */
    public boolean hasSunday(
    ) {
        return this._has_sunday;
    }

    /**
     * Method hasThursday.
     * 
     * @return true if at least one Thursday has been added
     */
    public boolean hasThursday(
    ) {
        return this._has_thursday;
    }

    /**
     * Method hasTuesday.
     * 
     * @return true if at least one Tuesday has been added
     */
    public boolean hasTuesday(
    ) {
        return this._has_tuesday;
    }

    /**
     * Method hasWednesday.
     * 
     * @return true if at least one Wednesday has been added
     */
    public boolean hasWednesday(
    ) {
        return this._has_wednesday;
    }

    /**
     * Returns the value of field 'friday'.
     * 
     * @return the value of field 'Friday'.
     */
    public boolean isFriday(
    ) {
        return this._friday;
    }

    /**
     * Returns the value of field 'monday'.
     * 
     * @return the value of field 'Monday'.
     */
    public boolean isMonday(
    ) {
        return this._monday;
    }

    /**
     * Returns the value of field 'saturday'.
     * 
     * @return the value of field 'Saturday'.
     */
    public boolean isSaturday(
    ) {
        return this._saturday;
    }

    /**
     * Returns the value of field 'sunday'.
     * 
     * @return the value of field 'Sunday'.
     */
    public boolean isSunday(
    ) {
        return this._sunday;
    }

    /**
     * Returns the value of field 'thursday'.
     * 
     * @return the value of field 'Thursday'.
     */
    public boolean isThursday(
    ) {
        return this._thursday;
    }

    /**
     * Returns the value of field 'tuesday'.
     * 
     * @return the value of field 'Tuesday'.
     */
    public boolean isTuesday(
    ) {
        return this._tuesday;
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
     * Returns the value of field 'wednesday'.
     * 
     * @return the value of field 'Wednesday'.
     */
    public boolean isWednesday(
    ) {
        return this._wednesday;
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
     * Sets the value of field 'friday'.
     * 
     * @param friday the value of field 'friday'.
     */
    public void setFriday(
            final boolean friday) {
        this._friday = friday;
        this._has_friday = true;
    }

    /**
     * Sets the value of field 'monday'.
     * 
     * @param monday the value of field 'monday'.
     */
    public void setMonday(
            final boolean monday) {
        this._monday = monday;
        this._has_monday = true;
    }

    /**
     * Sets the value of field 'saturday'.
     * 
     * @param saturday the value of field 'saturday'.
     */
    public void setSaturday(
            final boolean saturday) {
        this._saturday = saturday;
        this._has_saturday = true;
    }

    /**
     * Sets the value of field 'sunday'.
     * 
     * @param sunday the value of field 'sunday'.
     */
    public void setSunday(
            final boolean sunday) {
        this._sunday = sunday;
        this._has_sunday = true;
    }

    /**
     * Sets the value of field 'thursday'.
     * 
     * @param thursday the value of field 'thursday'.
     */
    public void setThursday(
            final boolean thursday) {
        this._thursday = thursday;
        this._has_thursday = true;
    }

    /**
     * Sets the value of field 'tuesday'.
     * 
     * @param tuesday the value of field 'tuesday'.
     */
    public void setTuesday(
            final boolean tuesday) {
        this._tuesday = tuesday;
        this._has_tuesday = true;
    }

    /**
     * Sets the value of field 'wednesday'.
     * 
     * @param wednesday the value of field 'wednesday'.
     */
    public void setWednesday(
            final boolean wednesday) {
        this._wednesday = wednesday;
        this._has_wednesday = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled com.bugclipse.fogbugz.api.RgWorkDays
     */
    public static com.bugclipse.fogbugz.api.RgWorkDays unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.RgWorkDays) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.RgWorkDays.class, reader);
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
