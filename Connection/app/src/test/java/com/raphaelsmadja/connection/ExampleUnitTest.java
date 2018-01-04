package com.raphaelsmadja.connection;

import org.junit.Test;

import java.util.regex.Pattern;

import static com.raphaelsmadja.connection.MainActivity.EMAIL_ADDRESS_PATTERN;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void isValidEmail() {
        String email = "k@gmail.fr";
        Boolean test = EMAIL_ADDRESS_PATTERN.matcher(email).matches();
        assertTrue(test);
    }
}