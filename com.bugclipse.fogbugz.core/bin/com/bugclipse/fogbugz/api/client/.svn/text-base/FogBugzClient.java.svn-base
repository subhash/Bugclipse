package com.bugclipse.fogbugz.api.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.PartSource;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.mylyn.tasks.core.ITaskAttachment;
import org.eclipse.mylyn.web.core.WebClientUtil;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import com.bugclipse.fogbugz.api.Area;
import com.bugclipse.fogbugz.api.Case;
import com.bugclipse.fogbugz.api.CaseResponse;
import com.bugclipse.fogbugz.api.Category;
import com.bugclipse.fogbugz.api.Filter;
import com.bugclipse.fogbugz.api.Fixfor;
import com.bugclipse.fogbugz.api.Interval;
import com.bugclipse.fogbugz.api.Person;
import com.bugclipse.fogbugz.api.PersonContained;
import com.bugclipse.fogbugz.api.Priority;
import com.bugclipse.fogbugz.api.Project;
import com.bugclipse.fogbugz.api.Response;
import com.bugclipse.fogbugz.api.Status;
import com.bugclipse.fogbugz.api.exception.FogBugzAPIException;
import com.bugclipse.fogbugz.api.exception.FogBugzClientException;
import com.bugclipse.fogbugz.api.exception.FogBugzLicenseException;
import com.bugclipse.fogbugz.core.FogBugzAttributeFactory;
import com.bugclipse.fogbugz.core.FogBugzTaskDataHandler;
import com.websina.license.LicenseManager;

public class FogBugzClient implements IFogBugzClient {

	private HttpClient httpClient;

	private static ExceptionInInitializerError licenseException = null;

	private boolean authenticated;

	private String token;

	private String repositoryUrl, username, password;

	private Proxy proxy;

	private static final FogBugzAttributeFactory attributeFactory = new FogBugzAttributeFactory();

	private HashMap<String, ArrayList<String>> areas;

	private HashMap<String, HashMap<String, String>> fixFors;

	public FogBugzClient(String repositoryUrl, String username,
			String password, Proxy proxy) {
		this.repositoryUrl = repositoryUrl;
		this.username = username;
		this.password = password;
		this.proxy = proxy;
		this.httpClient = new HttpClient();
		httpClient
				.setHttpConnectionManager(new MultiThreadedHttpConnectionManager());
	}

	public void updateCredentials(String username, String password, Proxy proxy) {
		this.username = username;
		this.password = password;
		this.proxy = proxy;
		this.token = null;
		this.authenticated = false;
	}

	public void login() throws MarshalException, ValidationException,
			HttpException, FogBugzClientException, IOException {
		WebClientUtil.setupHttpClient(httpClient, proxy, repositoryUrl, null,
				null);
		this.authenticate();
	}

	public Filter[] getFilters(IProgressMonitor monitor)
			throws FogBugzClientException {
		GetMethod method = connect(repositoryUrl + LIST_FILTERS_URL, monitor);
		if (checkMonitor(monitor))
			throw new FogBugzClientException("User cancelled fetch");
		Response response = unmarshalResponse(method);
		return response.getFilters().getFilter();
	}

	public Case[] getCasesIn(String filterId, IProgressMonitor monitor)
			throws FogBugzClientException {
		GetMethod method = connect(repositoryUrl + SET_CURRENT_FILTER_URL
				+ filterId, monitor);
		if (checkMonitor(monitor))
			throw new FogBugzClientException("User cancelled fetch of filter "
					+ filterId);
		Response response = unmarshalResponse(method);
		// String cols = "ixBug,fOpen,sTitle,sLatestTextSummary,sProject,sArea,"
		// +
		// "ixPersonAssignedTo,sPersonAssignedTo,sEmailAssignedTo,ixStatus,sStatus,"
		// + "ixPriority,sPriority,ixFixFor,sFixFor,dtFixFor,"
		// +
		// "sVersion,sComputer,hrsCurrEst,hrsOrigEst,hrsElapsed,ixCategory,sCategory,dtOpened,dtResolved,dtClosed,dtLastUpdated,dtDue,events";
		String cols = "ixBug,sTitle," + "sPersonAssignedTo," + "ixPriority,"
				+ "sCategory,dtOpened,dtDue";
		method = connect(repositoryUrl + LIST_CASES_URL + "&cols=" + cols,
				monitor);
		if (checkMonitor(monitor))
			throw new FogBugzClientException("User cancelled fetch of filter "
					+ filterId);
		response = unmarshalResponse(method);
		return response.getCases().getCase();
	}

