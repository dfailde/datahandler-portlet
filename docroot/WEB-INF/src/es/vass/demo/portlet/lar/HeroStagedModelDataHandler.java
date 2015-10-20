package es.vass.demo.portlet.lar;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.portal.kernel.lar.ExportImportPathUtil;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

import es.vass.demo.service.model.Hero;
import es.vass.demo.service.service.HeroLocalServiceUtil;

import java.util.Date;
import java.util.Map;

public class HeroStagedModelDataHandler extends
		BaseStagedModelDataHandler<Hero> {

	public static final String[] CLASS_NAMES = { Hero.class.getName() };

	private static Log _log = LogFactoryUtil
			.getLog(HeroStagedModelDataHandler.class);

	@Override
	public void deleteStagedModel(String uuid, long groupId, String className,
			String extraData) throws PortalException, SystemException {
		Hero hero = HeroLocalServiceUtil.fetchHeroByUuidAndGroupId(uuid,
				groupId);
		if (Validator.isNotNull(hero)) {
			HeroLocalServiceUtil.deleteHero(hero);
		}
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected boolean countStagedModel(PortletDataContext portletDataContext,
			Hero hero) {
		return !portletDataContext.isModelCounted(Hero.class.getName(),
				hero.getHeroId());
	}

	@Override
	public String getDisplayName(Hero hero) {
		return hero.getName();
	}

	@Override
	protected void doExportStagedModel(PortletDataContext portletDataContext,
			Hero hero) throws Exception {
		Element heroElement = portletDataContext.getExportDataElement(hero);
		if (Validator.isNotNull(hero.getImageId())) {
			final FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(hero
					.getImageId());
			if (Validator.isNotNull(fileEntry)) {
				StagedModelDataHandlerUtil.exportReferenceStagedModel(
						portletDataContext, hero, fileEntry,
						PortletDataContext.REFERENCE_TYPE_STRONG);
			}
		}
		portletDataContext.addClassedModel(heroElement,
				ExportImportPathUtil.getModelPath(hero), hero);
	}

	@Override
	protected void doImportStagedModel(PortletDataContext portletDataContext,
			Hero hero) throws Exception {
		ServiceContext serviceContext = portletDataContext.createServiceContext(hero);
		
		Hero importedEntry = null;
		Long fileEntryId = null;
		
		if (Validator.isNotNull(hero.getImageId())) {
			StagedModelDataHandlerUtil.importReferenceStagedModel(portletDataContext, hero, FileEntry.class, hero.getImageId());
			Map<Long, Long> fileEntryIds = (Map<Long, Long>) portletDataContext.getNewPrimaryKeysMap(FileEntry.class);
			fileEntryId = MapUtil.getLong(fileEntryIds, hero.getImageId(), hero.getImageId());
		}
		if (portletDataContext.isDataStrategyMirror()) {
			Hero existingEntry = HeroLocalServiceUtil.fetchHeroByUuidAndGroupId(hero.getUuid(),portletDataContext.getScopeGroupId());
			if (existingEntry == null) {
				serviceContext.setUuid(hero.getUuid());
				importedEntry = createNewHero(portletDataContext, hero);
				importedEntry.setImageId(fileEntryId);
				importedEntry = HeroLocalServiceUtil.addHero(importedEntry);
			} else {
				existingEntry.setUuid(hero.getUuid());
				existingEntry.setName(hero.getName());
				existingEntry.setDescription(hero.getDescription());
				existingEntry.setImageId(fileEntryId);
				existingEntry.setModifiedDate(new Date());
				existingEntry.setUserId(hero.getUserId());
				existingEntry.setUserName(hero.getUserName());
				importedEntry = HeroLocalServiceUtil.updateHero(existingEntry);
			}
		} else {
			importedEntry = createNewHero(portletDataContext, hero);
			importedEntry.setImageId(fileEntryId);
			importedEntry = HeroLocalServiceUtil.addHero(importedEntry);

		}
		portletDataContext.importClassedModel(hero, importedEntry);
	}

	@Override
	protected boolean validateMissingReference(String uuid, long companyId,
			long groupId) throws Exception {
		Hero hero = HeroLocalServiceUtil.fetchHeroByUuidAndGroupId(uuid,
				groupId);
		return hero != null;
	}

	private Hero createNewHero(PortletDataContext portletDataContext, Hero entry)
			throws SystemException {
		Date currentDate = new Date();
		Hero hero = HeroLocalServiceUtil.createHero(CounterLocalServiceUtil
				.increment());
		hero.setUuid(entry.getUuid());
		hero.setName(entry.getName());
		hero.setImageId(entry.getImageId());
		hero.setDescription(entry.getDescription());
		hero.setCompanyId(entry.getCompanyId());
		hero.setGroupId(portletDataContext.getScopeGroupId());
		hero.setCreateDate(currentDate);
		hero.setModifiedDate(currentDate);
		hero.setUserId(entry.getUserId());
		hero.setUserName(entry.getUserName());
		return hero;
	}
}
