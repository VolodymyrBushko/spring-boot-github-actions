package com.example.githubactions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.githubactions.controller.HelloController;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = HelloController.class)
class SpringBootGithubActionsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldContextLoads() {
        assertThat(mockMvc).isNotNull();
    }

    @Test
    @SneakyThrows
    void shouldReturnHelloWhenPerformGetMethodRequestOnHelloEndpoint() {
        mockMvc.perform(get("/hello"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Hello")));
    }
}
