package recoveryplus.mobi.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 应用启动测试
 *
 * @author LiuDecai
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RunApplicationTest {

    @Test(timeout = 60000)
    public void loadContext() {
        RunApplication.main(new String[]{});
    }

}
