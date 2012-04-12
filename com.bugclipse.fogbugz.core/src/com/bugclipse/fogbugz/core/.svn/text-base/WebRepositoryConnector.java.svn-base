package com.bugclipse.fogbugz.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.web.core.WebClientUtil;

public class WebRepositoryConnector {

	public static final String REPOSITORY_TYPE = "web";

	public static final String PROPERTY_TASK_CREATION_URL = "taskCreationUrl";

	public static final String PROPERTY_TASK_URL = "taskUrl";

	public static final String PROPERTY_QUERY_URL = "queryUrl";

	public static final String PROPERTY_QUERY_METHOD = "queryMethod";

	public static final String PROPERTY_QUERY_REGEXP = "queryPattern";

	public static final String PROPERTY_LOGIN_FORM_URL = "loginFormUrl";

	public static final String PROPERTY_LOGIN_TOKEN_REGEXP = "loginTokenPattern";

	public static final String PROPERTY_LOGIN_REQUEST_METHOD = "loginRequestMethod";

	public static final String PROPERTY_LOGIN_REQUEST_URL = "loginRequestUrl";

	public static final String PARAM_PREFIX = "param_";

	public static final String PARAM_SERVER_URL = "serverUrl";

	public static final String PARAM_USER_ID = "userId";

	public static final String PARAM_PASSWORD = "password";

	public static final String PARAM_LOGIN_TOKEN = "loginToken";

	public static final String REQUEST_POST = "POST";

	public static final String REQUEST_GET = "GET";

