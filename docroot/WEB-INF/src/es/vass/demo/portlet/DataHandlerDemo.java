package es.vass.demo.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import es.vass.demo.portlet.domain.DemoContext;
import es.vass.demo.portlet.facade.HeroFacade;
import es.vass.demo.portlet.view.ListHeroView;
import es.vass.demo.portlet.view.View;
import es.vass.demo.portlet.view.ViewSelector;
import es.vass.demo.portlet.view.model.ErrorMessages;
import es.vass.demo.portlet.view.model.HeroDTO;
import es.vass.demo.portlet.view.model.HeroMessages;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class DataHandlerDemo
 */
public class DataHandlerDemo extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(DataHandlerDemo.class);
	private HeroFacade heroFacade = HeroFacade.getInstance();
	private static final String HERO_ID = "heroId";
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		renderView(request, response);
	}

	protected void renderView(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		View view = ViewSelector.getInstance().selectFrom(request);
		String viewName = view.render(request, response);
		include(getInitParameter(viewName), request, response,
				PortletRequest.RENDER_PHASE);
		super.render(request, response);
	}

	public void saveHero(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {
		HeroDTO heroDTO = HeroDTO.from(actionRequest);
		DemoContext context = DemoContext.buildFrom(actionRequest);
		try {
			_log.debug("Saving point of sale: " + heroDTO);
			heroFacade.save(heroDTO, context);
		} catch (Exception e) {
			_log.error("Error occurred while saving point of sale  " + heroDTO
					+ ": ", e);
			actionRequest.setAttribute(ErrorMessages.ERROR_ATTR,
					HeroMessages.SAVING);
		}
		toHeroListView(actionResponse);
	}

	public void updateHero(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {
		HeroDTO heroDTO = HeroDTO.from(actionRequest);
		DemoContext context = DemoContext.buildFrom(actionRequest);
		try {
			_log.debug("Updating point of sale: " + heroDTO);
			heroFacade.update(heroDTO, context);
		} catch (Exception e) {
			_log.error("Error occurred while updating point of sale  "
					+ heroDTO + ": ", e);
			actionRequest.setAttribute(ErrorMessages.ERROR_ATTR,
					HeroMessages.UPDATING);
		}
		toHeroListView(actionResponse);
	}

	public void removeHero(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {
		String heroId = ParamUtil.getString(actionRequest, HERO_ID);
		DemoContext context = DemoContext.buildFrom(actionRequest);

		try {
			_log.debug("Deleting point of sale with ID: " + heroId);
			heroFacade.remove(heroId, context);
		} catch (Exception e) {
			_log.error("An error ocurred while deleting point of sale with ID: "
					+ heroId + ": ", e);
			actionRequest.setAttribute(ErrorMessages.ERROR_ATTR,
					HeroMessages.DELETING);
		}
		toHeroListView(actionResponse);
	}

	public void searchHerosInListView(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {
		toHeroListView(actionResponse);
	}

	private void toHeroListView(ActionResponse actionResponse) {
		actionResponse.setRenderParameter(View.VIEW_PARAM_NAME,
				ListHeroView.VIEW_NAME);
	}

}
