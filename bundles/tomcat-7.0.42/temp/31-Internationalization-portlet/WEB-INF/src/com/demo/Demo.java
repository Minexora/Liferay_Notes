package com.demo;

import java.io.IOException;
import java.util.Locale;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.jsp.PageContext;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class Demo extends MVCPortlet {
 
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		Locale defaultLocale = Locale.getDefault();
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String message = LanguageUtil.get(portletConfig, defaultLocale, "welcome_message");
		String title = LanguageUtil.get(portletConfig, defaultLocale, "portlet-title");
		renderResponse.setTitle(title);
		renderRequest.setAttribute("message", message);
		
		super.doView(renderRequest, renderResponse);
	}

}
