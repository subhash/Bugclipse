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
 * Class Discussion.
 * 
 * @version $Revision$ $Date$
 */
public class Discussion implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sFullName.
     */
    private java.lang.String _sFullName;

    /**
     * Field _sURL.
     */
    private java.lang.String _sURL;

    /**
     * Field _sTagLineHTML.
     */
    private java.lang.String _sTagLineHTML;

    /**
     * Field _topicContainedList.
     */
    private java.util.Vector _topicContainedList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Discussion() {
        super();
        this._topicContainedList = new java.util.Vector();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vTopicContained
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTopicContained(
            final com.bugclipse.fogbugz.api.TopicContained vTopicContained)
    throws java.lang.IndexOutOfBoundsException {
        this._topicContainedList.addElement(vTopicContained);
    }

    /**
     * 
     * 
     * @param index
     * @param vTopicContained
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTopicContained(
            final int index,
            final com.bugclipse.fogbugz.api.TopicContained vTopicContained)
    throws java.lang.IndexOutOfBoundsException {
        this._topicContainedList.add(index, vTopicContained);
    }

    /**
     * Method enumerateTopicContained.
     * 
     * @return an Enumeration over all
     * com.bugclipse.fogbugz.api.TopicContained elements
     */
    public java.util.Enumeration enumerateTopicContained(
    ) {
        return this._topicContainedList.elements();
    }

    /**
     * Returns the value of field 'sFullName'.
     * 
     * @return the value of field 'SFullName'.
     */
    public java.lang.String getSFullName(
    ) {
        return this._sFullName;
    }

    /**
     * Returns the value of field 'sTagLineHTML'.
     * 
     * @return the value of field 'STagLineHTML'.
     */
    public java.lang.String getSTagLineHTML(
    ) {
        return this._sTagLineHTML;
    }

    /**
     * Returns the value of field 'sURL'.
     * 
     * @return the value of field 'SURL'.
     */
    public java.lang.String getSURL(
    ) {
        return this._sURL;
    }

    /**
     * Method getTopicContained.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.bugclipse.fogbugz.api.TopicContained at the given index
     */
    public com.bugclipse.fogbugz.api.TopicContained getTopicContained(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._topicContainedList.size()) {
            throw new IndexOutOfBoundsException("getTopicContained: Index value '" + index + "' not in range [0.." + (this._topicContainedList.size() - 1) + "]");
        }
        
        return (com.bugclipse.fogbugz.api.TopicContained) _topicContainedList.get(index);
    }

    /**
     * Method getTopicContained.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.bugclipse.fogbugz.api.TopicContained[] getTopicContained(
    ) {
        com.bugclipse.fogbugz.api.TopicContained[] array = new com.bugclipse.fogbugz.api.TopicContained[0];
        return (com.bugclipse.fogbugz.api.TopicContained[]) this._topicContainedList.toArray(array);
    }

    /**
     * Method getTopicContainedCount.
     * 
     * @return the size of this collection
     */
    public int getTopicContainedCount(
    ) {
        return this._topicContainedList.size();
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
    public void removeAllTopicContained(
    ) {
        this._topicContainedList.clear();
    }

    /**
     * Method removeTopicContained.
     * 
     * @param vTopicContained
     * @return true if the object was removed from the collection.
     */
    public boolean removeTopicContained(
            final com.bugclipse.fogbugz.api.TopicContained vTopicContained) {
        boolean removed = _topicContainedList.remove(vTopicContained);
        return removed;
    }

    /**
     * Method removeTopicContainedAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.bugclipse.fogbugz.api.TopicContained removeTopicContainedAt(
            final int index) {
        java.lang.Object obj = this._topicContainedList.remove(index);
        return (com.bugclipse.fogbugz.api.TopicContained) obj;
    }

    /**
     * Sets the value of field 'sFullName'.
     * 
     * @param sFullName the value of field 'sFullName'.
     */
    public void setSFullName(
            final java.lang.String sFullName) {
        this._sFullName = sFullName;
    }

    /**
     * Sets the value of field 'sTagLineHTML'.
     * 
     * @param sTagLineHTML the value of field 'sTagLineHTML'.
     */
    public void setSTagLineHTML(
            final java.lang.String sTagLineHTML) {
        this._sTagLineHTML = sTagLineHTML;
    }

    /**
     * Sets the value of field 'sURL'.
     * 
     * @param sURL the value of field 'sURL'.
     */
    public void setSURL(
            final java.lang.String sURL) {
        this._sURL = sURL;
    }

    /**
     * 
     * 
     * @param index
     * @param vTopicContained
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTopicContained(
            final int index,
            final com.bugclipse.fogbugz.api.TopicContained vTopicContained)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._topicContainedList.size()) {
            throw new IndexOutOfBoundsException("setTopicContained: Index value '" + index + "' not in range [0.." + (this._topicContainedList.size() - 1) + "]");
        }
        
        this._topicContainedList.set(index, vTopicContained);
    }

    /**
     * 
     * 
     * @param vTopicContainedArray
     */
    public void setTopicContained(
            final com.bugclipse.fogbugz.api.TopicContained[] vTopicContainedArray) {
        //-- copy array
        _topicContainedList.clear();
        
        for (int i = 0; i < vTopicContainedArray.length; i++) {
                this._topicContainedList.add(vTopicContainedArray[i]);
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
     * @return the unmarshaled com.bugclipse.fogbugz.api.Discussion
     */
    public static com.bugclipse.fogbugz.api.Discussion unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Discussion) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Discussion.class, reader);
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
