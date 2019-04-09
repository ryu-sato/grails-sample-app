package grails.sample.app

import grails.sample.app.spring.web.PrefixedViewResolver

import groovy.util.logging.Commons
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Profile
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver

@Configuration
@Commons
class MngWebMvcConfigurer extends WebMvcConfigurerAdapter {

  /**
   * PrefixedViewResolver Bean Factory
   * @return
   */
  @Bean
  InternalResourceViewResolver prefixedViewResolver() {
    log.info("initialize PrefixedViewResolver")

    PrefixedViewResolver viewResolver = new PrefixedViewResolver("zk:")
    viewResolver.setSuffix(".zhtml")
    viewResolver.setOrder(1)
    return viewResolver
  }

  @Override
  void addViewControllers(ViewControllerRegistry registry) {
    log.info("add ViewController for '/zkfw/**'")

    registry.addViewController("/zkfw/**").setViewName("zk:index");
  }
}
