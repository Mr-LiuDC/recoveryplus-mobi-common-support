package recoveryplus.mobi.eureka;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 应用启动类
 *
 * @author LiuDecai
 */
@EnableAdminServer
@EnableEurekaServer
@SpringBootApplication
public class AdminEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminEurekaApplication.class, args);
    }

}

