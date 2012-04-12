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
 * Class Topic.
 * 
 * @version $Revision$ $Date$
 */
public class Topic implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _postList.
     */
    private java.util.Vector _postList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Topic() {
        super();
        this._postList = new java.util.Vector();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPost
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPost(
            final com.bugclipse.fogbugz.api.Post vPost)
    throws java.lang.IndexOutOfBoundsException {
        this._postList.addElement(vPost);
    }

    /**
     * 
     * 
     * @param index
     * @param vPost
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPost(
            final int index,
            final com.bugclipse.fogbugz.api.Post vPost)
    throws java.lang.IndexOutOfBoundsException {
        this._postList.add(index, vPost);
    }

    /**
     * Method enumeratePost.
     * 
     * @return an Enumeration over all
     * com.bugclipse.fogbugz.api.Post elements
     */
    public java.util.Enumeration enumeratePost(
    ) {
        return this._postList.elements();
    }

    /**
     * Method getPost.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the com.bugclipse.fogbugz.api.Post at
     * the given index
     */
    public com.bugclipse.fogbugz.api.Post getPost(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._postList.size()) {
            throw new IndexOutOfBoundsException("getPost: Index value '" + index + "' not in range [0.." + (this._postList.size() - 1) + "]");
        }
        
        return (com.bugclipse.fogbugz.api.Post) _postList.get(index);
    }

    /**
     * Method getPost.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.bugclipse.fogbugz.api.Post[] getPost(
    ) {
        com.bugclipse.fogbugz.api.Post[] array = new com.bugclipse.fogbugz.api.Post[0];
        return (com.bugclipse.fogbugz.api.Post[]) this._postList.toArray(array);
    }

    /**
     * Method getPostCount.
     * 
     * @return the size of this collection
     */
    public int getPostCount(
    ) {
        return this._postList.size();
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
    public void removeAllPost(
    ) {
        this._postList.clear();
    }

    /**
     * Method removePost.
     * 
     * @param vPost
     * @return true if the object was removed from the collection.
     */
    public boolean removePost(
            final com.bugclipse.fogbugz.api.Post vPost) {
        boolean removed = _postList.remove(vPost);
        return removed;
    }

    /**
     * Method removePostAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.bugclipse.fogbugz.api.Post removePostAt(
            final int index) {
        java.lang.Object obj = this._postList.remove(index);
        return (com.bugclipse.fogbugz.api.Post) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vPost
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPost(
            final int index,
            final com.bugclipse.fogbugz.api.Post vPost)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._postList.size()) {
            throw new IndexOutOfBoundsException("setPost: Index value '" + index + "' not in range [0.." + (this._postList.size() - 1) + "]");
        }
        
        this._postList.set(index, vPost);
    }

    /**
     * 
     * 
     * @param vPostArray
     */
    public void setPost(
            final com.bugclipse.fogbugz.api.Post[] vPostArray) {
        //-- copy array
        _postList.clear();
        
        for (int i = 0; i < vPostArray.length; i++) {
                this._postList.add(vPostArray[i]);
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
     * @return the unmarshaled com.bugclipse.fogbugz.api.Topic
     */
    public static com.bugclipse.fogbugz.api.Topic unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Topic) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Topic.class, reader);
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
