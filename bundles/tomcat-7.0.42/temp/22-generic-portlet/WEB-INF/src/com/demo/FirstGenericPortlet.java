package com.demo;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * Portlet implementation class FirstGenericPortlet
 */
public class FirstGenericPortlet extends GenericPortlet {

    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    @RenderMode(name="view")
    public void myView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

    	include(viewTemplate, renderRequest, renderResponse);
    }
    
    @ProcessAction(name="firstActionMethod")
	public void firstActionMethod(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		String name = ParamUtil.getString(request, "name");
    	System.out.println("Name ==>" + name);		
	}
    

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(FirstGenericPortlet.class);

}
