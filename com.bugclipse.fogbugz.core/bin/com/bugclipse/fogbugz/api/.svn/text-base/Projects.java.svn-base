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
 * Class Projects.
 * 
 * @version $Revision$ $Date$
 */
public class Projects implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _projectList.
     */
    private java.util.Vector _projectList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Projects() {
        super();
        this._projectList = new java.util.Vector();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vProject
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addProject(
            final com.bugclipse.fogbugz.api.Project vProject)
    throws java.lang.IndexOutOfBoundsException {
        this._projectList.addElement(vProject);
    }

    /**
     * 
     * 
     * @param index
     * @param vProject
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addProject(
            final int index,
            final com.bugclipse.fogbugz.api.Project vProject)
    throws java.lang.IndexOutOfBoundsException {
        this._projectList.add(index, vProject);
    }

    /**
     * Method enumerateProject.
     * 
     * @return an Enumeration over all
     * com.bugclipse.fogbugz.api.Project elements
     */
    public java.util.Enumeration enumerateProject(
    ) {
        return this._projectList.elements();
    }

    /**
     * Method getProject.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the com.bugclipse.fogbugz.api.Project
     * at the given index
     */
    public com.bugclipse.fogbugz.api.Project getProject(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._projectList.size()) {
            throw new IndexOutOfBoundsException("getProject: Index value '" + index + "' not in range [0.." + (this._projectList.size() - 1) + "]");
        }
        
        return (com.bugclipse.fogbugz.api.Project) _projectList.get(index);
    }

    /**
     * Method getProject.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.bugclipse.fogbugz.api.Project[] getProject(
    ) {
        com.bugclipse.fogbugz.api.Project[] array = new com.bugclipse.fogbugz.api.Project[0];
        return (com.bugclipse.fogbugz.api.Project[]) this._projectList.toArray(array);
    }

    /**
     * Method getProjectCount.
     * 
     * @return the size of this collection
     */
    public int getProjectCount(
    ) {
        return this._projectList.size();
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
    public void removeAllProject(
    ) {
        this._projectList.clear();
    }

    /**
     * Method removeProject.
     * 
     * @param vProject
     * @return true if the object was removed from the collection.
     */
    public boolean removeProject(
            final com.bugclipse.fogbugz.api.Project vProject) {
        boolean removed = _projectList.remove(vProject);
        return removed;
    }

    /**
     * Method removeProjectAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.bugclipse.fogbugz.api.Project removeProjectAt(
            final int index) {
        java.lang.Object obj = this._projectList.remove(index);
        return (com.bugclipse.fogbugz.api.Project) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vProject
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setProject(
            final int index,
            final com.bugclipse.fogbugz.api.Project vProject)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._projectList.size()) {
            throw new IndexOutOfBoundsException("setProject: Index value '" + index + "' not in range [0.." + (this._projectList.size() - 1) + "]");
        }
        
        this._projectList.set(index, vProject);
    }

    /**
     * 
     * 
     * @param vProjectArray
     */
    public void setProject(
            final com.bugclipse.fogbugz.api.Project[] vProjectArray) {
        //-- copy array
        _projectList.clear();
        
        for (int i = 0; i < vProjectArray.length; i++) {
                this._projectList.add(vProjectArray[i]);
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
     * @return the unmarshaled com.bugclipse.fogbugz.api.Projects
     */
    public static com.bugclipse.fogbugz.api.Projects unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Projects) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Projects.class, reader);
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
