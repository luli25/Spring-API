package com.example.demo

import com.example.demo.model.Client
import com.example.demo.repositories.ClientRepository
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class ClientServiceTest extends Specification {

    def repo = Mock(ClientRepository)
    def ClientService = new ClientService(repo)

    def "method getAllClients should return a list of clients"() {
        given:
        repo.findAll() >> List.of(new Client("test"))

        when:
        def clients = ClientService.getAllClients()

        then:
        !clients.isEmpty()
        clients.get(0).name == "test"
    }

    def "method findByName should return a client when a name is provided"() {
        given:
        def newClient = Mock(Client)
        newClient.setName("test")

        when:
        ClientService.addClient(newClient)

        then:
        ClientService.findByName() >> "test"
    }

    def "method addClient should add a new client to the database"() {
        given:
        def newClient = Mock(Client)

        when:
        ClientService.addClient(newClient)

        then:
        1 * repo.save(newClient)
    }

}
