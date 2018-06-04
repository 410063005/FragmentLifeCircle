package com.example.cm.demo_arch;

import org.junit.Test;

/**
 * Created by kingcmchen on 2018/5/30.
 */

public class ExtensionDemoTest {

    @Test
    public void test() {
        ExtensionDemoKt.cm(1);
        ExtensionDemoKt.toInt("123");
    }
}
