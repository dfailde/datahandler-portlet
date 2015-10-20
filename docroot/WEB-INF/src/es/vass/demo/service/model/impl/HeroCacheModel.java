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

package es.vass.demo.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import es.vass.demo.service.model.Hero;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Hero in entity cache.
 *
 * @author diego.failde
 * @see Hero
 * @generated
 */
public class HeroCacheModel implements CacheModel<Hero>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", heroId=");
		sb.append(heroId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Hero toEntityModel() {
		HeroImpl heroImpl = new HeroImpl();

		if (uuid == null) {
			heroImpl.setUuid(StringPool.BLANK);
		}
		else {
			heroImpl.setUuid(uuid);
		}

		heroImpl.setHeroId(heroId);
		heroImpl.setGroupId(groupId);
		heroImpl.setCompanyId(companyId);
		heroImpl.setUserId(userId);

		if (userName == null) {
			heroImpl.setUserName(StringPool.BLANK);
		}
		else {
			heroImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			heroImpl.setCreateDate(null);
		}
		else {
			heroImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			heroImpl.setModifiedDate(null);
		}
		else {
			heroImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			heroImpl.setName(StringPool.BLANK);
		}
		else {
			heroImpl.setName(name);
		}

		if (description == null) {
			heroImpl.setDescription(StringPool.BLANK);
		}
		else {
			heroImpl.setDescription(description);
		}

		heroImpl.setImageId(imageId);

		heroImpl.resetOriginalValues();

		return heroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		heroId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		imageId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(heroId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(imageId);
	}

	public String uuid;
	public long heroId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public long imageId;
}