package es.vass.demo.portlet.view;

import es.vass.demo.portlet.domain.DemoContext;
import es.vass.demo.portlet.view.model.HeroModelView;
import es.vass.demo.portlet.view.model.HeroModelViewAdapter;
import es.vass.demo.service.model.Hero;
import es.vass.demo.service.service.HeroLocalServiceUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public class CreateHeroView implements View {
	public static final String VIEW_NAME = "create-view";
	private static final String HERO_ATTR = "hero";
	private static final String IMAGES = "images";

	@Override
	public String render(PortletRequest request, PortletResponse response) {
		DemoContext context = DemoContext.buildFrom(request);
		Hero hero = HeroLocalServiceUtil.createHero(0);
		HeroModelView heroModelView = new HeroModelViewAdapter(hero);
		request.setAttribute(HERO_ATTR, heroModelView);
		return getName();

	}

	@Override
	public String getName() {
		return VIEW_NAME;
	}
}
