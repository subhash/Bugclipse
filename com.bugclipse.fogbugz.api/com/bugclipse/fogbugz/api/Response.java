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
 * Class Response.
 * 
 * @version $Revision$ $Date$
 */
public class Response implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _version.
     */
    private long _version;

    /**
     * keeps track of state for field: _version
     */
    private boolean _has_version;

    /**
     * Field _minversion.
     */
    private long _minversion;

    /**
     * keeps track of state for field: _minversion
     */
    private boolean _has_minversion;

    /**
     * Field _url.
     */
    private java.lang.String _url;

    /**
     * Field _error.
     */
    private com.bugclipse.fogbugz.api.Error _error;

    /**
     * Field _filters.
     */
    private com.bugclipse.fogbugz.api.Filters _filters;

    /**
     * Field _cases.
     */
    private com.bugclipse.fogbugz.api.Cases _cases;

    /**
     * Field _events.
     */
    private com.bugclipse.fogbugz.api.Events _events;

    /**
     * Field _projects.
     */
    private com.bugclipse.fogbugz.api.Projects _projects;

    /**
     * Field _areas.
     */
    private com.bugclipse.fogbugz.api.Areas _areas;

    /**
     * Field _priorities.
     */
    private com.bugclipse.fogbugz.api.Priorities _priorities;

    /**
     * Field _categories.
     */
    private com.bugclipse.fogbugz.api.Categories _categories;

    /**
     * Field _workingSchedule.
     */
    private com.bugclipse.fogbugz.api.WorkingSchedule _workingSchedule;

    /**
     * Field _intervals.
     */
    private com.bugclipse.fogbugz.api.Intervals _intervals;

    /**
     * Field _people.
     */
    private com.bugclipse.fogbugz.api.People _people;

    /**
     * Field _topic.
     */
    private com.bugclipse.fogbugz.api.Topic _topic;

    /**
     * Field _discussion.
     */
    private com.bugclipse.fogbugz.api.Discussion _discussion;

    /**
     * Field _discussions.
     */
    private com.bugclipse.fogbugz.api.Discussions _discussions;

    /**
     * Field _checkins.
     */
    private com.bugclipse.fogbugz.api.Checkins _checkins;

    /**
     * Field _mailboxes.
     */
    private com.bugclipse.fogbugz.api.Mailboxes _mailboxes;

    /**
     * Field _settings.
     */
    private com.bugclipse.fogbugz.api.Settings _settings;


      //----------------/
     //- Constructors -/
    //----------------/

    public Response() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteMinversion(
    ) {
        this._has_minversion= false;
    }

    /**
     */
    public void deleteVersion(
    ) {
        this._has_version= false;
    }

    /**
     * Returns the value of field 'areas'.
     * 
     * @return the value of field 'Areas'.
     */
    public com.bugclipse.fogbugz.api.Areas getAreas(
    ) {
        return this._areas;
    }

    /**
     * Returns the value of field 'cases'.
     * 
     * @return the value of field 'Cases'.
     */
    public com.bugclipse.fogbugz.api.Cases getCases(
    ) {
        return this._cases;
    }

    /**
     * Returns the value of field 'categories'.
     * 
     * @return the value of field 'Categories'.
     */
    public com.bugclipse.fogbugz.api.Categories getCategories(
    ) {
        return this._categories;
    }

    /**
     * Returns the value of field 'checkins'.
     * 
     * @return the value of field 'Checkins'.
     */
    public com.bugclipse.fogbugz.api.Checkins getCheckins(
    ) {
        return this._checkins;
    }

    /**
     * Returns the value of field 'discussion'.
     * 
     * @return the value of field 'Discussion'.
     */
    public com.bugclipse.fogbugz.api.Discussion getDiscussion(
    ) {
        return this._discussion;
    }

    /**
     * Returns the value of field 'discussions'.
     * 
     * @return the value of field 'Discussions'.
     */
    public com.bugclipse.fogbugz.api.Discussions getDiscussions(
    ) {
        return this._discussions;
    }

    /**
     * Returns the value of field 'error'.
     * 
     * @return the value of field 'Error'.
     */
    public com.bugclipse.fogbugz.api.Error getError(
    ) {
        return this._error;
    }

    /**
     * Returns the value of field 'events'.
     * 
     * @return the value of field 'Events'.
     */
    public com.bugclipse.fogbugz.api.Events getEvents(
    ) {
        return this._events;
    }

    /**
     * Returns the value of field 'filters'.
     * 
     * @return the value of field 'Filters'.
     */
    public com.bugclipse.fogbugz.api.Filters getFilters(
    ) {
        return this._filters;
    }

    /**
     * Returns the value of field 'intervals'.
     * 
     * @return the value of field 'Intervals'.
     */
    public com.bugclipse.fogbugz.api.Intervals getIntervals(
    ) {
        return this._intervals;
    }

    /**
     * Returns the value of field 'mailboxes'.
     * 
     * @return the value of field 'Mailboxes'.
     */
    public com.bugclipse.fogbugz.api.Mailboxes getMailboxes(
    ) {
        return this._mailboxes;
    }

    /**
     * Returns the value of field 'minversion'.
     * 
     * @return the value of field 'Minversion'.
     */
    public long getMinversion(
    ) {
        return this._minversion;
    }

    /**
     * Returns the value of field 'people'.
     * 
     * @return the value of field 'People'.
     */
    public com.bugclipse.fogbugz.api.People getPeople(
    ) {
        return this._people;
    }

    /**
     * Returns the value of field 'priorities'.
     * 
     * @return the value of field 'Priorities'.
     */
    public com.bugclipse.fogbugz.api.Priorities getPriorities(
    ) {
        return this._priorities;
    }

    /**
     * Returns the value of field 'projects'.
     * 
     * @return the value of field 'Projects'.
     */
    public com.bugclipse.fogbugz.api.Projects getProjects(
    ) {
        return this._projects;
    }

    /**
     * Returns the value of field 'settings'.
     * 
     * @return the value of field 'Settings'.
     */
    public com.bugclipse.fogbugz.api.Settings getSettings(
    ) {
        return this._settings;
    }

    /**
     * Returns the value of field 'topic'.
     * 
     * @return the value of field 'Topic'.
     */
    public com.bugclipse.fogbugz.api.Topic getTopic(
    ) {
        return this._topic;
    }

    /**
     * Returns the value of field 'url'.
     * 
     * @return the value of field 'Url'.
     */
    public java.lang.String getUrl(
    ) {
        return this._url;
    }

    /**
     * Returns the value of field 'version'.
     * 
     * @return the value of field 'Version'.
     */
    public long getVersion(
    ) {
        return this._version;
    }

    /**
     * Returns the value of field 'workingSchedule'.
     * 
     * @return the value of field 'WorkingSchedule'.
     */
    public com.bugclipse.fogbugz.api.WorkingSchedule getWorkingSchedule(
    ) {
        return this._workingSchedule;
    }

    /**
     * Method hasMinversion.
     * 
     * @return true if at least one Minversion has been added
     */
    public boolean hasMinversion(
    ) {
        return this._has_minversion;
    }

    /**
     * Method hasVersion.
     * 
     * @return true if at least one Version has been added
     */
    public boolean hasVersion(
    ) {
        return this._has_version;
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
     * Sets the value of field 'areas'.
     * 
     * @param areas the value of field 'areas'.
     */
    public void setAreas(
            final com.bugclipse.fogbugz.api.Areas areas) {
        this._areas = areas;
    }

    /**
     * Sets the value of field 'cases'.
     * 
     * @param cases the value of field 'cases'.
     */
    public void setCases(
            final com.bugclipse.fogbugz.api.Cases cases) {
        this._cases = cases;
    }

    /**
     * Sets the value of field 'categories'.
     * 
     * @param categories the value of field 'categories'.
     */
    public void setCategories(
            final com.bugclipse.fogbugz.api.Categories categories) {
        this._categories = categories;
    }

    /**
     * Sets the value of field 'checkins'.
     * 
     * @param checkins the value of field 'checkins'.
     */
    public void setCheckins(
            final com.bugclipse.fogbugz.api.Checkins checkins) {
        this._checkins = checkins;
    }

    /**
     * Sets the value of field 'discussion'.
     * 
     * @param discussion the value of field 'discussion'.
     */
    public void setDiscussion(
            final com.bugclipse.fogbugz.api.Discussion discussion) {
        this._discussion = discussion;
    }

    /**
     * Sets the value of field 'discussions'.
     * 
     * @param discussions the value of field 'discussions'.
     */
    public void setDiscussions(
            final com.bugclipse.fogbugz.api.Discussions discussions) {
        this._discussions = discussions;
    }

    /**
     * Sets the value of field 'error'.
     * 
     * @param error the value of field 'error'.
     */
    public void setError(
            final com.bugclipse.fogbugz.api.Error error) {
        this._error = error;
    }

    /**
     * Sets the value of field 'events'.
     * 
     * @param events the value of field 'events'.
     */
    public void setEvents(
            final com.bugclipse.fogbugz.api.Events events) {
        this._events = events;
    }

    /**
     * Sets the value of field 'filters'.
     * 
     * @param filters the value of field 'filters'.
     */
    public void setFilters(
            final com.bugclipse.fogbugz.api.Filters filters) {
        this._filters = filters;
    }

    /**
     * Sets the value of field 'intervals'.
     * 
     * @param intervals the value of field 'intervals'.
     */
    public void setIntervals(
            final com.bugclipse.fogbugz.api.Intervals intervals) {
        this._intervals = intervals;
    }

    /**
     * Sets the value of field 'mailboxes'.
     * 
     * @param mailboxes the value of field 'mailboxes'.
     */
    public void setMailboxes(
            final com.bugclipse.fogbugz.api.Mailboxes mailboxes) {
        this._mailboxes = mailboxes;
    }

    /**
     * Sets the value of field 'minversion'.
     * 
     * @param minversion the value of field 'minversion'.
     */
    public void setMinversion(
            final long minversion) {
        this._minversion = minversion;
        this._has_minversion = true;
    }

    /**
     * Sets the value of field 'people'.
     * 
     * @param people the value of field 'people'.
     */
    public void setPeople(
            final com.bugclipse.fogbugz.api.People people) {
        this._people = people;
    }

    /**
     * Sets the value of field 'priorities'.
     * 
     * @param priorities the value of field 'priorities'.
     */
    public void setPriorities(
            final com.bugclipse.fogbugz.api.Priorities priorities) {
        this._priorities = priorities;
    }

    /**
     * Sets the value of field 'projects'.
     * 
     * @param projects the value of field 'projects'.
     */
    public void setProjects(
            final com.bugclipse.fogbugz.api.Projects projects) {
        this._projects = projects;
    }

    /**
     * Sets the value of field 'settings'.
     * 
     * @param settings the value of field 'settings'.
     */
    public void setSettings(
            final com.bugclipse.fogbugz.api.Settings settings) {
        this._settings = settings;
    }

    /**
     * Sets the value of field 'topic'.
     * 
     * @param topic the value of field 'topic'.
     */
    public void setTopic(
            final com.bugclipse.fogbugz.api.Topic topic) {
        this._topic = topic;
    }

    /**
     * Sets the value of field 'url'.
     * 
     * @param url the value of field 'url'.
     */
    public void setUrl(
            final java.lang.String url) {
        this._url = url;
    }

    /**
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(
            final long version) {
        this._version = version;
        this._has_version = true;
    }

    /**
     * Sets the value of field 'workingSchedule'.
     * 
     * @param workingSchedule the value of field 'workingSchedule'.
     */
    public void setWorkingSchedule(
            final com.bugclipse.fogbugz.api.WorkingSchedule workingSchedule) {
        this._workingSchedule = workingSchedule;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled com.bugclipse.fogbugz.api.Response
     */
    public static com.bugclipse.fogbugz.api.Response unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.bugclipse.fogbugz.api.Response) Unmarshaller.unmarshal(com.bugclipse.fogbugz.api.Response.class, reader);
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
