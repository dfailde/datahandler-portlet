package es.vass.demo.portlet.facade;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

import es.vass.demo.portlet.domain.DemoContext;
import es.vass.demo.portlet.view.model.HeroDTO;
import es.vass.demo.service.model.Hero;
import es.vass.demo.service.service.HeroLocalServiceUtil;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeroFacade {
	private static final String HERO_ID = "heroId";
	private static final String GROUP_ID = "groupId";
	private static HeroFacade _instance;
	private static final Logger LOG = LoggerFactory.getLogger(HeroFacade.class);

	private HeroFacade() {
	}

	public static HeroFacade getInstance() {
		if (_instance == null) {
			_instance = new HeroFacade();
		}
		return _instance;
	}

	public Hero save(HeroDTO heroDTO, DemoContext context)
			throws SystemException {
		Hero hero = HeroLocalServiceUtil.createHero(heroId());
		copyHeroFromDTO(context, heroDTO, hero);
		setBasicAuditFields(context, hero);
		hero.setCreateDate(new Date());
		hero.setModifiedDate(new Date());
		return HeroLocalServiceUtil.addHero(hero);
	}

	private void copyHeroFromDTO(DemoContext context, HeroDTO heroDTO, Hero hero) {
		hero.setName(heroDTO.getName());
		hero.setDescription(heroDTO.getDescription());
		DLFileEntry file;
		try {
			file = DLFileEntryLocalServiceUtil.fetchFileEntryByName(
					context.getGroupId(), context.getFolderId(),
					heroDTO.getImage());
			if (file != null) {
				hero.setImageId(file.getFileEntryId());
			}
		} catch (SystemException e) {
		}
	}

	private void setBasicAuditFields(DemoContext context, Hero hero) {
		hero.setGroupId(context.getGroupId());
		hero.setCompanyId(context.getCompanyId());
		hero.setUserId(context.getUserId());
		hero.setUserName(context.getUserName());
	}

	private long heroId() throws SystemException {
		return CounterLocalServiceUtil.increment(Hero.class.getName());
	}

	public Hero update(HeroDTO heroDTO, DemoContext context)
			throws PortalException, SystemException {
		Hero hero = HeroLocalServiceUtil.getHero(heroDTO.getHeroIdAsLong());
		copyHeroFromDTO(context, heroDTO, hero);
		setBasicAuditFields(context, hero);
		hero.setModifiedDate(new Date());
		return HeroLocalServiceUtil.updateHero(hero);
	}

	public void remove(String heroId, DemoContext context) throws Exception {
		HeroLocalServiceUtil.deleteHero(Long.parseLong(heroId));
	}

}