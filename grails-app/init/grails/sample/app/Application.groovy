package grails.sample.app

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan
class Application extends GrailsAutoConfiguration {
  static void main(String[] args) {
    GrailsApp.run(Application, args)
  }
}
