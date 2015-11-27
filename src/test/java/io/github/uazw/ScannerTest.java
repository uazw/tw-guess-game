package io.github.uazw;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ScannerTest {

    @Test
    public void should_return_the_input_when_receive_bebe() {
        InputStream input = new ByteArrayInputStream("1234\n".getBytes());
        Scanner scanner = new Scanner(input);

        String result = "";
        while (scanner.hasNextLine()) {
            result = scanner.nextLine();
        }

        assertEquals(result, "1234");
    }
}
