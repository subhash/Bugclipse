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
 * Class Priorities.
 * 
 * @version $Revision$ $Date$
 */
public class Priorities implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _priorityList.
     */
    private java.util.Vector _priorityList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Priorities() {
        super();
        this._priorityList = new java.util.Vector();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPriority
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPriority(
            final com.bugclipse.fogbugz.api.Priority vPriority)
    throws java.lang.IndexOutOfBoundsException {
        this._priorityList.addElement(vPriority);
    }

    /**
     * 
     * 
     * @param index
     * @param vPriority
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPriority(
            final int index,
            final com.bugclipse.fogbugz.api.Priority vPriority)
    throws java.lang.IndexOutOfBoundsException {
        this._priorityList.add(index, vPriority);
    }

    /**
     * Method enumeratePriority.
     * 
     * @return an Enumeration over all
     * com.bugclipse.fogbugz.api.Priority elements
     */
    public java.util.Enumeration enumeratePriority(
    ) {
        return this._priorityList.elements();
    }

    /**
     * Method getPriority.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the com.bugclipse.fogbugz.api.Priority
     * at the given index
     */
    public com.bugclipse.fogbugz.api.Priority getPriority(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._priorityList.size()) {
            throw new IndexOutOfBoundsException("getPriority: Index value '" + index + "' not in range [0.." + (this._priorityList.size() - 1) + "]");
        }
        
        return (com.bugclipse.fogbugz.api.Priority) _priorityList.get(index);
    }

    /**
     * Method getPriority.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.bugclipse.fogbugz.api.Priority[] getPriority(
    ) {
        com.bugclipse.fogbugz.api.Priority[] array = new com.bugclipse.fogbugz.api.Priority[0];
        return (com.bugclipse.fogbugz.api.Priority[]) this._priorityList.toArray(array);
    }

    /**
     * Method getPriorityCount.
     * 
     * @return the size of this collection
     */
    public int getPriorityCount(
    ) {
        return this._priorityList.size();
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
    public void removeAllPriority(
    ) {
        this._priorityList.clear();
    }

    /**
     * Method removePriority.
     * 
     * @param vPriority
     * @return true if the object was removed from the collection.
     */
    public boolean removePriority(
            final com.bugclipse.fogbugz.api.Priority vPriority) {
        boolean removed = _priorityList.remove(vPriority);
        return removed;
    }

    /**
     * Method removePriorityAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.bugclipse.fogbugz.api.Priority removePriorityAt(
            final int index) {
        java.lang.Object obj = this._priorityList.remove(index);
        return (com.bugclipse.fogbugz.api.Priority) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vPriority
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPriority(
            final int index,
            final com.bugclipse.fogbugz.api.Priority vPriority)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._priorityList.size()) {
            throw new IndexOutOfBoundsException("setPriority: Index value '" + index + "' not in range [0.." + (this._priorityList.size() - 1) + "]");
        }
        
        this._priorityList.set(index, vPriority);
    }

    /**
     * 
     * 
     * @param vPriorityArray
     */
    public void setPriority(
            final com.bugclipse.fogbugz.api.Priority[] vPriorityArray) {
        //-- copy array
        _priorityList.clear();
        
        for (int i = 0; i < vPriorityArray.length; i++) {
                this._priorityList.add(vPriorityArray[i]);
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
     * @return the unmarshaled com.bugclipse.fogbugz.api.Priorities
     */
    public static com.bugclipse.fogbugz.api.Priorities unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Priorities) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Priorities.class, reader);
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
