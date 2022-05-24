package ru.mail.go.api.test;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoMailTest extends AbstractTest {
    @Test
    public void testGetSearch() {
        String url="https://go.mail.ru/search?q=Минск";
        String title="Минск — Википедия";
        String responseUrl="ru.wikipedia.org›wiki/Минск";
        connection.sendGet(url);
        assertEquals(200,connection.getStatusCode());
        assertTrue(connection.isResponseContainInformation(title));
        assertTrue(connection.isResponseContainInformation(responseUrl));

    }
}
