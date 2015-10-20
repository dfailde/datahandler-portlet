package es.vass.demo.portlet.view.model;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;

import es.vass.demo.portlet.domain.DemoContext;
import es.vass.demo.service.model.Hero;
import es.vass.demo.service.service.HeroLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class HeroSearchContainer extends BaseSearchContainer {

	private static final String NO_RESULTS_MSG = "No points of sale were found";

	private HeroSearchContainer() {
	}

	public static SearchContainer<Hero> buildWithSearchCapabilites(
			HeroSearchDTO heroSearchDTO, RenderRequest renderRequest,
			RenderResponse renderResponse, DemoContext context)
			throws SystemException {
		PortletConfig portletConfig = getPortletConfig(renderRequest);
		ThemeDisplay themeDisplay = getThemeDisplay(renderRequest);
		PortletURL iteratorURL = createIteratorUrl(renderResponse,
				heroSearchDTO.asMap());
		return createSearchContainer(heroSearchDTO, renderRequest,
				portletConfig, themeDisplay, iteratorURL, context);

	}

	private static SearchContainer<Hero> createSearchContainer(
			HeroSearchDTO heroSearchDTO, RenderRequest renderRequest,
			PortletConfig portletConfig, ThemeDisplay themeDisplay,
			PortletURL iteratorURL, DemoContext context) throws SystemException {

		SearchContainer<Hero> searchContainer = new SearchContainer<Hero>(
				renderRequest, heroSearchDTO.getDisplayTerms(),
				heroSearchDTO.getDisplayTerms(),
				SearchContainer.DEFAULT_CUR_PARAM, ParamUtil.getInteger(
						renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
						RESULTS_PER_PAGE), iteratorURL, null,
				LanguageUtil.get(portletConfig, themeDisplay.getLocale(),
						NO_RESULTS_MSG));

		searchContainer.setTotal(totalResults(context));
		searchContainer.setResults(pagedResults(searchContainer, heroSearchDTO,
				context));
		return searchContainer;
	}

	private static int totalResults(DemoContext context) throws SystemException {
		return HeroLocalServiceUtil.countByGroupId(context.getGroupId());
	}

	private static List<Hero> pagedResults(
			SearchContainer<Hero> searchContainer, HeroSearchDTO heroSearchDTO,
			DemoContext context) throws SystemException {

		Collection<Hero> results = Collections.emptyList();
		results = HeroLocalServiceUtil.findByGroupId(context.getGroupId(),
				searchContainer.getStart(), searchContainer.getEnd());
		return asList(results);

	}

	private static List<Hero> asList(Collection<Hero> results) {
		return new ArrayList<Hero>(results);
	}

}
