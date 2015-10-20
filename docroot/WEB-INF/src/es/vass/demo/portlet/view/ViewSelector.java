package es.vass.demo.portlet.view;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

public class ViewSelector {
	private static final String VIEW_PARAM_NAME = "view";
	private static ViewSelector _instance;
	private static Map<String, View> views;

	static {
		views = new HashMap<String, View>();
		views.put(ListHeroView.VIEW_NAME, new ListHeroView());
		views.put(CreateHeroView.VIEW_NAME, new CreateHeroView());
		views.put(EditHeroView.VIEW_NAME, new EditHeroView());
	}

	private ViewSelector() {
	}

	public static ViewSelector getInstance() {
		if (_instance == null) {
			_instance = new ViewSelector();
		}
		return _instance;
	}

	public View selectFrom(PortletRequest request) {
		String viewName = request.getParameter(VIEW_PARAM_NAME);
		return retrieveViewFromRepository(viewName);
	}

	private View retrieveViewFromRepository(String viewName) {
		View view = views.get(viewName);
		if (view == null)
			return new NullView();
		return view;
	}

	public View selectViewByName(String viewName) {
		return retrieveViewFromRepository(viewName);
	}
}
