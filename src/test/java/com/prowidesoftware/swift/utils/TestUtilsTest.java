package com.prowidesoftware.swift.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @since 8.0.2
 */
public class TestUtilsTest {

    @Test
    public void testPatchXpath() {
        assertEquals("/*[local-name()='Foo']", TestUtils.patch("/Foo"));
        assertEquals("/*[local-name()='Foo']/*[local-name()='Bar']", TestUtils.patch("/Foo/Bar"));
        assertEquals("/*[local-name()='Foo']/*[local-name()='Bar'][4]", TestUtils.patch("/Foo/Bar[4]"));
    }

}
