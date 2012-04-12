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
 * Class People.
 * 
 * @version $Revision$ $Date$
 */
public class People implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _personList.
     */
    private java.util.Vector _personList;


      //----------------/
     //- Constructors -/
    //----------------/

    public People() {
        super();
        this._personList = new java.util.Vector();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPerson(
            final com.bugclipse.fogbugz.api.Person vPerson)
    throws java.lang.IndexOutOfBoundsException {
        this._personList.addElement(vPerson);
    }

    /**
     * 
     * 
     * @param index
     * @param vPerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPerson(
            final int index,
            final com.bugclipse.fogbugz.api.Person vPerson)
    throws java.lang.IndexOutOfBoundsException {
        this._personList.add(index, vPerson);
    }

    /**
     * Method enumeratePerson.
     * 
     * @return an Enumeration over all
     * com.bugclipse.fogbugz.api.Person elements
     */
    public java.util.Enumeration enumeratePerson(
    ) {
        return this._personList.elements();
    }

    /**
     * Method getPerson.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the com.bugclipse.fogbugz.api.Person at
     * the given index
     */
    public com.bugclipse.fogbugz.api.Person getPerson(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._personList.size()) {
            throw new IndexOutOfBoundsException("getPerson: Index value '" + index + "' not in range [0.." + (this._personList.size() - 1) + "]");
        }
        
        return (com.bugclipse.fogbugz.api.Person) _personList.get(index);
    }

    /**
     * Method getPerson.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.bugclipse.fogbugz.api.Person[] getPerson(
    ) {
        com.bugclipse.fogbugz.api.Person[] array = new com.bugclipse.fogbugz.api.Person[0];
        return (com.bugclipse.fogbugz.api.Person[]) this._personList.toArray(array);
    }

    /**
     * Method getPersonCount.
     * 
     * @return the size of this collection
     */
    public int getPersonCount(
    ) {
        return this._personList.size();
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
    public void removeAllPerson(
    ) {
        this._personList.clear();
    }

    /**
     * Method removePerson.
     * 
     * @param vPerson
     * @return true if the object was removed from the collection.
     */
    public boolean removePerson(
            final com.bugclipse.fogbugz.api.Person vPerson) {
        boolean removed = _personList.remove(vPerson);
        return removed;
    }

    /**
     * Method removePersonAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.bugclipse.fogbugz.api.Person removePersonAt(
            final int index) {
        java.lang.Object obj = this._personList.remove(index);
        return (com.bugclipse.fogbugz.api.Person) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vPerson
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPerson(
            final int index,
            final com.bugclipse.fogbugz.api.Person vPerson)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._personList.size()) {
            throw new IndexOutOfBoundsException("setPerson: Index value '" + index + "' not in range [0.." + (this._personList.size() - 1) + "]");
        }
        
        this._personList.set(index, vPerson);
    }

    /**
     * 
     * 
     * @param vPersonArray
     */
    public void setPerson(
            final com.bugclipse.fogbugz.api.Person[] vPersonArray) {
        //-- copy array
        _personList.clear();
        
        for (int i = 0; i < vPersonArray.length; i++) {
                this._personList.add(vPersonArray[i]);
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
     * @return the unmarshaled com.bugclipse.fogbugz.api.People
     */
    public static com.bugclipse.fogbugz.api.People unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.People) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.People.class, reader);
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
