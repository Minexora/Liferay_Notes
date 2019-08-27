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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.sample.service.ClpSerializer;
import com.liferay.sample.service.kisilerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author giray
 */
public class kisilerClp extends BaseModelImpl<kisiler> implements kisiler {
	public kisilerClp() {
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
	public int getPrimaryKey() {
		return _kid;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setKid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
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

	@Override
	public int getKid() {
		return _kid;
	}

	@Override
	public void setKid(int kid) {
		_kid = kid;

		if (_kisilerRemoteModel != null) {
			try {
				Class<?> clazz = _kisilerRemoteModel.getClass();

				Method method = clazz.getMethod("setKid", int.class);

				method.invoke(_kisilerRemoteModel, kid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_kisilerRemoteModel != null) {
			try {
				Class<?> clazz = _kisilerRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_kisilerRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getkisilerRemoteModel() {
		return _kisilerRemoteModel;
	}

	public void setkisilerRemoteModel(BaseModel<?> kisilerRemoteModel) {
		_kisilerRemoteModel = kisilerRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _kisilerRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_kisilerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			kisilerLocalServiceUtil.addkisiler(this);
		}
		else {
			kisilerLocalServiceUtil.updatekisiler(this);
		}
	}

	@Override
	public kisiler toEscapedModel() {
		return (kisiler)ProxyUtil.newProxyInstance(kisiler.class.getClassLoader(),
			new Class[] { kisiler.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		kisilerClp clone = new kisilerClp();

		clone.setKid(getKid());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(kisiler kisiler) {
		int primaryKey = kisiler.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof kisilerClp)) {
			return false;
		}

		kisilerClp kisiler = (kisilerClp)obj;

		int primaryKey = kisiler.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{kid=");
		sb.append(getKid());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.kisiler");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kid</column-name><column-value><![CDATA[");
		sb.append(getKid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _kid;
	private String _name;
	private BaseModel<?> _kisilerRemoteModel;
}