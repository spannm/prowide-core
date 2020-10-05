package com.prowidesoftware.swift.utils;

import com.prowidesoftware.swift.model.SwiftMessage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @sinec 8.0.3
 */
public class MurMessageComparatorTest {

    @Test
    public void test() throws IOException {
        SwiftMessage systemMessage = SwiftMessage.parse("1:F01AAAAFRPPZXXX0000000006}{2:O0111702040914BBBBXXXXCXXX00000000001702040914S}{4:{175:0914}{106:170204BNPAFRPPZXXX0000000007}{108:MYREFERENCE12345}{175:0914}{107:170204MGTCBEBBXXXX0000000007}}{5:{CHK:ABCDEF123456}{SYS:}}");

        // no MUR
        SwiftMessage mt1 = SwiftMessage.parse("{1:F01GEBABEBBC36A7951305337}{2:I103YORKGB22XXXXN}{4:\n" +
                ":20:14045DOYVLVSCT29\n" +
                "-}");

        // no MUR
        SwiftMessage mt2 = SwiftMessage.parse("{1:F01GEBABEBBC36A7951305337}{2:I103YORKGB22XXXXN}{3:{119:STP}}{4:\n" +
                ":20:14045DOYVLVSCT29\n" +
                "-}");

        // different MUR
        SwiftMessage mt3 = SwiftMessage.parse("{1:F01GEBABEBBC36A7951305337}{2:I103YORKGB22XXXXN}{3:{108:YSYU39045360FXXX}{119:STP}}{4:\n" +
                ":20:14045DOYVLVSCT29\n" +
                "-}");

        // equal MUR
        SwiftMessage mt4 = SwiftMessage.parse("{1:F01GEBABEBBC36A7951305337}{2:I103YORKGB22XXXXN}{3:{108:MYREFERENCE12345}{119:STP}}{4:\n" +
                ":20:14045DOYVLVSCT29\n" +
                "-}");

        MurMessageComparator comp = new MurMessageComparator();
        assertFalse(0 == comp.compare(systemMessage, mt1));
        assertFalse(0 == comp.compare(systemMessage, mt2));
        assertFalse(0 == comp.compare(systemMessage, mt3));
        assertTrue(0 == comp.compare(systemMessage, mt4));
    }

}