	public Map<String, Case> getCases(Set<String> caseIds,
			IProgressMonitor monitor) throws FogBugzClientException {
		HashMap<String, Case> caseMap = new HashMap<String, Case>();
		String cols = "ixBug,fOpen,sTitle,sLatestTextSummary,sProject,sArea,"
				+ "ixPersonAssignedTo,ixPersonOpenedBy,sPersonAssignedTo,sEmailAssignedTo,ixStatus,sStatus,"
				+ "ixPriority,sPriority,ixFixFor,sFixFor,dtFixFor,"
				+ "sVersion,sComputer,hrsCurrEst,hrsOrigEst,hrsElapsed,ixCategory,sCategory,dtOpened,dtResolved,dtClosed,dtLastUpdated,dtDue,events";
		Iterator i = caseIds.iterator();
		if (i.hasNext()) {
			String ids = "" + i.next();
			while (i.hasNext())
				ids += "," + i.next();
			monitor.subTask("Fetching case information");
			GetMethod method = connect(repositoryUrl + LIST_CASES_URL + ids
					+ "&cols=" + cols, monitor);
			if (checkMonitor(monitor))
				return caseMap;
			monitor.subTask("Formatting results");
			Response response = unmarshalResponse(method);
			Case[] cases = response.getCases().getCase();
			for (int j = 0; j < cases.length; j++) {
				caseMap.put(cases[j].getIxBug() + "", cases[j]);
			}
		}
		return caseMap;
	}

	public Case getCase(String id, IProgressMonitor monitor)
			throws FogBugzClientException {
		Set<String> data = new HashSet<String>();
		data.add(id);
		Map<String, Case> returnedData = getCases(data, monitor);
		return returnedData.get(id);
	}

	public Case[] getChangedCases(String since) throws FogBugzClientException {
		String query = encode("edited:\"" + since + " - today\"");
		GetMethod method = connect(repositoryUrl + LIST_CASES_SINCE_URL + query);
		Response response = unmarshalResponse(method);
		return response.getCases().getCase();
	}

	public Case getCaseUpdateTime(String caseId, IProgressMonitor monitor)
			throws FogBugzClientException {
		String cols = "ixBug,dtLastUpdated";
		GetMethod method = connect(repositoryUrl + LIST_CASES_URL + caseId
				+ "&cols=" + cols, monitor);
		if (checkMonitor(monitor))
			throw new FogBugzClientException("User cancelled operation");
		Response response = unmarshalResponse(method);
		return response.getCases().getCase()[0];
	}

	private Area[] getSAreas() throws FogBugzClientException {
		GetMethod method = connect(repositoryUrl + LIST_AREAS_URL);
		Response response = unmarshalResponse(method);
		return response.getAreas().getArea();
	}

	public HashMap<String, ArrayList<String>> getAreaOptions()
			throws FogBugzClientException {
		if (areas == null) {
			Area[] sAreas = getSAreas();
			areas = new HashMap<String, ArrayList<String>>();
			for (Area area : sAreas) {
				ArrayList entry = areas.get(area.getSProject());
				if (entry == null) {
					ArrayList<String> a = new ArrayList<String>();
					a.add(area.getSArea());
					areas.put(area.getSProject(), a);
				} else {
					entry.add(area.getSArea());
				}
			}
		}
		return areas;
	}

