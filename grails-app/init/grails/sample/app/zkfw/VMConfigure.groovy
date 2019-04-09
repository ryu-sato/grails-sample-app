package grails.sample.app

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 * Manager で利用する VM の Bean を初期化する
 */
@Configuration
@ComponentScan
class VMConfigurer {
}
