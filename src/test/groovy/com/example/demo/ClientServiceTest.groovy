package com.example.demo

import com.example.demo.model.Client
import com.example.demo.repositories.ClientRepository

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification


@SpringBootTest
class ClientServiceTest extends Specification {

    def repo = Mock(ClientRepository)
    def ClientService = new ClientService(repo)

    Client dummyClient = Mock(Client)

    def "should add a new client to the repository"() {
        given:
        dummyClient.setName("test")

        when:
        ClientService.addClient(dummyClient)

        then:
        1 * repo.save(dummyClient)
    }

    def "should get a client by id"() {
        given:
        def fakeClient = Mock(Client)
        fakeClient.setName("nn")

        when:
        ClientService.addClient(fakeClient)

        then:
        ClientService.findByName() >> "nn"

    }
}