	public HashMap<String, HashMap<String, String>> getFixForOptions(
			List<String> projects) throws FogBugzClientException {
		String undecided = null;
		if (fixFors == null) {
			Fixfor[] fixs = getSFixFors();
			fixFors = new HashMap<String, HashMap<String, String>>();
			for (Fixfor fix : fixs) {
				if (fix.getSProject() == null || fix.getSProject().equals(""))
					undecided = fix.getSFixFor();
				else {
					HashMap<String, String> entry = fixFors.get(fix
							.getSProject());
					if (entry == null) {
						HashMap<String, String> a = new HashMap<String, String>();
						a.put(fix.getSFixFor() + ": " + fix.getDt(), fix
								.getSFixFor());
						fixFors.put(fix.getSProject(), a);
					} else {
						entry.put(fix.getSFixFor() + ": " + fix.getDt(), fix
								.getSFixFor());
					}
				}
			}
			for (Entry<String, HashMap<String, String>> entry : fixFors
					.entrySet()) {
				entry.getValue().put(undecided, undecided);
			}
			for (String p : projects) {
				if (fixFors.get(p) == null) {
					HashMap<String, String> map = new HashMap<String, String>();
					map.put(undecided, undecided);
					fixFors.put(p, map);
				}
			}
		}
		return fixFors;
	}

	public Fixfor[] getSFixFors() throws FogBugzClientException {
		GetMethod method = connect(repositoryUrl + LIST_FIXFORS_URL);
		Response response = unmarshalResponse(method);
		return response.getFixfors().getFixfor();
	}

	private Project[] projects;

	private Category[] categories;

	private Priority[] priorities;

	private PersonContained[] people;

	private HashMap<Long, ArrayList<Status>> resolvedStatuses;

	public Project[] getProjects() throws FogBugzClientException {
		if (projects == null) {
			GetMethod method = connect(repositoryUrl + LIST_PROJECTS_URL);
			Response response = unmarshalResponse(method);
			projects = response.getProjects().getProject();
		}
		return projects;
	}

	public Category[] getCategories() throws FogBugzClientException {
		if (categories == null) {
			GetMethod method = connect(repositoryUrl + LIST_CATEGORIES_URL);
			Response response = unmarshalResponse(method);
			categories = response.getCategories().getCategory();
		}
		return categories;
	}

	public Priority[] getPriorities() throws FogBugzClientException {
		if (priorities == null) {
			GetMethod method = connect(repositoryUrl + LIST_PRIORITIES_URL);
			Response response = unmarshalResponse(method);
			priorities = response.getPriorities().getPriority();
		}
		return priorities;
	}

	public PersonContained[] getPeople() throws FogBugzClientException {
		if (people == null) {
			GetMethod method = connect(repositoryUrl + LIST_PEOPLE_URL);
			Response response = unmarshalResponse(method);
			people = response.getPeople().getPersonContained();
		}
		return people;
	}

	public Status[] getStatuses() throws FogBugzClientException {
		GetMethod method = connect(repositoryUrl + LIST_STATUSES_URL);
		Response response = unmarshalResponse(method);
		return response.getStatuses().getStatus();
	}

	public Status[] getResolvedStatuses(long ixCategory)
			throws FogBugzClientException {
		if (resolvedStatuses == null) {
			GetMethod method = connect(repositoryUrl
					+ LIST_RESOLVED_STATUSES_URL);
			Response response = unmarshalResponse(method);
			Status[] statuses = response.getStatuses().getStatus();
			resolvedStatuses = new HashMap<Long, ArrayList<Status>>();
			for (Status status : statuses) {
				System.out.println("Status = " + status.getSStatus()
						+ ",category = " + status.getIxCategory());
				if (resolvedStatuses.containsKey(status.getIxCategory())) {
					resolvedStatuses.get(status.getIxCategory()).add(status);
				} else {
					ArrayList<Status> a = new ArrayList<Status>();
					a.add(status);
					resolvedStatuses.put(status.getIxCategory(), a);
				}
			}
		}
		ArrayList<Status> statusList = new ArrayList<Status>();
		statusList.addAll(resolvedStatuses.get(ixCategory));
		for (long key : resolvedStatuses.keySet()) {
			if (key < 0)
				statusList.addAll(resolvedStatuses.get(key));
		}
		return statusList.toArray(new Status[0]);
	}

	public Person getPerson(String personId) throws FogBugzClientException {
		GetMethod method = connect(repositoryUrl + VIEW_PERSON_URL + personId);
		Response response = unmarshalResponse(method);
		return response.getPerson();
	}

