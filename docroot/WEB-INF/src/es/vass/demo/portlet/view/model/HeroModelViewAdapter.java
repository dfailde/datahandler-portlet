package es.vass.demo.portlet.view.model;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

import es.vass.demo.service.model.Hero;

public class HeroModelViewAdapter implements HeroModelView {

	private Hero hero;

	public HeroModelViewAdapter(Hero hero) {
		this.hero = hero;
	}

	@Override
	public String getName() {
		if (isNew())
			return StringPool.BLANK;
		return hero.getName();
	}
	
	@Override
	public String getDescription() {
		if (isNew())
			return StringPool.BLANK;
		return hero.getDescription();
	}
	
	@Override
	public long getHeroId() {
		if (isNew())
			return 0;
		return hero.getHeroId();
	}
	
	@Override
	public String getImage() {
		if (isNew())
			return "";
		try {
			DLFileEntry fetchDLFileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(hero.getImageId());
			if(fetchDLFileEntry != null){
				return fetchDLFileEntry.getName();
			}
		} catch (SystemException e) {
		}
		return "";
	}

	private boolean isNew() {
		return this.hero.getHeroId() == 0;
	}

}
