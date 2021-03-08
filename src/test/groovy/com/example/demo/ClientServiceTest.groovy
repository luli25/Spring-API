package com.example.demo

import com.example.demo.model.Client
import com.example.demo.repositories.ClientRepository
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Shared
import spock.lang.Specification


@SpringBootTest
class ClientServiceTest extends Specification {

    ClientRepository repo = Mock(ClientRepository)

    @Shared
    Client dummyClient = Mock(Client)

    def "should add a new client to the repository"() {
        given:
        dummyClient.setName("test")

        when:
        repo.save(dummyClient)

        then:
        1 * repo.save(dummyClient)
    }

    def "should get a client by id"() {
        given:
        def fakeClient = Mock(Client)
        fakeClient.setName("nn")

        when:
        repo.save(fakeClient)

        then:
        repo.findById() >> "nn"

    }
}