	/**
	 * @param url
	 *            Relative URL of the attachment of the form
	 *            "default.asp?pg=pgDownload&amp;pgType=pgAttachment&amp;ixBugEvent=756"
	 * @return InputStream of the file in the HTTP response
	 * @throws FogBugzClientException
	 * @throws IOException
	 */
	public InputStream downloadAttachment(String url, IProgressMonitor monitor)
			throws FogBugzClientException, IOException {
		GetMethod method = connect(repositoryUrl + "/" + url, monitor);
		if (checkMonitor(monitor))
			throw new FogBugzClientException("Download cancelled by user");
		return method.getResponseBodyAsStream();
	}

	public void uploadAttachment(String caseId, ITaskAttachment attach,
			String comment, IProgressMonitor monitor)
			throws FogBugzClientException {
		String url = repositoryUrl + EDIT_CASE_URL + caseId;
		Map<String, String> attr = new HashMap<String, String>();
		if (comment != null && !comment.equals(""))
			attr.put("sEvent", comment);
		PostMethod method = post(url, attr, attach, monitor);
		Response response = unmarshalResponse(method);
	}

	private void updateCase(String updateUrl, String caseId,
			Map<String, String> attributes, String newComment,
			ITaskAttachment attach) throws FogBugzClientException {
		String url = repositoryUrl + updateUrl + caseId;
		if (newComment != null && !newComment.equals("")) {
			attributes.put("sEvent", newComment);
		}
		PostMethod method = post(url, attributes, attach);
		Response response = unmarshalResponse(method);
	}

	public void editCase(String caseId, Map<String, String> attributes,
			String newComment) throws FogBugzClientException {
		updateCase(EDIT_CASE_URL, caseId, attributes, newComment, null);
	}

	public void assignCase(String caseId, Map<String, String> attributes,
			String newComment) throws FogBugzClientException {
		updateCase(ASSIGN_CASE_URL, caseId, attributes, newComment, null);
	}

	public void reactivateCase(String caseId, Map<String, String> attributes,
			String newComment) throws FogBugzClientException {
		updateCase(REACTIVATE_CASE_URL, caseId, attributes, newComment, null);
	}

	public void reopenCase(String caseId, Map<String, String> attributes,
			String newComment) throws FogBugzClientException {
		updateCase(REOPEN_CASE_URL, caseId, attributes, newComment, null);
	}

	public void resolveCase(String caseId, Map<String, String> attributes,
			String newComment) throws FogBugzClientException {
		updateCase(RESOLVE_CASE_URL, caseId, attributes, newComment, null);
	}

	public void closeCase(String caseId, Map<String, String> attributes,
			String newComment) throws FogBugzClientException {
		updateCase(CLOSE_CASE_URL, caseId, attributes, newComment, null);
	}

	public CaseResponse createCase(Map<String, String> attributes,
			String newComment, ITaskAttachment attach)
			throws FogBugzClientException {
		String url = repositoryUrl + NEW_CASE_URL;
		if (newComment != null && !newComment.equals("")) {
			attributes.put("sEvent", newComment);
		}
		PostMethod method = post(url, attributes, attach);
		Response response = unmarshalResponse(method);
		return response.getCaseResponse();
	}

	public void startWork(String caseId, IProgressMonitor monitor)
			throws FogBugzClientException {
		GetMethod method = connect(repositoryUrl + START_WORK_URL + caseId,
				monitor);
		Response response = unmarshalResponse(method);
	}

	public void stopWork(IProgressMonitor monitor)
			throws FogBugzClientException {
		GetMethod method = connect(repositoryUrl + STOP_WORK_URL, monitor);
		Response response = unmarshalResponse(method);
	}

	public Interval[] getIntervals(String from, String to,
			IProgressMonitor monitor) throws FogBugzClientException {
		monitor.subTask("Querying repository for intervals");
		GetMethod method = connect(repositoryUrl + LIST_INTERVALS_URL
				+ "&dtStart=" + encode(from) + "&dtEnd=" + encode(to), monitor);
		if (checkMonitor(monitor))
			return new Interval[0];
		monitor.subTask("Formatting results");
		Response response = unmarshalResponse(method);
		if (checkMonitor(monitor))
			return new Interval[0];
		return response.getIntervals().getInterval();
	}

