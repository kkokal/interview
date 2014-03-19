package com.kokal.three;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReverseTest {

    Reverser reverser = new Reverser();

    @Test
    public void testNull() throws Exception {
        assertNull(reverser.reverse(null));
    }

    @Test
    public void testReverse() throws Exception {

        assertEquals("tset", reverser.reverse("test"));
    }

    @Test
    public void testUnicodeReverse() throws Exception {
        assertEquals("üd reksüh", reverser.reverse("hüsker dü"));
    }
}
