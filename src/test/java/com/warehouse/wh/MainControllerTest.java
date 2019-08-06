package com.warehouse.wh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private MainController mainController;

    @Test
    public void getHello() throws Exception {
        String response = mainController.index();
        assertEquals("hello controller!", response);
    }

    @Transactional
    @Test
    public void getAllItems() throws Exception {
        String response = mainController.stockItems();
        assertTrue(response.length() > 0);
    }

    @Transactional
    @Test
    public void newStockItemAdded() throws Exception {
        String response1 = mainController.stockItems();
        mainController.newStockItem();
        String response2 = mainController.stockItems();
        assertTrue(response2.length() > response1.length());
    }

}