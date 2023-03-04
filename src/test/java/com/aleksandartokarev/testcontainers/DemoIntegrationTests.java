//package com.aleksandartokarev.testcontainers;
//
//import com.aleksandartokarev.testcontainers.dao.UserRepository;
//import com.aleksandartokarev.testcontainers.model.User;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class DemoIntegrationTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private static final Integer THREAD_POOL_SIZE = 10;
//
//    @Test
//    public void givenUsersInDB_WhenUpdateStatusForNameModifyingQueryAnnotationNative_ThenModifyMatchingUsers() throws InterruptedException {
//        final List<User> users2 = userRepository.getUsers();
//        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
//        List<Callable<Void>> callables = new ArrayList<>();
//
//        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
//            int tempI = i;
//            callables.add(() -> {
//                User tempUser = new User();
//                tempUser.setName("UserName" + tempI);
//                System.out.println(tempUser);
//                userRepository.createUser(tempUser);
//                return null;
//            });
//        }
//        executorService.invokeAll(callables);
//        executorService.shutdown();
//
//        Thread.sleep(5000);
//        final List<User> users = userRepository.getUsers();
//        System.out.println(users.size());
//        Assertions.assertEquals(users.size(), 10);
//    }
//}