	public Case[] search(String searchText, IProgressMonitor monitor)
			throws FogBugzClientException {
		monitor.subTask("Searching repository");
		searchText = encode(searchText);
		String cols = "ixBug,sTitle," + "sPersonAssignedTo," + "ixPriority,"
				+ "sCategory,dtOpened,dtDue";
		GetMethod method = connect(repositoryUrl + SEARCH_CASES_URL
				+ searchText + "&cols=" + cols, monitor);
		if (checkMonitor(monitor))
			return new Case[0];
		monitor.subTask("Formatting results");
		Response response = unmarshalResponse(method);
		return response.getCases().getCase();
	}

	private synchronized GetMethod connect(String serverURL)
			throws FogBugzClientException {
		System.out.println("connect - " + serverURL);
		try {
			if (licenseException != null)
				throw licenseException;
			if (!LicenseManager.getInstance().isValid())
				throw new FogBugzLicenseException("License not valid!");
			GetMethod m = connectInternal(serverURL);
			return m;

		} catch (FogBugzClientException e) {
			throw e;
		} catch (MarshalException e) {
			throw new FogBugzClientException(e);
		} catch (ValidationException e) {
			throw new FogBugzClientException(e);
		} catch (HttpException e) {
			throw new FogBugzClientException(e);
		} catch (IOException e) {
			throw new FogBugzClientException(e);
		} catch (GeneralSecurityException e) {
			throw new FogBugzLicenseException(e);
		} catch (ExceptionInInitializerError e) {
			licenseException = e;
			throw new FogBugzLicenseException(e.getCause());
		} catch (Throwable t) {
			throw new FogBugzClientException(t);
		}
	}

	private synchronized GetMethod connect(String serverURL,
			IProgressMonitor monitor) throws FogBugzClientException {
		System.out.println("connect - " + serverURL);
		try {
			if (licenseException != null)
				throw licenseException;
			if (!LicenseManager.getInstance().isValid())
				throw new FogBugzLicenseException("License not valid!");
			GetMethod m = connectInternal(serverURL, monitor);
			return m;

		} catch (FogBugzClientException e) {
			throw e;
		} catch (MarshalException e) {
			throw new FogBugzClientException(e);
		} catch (ValidationException e) {
			throw new FogBugzClientException(e);
		} catch (HttpException e) {
			throw new FogBugzClientException(e);
		} catch (IOException e) {
			throw new FogBugzClientException(e);
		} catch (GeneralSecurityException e) {
			throw new FogBugzLicenseException(e);
		} catch (ExceptionInInitializerError e) {
			licenseException = e;
			throw new FogBugzLicenseException(e.getCause());
		} catch (Throwable t) {
			throw new FogBugzClientException(t);
		}
	}

	private GetMethod connectInternal(String serverURL)
			throws MarshalException, ValidationException, HttpException,
			FogBugzClientException, IOException {
		WebClientUtil.setupHttpClient(httpClient, proxy, serverURL, null, null);

		for (int attempt = 0; attempt < 2; attempt++) {
			// force authentication
			if (!authenticated && hasAuthenticationCredentials()) {
				authenticate();
			}
			String requestUrl = WebClientUtil.getRequestPath(serverURL
					+ "&token=" + token);
			GetMethod method = new GetMethod(requestUrl);
			method.getParams().setCookiePolicy(
					CookiePolicy.BROWSER_COMPATIBILITY);
			int code;
			try {
				code = httpClient.executeMethod(method);
			} catch (IOException e) {
				method.releaseConnection();
				e.printStackTrace();
				throw e;
			}

			if (code == HttpURLConnection.HTTP_OK) {
				return method;
			} else if (code == HttpURLConnection.HTTP_UNAUTHORIZED
					|| code == HttpURLConnection.HTTP_FORBIDDEN) {
				// login or re-authenticate due to an expired session
				method.releaseConnection();
				authenticated = false;
				authenticate();
			} else {
				throw new FogBugzClientException("code = " + code);
			}
		}

		throw new FogBugzClientException("Session might have expired!");
	}

