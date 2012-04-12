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
 * Class Filters.
 * 
 * @version $Revision$ $Date$
 */
public class Filters implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _filterList.
     */
    private java.util.Vector _filterList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Filters() {
        super();
        this._filterList = new java.util.Vector();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vFilter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFilter(
            final com.bugclipse.fogbugz.api.Filter vFilter)
    throws java.lang.IndexOutOfBoundsException {
        this._filterList.addElement(vFilter);
    }

    /**
     * 
     * 
     * @param index
     * @param vFilter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addFilter(
            final int index,
            final com.bugclipse.fogbugz.api.Filter vFilter)
    throws java.lang.IndexOutOfBoundsException {
        this._filterList.add(index, vFilter);
    }

    /**
     * Method enumerateFilter.
     * 
     * @return an Enumeration over all
     * com.bugclipse.fogbugz.api.Filter elements
     */
    public java.util.Enumeration enumerateFilter(
    ) {
        return this._filterList.elements();
    }

    /**
     * Method getFilter.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the com.bugclipse.fogbugz.api.Filter at
     * the given index
     */
    public com.bugclipse.fogbugz.api.Filter getFilter(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._filterList.size()) {
            throw new IndexOutOfBoundsException("getFilter: Index value '" + index + "' not in range [0.." + (this._filterList.size() - 1) + "]");
        }
        
        return (com.bugclipse.fogbugz.api.Filter) _filterList.get(index);
    }

    /**
     * Method getFilter.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.bugclipse.fogbugz.api.Filter[] getFilter(
    ) {
        com.bugclipse.fogbugz.api.Filter[] array = new com.bugclipse.fogbugz.api.Filter[0];
        return (com.bugclipse.fogbugz.api.Filter[]) this._filterList.toArray(array);
    }

    /**
     * Method getFilterCount.
     * 
     * @return the size of this collection
     */
    public int getFilterCount(
    ) {
        return this._filterList.size();
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
    public void removeAllFilter(
    ) {
        this._filterList.clear();
    }

    /**
     * Method removeFilter.
     * 
     * @param vFilter
     * @return true if the object was removed from the collection.
     */
    public boolean removeFilter(
            final com.bugclipse.fogbugz.api.Filter vFilter) {
        boolean removed = _filterList.remove(vFilter);
        return removed;
    }

    /**
     * Method removeFilterAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.bugclipse.fogbugz.api.Filter removeFilterAt(
            final int index) {
        java.lang.Object obj = this._filterList.remove(index);
        return (com.bugclipse.fogbugz.api.Filter) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vFilter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setFilter(
            final int index,
            final com.bugclipse.fogbugz.api.Filter vFilter)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._filterList.size()) {
            throw new IndexOutOfBoundsException("setFilter: Index value '" + index + "' not in range [0.." + (this._filterList.size() - 1) + "]");
        }
        
        this._filterList.set(index, vFilter);
    }

    /**
     * 
     * 
     * @param vFilterArray
     */
    public void setFilter(
            final com.bugclipse.fogbugz.api.Filter[] vFilterArray) {
        //-- copy array
        _filterList.clear();
        
        for (int i = 0; i < vFilterArray.length; i++) {
                this._filterList.add(vFilterArray[i]);
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
     * @return the unmarshaled com.bugclipse.fogbugz.api.Filters
     */
    public static com.bugclipse.fogbugz.api.Filters unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Filters) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Filters.class, reader);
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
