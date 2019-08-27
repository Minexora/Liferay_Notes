package com.registration;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.ProcessAction;


import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class Registration extends MVCPortlet {
	@ProcessAction(name="registerMethod")
	public void registerMethod(ActionRequest request, ActionResponse response) {
		String firstname = ParamUtil.getString(request, "firstname");
		String lastname = ParamUtil.getString(request, "lastname");
		String phone = ParamUtil.getString(request, "phone");
		String email = ParamUtil.getString(request, "email");
		
		RegistrationCon User = new RegistrationCon(firstname, lastname, phone, email);
		List<String> errors = validate(User, request);
		if (errors.size() == 0) {
			System.out.println("Successfully Created");
		}
		else {
			PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			SessionMessages.add(request, ((LiferayPortletConfig) portletConfig).getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			request.setAttribute("User", User);
			request.setAttribute("errors", errors);
		}
	}
	
	public List<String> validate(RegistrationCon User, ActionRequest request) {
		List<String> errors = new ArrayList<String>();
		ResourceBundle bundle = getPortletConfig().getResourceBundle(request.getLocale());
		if (!Validator.isName(User.firstname)) {
			errors.add(bundle.getString("firstname.errorMsg.missing"));			
		}
		if (!Validator.isName(User.lastname)) {
			errors.add(bundle.getString("lastname.errorMsg.missing"));			
		}
		if (!Validator.isPhoneNumber(User.phone)) {
			errors.add(bundle.getString("phone.errorMsg.missing"));			
		}
		if (!Validator.isEmailAddress(User.email)) {
			errors.add(bundle.getString("email.errorMsg.missing"));			
		}
		return errors;
	}
}