	private GetMethod connectInternal(String serverURL, IProgressMonitor monitor)
			throws MarshalException, ValidationException, HttpException,
			FogBugzClientException, IOException {
		WebClientUtil.setupHttpClient(httpClient, proxy, serverURL, null, null);

		for (int attempt = 0; attempt < 2; attempt++) {
			// force authentication
			if (!authenticated && hasAuthenticationCredentials()) {
				monitor.subTask("Authenticating request");
				authenticate();
				if (checkMonitor(monitor))
					return null;
			}
			String requestUrl = WebClientUtil.getRequestPath(serverURL
					+ "&token=" + token);
			GetMethod method = new GetMethod(requestUrl);
			method.getParams().setCookiePolicy(
					CookiePolicy.BROWSER_COMPATIBILITY);
			int code;
			try {
				monitor.subTask("Sending request");
				code = httpClient.executeMethod(method);
				if (checkMonitor(monitor))
					return null;
			} catch (IOException e) {
				method.releaseConnection();
				e.printStackTrace();
				throw e;
			}

			if (code == HttpURLConnection.HTTP_OK) {
				return method;
			} else if (code == HttpURLConnection.HTTP_UNAUTHORIZED
					|| code == HttpURLConnection.HTTP_FORBIDDEN) {
				// login or re-authenticate due to an expired session
				method.releaseConnection();
				authenticated = false;
				authenticate();
			} else {
				throw new FogBugzClientException("code = " + code);
			}
		}

		throw new FogBugzClientException("Session might have expired!");
	}

	private PostMethod post(String formUrl, Map<String, String> formData,
			ITaskAttachment attach) throws FogBugzClientException {
		for (Entry<String, String> b : formData.entrySet()) {
			System.out.println(b.getKey() + " = " + b.getValue());
		}
		try {
			if (licenseException != null)
				throw licenseException;
			if (!LicenseManager.getInstance().isValid())
				throw new FogBugzLicenseException("License not valid!");
			return postInternal(formUrl, formData, attach);
		} catch (MarshalException e) {
			throw new FogBugzClientException(e);
		} catch (ValidationException e) {
			throw new FogBugzClientException(e);
		} catch (HttpException e) {
			throw new FogBugzClientException(e);
		} catch (IOException e) {
			throw new FogBugzClientException(e);
		} catch (ExceptionInInitializerError e) {
			licenseException = e;
			throw new FogBugzLicenseException(e.getCause());
		} catch (GeneralSecurityException e) {
			throw new FogBugzLicenseException(e);
		}
	}

	private PostMethod post(String formUrl, Map<String, String> formData,
			ITaskAttachment attach, IProgressMonitor monitor)
			throws FogBugzClientException {
		for (Entry<String, String> b : formData.entrySet()) {
			System.out.println(b.getKey() + " = " + b.getValue());
		}
		try {
			if (licenseException != null)
				throw licenseException;
			if (!LicenseManager.getInstance().isValid())
				throw new FogBugzLicenseException("License not valid!");
			return postInternal(formUrl, formData, attach, monitor);
		} catch (MarshalException e) {
			throw new FogBugzClientException(e);
		} catch (ValidationException e) {
			throw new FogBugzClientException(e);
		} catch (HttpException e) {
			throw new FogBugzClientException(e);
		} catch (IOException e) {
			throw new FogBugzClientException(e);
		} catch (ExceptionInInitializerError e) {
			licenseException = e;
			throw new FogBugzLicenseException(e.getCause());
		} catch (GeneralSecurityException e) {
			throw new FogBugzLicenseException(e);
		}
	}

