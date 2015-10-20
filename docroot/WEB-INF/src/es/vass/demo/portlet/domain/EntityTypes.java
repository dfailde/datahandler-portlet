package es.vass.demo.portlet.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public enum EntityTypes {
	HEROES("heroes");

	private String value;

	private static final Map<String, EntityTypes> lookup = new HashMap<String, EntityTypes>();
	static {
		for (EntityTypes tabs : EntityTypes.values())
			lookup.put(tabs.getValue(), tabs);
	}

	EntityTypes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static EntityTypes getFromValue(String value) {
		return lookup.get(value);
	}

	public static boolean isUbigeoType(String value) {
		if (StringUtils.isEmpty(value))
			return false;
		return lookup.containsKey(value.toLowerCase());
	}

}
