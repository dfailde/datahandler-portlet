/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package es.vass.demo.service.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Hero}.
 * </p>
 *
 * @author diego.failde
 * @see Hero
 * @generated
 */
public class HeroWrapper implements Hero, ModelWrapper<Hero> {
	public HeroWrapper(Hero hero) {
		_hero = hero;
	}

	@Override
	public Class<?> getModelClass() {
		return Hero.class;
	}

	@Override
	public String getModelClassName() {
		return Hero.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("heroId", getHeroId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("imageId", getImageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long heroId = (Long)attributes.get("heroId");

		if (heroId != null) {
			setHeroId(heroId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}
	}

	/**
	* Returns the primary key of this hero.
	*
	* @return the primary key of this hero
	*/
	@Override
	public long getPrimaryKey() {
		return _hero.getPrimaryKey();
	}

	/**
	* Sets the primary key of this hero.
	*
	* @param primaryKey the primary key of this hero
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_hero.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this hero.
	*
	* @return the uuid of this hero
	*/
	@Override
	public java.lang.String getUuid() {
		return _hero.getUuid();
	}

	/**
	* Sets the uuid of this hero.
	*
	* @param uuid the uuid of this hero
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_hero.setUuid(uuid);
	}

	/**
	* Returns the hero ID of this hero.
	*
	* @return the hero ID of this hero
	*/
	@Override
	public long getHeroId() {
		return _hero.getHeroId();
	}

	/**
	* Sets the hero ID of this hero.
	*
	* @param heroId the hero ID of this hero
	*/
	@Override
	public void setHeroId(long heroId) {
		_hero.setHeroId(heroId);
	}

	/**
	* Returns the group ID of this hero.
	*
	* @return the group ID of this hero
	*/
	@Override
	public long getGroupId() {
		return _hero.getGroupId();
	}

	/**
	* Sets the group ID of this hero.
	*
	* @param groupId the group ID of this hero
	*/
	@Override
	public void setGroupId(long groupId) {
		_hero.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this hero.
	*
	* @return the company ID of this hero
	*/
	@Override
	public long getCompanyId() {
		return _hero.getCompanyId();
	}

	/**
	* Sets the company ID of this hero.
	*
	* @param companyId the company ID of this hero
	*/
	@Override
	public void setCompanyId(long companyId) {
		_hero.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this hero.
	*
	* @return the user ID of this hero
	*/
	@Override
	public long getUserId() {
		return _hero.getUserId();
	}

	/**
	* Sets the user ID of this hero.
	*
	* @param userId the user ID of this hero
	*/
	@Override
	public void setUserId(long userId) {
		_hero.setUserId(userId);
	}

	/**
	* Returns the user uuid of this hero.
	*
	* @return the user uuid of this hero
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hero.getUserUuid();
	}

	/**
	* Sets the user uuid of this hero.
	*
	* @param userUuid the user uuid of this hero
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_hero.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this hero.
	*
	* @return the user name of this hero
	*/
	@Override
	public java.lang.String getUserName() {
		return _hero.getUserName();
	}

	/**
	* Sets the user name of this hero.
	*
	* @param userName the user name of this hero
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_hero.setUserName(userName);
	}

	/**
	* Returns the create date of this hero.
	*
	* @return the create date of this hero
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _hero.getCreateDate();
	}

	/**
	* Sets the create date of this hero.
	*
	* @param createDate the create date of this hero
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_hero.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this hero.
	*
	* @return the modified date of this hero
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _hero.getModifiedDate();
	}

	/**
	* Sets the modified date of this hero.
	*
	* @param modifiedDate the modified date of this hero
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_hero.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this hero.
	*
	* @return the name of this hero
	*/
	@Override
	public java.lang.String getName() {
		return _hero.getName();
	}

	/**
	* Sets the name of this hero.
	*
	* @param name the name of this hero
	*/
	@Override
	public void setName(java.lang.String name) {
		_hero.setName(name);
	}

	/**
	* Returns the description of this hero.
	*
	* @return the description of this hero
	*/
	@Override
	public java.lang.String getDescription() {
		return _hero.getDescription();
	}

	/**
	* Sets the description of this hero.
	*
	* @param description the description of this hero
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_hero.setDescription(description);
	}

	/**
	* Returns the image ID of this hero.
	*
	* @return the image ID of this hero
	*/
	@Override
	public long getImageId() {
		return _hero.getImageId();
	}

	/**
	* Sets the image ID of this hero.
	*
	* @param imageId the image ID of this hero
	*/
	@Override
	public void setImageId(long imageId) {
		_hero.setImageId(imageId);
	}

	@Override
	public boolean isNew() {
		return _hero.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_hero.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _hero.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_hero.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _hero.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _hero.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hero.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hero.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_hero.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_hero.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hero.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HeroWrapper((Hero)_hero.clone());
	}

	@Override
	public int compareTo(es.vass.demo.service.model.Hero hero) {
		return _hero.compareTo(hero);
	}

	@Override
	public int hashCode() {
		return _hero.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<es.vass.demo.service.model.Hero> toCacheModel() {
		return _hero.toCacheModel();
	}

	@Override
	public es.vass.demo.service.model.Hero toEscapedModel() {
		return new HeroWrapper(_hero.toEscapedModel());
	}

	@Override
	public es.vass.demo.service.model.Hero toUnescapedModel() {
		return new HeroWrapper(_hero.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hero.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _hero.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hero.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HeroWrapper)) {
			return false;
		}

		HeroWrapper heroWrapper = (HeroWrapper)obj;

		if (Validator.equals(_hero, heroWrapper._hero)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _hero.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Hero getWrappedHero() {
		return _hero;
	}

	@Override
	public Hero getWrappedModel() {
		return _hero;
	}

	@Override
	public void resetOriginalValues() {
		_hero.resetOriginalValues();
	}

	private Hero _hero;
}