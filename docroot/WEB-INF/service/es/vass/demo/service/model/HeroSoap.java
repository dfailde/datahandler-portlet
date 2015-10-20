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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link es.vass.demo.service.service.http.HeroServiceSoap}.
 *
 * @author diego.failde
 * @see es.vass.demo.service.service.http.HeroServiceSoap
 * @generated
 */
public class HeroSoap implements Serializable {
	public static HeroSoap toSoapModel(Hero model) {
		HeroSoap soapModel = new HeroSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setHeroId(model.getHeroId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setImageId(model.getImageId());

		return soapModel;
	}

	public static HeroSoap[] toSoapModels(Hero[] models) {
		HeroSoap[] soapModels = new HeroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HeroSoap[][] toSoapModels(Hero[][] models) {
		HeroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HeroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HeroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HeroSoap[] toSoapModels(List<Hero> models) {
		List<HeroSoap> soapModels = new ArrayList<HeroSoap>(models.size());

		for (Hero model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HeroSoap[soapModels.size()]);
	}

	public HeroSoap() {
	}

	public long getPrimaryKey() {
		return _heroId;
	}

	public void setPrimaryKey(long pk) {
		setHeroId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getHeroId() {
		return _heroId;
	}

	public void setHeroId(long heroId) {
		_heroId = heroId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	private String _uuid;
	private long _heroId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private long _imageId;
}