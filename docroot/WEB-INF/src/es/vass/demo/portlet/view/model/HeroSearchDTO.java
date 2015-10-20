package es.vass.demo.portlet.view.model;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import es.vass.demo.portlet.view.View;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.apache.commons.lang.StringUtils;

public class HeroSearchDTO {
	private static final String NAME_PARAM_NAME = "name";

	private String name;
	private String view;
	private DisplayTerms displayTerms;

	public HeroSearchDTO(String name, String view, DisplayTerms displayTerms) {
		super();
		this.name = name;
		this.view = view;
		this.displayTerms = displayTerms;
	}

	public static HeroSearchDTO from(PortletRequest request) {
		String name = ParamUtil.getString(request, NAME_PARAM_NAME);
		String view = ParamUtil.getString(request, View.VIEW_PARAM_NAME);
		DisplayTerms displayTerms = new DisplayTerms(request);
		return new HeroSearchDTO(name, view, displayTerms);
	}

	public Map<String, String> asMap() {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put(NAME_PARAM_NAME, this.name);
		paramMap.put(View.VIEW_PARAM_NAME, this.view);
		return paramMap;
	}

	public String getName() {
		return name;
	}

	public String getView() {
		return view;
	}

	public DisplayTerms getDisplayTerms() {
		return displayTerms;
	}

	public boolean isConjunctionAdvanceQuery() {
		return displayTerms.isAdvancedSearch() && displayTerms.isAndOperator();
	}

	public boolean isDisjunctionAdvanceQuery() {
		return displayTerms.isAdvancedSearch() && !displayTerms.isAndOperator();
	}

	public boolean hasNoSearchParams() {
		return !displayTerms.isAdvancedSearch()
				&& StringUtils.isEmpty(displayTerms.getKeywords());
	}

	public String getKeyWords() {
		return displayTerms.getKeywords();
	}

}
