package application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import config.web.ResourceConfiguration;
import config.web.WebConfiguration;

public class Application implements WebApplicationInitializer {

	public void onStartup(ServletContext context) throws ServletException {
		System.out.println("Web application initializer started!");
		System.out.println("Context path: " + context.getContextPath());
		
				AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
				springContext.register(WebConfiguration.class);
				springContext.register(ResourceConfiguration.class);
				springContext.setServletContext(context);
				springContext.refresh();//
				
		        ServletRegistration.Dynamic servlet = context.addServlet("dispatcher", new DispatcherServlet(springContext));
		        servlet.setLoadOnStartup(1);
		        servlet.addMapping("/");	
		        
	}

}
