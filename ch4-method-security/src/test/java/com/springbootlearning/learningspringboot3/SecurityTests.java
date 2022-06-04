package com.springbootlearning.learningspringboot3;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class SecurityTests {

  @Autowired MockMvc mvc;

  @Test
  @WithMockUser(username = "admin", roles = "ADMIN")
  void testSuccess() throws Exception {
    mvc.perform(get("/admin")).andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "nobody", roles = "NOTHING")
  void testFailure() throws Exception {
    mvc.perform(get("/admin")).andExpect(status().isForbidden());
  }

}
