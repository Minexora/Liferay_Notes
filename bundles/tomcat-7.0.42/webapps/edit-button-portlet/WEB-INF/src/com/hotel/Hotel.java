package com.hotel;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class Hotel extends MVCPortlet {
	@ProcessAction(name="processFood")
	public void processFood(ActionRequest actionRequest, ActionResponse actionResponse)	throws IOException, PortletException {
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest, ((LiferayPortletConfig) portletConfig).getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		String foodType = ParamUtil.getString(actionRequest, "foodType");
		actionResponse.setRenderParameter("jspPage", "/html/hotel/view.jsp");
		actionRequest.setAttribute("foodType", foodType);
	}

}
