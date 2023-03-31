package com.bank.moneytransfer;

import com.bank.moneytransfer.entity.TransferAmount;
import com.bank.moneytransfer.entity.TransferRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DockerTests {

    @Autowired
    private TestRestTemplate template = new TestRestTemplate();

    @Container
    private GenericContainer<?> appTest = new GenericContainer<>("transfer:1.0")
            .withExposedPorts(5500);

    @Test
    public void transferDockerTest() {

        final TransferRequest request = this.createTransferRequest();
        final int transferAppPort = appTest.getMappedPort(5500);

        final ResponseEntity<String> entity = this.template.postForEntity(
                "http://localhost:" + transferAppPort + "/transfer",
                request,
                String.class
        );

        System.out.println("response:  " + entity.getBody());

        Assertions.assertEquals("{\"operationId\":\"1\"}", entity.getBody());
        Assertions.assertEquals(HttpStatusCode.valueOf(200), entity.getStatusCode());
    }

    private TransferRequest createTransferRequest() {
        final TransferRequest transfer = new TransferRequest();
        final TransferAmount amount = new TransferAmount();

        amount.setValue(1);
        amount.setCurrency("RUS");

        transfer.setAmount(amount);
        transfer.setCardFromNumber("2585541741745566");
        transfer.setCardFromValidTill("12/27");
        transfer.setCardFromCVV("850");
        transfer.setCardToNumber("3754567210826497");


        return transfer;
    }

}
