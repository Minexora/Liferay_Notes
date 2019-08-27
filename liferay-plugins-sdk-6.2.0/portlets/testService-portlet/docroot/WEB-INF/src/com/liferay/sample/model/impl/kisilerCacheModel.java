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

package com.liferay.sample.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.sample.model.kisiler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing kisiler in entity cache.
 *
 * @author giray
 * @see kisiler
 * @generated
 */
public class kisilerCacheModel implements CacheModel<kisiler>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{kid=");
		sb.append(kid);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public kisiler toEntityModel() {
		kisilerImpl kisilerImpl = new kisilerImpl();

		kisilerImpl.setKid(kid);

		if (name == null) {
			kisilerImpl.setName(StringPool.BLANK);
		}
		else {
			kisilerImpl.setName(name);
		}

		kisilerImpl.resetOriginalValues();

		return kisilerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		kid = objectInput.readInt();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(kid);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public int kid;
	public String name;
}