	private PostMethod postInternal(String formUrl,
			Map<String, String> changed, final ITaskAttachment attach)
			throws FogBugzClientException, HttpException, IOException,
			MarshalException, ValidationException {

		WebClientUtil.setupHttpClient(httpClient, proxy, formUrl, null, null);
		if (!authenticated && hasAuthenticationCredentials()) {
			authenticate();
		}

		String requestUrl = WebClientUtil.getRequestPath(formUrl + "&token="
				+ token);

		ArrayList<Part> parts = new ArrayList<Part>();
		if (attach != null) {
			requestUrl += "&nFileCount=1";
			FilePart part = new FilePart("File1", new PartSource() {

				public InputStream createInputStream() throws IOException {
					return attach.createInputStream();
				}

				public String getFileName() {
					return attach.getFilename();
				}

				public long getLength() {
					return attach.getLength();
				}

			});
			part.setTransferEncoding(null);
			parts.add(part);
			parts.add(new StringPart("Content-Type", attach.getContentType()));
		}
		PostMethod postMethod = new PostMethod(requestUrl);
		// postMethod.setRequestHeader("Content-Type",
		// "application/x-www-form-urlencoded; charset="
		// + characterEncoding);

		// postMethod.setRequestBody(formData);
		postMethod.setDoAuthentication(true);

		for (String key : changed.keySet()) {
			StringPart p = new StringPart(key, changed.get(key));
			p.setTransferEncoding(null);
			p.setContentType(null);
			parts.add(p);
		}
		postMethod.setRequestEntity(new MultipartRequestEntity(parts
				.toArray(new Part[0]), postMethod.getParams()));

		int status = httpClient.executeMethod(postMethod);
		if (status == HttpStatus.SC_OK) {
			return postMethod;
		} else {
			postMethod.getResponseBody();
			postMethod.releaseConnection();
			throw new IOException(
					"Communication error occurred during upload. \n\n"
							+ HttpStatus.getStatusText(status));
		}
	}

	private PostMethod postInternal(String formUrl,
			Map<String, String> changed, final ITaskAttachment attach,
			IProgressMonitor monitor) throws FogBugzClientException,
			HttpException, IOException, MarshalException, ValidationException {

		WebClientUtil.setupHttpClient(httpClient, proxy, formUrl, null, null);
		if (!authenticated && hasAuthenticationCredentials()) {
			monitor.subTask("Authenticating request");
			authenticate();
			if (checkMonitor(monitor))
				return null;
		}

		String requestUrl = WebClientUtil.getRequestPath(formUrl + "&token="
				+ token);

		ArrayList<Part> parts = new ArrayList<Part>();
		if (attach != null) {
			requestUrl += "&nFileCount=1";
			FilePart part = new FilePart("File1", new PartSource() {

				public InputStream createInputStream() throws IOException {
					return attach.createInputStream();
				}

				public String getFileName() {
					return attach.getFilename();
				}

				public long getLength() {
					return attach.getLength();
				}

			});
			part.setTransferEncoding(null);
			parts.add(part);
			parts.add(new StringPart("Content-Type", attach.getContentType()));
		}
		PostMethod postMethod = new PostMethod(requestUrl);
		// postMethod.setRequestHeader("Content-Type",
		// "application/x-www-form-urlencoded; charset="
		// + characterEncoding);

		// postMethod.setRequestBody(formData);
		postMethod.setDoAuthentication(true);

		for (String key : changed.keySet()) {
			StringPart p = new StringPart(key, changed.get(key));
			p.setTransferEncoding(null);
			p.setContentType(null);
			parts.add(p);
		}
		postMethod.setRequestEntity(new MultipartRequestEntity(parts
				.toArray(new Part[0]), postMethod.getParams()));

		monitor.subTask("Sending request");
		int status = httpClient.executeMethod(postMethod);
		if (status == HttpStatus.SC_OK) {
			return postMethod;
		} else {
			postMethod.getResponseBody();
			postMethod.releaseConnection();
			throw new IOException(
					"Communication error occurred during upload. \n\n"
							+ HttpStatus.getStatusText(status));
		}
	}

	protected boolean hasAuthenticationCredentials() {
		return username != null && username.length() > 0;
	}

