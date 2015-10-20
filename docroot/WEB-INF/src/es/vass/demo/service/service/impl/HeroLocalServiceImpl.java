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

package es.vass.demo.service.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.SystemEventConstants;
import com.liferay.portal.service.SystemEventLocalServiceUtil;

import es.vass.demo.service.model.Hero;
import es.vass.demo.service.service.base.HeroLocalServiceBaseImpl;

import java.util.Collection;

/**
 * The implementation of the hero local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link es.vass.demo.service.service.HeroLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author diego.failde
 * @see es.vass.demo.service.service.base.HeroLocalServiceBaseImpl
 * @see es.vass.demo.service.service.HeroLocalServiceUtil
 */
public class HeroLocalServiceImpl extends HeroLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * es.vass.demo.service.service.HeroLocalServiceUtil} to access the hero
	 * local service.
	 */

	@Override
	public Collection<Hero> findByGroupId(long groupId) throws SystemException {
		return heroPersistence.findByGroupId(groupId);
	}

	@Override
	public Collection<Hero> findByGroupId(long groupId, int start, int end)
			throws SystemException {
		return heroPersistence.findByGroupId(groupId, start, end);
	}

	@Override
	public int countByGroupId(long groupId) throws SystemException {
		return heroPersistence.countByGroupId(groupId);
	}

	@Override
	public void removeAll(long groupId) throws SystemException {
		heroPersistence.removeByGroupId(groupId);
	}

	@Override
	public Hero deleteHero(Hero hero) throws SystemException {
		try {
			addSystemEvent(hero);
		} catch (PortalException e) {
		}
		return super.deleteHero(hero);
	}

	@Override
	public Hero deleteHero(long heroId) throws PortalException, SystemException {
		Hero hero = getHero(heroId);
		addSystemEvent(hero);
		return super.deleteHero(heroId);
	}

	private void addSystemEvent(Hero deleteHero) throws SystemException,
			PortalException {
		SystemEventLocalServiceUtil.addSystemEvent(deleteHero.getUserId(),
				deleteHero.getGroupId(), Hero.class.getName(),
				deleteHero.getHeroId(), deleteHero.getUuid(), null,
				SystemEventConstants.TYPE_DELETE, null);
	}
}