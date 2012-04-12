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
 * Class Intervals.
 * 
 * @version $Revision$ $Date$
 */
public class Intervals implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _intervalList.
     */
    private java.util.Vector _intervalList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Intervals() {
        super();
        this._intervalList = new java.util.Vector();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vInterval
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addInterval(
            final com.bugclipse.fogbugz.api.Interval vInterval)
    throws java.lang.IndexOutOfBoundsException {
        this._intervalList.addElement(vInterval);
    }

    /**
     * 
     * 
     * @param index
     * @param vInterval
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addInterval(
            final int index,
            final com.bugclipse.fogbugz.api.Interval vInterval)
    throws java.lang.IndexOutOfBoundsException {
        this._intervalList.add(index, vInterval);
    }

    /**
     * Method enumerateInterval.
     * 
     * @return an Enumeration over all
     * com.bugclipse.fogbugz.api.Interval elements
     */
    public java.util.Enumeration enumerateInterval(
    ) {
        return this._intervalList.elements();
    }

    /**
     * Method getInterval.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the com.bugclipse.fogbugz.api.Interval
     * at the given index
     */
    public com.bugclipse.fogbugz.api.Interval getInterval(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._intervalList.size()) {
            throw new IndexOutOfBoundsException("getInterval: Index value '" + index + "' not in range [0.." + (this._intervalList.size() - 1) + "]");
        }
        
        return (com.bugclipse.fogbugz.api.Interval) _intervalList.get(index);
    }

    /**
     * Method getInterval.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.bugclipse.fogbugz.api.Interval[] getInterval(
    ) {
        com.bugclipse.fogbugz.api.Interval[] array = new com.bugclipse.fogbugz.api.Interval[0];
        return (com.bugclipse.fogbugz.api.Interval[]) this._intervalList.toArray(array);
    }

    /**
     * Method getIntervalCount.
     * 
     * @return the size of this collection
     */
    public int getIntervalCount(
    ) {
        return this._intervalList.size();
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
     */
    public void removeAllInterval(
    ) {
        this._intervalList.clear();
    }

    /**
     * Method removeInterval.
     * 
     * @param vInterval
     * @return true if the object was removed from the collection.
     */
    public boolean removeInterval(
            final com.bugclipse.fogbugz.api.Interval vInterval) {
        boolean removed = _intervalList.remove(vInterval);
        return removed;
    }

    /**
     * Method removeIntervalAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.bugclipse.fogbugz.api.Interval removeIntervalAt(
            final int index) {
        java.lang.Object obj = this._intervalList.remove(index);
        return (com.bugclipse.fogbugz.api.Interval) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vInterval
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setInterval(
            final int index,
            final com.bugclipse.fogbugz.api.Interval vInterval)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._intervalList.size()) {
            throw new IndexOutOfBoundsException("setInterval: Index value '" + index + "' not in range [0.." + (this._intervalList.size() - 1) + "]");
        }
        
        this._intervalList.set(index, vInterval);
    }

    /**
     * 
     * 
     * @param vIntervalArray
     */
    public void setInterval(
            final com.bugclipse.fogbugz.api.Interval[] vIntervalArray) {
        //-- copy array
        _intervalList.clear();
        
        for (int i = 0; i < vIntervalArray.length; i++) {
                this._intervalList.add(vIntervalArray[i]);
        }
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled com.bugclipse.fogbugz.api.Intervals
     */
    public static com.bugclipse.fogbugz.api.Intervals unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Intervals) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Intervals.class, reader);
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
