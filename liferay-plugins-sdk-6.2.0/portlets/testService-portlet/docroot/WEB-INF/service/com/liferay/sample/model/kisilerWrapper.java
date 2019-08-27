/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sample.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link kisiler}.
 * </p>
 *
 * @author giray
 * @see kisiler
 * @generated
 */
public class kisilerWrapper implements kisiler, ModelWrapper<kisiler> {
	public kisilerWrapper(kisiler kisiler) {
		_kisiler = kisiler;
	}

	@Override
	public Class<?> getModelClass() {
		return kisiler.class;
	}

	@Override
	public String getModelClassName() {
		return kisiler.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kid", getKid());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer kid = (Integer)attributes.get("kid");

		if (kid != null) {
			setKid(kid);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this kisiler.
	*
	* @return the primary key of this kisiler
	*/
	@Override
	public int getPrimaryKey() {
		return _kisiler.getPrimaryKey();
	}

	/**
	* Sets the primary key of this kisiler.
	*
	* @param primaryKey the primary key of this kisiler
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_kisiler.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the kid of this kisiler.
	*
	* @return the kid of this kisiler
	*/
	@Override
	public int getKid() {
		return _kisiler.getKid();
	}

	/**
	* Sets the kid of this kisiler.
	*
	* @param kid the kid of this kisiler
	*/
	@Override
	public void setKid(int kid) {
		_kisiler.setKid(kid);
	}

	/**
	* Returns the name of this kisiler.
	*
	* @return the name of this kisiler
	*/
	@Override
	public java.lang.String getName() {
		return _kisiler.getName();
	}

	/**
	* Sets the name of this kisiler.
	*
	* @param name the name of this kisiler
	*/
	@Override
	public void setName(java.lang.String name) {
		_kisiler.setName(name);
	}

	@Override
	public boolean isNew() {
		return _kisiler.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_kisiler.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _kisiler.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kisiler.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _kisiler.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _kisiler.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kisiler.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kisiler.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_kisiler.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_kisiler.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kisiler.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new kisilerWrapper((kisiler)_kisiler.clone());
	}

	@Override
	public int compareTo(kisiler kisiler) {
		return _kisiler.compareTo(kisiler);
	}

	@Override
	public int hashCode() {
		return _kisiler.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<kisiler> toCacheModel() {
		return _kisiler.toCacheModel();
	}

	@Override
	public kisiler toEscapedModel() {
		return new kisilerWrapper(_kisiler.toEscapedModel());
	}

	@Override
	public kisiler toUnescapedModel() {
		return new kisilerWrapper(_kisiler.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _kisiler.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kisiler.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_kisiler.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof kisilerWrapper)) {
			return false;
		}

		kisilerWrapper kisilerWrapper = (kisilerWrapper)obj;

		if (Validator.equals(_kisiler, kisilerWrapper._kisiler)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public kisiler getWrappedkisiler() {
		return _kisiler;
	}

	@Override
	public kisiler getWrappedModel() {
		return _kisiler;
	}

	@Override
	public void resetOriginalValues() {
		_kisiler.resetOriginalValues();
	}

	private kisiler _kisiler;
}