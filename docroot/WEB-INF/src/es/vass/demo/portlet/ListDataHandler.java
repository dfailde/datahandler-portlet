package es.vass.demo.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import es.vass.demo.service.model.Hero;
import es.vass.demo.service.service.HeroLocalServiceUtil;

import java.io.IOException;
import java.util.Collection;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class DataHandlerDemo
 */
public class ListDataHandler extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(ListDataHandler.class);

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		Collection<Hero> heroes = null;
		try {
			heroes = HeroLocalServiceUtil.findByGroupId(themeDisplay
					.getScopeGroupId());
		} catch (SystemException e) {
			if (_log.isErrorEnabled()) {
				_log.error(e);
			}
		}
		request.setAttribute("heroes", heroes);
		super.render(request, response);
	}

}
