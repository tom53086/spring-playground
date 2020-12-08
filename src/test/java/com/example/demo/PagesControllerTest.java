package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(PagesController.class)

public class PagesControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testingPages() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    public void testingPi() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

//    @Test
//    public void testIndexEndpoint() throws Exception {
//        this.mvc.perform(get("/").accept(MediaType.TEXT_PLAIN))
//                .andExpect(status().isOk())
//                .andExpect(content().string("GET to index route"));
//    }
//
//    @Test
//    public void testPostMessageEndpoint() throws Exception {
//        this.mvc.perform(post("/messages"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("POST to messages route"));
//    }

}