	private void authenticate() throws FogBugzClientException, HttpException,
			IOException, MarshalException, ValidationException {
		// WebClientUtil.setupHttpClient(httpClient, proxy, repositoryUrl, null,
		// null);
		if (!hasAuthenticationCredentials()) {
			throw new FogBugzClientException("No authentication credentials!");
		}

		// try standard basic/digest authentication first
		Credentials credentials = new UsernamePasswordCredentials(username,
				password);
		httpClient.getState().setCredentials(
				new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT,
						AuthScope.ANY_REALM), credentials);

		GetMethod method = new GetMethod(WebClientUtil
				.getRequestPath(repositoryUrl + "/api.asp?cmd=logon&email="
						+ username + "&password=" + password));
		method.setFollowRedirects(false);
		int code;
		try {
			httpClient.getParams().setAuthenticationPreemptive(true);
			code = httpClient.executeMethod(method);
			if (code == HttpURLConnection.HTTP_UNAUTHORIZED
					|| code == HttpURLConnection.HTTP_FORBIDDEN) {
				throw new FogBugzClientException("Session might have expired!");
			}
			Response r = unmarshalResponse(method);
			authenticated = true;
			token = r.getToken();
		} finally {
			method.releaseConnection();
			httpClient.getParams().setAuthenticationPreemptive(false);
		}

		// the expected return code is a redirect, anything else is suspicious
		if (code == HttpURLConnection.HTTP_OK) {
			// try form-based authentication via AccountManagerPlugin as a
			// fall-back
			// authenticateAccountManager(httpClient);
		}

		// validateAuthenticationState(httpClient);

		// success since no exception was thrown

	}

	private Response unmarshalResponse(HttpMethod method)
			throws FogBugzClientException {
		try {
			Unmarshaller un = new Unmarshaller(Response.class);
			un.setIgnoreExtraElements(true);
			un.setIgnoreExtraAttributes(true);
			un.setValidation(false);
			un.setWhitespacePreserve(true);
			String respBody = method.getResponseBodyAsString();
			System.out.println("response - " + respBody);
			Response r = (Response) un.unmarshal(new StringReader(respBody));
			if (r.getError() != null)
				throw new FogBugzAPIException(r.getError());
			return r;
		} catch (IOException e) {
			throw new FogBugzClientException(e);
		} catch (MarshalException e) {
			throw new FogBugzClientException(e);
		} catch (ValidationException e) {
			throw new FogBugzClientException(e);
		} finally {
			method.releaseConnection();
		}
	}

	private static boolean checkMonitor(IProgressMonitor monitor) {
		if (monitor.isCanceled())
			return true;
		else
			monitor.worked(1);
		return false;
	}

	private static String encode(String str) {
		try {
			return new URLCodec().encode(str);
		} catch (EncoderException e) {
			e.printStackTrace();
			return str;
		}
	}

	public static void main(String[] args) throws Exception {
		FogBugzClient client = new FogBugzClient("https://subhash.fogbugz.com",
				"cs19739@yahoo.com", "cs19739", null);
		Map<String, String> map = new HashMap<String, String>();
		map.put("dtDue", "12/8/07 8:00 PM");
		client.editCase("6", map, null);
	}

	public String getUsername() {
		return username;
	}

	public String[] getActions(Case fcase) {
		if (fcase.getSStatus().equals("Active")) {
			return new String[] { FogBugzTaskDataHandler.LEAVE_OPERATION,
					FogBugzTaskDataHandler.REASSIGN_OPERATION,
					FogBugzTaskDataHandler.RESOLVE_OPERATION,
					FogBugzTaskDataHandler.RESOLVE_CLOSE_OPERATION };
		} else if (fcase.getSStatus().contains("Resolved")) {
			return new String[] { FogBugzTaskDataHandler.LEAVE_OPERATION,
					FogBugzTaskDataHandler.REASSIGN_OPERATION,
					FogBugzTaskDataHandler.RESOLVE_OPERATION,
					FogBugzTaskDataHandler.REACTIVATE_OPERATION,
					FogBugzTaskDataHandler.CLOSE_OPERATION };
		} else if (fcase.getSStatus().contains("Closed")) {
			return new String[] { FogBugzTaskDataHandler.LEAVE_OPERATION,
					FogBugzTaskDataHandler.REOPEN_OPERATION };
		} else
			return null;
	}

}
