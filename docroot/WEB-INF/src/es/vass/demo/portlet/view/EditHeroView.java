package es.vass.demo.portlet.view;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

import es.vass.demo.portlet.domain.DemoContext;
import es.vass.demo.portlet.view.model.HeroModelView;
import es.vass.demo.portlet.view.model.HeroModelViewAdapter;
import es.vass.demo.service.model.Hero;
import es.vass.demo.service.service.HeroLocalServiceUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class EditHeroView implements View {
	private static final String HERO_ATTR = "hero";
	public static final String VIEW_NAME = "edit-view";
	private static final String HERO_ID = "heroId";

	@Override
	public String getName() {
		return VIEW_NAME;
	}

	@Override
	public String render(PortletRequest request, PortletResponse response) {
		long heroId = ParamUtil.getLong(request, HERO_ID);
		DemoContext context = DemoContext.buildFrom(request);
		try {
			Hero hero = HeroLocalServiceUtil.getHero(heroId);
			HeroModelView heroModelView = new HeroModelViewAdapter(hero);
			request.setAttribute(HERO_ATTR, heroModelView);
			return getName();
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
			return getName();
		}
	}

}
