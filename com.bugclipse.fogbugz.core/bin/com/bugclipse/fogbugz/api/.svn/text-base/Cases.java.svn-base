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
 * Class Cases.
 * 
 * @version $Revision$ $Date$
 */
public class Cases implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _count.
     */
    private long _count;

    /**
     * keeps track of state for field: _count
     */
    private boolean _has_count;

    /**
     * Field _caseList.
     */
    private java.util.Vector _caseList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Cases() {
        super();
        this._caseList = new java.util.Vector();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCase(
            final com.bugclipse.fogbugz.api.Case vCase)
    throws java.lang.IndexOutOfBoundsException {
        this._caseList.addElement(vCase);
    }

    /**
     * 
     * 
     * @param index
     * @param vCase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCase(
            final int index,
            final com.bugclipse.fogbugz.api.Case vCase)
    throws java.lang.IndexOutOfBoundsException {
        this._caseList.add(index, vCase);
    }

    /**
     */
    public void deleteCount(
    ) {
        this._has_count= false;
    }

    /**
     * Method enumerateCase.
     * 
     * @return an Enumeration over all
     * com.bugclipse.fogbugz.api.Case elements
     */
    public java.util.Enumeration enumerateCase(
    ) {
        return this._caseList.elements();
    }

    /**
     * Method getCase.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the com.bugclipse.fogbugz.api.Case at
     * the given index
     */
    public com.bugclipse.fogbugz.api.Case getCase(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._caseList.size()) {
            throw new IndexOutOfBoundsException("getCase: Index value '" + index + "' not in range [0.." + (this._caseList.size() - 1) + "]");
        }
        
        return (com.bugclipse.fogbugz.api.Case) _caseList.get(index);
    }

    /**
     * Method getCase.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.bugclipse.fogbugz.api.Case[] getCase(
    ) {
        com.bugclipse.fogbugz.api.Case[] array = new com.bugclipse.fogbugz.api.Case[0];
        return (com.bugclipse.fogbugz.api.Case[]) this._caseList.toArray(array);
    }

    /**
     * Method getCaseCount.
     * 
     * @return the size of this collection
     */
    public int getCaseCount(
    ) {
        return this._caseList.size();
    }

    /**
     * Returns the value of field 'count'.
     * 
     * @return the value of field 'Count'.
     */
    public long getCount(
    ) {
        return this._count;
    }

    /**
     * Method hasCount.
     * 
     * @return true if at least one Count has been added
     */
    public boolean hasCount(
    ) {
        return this._has_count;
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
    public void removeAllCase(
    ) {
        this._caseList.clear();
    }

    /**
     * Method removeCase.
     * 
     * @param vCase
     * @return true if the object was removed from the collection.
     */
    public boolean removeCase(
            final com.bugclipse.fogbugz.api.Case vCase) {
        boolean removed = _caseList.remove(vCase);
        return removed;
    }

    /**
     * Method removeCaseAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.bugclipse.fogbugz.api.Case removeCaseAt(
            final int index) {
        java.lang.Object obj = this._caseList.remove(index);
        return (com.bugclipse.fogbugz.api.Case) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCase
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCase(
            final int index,
            final com.bugclipse.fogbugz.api.Case vCase)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._caseList.size()) {
            throw new IndexOutOfBoundsException("setCase: Index value '" + index + "' not in range [0.." + (this._caseList.size() - 1) + "]");
        }
        
        this._caseList.set(index, vCase);
    }

    /**
     * 
     * 
     * @param vCaseArray
     */
    public void setCase(
            final com.bugclipse.fogbugz.api.Case[] vCaseArray) {
        //-- copy array
        _caseList.clear();
        
        for (int i = 0; i < vCaseArray.length; i++) {
                this._caseList.add(vCaseArray[i]);
        }
    }

    /**
     * Sets the value of field 'count'.
     * 
     * @param count the value of field 'count'.
     */
    public void setCount(
            final long count) {
        this._count = count;
        this._has_count = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled com.bugclipse.fogbugz.api.Cases
     */
    public static com.bugclipse.fogbugz.api.Cases unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Cases) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Cases.class, reader);
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
