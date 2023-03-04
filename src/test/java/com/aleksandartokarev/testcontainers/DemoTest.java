package com.aleksandartokarev.testcontainers;

import com.aleksandartokarev.testcontainers.dao.UserRepository;
import com.aleksandartokarev.testcontainers.model.User;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// Based on @TestMethodOrder and @Order - we can determine whether
// to use method name or order annotation to be the order for running the tests
@SpringBootTest
public class DemoTest extends AbstractIntegrationTest {

    private static final Logger logger = LoggerFactory.getLogger(DemoTest.class);

    @Autowired
    private UserRepository userRepository;

    private static final Integer THREAD_POOL_SIZE = 10;

    @Test
    @Order(1)
    public void test3() throws InterruptedException {
        final List<User> usersBeforeInsert = userRepository.getUsers();
        logger.info("Total users size in database before insert: " + usersBeforeInsert.size());
        Assertions.assertEquals(usersBeforeInsert.size(), 4);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Callable<Void>> callables = new ArrayList<>();

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            int tempI = i;
            callables.add(() -> {
                User tempUser = new User();
                tempUser.setName("UserName" + tempI);
                logger.info("Getting ready to create user: " + tempUser);
                final Long id = userRepository.createUser(tempUser);
                logger.info("Created user with id: " + id);
                return null;
            });
        }
        executorService.invokeAll(callables);
        executorService.shutdown();

        final List<User> usersAfterInsert = userRepository.getUsers();
        logger.info("Total users size in database: " + usersAfterInsert.size());
        Assertions.assertEquals(usersAfterInsert.size(), 14);
    }


    @Test
    @Order(2)
    public void test2() throws InterruptedException {
        final User user1 = userRepository.getUser(15L);
        Assertions.assertNull(user1);
        User tempUser = new User();
        tempUser.setName("Alex");
        Long id = userRepository.createUser(tempUser);
        final User user2 = userRepository.getUser(id);
        Assertions.assertNotNull(user2);
        userRepository.deleteUser(id);
        final User user3 = userRepository.getUser(id);
        Assertions.assertNull(user3);
    }
}
