package com.mtrojahn.boot
 
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zkoss.zk.au.http.DHtmlUpdateServlet
import org.zkoss.zk.ui.http.DHtmlLayoutServlet
 
// see: https://www.marcelustrojahn.com/2015/12/integrating-zk-framework-on-a-spring-boot-application/
@Configuration
class ZKConfiguration {
  @Bean
  ServletRegistrationBean dHtmlLayoutServlet() {
    def params = [ 'update-uri': '/zkau' ]
    def dHtmlLayoutServlet = new DHtmlLayoutServlet()
    def reg = new ServletRegistrationBean(dHtmlLayoutServlet, "*.zul")
    reg.setLoadOnStartup(1)
    reg.setInitParameters(params)
    reg
  }

  @Bean
  ServletRegistrationBean dHtmlUpdateServlet() {
    def params = [ 'update-uri': '/zkau/*' ]
    def reg = new ServletRegistrationBean(new DHtmlUpdateServlet(), "/zkau/*")
    reg.setLoadOnStartup(2)
    reg.setInitParameters(params)
    reg
  }
}
