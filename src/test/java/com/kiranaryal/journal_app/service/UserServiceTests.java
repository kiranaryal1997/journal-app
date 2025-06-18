package com.kiranaryal.journal_app.service;


import com.kiranaryal.journal_app.entity.User;
import com.kiranaryal.journal_app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    //example of test
    @Test
    public void testAdd() {
        Assertions.assertEquals(15, 5 + 5 + 5);
    }

    @Test
    public void testFindByUsername() {
        Assertions.assertNotNull(userRepository.findByUsername("kiran"));
    }

    @Test
    public void testJournalEntriesOfUser() {
        User user = userRepository.findByUsername("kiran");
        Assertions.assertTrue(!user.getJournals().isEmpty());
    }

    //example of parameterized test
    @ParameterizedTest
    @CsvSource({"1,1,2", "2,10,12", "3,3,9"})
    public void test(int a, int b, int expected) {
        Assertions.assertEquals(expected, a + b);
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user) {
        Assertions.assertTrue(userService.saveNewUser(user), "failed for: " + user.getUsername());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "kiran",
            "asmit",
            "asmita",
            "adarsha"
    })
    public void testJournalEntriesOfUser(String name) {
        Assertions.assertNotNull(userRepository.findByUsername(name), "failed for: " + name);
    }
}
