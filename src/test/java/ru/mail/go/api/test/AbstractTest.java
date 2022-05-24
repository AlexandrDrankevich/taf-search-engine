package ru.mail.go.api.test;

import org.junit.jupiter.api.BeforeEach;
import ru.mail.go.api.connection.BaseConnection;

public class AbstractTest {
    BaseConnection connection;
    @BeforeEach
    public void getConnection(){
        connection=new BaseConnection();
    }
}
