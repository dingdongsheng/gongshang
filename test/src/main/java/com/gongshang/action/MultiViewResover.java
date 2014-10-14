package com.gongshang.action;


import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class MultiViewResover implements ViewResolver {

	private Map<String, ViewResolver> resolvers;
	
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		// TODO Auto-generated method stub
		
		int n = viewName.lastIndexOf("."); // If there is underscore.
		String suffix = "";
		if(-1 == n){
			suffix = "jsp";
		}else{
			suffix = viewName.substring(n+1);
			viewName = viewName.substring(0,n);
		}
		
		// Get viewResolver by the string after '_'
		ViewResolver resolver = resolvers.get(suffix);
		
		if(resolver != null){
			return resolver.resolveViewName(viewName, locale);
		}else{
			return null;
		}
	}
	
	public Map<String, ViewResolver> getResolvers() {
		return resolvers;
	}

	public void setResolvers(Map<String, ViewResolver> resolvers) {
		this.resolvers = resolvers;
	}

}
