package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class BeatifulPortletMVC extends MVCPortlet {
	@ProcessAction(name="myFunctionMethod")
	public void myFunctionMethod(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		String name = ParamUtil.getString(actionRequest, "name");		
		System.out.println("Name ==> " + name);
	}
}
