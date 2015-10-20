package es.vass.demo.portlet.view;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public interface View {
	String VIEW_PARAM_NAME = "view";

	/**
	 * Execute the view by setting attributes to request.
	 * @param request
	 * @param response
	 * @return view name to render
	 */
	String render(PortletRequest request,PortletResponse response); 
	String getName();
}
