package es.vass.demo.portlet.lar;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.lar.BasePortletDataHandler;
import com.liferay.portal.kernel.lar.DataLevel;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.PortletDataHandlerBoolean;
import com.liferay.portal.kernel.lar.PortletDataHandlerKeys;
import com.liferay.portal.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.xml.Element;

import es.vass.demo.service.model.Hero;
import es.vass.demo.service.service.HeroLocalServiceUtil;
import es.vass.demo.service.service.persistence.HeroExportActionableDynamicQuery;

import java.util.List;

import javax.portlet.PortletPreferences;

public class DemoPortletDataHandler extends BasePortletDataHandler {

	private static final String HERO_PARAM = "hero";
	public static final String NAMESPACE = "demo";

	public DemoPortletDataHandler() {
		setDataLevel(DataLevel.SITE);
		setDeletionSystemEventStagedModelTypes(new StagedModelType(Hero.class));
		setExportControls(new PortletDataHandlerBoolean(NAMESPACE, HERO_PARAM,
				true, false, null, Hero.class.getName()));
		setImportControls(getExportControls());
		setPublishToLiveByDefault(true);
	}

	@Override
	protected PortletPreferences doDeleteData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences) throws Exception {

		if (portletDataContext.addPrimaryKey(DemoPortletDataHandler.class,
				"deleteData")) {
			return portletPreferences;
		}

		HeroLocalServiceUtil.removeAll(portletDataContext.getScopeGroupId());
		return portletPreferences;
	}

	@Override
	protected void doPrepareManifestSummary(
			PortletDataContext portletDataContext,
			PortletPreferences portletPreferences) throws Exception {
		ActionableDynamicQuery packActionableDynamicQuery = new HeroExportActionableDynamicQuery(
				portletDataContext);
		packActionableDynamicQuery.performCount();
	}

	@Override
	protected String doExportData(PortletDataContext portletDataContext,
			String portletId, PortletPreferences portletPreferences)
			throws Exception {
		Element rootElement = addExportDataRootElement(portletDataContext);
		portletDataContext.addPortletPermissions(portletId);
		portletDataContext.getParameterMap().put(
				PortletDataHandlerKeys.DELETIONS, new String[] { "true" });
		rootElement.addAttribute("group-id",
				String.valueOf(portletDataContext.getScopeGroupId()));

		if (portletDataContext.getBooleanParameter(NAMESPACE, HERO_PARAM)) {
			ActionableDynamicQuery packDynamicQuery = new HeroExportActionableDynamicQuery(
					portletDataContext);
			packDynamicQuery.performActions();
		}
		return getExportDataRootElementString(rootElement);
	}

	@Override
	protected PortletPreferences doImportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences, String data)
			throws Exception {
		portletDataContext.importPortletPermissions(portletId);

		if (portletDataContext.getBooleanParameter(NAMESPACE, HERO_PARAM)) {
			Element packElement = portletDataContext
					.getImportDataGroupElement(Hero.class);
			List<Element> packElements = packElement.elements();
			for (Element element : packElements) {
				StagedModelDataHandlerUtil.importStagedModel(
						portletDataContext, element);
			}
		}
		return portletPreferences;
	}

}
