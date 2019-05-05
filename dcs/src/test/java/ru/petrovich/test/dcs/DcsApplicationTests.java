package ru.petrovich.test.dcs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.petrovich.test.dcs.model.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DcsApplicationTests {

    @Before
    public void setUp() {
        Task task_one = new Task();
    }

    @Test
    public void contextLoads() {
    }

}
