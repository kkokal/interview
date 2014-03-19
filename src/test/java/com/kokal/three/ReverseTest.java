package com.kokal.three;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReverseTest {

    @Test
    public void testNull() throws Exception {
        assertNull(Reverser.reverse(null));
    }

    @Test
    public void testReverse() throws Exception {

        assertEquals("tset", Reverser.reverse("test"));
    }

    @Test
    public void testUnicodeReverse() throws Exception {
        assertEquals("üd reksüh", Reverser.reverse("hüsker dü"));
    }
}
