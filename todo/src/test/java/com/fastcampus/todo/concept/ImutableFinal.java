package com.fastcampus.todo.concept;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class ImutableFinal {

    @Test // final -> 재할당 방지
    void test() {
        final List<String> list = Lists.newArrayList("martin");
//        List<String> list = Lists.newArrayList("martin");
//        list = Lists.newArrayList("steve");

        System.out.println(list);
    }

    @Test // Immutable -> 값에 대한 변조를 막음
    void test1() {
        Map.Entry<String, String> entry
                = new AbstractMap.SimpleImmutableEntry<>("name", "martin");

        entry = new AbstractMap.SimpleEntry<>("aaa", "bbb");
        entry.setValue("martin");
        System.out.println(entry);
    }
}
