package com.jay.apollo.smoke;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import com.jay.apollo.common.FunctionalTestBase;
import com.jay.apollo.common.SpringBootTestShared;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTestShared
class ApplicationStartupTest extends FunctionalTestBase {

    private final ApplicationContext appContext;

    ApplicationStartupTest(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @Test
    void contextLoads() {
        assertNotNull(appContext);
    }
}
