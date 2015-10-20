package es.vass.demo.portlet.view.model;

import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class BaseSearchContainer {

	protected static final int RESULTS_PER_PAGE = 20;

	protected static Map<String, String> createIteratorUrlParamMap(
			String paramName, String paramValue) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put(paramName, paramValue);
		return paramMap;
	}

	protected static PortletURL createIteratorUrl(
			RenderResponse renderResponse, Map<String, String> paramMap) {
		PortletURL iteratorURL = renderResponse.createRenderURL();
		Iterator<Map.Entry<String, String>> entries = paramMap.entrySet()
				.iterator();
		while (entries.hasNext()) {
			Map.Entry<String, String> entry = entries.next();
			iteratorURL.setParameter(entry.getKey(), entry.getValue());
		}
		return iteratorURL;
	}

	protected static ThemeDisplay getThemeDisplay(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay;
	}

	protected static PortletConfig getPortletConfig(RenderRequest renderRequest) {
		PortletConfig portletConfig = (PortletConfig) renderRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		return portletConfig;
	}
}
