package com.mansour.testcontainers.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Testcontainers
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@SpringBootTest(/*webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT*/)
class PostControllerTest {
    private static final String API = "/api/v1/posts";
    private static final DockerImageName postgres = DockerImageName.parse("postgis/postgis:14-3.2").asCompatibleSubstituteFor("postgres");

    @Container
    @ServiceConnection
    private static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(postgres);

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnAllPosts() throws Exception {
        mockMvc
                .perform(get(API))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("My First Post Title")));

    }

    @Test
    void shouldReturnPostById() throws Exception {
        mockMvc
                .perform(get(API + "/{id}", 2))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Another Interesting Post")));
    }

    @Test
    @Rollback
    void createPost() throws Exception {
        Post post = new Post(100L, "New Post", "Bla bla bla", "Author");
        mockMvc
                .perform(post(API)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(post))
                ).andExpect(status().isCreated());
    }

    @Test
    @Rollback
    void deletePost() throws Exception {
        mockMvc
                .perform(delete(API+"/{id}", 1))
                .andExpect(status().isNoContent());

    }

    @Test
    void updatePost() {
    }
}