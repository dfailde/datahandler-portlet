package es.vass.demo.portlet.domain;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

public class DemoContext {
	private ThemeDisplay themeDisplay;
	private PortletPreferences preferences;

	private DemoContext(ThemeDisplay themeDisplay,
			PortletPreferences preferences) {
		super();
		this.themeDisplay = themeDisplay;
		this.preferences = preferences;
	}

	public static DemoContext buildFrom(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = request.getPreferences();
		return new DemoContext(themeDisplay, preferences);
	}

	public long getGroupId() {
		return themeDisplay.getScopeGroupId();
	}

	public long getCompanyId() {
		return themeDisplay.getCompanyId();
	}

	public long getUserId() {
		return themeDisplay.getUserId();
	}

	public String getUserName() {
		return themeDisplay.getUser().getScreenName();
	}

	public ThemeDisplay getThemeDisplay() {
		return themeDisplay;
	}

	public long getFolderId() {
		String folderIdPref = preferences.getValue("folderId", "0");
		return GetterUtil.getLong(folderIdPref);
	}

}
