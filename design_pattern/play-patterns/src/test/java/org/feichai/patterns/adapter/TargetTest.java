package org.feichai.patterns.adapter;

import static org.junit.jupiter.api.Assertions.*;

class TargetTest {

    @org.junit.jupiter.api.Test
    void request() {
        Target target = new Adapter();
        target.request();
    }
}