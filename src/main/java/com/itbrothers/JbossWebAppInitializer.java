package com.itbrothers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class JbossWebAppInitializer implements WebApplicationInitializer {

	public JbossWebAppInitializer() {
		System.out.println("JbossWebAppInitializer constructor");
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("JbossWebAppInitializer.onStartup()");
		
        AnnotationConfigWebApplicationContext ctx = getContext();
        ctx.setServletContext(servletContext);
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        //servlet.addMapping("*.spring");
        servlet.addMapping("/*");
        servlet.setLoadOnStartup(1);
	}
	private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = null;
        try {
                context = new AnnotationConfigWebApplicationContext();
                //context.register(WebConfig.class);
                context.register(AppConfs.class);
        } catch (Exception e) {
     	   e.printStackTrace();
        }
     return context;
 }

}