	static Object[][] entities = {
	// {"#39", new Integer(39)}, // ' - apostrophe
			{ "quot", new Integer(34) }, // " - double-quote
			{ "amp", new Integer(38) }, // & - ampersand
			{ "lt", new Integer(60) }, // < - less-than
			{ "gt", new Integer(62) }, // > - greater-than
			{ "nbsp", new Integer(160) }, // non-breaking space
			{ "copy", new Integer(169) }, // © - copyright
			{ "reg", new Integer(174) }, // ® - registered trademark
			{ "Agrave", new Integer(192) }, // À - uppercase A, grave accent
			{ "Aacute", new Integer(193) }, // Á - uppercase A, acute accent
			{ "Acirc", new Integer(194) }, // Â - uppercase A, circumflex
			// accent
			{ "Atilde", new Integer(195) }, // Ã - uppercase A, tilde
			{ "Auml", new Integer(196) }, // Ä - uppercase A, umlaut
			{ "Aring", new Integer(197) }, // Å - uppercase A, ring
			{ "AElig", new Integer(198) }, // Æ - uppercase AE
			{ "Ccedil", new Integer(199) }, // Ç - uppercase C, cedilla
			{ "Egrave", new Integer(200) }, // È - uppercase E, grave accent
			{ "Eacute", new Integer(201) }, // É - uppercase E, acute accent
			{ "Ecirc", new Integer(202) }, // Ê - uppercase E, circumflex
			// accent
			{ "Euml", new Integer(203) }, // Ë - uppercase E, umlaut
			{ "Igrave", new Integer(204) }, // Ì - uppercase I, grave accent
			{ "Iacute", new Integer(205) }, // Í - uppercase I, acute accent
			{ "Icirc", new Integer(206) }, // Î - uppercase I, circumflex
			// accent
			{ "Iuml", new Integer(207) }, // Ï - uppercase I, umlaut
			{ "ETH", new Integer(208) }, // Ð - uppercase Eth, Icelandic
			{ "Ntilde", new Integer(209) }, // Ñ - uppercase N, tilde
			{ "Ograve", new Integer(210) }, // Ò - uppercase O, grave accent
			{ "Oacute", new Integer(211) }, // Ó - uppercase O, acute accent
			{ "Ocirc", new Integer(212) }, // Ô - uppercase O, circumflex
			// accent
			{ "Otilde", new Integer(213) }, // Õ - uppercase O, tilde
			{ "Ouml", new Integer(214) }, // Ö - uppercase O, umlaut
			{ "Oslash", new Integer(216) }, // Ø - uppercase O, slash
			{ "Ugrave", new Integer(217) }, // Ù - uppercase U, grave accent
			{ "Uacute", new Integer(218) }, // Ú - uppercase U, acute accent
			{ "Ucirc", new Integer(219) }, // Û - uppercase U, circumflex
			// accent
			{ "Uuml", new Integer(220) }, // Ü - uppercase U, umlaut
			{ "Yacute", new Integer(221) }, // Ý - uppercase Y, acute accent
			{ "THORN", new Integer(222) }, // Þ - uppercase THORN, Icelandic
			{ "szlig", new Integer(223) }, // ß - lowercase sharps, German
			{ "agrave", new Integer(224) }, // à - lowercase a, grave accent
			{ "aacute", new Integer(225) }, // á - lowercase a, acute accent
			{ "acirc", new Integer(226) }, // â - lowercase a, circumflex
			// accent
			{ "atilde", new Integer(227) }, // ã - lowercase a, tilde
			{ "auml", new Integer(228) }, // ä - lowercase a, umlaut
			{ "aring", new Integer(229) }, // å - lowercase a, ring
			{ "aelig", new Integer(230) }, // æ - lowercase ae
			{ "ccedil", new Integer(231) }, // ç - lowercase c, cedilla
			{ "egrave", new Integer(232) }, // è - lowercase e, grave accent
			{ "eacute", new Integer(233) }, // é - lowercase e, acute accent
			{ "ecirc", new Integer(234) }, // ê - lowercase e, circumflex
			// accent
			{ "euml", new Integer(235) }, // ë - lowercase e, umlaut
			{ "igrave", new Integer(236) }, // ì - lowercase i, grave accent
			{ "iacute", new Integer(237) }, // í - lowercase i, acute accent
			{ "icirc", new Integer(238) }, // î - lowercase i, circumflex
			// accent
			{ "iuml", new Integer(239) }, // ï - lowercase i, umlaut
			{ "igrave", new Integer(236) }, // ì - lowercase i, grave accent
			{ "iacute", new Integer(237) }, // í - lowercase i, acute accent
			{ "icirc", new Integer(238) }, // î - lowercase i, circumflex
			// accent
			{ "iuml", new Integer(239) }, // ï - lowercase i, umlaut
			{ "eth", new Integer(240) }, // ð - lowercase eth, Icelandic
			{ "ntilde", new Integer(241) }, // ñ - lowercase n, tilde
			{ "ograve", new Integer(242) }, // ò - lowercase o, grave accent
			{ "oacute", new Integer(243) }, // ó - lowercase o, acute accent
			{ "ocirc", new Integer(244) }, // ô - lowercase o, circumflex
			// accent
			{ "otilde", new Integer(245) }, // õ - lowercase o, tilde
			{ "ouml", new Integer(246) }, // ö - lowercase o, umlaut
			{ "oslash", new Integer(248) }, // ø - lowercase o, slash
			{ "ugrave", new Integer(249) }, // ù - lowercase u, grave accent
			{ "uacute", new Integer(250) }, // ú - lowercase u, acute accent
			{ "ucirc", new Integer(251) }, // û - lowercase u, circumflex
			// accent
			{ "uuml", new Integer(252) }, // ü - lowercase u, umlaut
			{ "yacute", new Integer(253) }, // ý - lowercase y, acute accent
			{ "thorn", new Integer(254) }, // þ - lowercase thorn, Icelandic
			{ "yuml", new Integer(255) }, // ÿ - lowercase y, umlaut
			{ "euro", new Integer(8364) }, // Euro symbol
	};

	static Map e2i = new HashMap();
	static {
		for (int i = 0; i < entities.length; ++i) {
			e2i.put(entities[i][0], entities[i][1]);
		}
	}

