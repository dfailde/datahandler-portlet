package es.vass.demo.portlet.view;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;

import es.vass.demo.portlet.domain.DemoContext;
import es.vass.demo.portlet.view.model.HeroSearchContainer;
import es.vass.demo.portlet.view.model.HeroSearchDTO;
import es.vass.demo.service.model.Hero;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ListHeroView implements View {
	private static final String HERO_SEARCH_CONTAINER_ATTR = "heroSearchContainer";
	public static final String VIEW_NAME = "list-view";

	@Override
	public String render(PortletRequest request, PortletResponse response) {
		DemoContext context = DemoContext.buildFrom(request);
		HeroSearchDTO heroSearchDTO = HeroSearchDTO.from(request);

		SearchContainer<Hero> heroSearchContainer = null;
		try {
			heroSearchContainer = HeroSearchContainer
					.buildWithSearchCapabilites(heroSearchDTO,
							(RenderRequest) request, (RenderResponse) response,
							context);
		} catch (SystemException e) {
		}
		request.setAttribute(HERO_SEARCH_CONTAINER_ATTR, heroSearchContainer);
		return getName();
	}

	@Override
	public String getName() {
		return VIEW_NAME;
	}

}
