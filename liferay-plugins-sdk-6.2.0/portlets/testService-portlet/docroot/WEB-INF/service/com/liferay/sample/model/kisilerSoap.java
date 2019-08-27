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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author giray
 * @generated
 */
public class kisilerSoap implements Serializable {
	public static kisilerSoap toSoapModel(kisiler model) {
		kisilerSoap soapModel = new kisilerSoap();

		soapModel.setKid(model.getKid());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static kisilerSoap[] toSoapModels(kisiler[] models) {
		kisilerSoap[] soapModels = new kisilerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static kisilerSoap[][] toSoapModels(kisiler[][] models) {
		kisilerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new kisilerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new kisilerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static kisilerSoap[] toSoapModels(List<kisiler> models) {
		List<kisilerSoap> soapModels = new ArrayList<kisilerSoap>(models.size());

		for (kisiler model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new kisilerSoap[soapModels.size()]);
	}

	public kisilerSoap() {
	}

	public int getPrimaryKey() {
		return _kid;
	}

	public void setPrimaryKey(int pk) {
		setKid(pk);
	}

	public int getKid() {
		return _kid;
	}

	public void setKid(int kid) {
		_kid = kid;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private int _kid;
	private String _name;
}