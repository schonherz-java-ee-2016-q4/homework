package hu.schonherz.blog.web.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@Import({SecurityConfig.class})
public class SpringWebMVCConfiguration extends WebMvcConfigurerAdapter {
    private final Logger LOGGER = LoggerFactory.getLogger(SpringWebMVCConfiguration.class);

    @Override
    public void configureViewResolvers(final ViewResolverRegistry registry) {
        registry.viewResolver(new InternalResourceViewResolver("/", ".jsp"));
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
}
