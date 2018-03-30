package ar.com.imango.examen;

import ar.com.imango.examen.model.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = ExamenApplication.class
)
@AutoConfigureMockMvc
@Transactional
public class ExamenApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetUsers() throws Exception {
		this.mockMvc.perform(get("/user/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void testUpdateUser() throws Exception {
		Users user = new Users("moni@app.com.ar", "Monica", "Argento");
		this.mockMvc.perform(post("/user/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user)))
				.andExpect(status().isCreated());
	}


	@Test
	public void testDeleteUser() throws Exception {
		this.mockMvc.perform(delete("/user/1")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
	}



}
