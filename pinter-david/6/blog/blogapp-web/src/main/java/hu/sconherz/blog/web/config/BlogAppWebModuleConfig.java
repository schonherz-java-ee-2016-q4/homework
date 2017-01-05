/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.sconherz.blog.web.config;

import hu.schonherz.blog.service.config.BlogAppServiceModuleConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("hu.schonherz.blog.web")
@Import(BlogAppServiceModuleConfig.class)
public class BlogAppWebModuleConfig {
    
//    @Bean
//    public ViewResolver createViewResolver() {
//        return new InternalResourceViewResolver("/", ".jsp");
//    }
}
