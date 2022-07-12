package ngothanh.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configurable
@EnableWebMvc
@ComponentScan(basePackages = {"ngothanh.com.controller","ngothanh.com.api"})
public class WebMvcConfig implements WebMvcConfigurer{
	@Autowired
	  private ApplicationContext applicationContext;
	  @Bean
	  public SpringResourceTemplateResolver templateResolver() {
	    
	    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	    templateResolver.setApplicationContext(this.applicationContext);
	    templateResolver.setPrefix("/WEB-INF/templates/");
	    templateResolver.setSuffix(".html");
	    // HTML is the default value, added here for the sake of clarity.
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    templateResolver.setCacheable(true);
	    templateResolver.setCharacterEncoding("UTF-8");
	    return templateResolver;
	  }
	  @Bean
	  public SpringTemplateEngine templateEngine() {
	    // SpringTemplateEngine automatically applies SpringStandardDialect and
	    // enables Spring's own MessageSource message resolution mechanisms.
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver());
	    
	    templateEngine.setEnableSpringELCompiler(true);
	    return templateEngine;
	  }
	  
	   @Bean
	    public ViewResolver viewResolver(){
	        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	        viewResolver.setTemplateEngine(templateEngine());
	        viewResolver.setCharacterEncoding("UTF-8");
	        return viewResolver;
	    }
	   
	   @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	   
	       // Css resource.
	       registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
	       // Image resource.
	       registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/image/");
	       
	   }
}
