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
 * Class Post.
 * 
 * @version $Revision$ $Date$
 */
public class Post implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ixDiscussTopic.
     */
    private long _ixDiscussTopic;

    /**
     * keeps track of state for field: _ixDiscussTopic
     */
    private boolean _has_ixDiscussTopic;

    /**
     * Field _ixDiscussTopicParent.
     */
    private long _ixDiscussTopicParent;

    /**
     * keeps track of state for field: _ixDiscussTopicParent
     */
    private boolean _has_ixDiscussTopicParent;

    /**
     * Field _sHeadline.
     */
    private java.lang.String _sHeadline;

    /**
     * Field _sFullName.
     */
    private java.lang.String _sFullName;

    /**
     * Field _sURL.
     */
    private java.lang.Object _sURL;

    /**
     * Field _dt.
     */
    private org.exolab.castor.types.Date _dt;

    /**
     * Field _sPost.
     */
    private java.lang.String _sPost;

    /**
     * Field _fModerator.
     */
    private boolean _fModerator;

    /**
     * keeps track of state for field: _fModerator
     */
    private boolean _has_fModerator;

    /**
     * Field _fAuthorized.
     */
    private boolean _fAuthorized;

    /**
     * keeps track of state for field: _fAuthorized
     */
    private boolean _has_fAuthorized;


      //----------------/
     //- Constructors -/
    //----------------/

    public Post() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteFAuthorized(
    ) {
        this._has_fAuthorized= false;
    }

    /**
     */
    public void deleteFModerator(
    ) {
        this._has_fModerator= false;
    }

    /**
     */
    public void deleteIxDiscussTopic(
    ) {
        this._has_ixDiscussTopic= false;
    }

    /**
     */
    public void deleteIxDiscussTopicParent(
    ) {
        this._has_ixDiscussTopicParent= false;
    }

    /**
     * Returns the value of field 'dt'.
     * 
     * @return the value of field 'Dt'.
     */
    public org.exolab.castor.types.Date getDt(
    ) {
        return this._dt;
    }

    /**
     * Returns the value of field 'fAuthorized'.
     * 
     * @return the value of field 'FAuthorized'.
     */
    public boolean getFAuthorized(
    ) {
        return this._fAuthorized;
    }

    /**
     * Returns the value of field 'fModerator'.
     * 
     * @return the value of field 'FModerator'.
     */
    public boolean getFModerator(
    ) {
        return this._fModerator;
    }

    /**
     * Returns the value of field 'ixDiscussTopic'.
     * 
     * @return the value of field 'IxDiscussTopic'.
     */
    public long getIxDiscussTopic(
    ) {
        return this._ixDiscussTopic;
    }

    /**
     * Returns the value of field 'ixDiscussTopicParent'.
     * 
     * @return the value of field 'IxDiscussTopicParent'.
     */
    public long getIxDiscussTopicParent(
    ) {
        return this._ixDiscussTopicParent;
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
     * Returns the value of field 'sHeadline'.
     * 
     * @return the value of field 'SHeadline'.
     */
    public java.lang.String getSHeadline(
    ) {
        return this._sHeadline;
    }

    /**
     * Returns the value of field 'sPost'.
     * 
     * @return the value of field 'SPost'.
     */
    public java.lang.String getSPost(
    ) {
        return this._sPost;
    }

    /**
     * Returns the value of field 'sURL'.
     * 
     * @return the value of field 'SURL'.
     */
    public java.lang.Object getSURL(
    ) {
        return this._sURL;
    }

    /**
     * Method hasFAuthorized.
     * 
     * @return true if at least one FAuthorized has been added
     */
    public boolean hasFAuthorized(
    ) {
        return this._has_fAuthorized;
    }

    /**
     * Method hasFModerator.
     * 
     * @return true if at least one FModerator has been added
     */
    public boolean hasFModerator(
    ) {
        return this._has_fModerator;
    }

    /**
     * Method hasIxDiscussTopic.
     * 
     * @return true if at least one IxDiscussTopic has been added
     */
    public boolean hasIxDiscussTopic(
    ) {
        return this._has_ixDiscussTopic;
    }

    /**
     * Method hasIxDiscussTopicParent.
     * 
     * @return true if at least one IxDiscussTopicParent has been
     * added
     */
    public boolean hasIxDiscussTopicParent(
    ) {
        return this._has_ixDiscussTopicParent;
    }

    /**
     * Returns the value of field 'fAuthorized'.
     * 
     * @return the value of field 'FAuthorized'.
     */
    public boolean isFAuthorized(
    ) {
        return this._fAuthorized;
    }

    /**
     * Returns the value of field 'fModerator'.
     * 
     * @return the value of field 'FModerator'.
     */
    public boolean isFModerator(
    ) {
        return this._fModerator;
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
     * Sets the value of field 'dt'.
     * 
     * @param dt the value of field 'dt'.
     */
    public void setDt(
            final org.exolab.castor.types.Date dt) {
        this._dt = dt;
    }

    /**
     * Sets the value of field 'fAuthorized'.
     * 
     * @param fAuthorized the value of field 'fAuthorized'.
     */
    public void setFAuthorized(
            final boolean fAuthorized) {
        this._fAuthorized = fAuthorized;
        this._has_fAuthorized = true;
    }

    /**
     * Sets the value of field 'fModerator'.
     * 
     * @param fModerator the value of field 'fModerator'.
     */
    public void setFModerator(
            final boolean fModerator) {
        this._fModerator = fModerator;
        this._has_fModerator = true;
    }

    /**
     * Sets the value of field 'ixDiscussTopic'.
     * 
     * @param ixDiscussTopic the value of field 'ixDiscussTopic'.
     */
    public void setIxDiscussTopic(
            final long ixDiscussTopic) {
        this._ixDiscussTopic = ixDiscussTopic;
        this._has_ixDiscussTopic = true;
    }

    /**
     * Sets the value of field 'ixDiscussTopicParent'.
     * 
     * @param ixDiscussTopicParent the value of field
     * 'ixDiscussTopicParent'.
     */
    public void setIxDiscussTopicParent(
            final long ixDiscussTopicParent) {
        this._ixDiscussTopicParent = ixDiscussTopicParent;
        this._has_ixDiscussTopicParent = true;
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
     * Sets the value of field 'sHeadline'.
     * 
     * @param sHeadline the value of field 'sHeadline'.
     */
    public void setSHeadline(
            final java.lang.String sHeadline) {
        this._sHeadline = sHeadline;
    }

    /**
     * Sets the value of field 'sPost'.
     * 
     * @param sPost the value of field 'sPost'.
     */
    public void setSPost(
            final java.lang.String sPost) {
        this._sPost = sPost;
    }

    /**
     * Sets the value of field 'sURL'.
     * 
     * @param sURL the value of field 'sURL'.
     */
    public void setSURL(
            final java.lang.Object sURL) {
        this._sURL = sURL;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled com.bugclipse.fogbugz.api.Post
     */
    public static com.bugclipse.fogbugz.api.Post unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Post) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Post.class, reader);
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
