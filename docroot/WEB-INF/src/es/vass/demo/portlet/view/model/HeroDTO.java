package es.vass.demo.portlet.view.model;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

public class HeroDTO {
	private static final String HERO_ID = "heroId";
	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String IMAGE = "image";
	private String heroId;
	private String name;
	private String description;
	private String image;

	public HeroDTO(String heroId, String name, String description, String image) {
		super();
		this.heroId = heroId;
		this.name = name;
		this.description = description;
		this.image = image;
	}

	public static HeroDTO from(PortletRequest request) {
		String heroId = ParamUtil.getString(request, HERO_ID);
		String name = ParamUtil.getString(request, NAME);
		String description = ParamUtil.getString(request, DESCRIPTION);
		String image = ParamUtil.getString(request, IMAGE);
		return new HeroDTO(heroId, name, description, image);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getHeroId() {
		return heroId;
	}

	public String getImage() {
		return image;
	}

	public String toString() {
		return "HeroDTO [name=" + name + "]";
	}

	public long getHeroIdAsLong() {
		return GetterUtil.getLong(getHeroId());
	}

}
