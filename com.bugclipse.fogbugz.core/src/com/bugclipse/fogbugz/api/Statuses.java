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
 * Class Statuses.
 * 
 * @version $Revision$ $Date$
 */
public class Statuses implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _statusList.
     */
    private java.util.Vector _statusList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Statuses() {
        super();
        this._statusList = new java.util.Vector();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addStatus(
            final com.bugclipse.fogbugz.api.Status vStatus)
    throws java.lang.IndexOutOfBoundsException {
        this._statusList.addElement(vStatus);
    }

    /**
     * 
     * 
     * @param index
     * @param vStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addStatus(
            final int index,
            final com.bugclipse.fogbugz.api.Status vStatus)
    throws java.lang.IndexOutOfBoundsException {
        this._statusList.add(index, vStatus);
    }

    /**
     * Method enumerateStatus.
     * 
     * @return an Enumeration over all
     * com.bugclipse.fogbugz.api.Status elements
     */
    public java.util.Enumeration enumerateStatus(
    ) {
        return this._statusList.elements();
    }

    /**
     * Method getStatus.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the com.bugclipse.fogbugz.api.Status at
     * the given index
     */
    public com.bugclipse.fogbugz.api.Status getStatus(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._statusList.size()) {
            throw new IndexOutOfBoundsException("getStatus: Index value '" + index + "' not in range [0.." + (this._statusList.size() - 1) + "]");
        }
        
        return (com.bugclipse.fogbugz.api.Status) _statusList.get(index);
    }

    /**
     * Method getStatus.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.bugclipse.fogbugz.api.Status[] getStatus(
    ) {
        com.bugclipse.fogbugz.api.Status[] array = new com.bugclipse.fogbugz.api.Status[0];
        return (com.bugclipse.fogbugz.api.Status[]) this._statusList.toArray(array);
    }

    /**
     * Method getStatusCount.
     * 
     * @return the size of this collection
     */
    public int getStatusCount(
    ) {
        return this._statusList.size();
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
    public void removeAllStatus(
    ) {
        this._statusList.clear();
    }

    /**
     * Method removeStatus.
     * 
     * @param vStatus
     * @return true if the object was removed from the collection.
     */
    public boolean removeStatus(
            final com.bugclipse.fogbugz.api.Status vStatus) {
        boolean removed = _statusList.remove(vStatus);
        return removed;
    }

    /**
     * Method removeStatusAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.bugclipse.fogbugz.api.Status removeStatusAt(
            final int index) {
        java.lang.Object obj = this._statusList.remove(index);
        return (com.bugclipse.fogbugz.api.Status) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vStatus
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setStatus(
            final int index,
            final com.bugclipse.fogbugz.api.Status vStatus)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._statusList.size()) {
            throw new IndexOutOfBoundsException("setStatus: Index value '" + index + "' not in range [0.." + (this._statusList.size() - 1) + "]");
        }
        
        this._statusList.set(index, vStatus);
    }

    /**
     * 
     * 
     * @param vStatusArray
     */
    public void setStatus(
            final com.bugclipse.fogbugz.api.Status[] vStatusArray) {
        //-- copy array
        _statusList.clear();
        
        for (int i = 0; i < vStatusArray.length; i++) {
                this._statusList.add(vStatusArray[i]);
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
     * @return the unmarshaled com.bugclipse.fogbugz.api.Statuses
     */
    public static com.bugclipse.fogbugz.api.Statuses unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Statuses) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Statuses.class, reader);
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
