package com.example.demo.controller

import com.example.demo.ClientService
import com.example.demo.model.Client
import com.example.demo.model.dto.ClientDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.relational.core.sql.SQL
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [ClientController.class])
@SpringBootTest
class ClientControllerTest extends Specification {

    @Autowired
    private MockMvc mvc

    @Autowired
    private ClientService service = Stub(ClientService)

    @Autowired
    private ClientController controller = Mock(ClientController)


    def "setup"() {
        mvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

    def "should add a new client to the database"() {
        given:
        Client newClient = new Client()
        newClient.setName("test")

        and:
        service.addClient(newClient)

        expect:
        mvc.perform(post("/Client").contentType("application/json")
                .param("name", "test"))
                .andDo(print())
                .andExpect(status().isOk())

    }

}
