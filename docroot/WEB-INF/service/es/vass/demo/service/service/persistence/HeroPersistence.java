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

package es.vass.demo.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import es.vass.demo.service.model.Hero;

/**
 * The persistence interface for the hero service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author diego.failde
 * @see HeroPersistenceImpl
 * @see HeroUtil
 * @generated
 */
public interface HeroPersistence extends BasePersistence<Hero> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HeroUtil} to access the hero persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the heros where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the heros where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.demo.service.model.impl.HeroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of heros
	* @param end the upper bound of the range of heros (not inclusive)
	* @return the range of matching heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the heros where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.demo.service.model.impl.HeroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of heros
	* @param end the upper bound of the range of heros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first hero in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hero
	* @throws es.vass.demo.service.NoSuchHeroException if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Returns the first hero in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hero, or <code>null</code> if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last hero in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hero
	* @throws es.vass.demo.service.NoSuchHeroException if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Returns the last hero in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hero, or <code>null</code> if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the heros before and after the current hero in the ordered set where uuid = &#63;.
	*
	* @param heroId the primary key of the current hero
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next hero
	* @throws es.vass.demo.service.NoSuchHeroException if a hero with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero[] findByUuid_PrevAndNext(
		long heroId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Removes all the heros where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heros where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching heros
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hero where uuid = &#63; and groupId = &#63; or throws a {@link es.vass.demo.service.NoSuchHeroException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching hero
	* @throws es.vass.demo.service.NoSuchHeroException if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Returns the hero where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching hero, or <code>null</code> if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hero where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching hero, or <code>null</code> if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the hero where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the hero that was removed
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Returns the number of heros where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching heros
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heros where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the heros where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.demo.service.model.impl.HeroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of heros
	* @param end the upper bound of the range of heros (not inclusive)
	* @return the range of matching heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the heros where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.demo.service.model.impl.HeroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of heros
	* @param end the upper bound of the range of heros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first hero in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hero
	* @throws es.vass.demo.service.NoSuchHeroException if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Returns the first hero in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hero, or <code>null</code> if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last hero in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hero
	* @throws es.vass.demo.service.NoSuchHeroException if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Returns the last hero in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hero, or <code>null</code> if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the heros before and after the current hero in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param heroId the primary key of the current hero
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next hero
	* @throws es.vass.demo.service.NoSuchHeroException if a hero with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero[] findByUuid_C_PrevAndNext(
		long heroId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Removes all the heros where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heros where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching heros
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heros where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the heros where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.demo.service.model.impl.HeroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of heros
	* @param end the upper bound of the range of heros (not inclusive)
	* @return the range of matching heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the heros where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.demo.service.model.impl.HeroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of heros
	* @param end the upper bound of the range of heros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first hero in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hero
	* @throws es.vass.demo.service.NoSuchHeroException if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Returns the first hero in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hero, or <code>null</code> if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last hero in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hero
	* @throws es.vass.demo.service.NoSuchHeroException if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Returns the last hero in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hero, or <code>null</code> if a matching hero could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the heros before and after the current hero in the ordered set where groupId = &#63;.
	*
	* @param heroId the primary key of the current hero
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next hero
	* @throws es.vass.demo.service.NoSuchHeroException if a hero with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero[] findByGroupId_PrevAndNext(
		long heroId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Removes all the heros where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heros where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching heros
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the hero in the entity cache if it is enabled.
	*
	* @param hero the hero
	*/
	public void cacheResult(es.vass.demo.service.model.Hero hero);

	/**
	* Caches the heros in the entity cache if it is enabled.
	*
	* @param heros the heros
	*/
	public void cacheResult(
		java.util.List<es.vass.demo.service.model.Hero> heros);

	/**
	* Creates a new hero with the primary key. Does not add the hero to the database.
	*
	* @param heroId the primary key for the new hero
	* @return the new hero
	*/
	public es.vass.demo.service.model.Hero create(long heroId);

	/**
	* Removes the hero with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param heroId the primary key of the hero
	* @return the hero that was removed
	* @throws es.vass.demo.service.NoSuchHeroException if a hero with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero remove(long heroId)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	public es.vass.demo.service.model.Hero updateImpl(
		es.vass.demo.service.model.Hero hero)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hero with the primary key or throws a {@link es.vass.demo.service.NoSuchHeroException} if it could not be found.
	*
	* @param heroId the primary key of the hero
	* @return the hero
	* @throws es.vass.demo.service.NoSuchHeroException if a hero with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero findByPrimaryKey(long heroId)
		throws com.liferay.portal.kernel.exception.SystemException,
			es.vass.demo.service.NoSuchHeroException;

	/**
	* Returns the hero with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param heroId the primary key of the hero
	* @return the hero, or <code>null</code> if a hero with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public es.vass.demo.service.model.Hero fetchByPrimaryKey(long heroId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heros.
	*
	* @return the heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the heros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.demo.service.model.impl.HeroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of heros
	* @param end the upper bound of the range of heros (not inclusive)
	* @return the range of heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the heros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.demo.service.model.impl.HeroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of heros
	* @param end the upper bound of the range of heros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of heros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<es.vass.demo.service.model.Hero> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the heros from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heros.
	*
	* @return the number of heros
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}