/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.blog.service.config;

import hu.schonherz.blog.data.config.BlogAppDataModuleConfig;
import hu.schonherz.blog.service.modelmapper.UserModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author pintyo
 */
@Configuration
@ComponentScan("hu.schonherz.blog.service")
@Import(BlogAppDataModuleConfig.class)
public class BlogAppServiceModuleConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new UserModelMapper());
        return modelMapper;
    }
}