	public static String htmlunescape(String s1) {
		StringBuffer buf = new StringBuffer();
		int i;
		for (i = 0; i < s1.length(); ++i) {
			char ch = s1.charAt(i);
			if (ch == '&') {
				int semi = s1.indexOf(';', i + 1);
				if (semi == -1) {
					buf.append(ch);
					continue;
				}
				String entity = s1.substring(i + 1, semi);
				Integer iso;
				if (entity.charAt(0) == '#') {
					iso = new Integer(entity.substring(1));
				} else {
					iso = (Integer) e2i.get(entity);
				}
				if (iso == null) {
					buf.append("&" + entity + ";");
				} else {
					buf.append((char) (iso.intValue()));
				}
				i = semi;
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

	public static String cleanup(String text, TaskRepository repository) {
		if (text == null) {
			return null;
		}

		// Has to disable this for now. See bug 166737 and bug 166936
		// try {
		// text = URLDecoder.decode(text, repository.getCharacterEncoding());
		// } catch (UnsupportedEncodingException ex) {
		// // ignore
		// }

		text = text.replaceAll("<!--.+?-->", "");

		String[] tokens = text.split(" |\\t|\\n|\\r");
		StringBuilder sb = new StringBuilder();
		String sep = "";
		for (String token : tokens) {
			if (token.length() > 0) {
				sb.append(sep).append(token);
				sep = " ";
			}
		}

		return sb.toString();
	}

	public static String fetchResource(String url, Map<String, String> params,
			TaskRepository repository, IProgressMonitor monitor)
			throws IOException, InterruptedException {
		if (monitor != null) {
			monitor.worked(25);
			if (monitor.isCanceled())
				throw new InterruptedException(
						"The query operation was cancelled");
		}
		HttpClient client = new HttpClient();
		WebClientUtil.setupHttpClient(client, repository.getProxy(), url, //
				repository.getUserName(), repository.getPassword());
		if (monitor != null) {
			monitor.worked(25);
			if (monitor.isCanceled())
				throw new InterruptedException(
						"The query operation was cancelled");
		}

		loginRequestIfNeeded(client, params, repository);

		if (monitor != null) {
			monitor.worked(25);
			if (monitor.isCanceled())
				throw new InterruptedException(
						"The query operation was cancelled");
		}

		GetMethod method = new GetMethod(url);
		// method.setFollowRedirects(false);
		String r = requestResource(url, client, method);
		if (monitor != null) {
			monitor.worked(25);
			if (monitor.isCanceled())
				throw new InterruptedException(
						"The query operation was cancelled");
		}
		return r;
	}

	public static boolean isPresent(String value) {
		return value != null && value.length() > 0;
	}

	private static void loginRequestIfNeeded(HttpClient client,
			Map<String, String> params, TaskRepository repository)
			throws HttpException, IOException {
		if (!isPresent(repository.getUserName())
				|| !isPresent(repository.getPassword())
				|| !isPresent(repository
						.getProperty(PROPERTY_LOGIN_REQUEST_URL))) {
			return;
		}

		String loginFormUrl = evaluateParams(repository
				.getProperty(PROPERTY_LOGIN_FORM_URL), params, repository);
		String loginToken = evaluateParams(repository
				.getProperty(PROPERTY_LOGIN_TOKEN_REGEXP), params, repository);
		if (isPresent(loginFormUrl) || isPresent(loginToken)) {
			GetMethod method = new GetMethod(loginFormUrl);
			// method.setFollowRedirects(false);
			String loginFormPage = requestResource(loginFormUrl, client, method);
			if (loginFormPage != null) {
				Pattern p = Pattern.compile(loginToken);
				Matcher m = p.matcher(loginFormPage);
				if (m.find()) {
					params.put(PARAM_PREFIX + PARAM_LOGIN_TOKEN, m.group(1));
				}
			}
		}

		String loginRequestUrl = evaluateParams(repository
				.getProperty(PROPERTY_LOGIN_REQUEST_URL), params, repository);
		String loginRequestMethod = repository
				.getProperty(PROPERTY_LOGIN_REQUEST_METHOD);

		HttpMethod method = null;
		if (REQUEST_POST.equals(loginRequestMethod)) {
			int n = loginRequestUrl.indexOf('?');
			if (n == -1) {
				method = new PostMethod(loginRequestUrl);
			} else {
				PostMethod postMethod = new PostMethod(loginRequestUrl
						.substring(0, n));
				// TODO this does not take into account escaped values
				String[] requestParams = loginRequestUrl.substring(n + 1)
						.split("&");
				for (String requestParam : requestParams) {
					String[] nv = requestParam.split("=");
					postMethod.addParameter(nv[0], nv.length == 1 ? "" : nv[1]);
				}
				method = postMethod;
			}
		} else {
			method = new GetMethod(loginRequestUrl);
			// method.setFollowRedirects(false);
		}

		requestResource(loginRequestUrl, client, method);
	}

	private static String requestResource(String url, HttpClient client,
			HttpMethod method) throws IOException, HttpException {
		String refreshUrl = null;
		try {
			client.executeMethod(method);
			// int statusCode = client.executeMethod(method);
			// if (statusCode == 300 || statusCode == 301 || statusCode == 302
			// || statusCode == 303 || statusCode == 307) {
			// Header location = method.getResponseHeader("Location");
			// if (location != null) {
			// refreshUrl = location.getValue();
			// if (!refreshUrl.startsWith("/")) {
			// refreshUrl = "/" + refreshUrl;
			// }
			// }
			// }

			refreshUrl = getRefreshUrl(url, method);
			if (refreshUrl == null) {
				return method.getResponseBodyAsString();
			}
		} finally {
			method.releaseConnection();
		}

		method = new GetMethod(refreshUrl);
		try {
			client.executeMethod(method);
			return method.getResponseBodyAsString();
		} finally {
			method.releaseConnection();
		}
	}

	private static String getRefreshUrl(String url, HttpMethod method) {
		Header refreshHeader = method.getResponseHeader("Refresh");
		if (refreshHeader == null) {
			return null;
		}
		String value = refreshHeader.getValue();
		int n = value.indexOf(";url=");
		if (n == -1) {
			return null;
		}
		value = value.substring(n + 5);
		int requestPath;
		if (value.charAt(0) == '/') {
			int colonSlashSlash = url.indexOf("://");
			requestPath = url.indexOf('/', colonSlashSlash + 3);
		} else {
			requestPath = url.lastIndexOf('/');
		}

		String refreshUrl;
		if (requestPath == -1) {
			refreshUrl = url + "/" + value;
		} else {
			refreshUrl = url.substring(0, requestPath + 1) + value;
		}
		return refreshUrl;
	}

	public static String evaluateParams(String value,
			Map<String, String> params, TaskRepository repository) {
		return evaluateParams(evaluateParams(value, params), repository);
	}

	public static String evaluateParams(String value, TaskRepository repository) {
		if (value != null && value.indexOf("${") > -1) {
			value = evaluate(value, PARAM_SERVER_URL, repository.getUrl());
			value = evaluate(value, PARAM_USER_ID, encode(repository
					.getUserName()));
			value = evaluate(value, PARAM_PASSWORD, encode(repository
					.getPassword()));
			value = evaluateParams(value, repository.getProperties());
		}
		return value;
	}

	public static String evaluateParams(String value, Map<String, String> params) {
		for (Map.Entry<String, String> e : params.entrySet()) {
			String key = e.getKey();
			if (key.startsWith(PARAM_PREFIX)) {
				value = evaluate(value, key.substring(PARAM_PREFIX.length()),
						encode(e.getValue()));
			}
		}
		return value;
	}

	private static String evaluate(String s, String var, String value) {
		return s.replaceAll("\\$\\{" + var + "\\}", value);
	}

	private static String encode(String value) {
		try {
			return new URLCodec().encode(value);
		} catch (EncoderException ex) {
			return value;
		}
	}

	public static List<String> getTemplateVariables(String value) {
		if (value == null) {
			return Collections.emptyList();
		}

		List<String> vars = new ArrayList<String>();
		Matcher m = Pattern.compile("\\$\\{(.+?)\\}").matcher(value);
		while (m.find()) {
			vars.add(m.group(1));
		}
		return vars;
	}

}
