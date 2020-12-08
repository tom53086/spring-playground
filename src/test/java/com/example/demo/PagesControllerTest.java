package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        //RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");
        //this.mvc.perform(request)
        this.mvc.perform(get("/math/pi"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void testSum() throws Exception {
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("15"));
    }

    @Test
    public void testCalculateNoOperation() throws Exception{
        this.mvc.perform(get("/math/calculate2?x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    public void testCalculateMultiply() throws Exception{
        this.mvc.perform(get("/math/calculate2?operation=multiply&x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("24"));
    }

    @Test
    public void testCalculateDivide() throws Exception{
        this.mvc.perform(get("/math/calculate2?operation=divide&x=8&y=4"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    public void testCalculateAdd() throws Exception{
        this.mvc.perform(get("/math/calculate2?operation=add&x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    public void testCalculateSubtract() throws Exception{
        this.mvc.perform(get("/math/calculate2?operation=subtract&x=6&y=4"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }
    @Test
    public void testPostRec() throws Exception {
        this.mvc.perform(post("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }
    @Test
    public void testPatchRec() throws Exception {
        this.mvc.perform(patch("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }
    @Test
    public void testGetRec() throws Exception {
        this.mvc.perform(get("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
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
