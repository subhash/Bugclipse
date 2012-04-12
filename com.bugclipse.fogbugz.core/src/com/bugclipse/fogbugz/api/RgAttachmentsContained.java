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
 * Class RgAttachmentsContained.
 * 
 * @version $Revision$ $Date$
 */
public class RgAttachmentsContained implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _attachmentContainedList.
     */
    private java.util.Vector _attachmentContainedList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RgAttachmentsContained() {
        super();
        this._attachmentContainedList = new java.util.Vector();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAttachmentContained
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAttachmentContained(
            final com.bugclipse.fogbugz.api.AttachmentContained vAttachmentContained)
    throws java.lang.IndexOutOfBoundsException {
        this._attachmentContainedList.addElement(vAttachmentContained);
    }

    /**
     * 
     * 
     * @param index
     * @param vAttachmentContained
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAttachmentContained(
            final int index,
            final com.bugclipse.fogbugz.api.AttachmentContained vAttachmentContained)
    throws java.lang.IndexOutOfBoundsException {
        this._attachmentContainedList.add(index, vAttachmentContained);
    }

    /**
     * Method enumerateAttachmentContained.
     * 
     * @return an Enumeration over all
     * com.bugclipse.fogbugz.api.AttachmentContained elements
     */
    public java.util.Enumeration enumerateAttachmentContained(
    ) {
        return this._attachmentContainedList.elements();
    }

    /**
     * Method getAttachmentContained.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.bugclipse.fogbugz.api.AttachmentContained at the given
     * index
     */
    public com.bugclipse.fogbugz.api.AttachmentContained getAttachmentContained(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._attachmentContainedList.size()) {
            throw new IndexOutOfBoundsException("getAttachmentContained: Index value '" + index + "' not in range [0.." + (this._attachmentContainedList.size() - 1) + "]");
        }
        
        return (com.bugclipse.fogbugz.api.AttachmentContained) _attachmentContainedList.get(index);
    }

    /**
     * Method getAttachmentContained.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.bugclipse.fogbugz.api.AttachmentContained[] getAttachmentContained(
    ) {
        com.bugclipse.fogbugz.api.AttachmentContained[] array = new com.bugclipse.fogbugz.api.AttachmentContained[0];
        return (com.bugclipse.fogbugz.api.AttachmentContained[]) this._attachmentContainedList.toArray(array);
    }

    /**
     * Method getAttachmentContainedCount.
     * 
     * @return the size of this collection
     */
    public int getAttachmentContainedCount(
    ) {
        return this._attachmentContainedList.size();
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
    public void removeAllAttachmentContained(
    ) {
        this._attachmentContainedList.clear();
    }

    /**
     * Method removeAttachmentContained.
     * 
     * @param vAttachmentContained
     * @return true if the object was removed from the collection.
     */
    public boolean removeAttachmentContained(
            final com.bugclipse.fogbugz.api.AttachmentContained vAttachmentContained) {
        boolean removed = _attachmentContainedList.remove(vAttachmentContained);
        return removed;
    }

    /**
     * Method removeAttachmentContainedAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.bugclipse.fogbugz.api.AttachmentContained removeAttachmentContainedAt(
            final int index) {
        java.lang.Object obj = this._attachmentContainedList.remove(index);
        return (com.bugclipse.fogbugz.api.AttachmentContained) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vAttachmentContained
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAttachmentContained(
            final int index,
            final com.bugclipse.fogbugz.api.AttachmentContained vAttachmentContained)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._attachmentContainedList.size()) {
            throw new IndexOutOfBoundsException("setAttachmentContained: Index value '" + index + "' not in range [0.." + (this._attachmentContainedList.size() - 1) + "]");
        }
        
        this._attachmentContainedList.set(index, vAttachmentContained);
    }

    /**
     * 
     * 
     * @param vAttachmentContainedArray
     */
    public void setAttachmentContained(
            final com.bugclipse.fogbugz.api.AttachmentContained[] vAttachmentContainedArray) {
        //-- copy array
        _attachmentContainedList.clear();
        
        for (int i = 0; i < vAttachmentContainedArray.length; i++) {
                this._attachmentContainedList.add(vAttachmentContainedArray[i]);
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
     * @return the unmarshaled
     * com.bugclipse.fogbugz.api.RgAttachmentsContained
     */
    public static com.bugclipse.fogbugz.api.RgAttachmentsContained unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.RgAttachmentsContained) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.RgAttachmentsContained.class, reader);
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
