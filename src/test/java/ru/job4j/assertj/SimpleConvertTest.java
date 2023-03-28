package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("four")
                .containsSequence("first", "second")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("ten");

    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set set = simpleConvert.toSet("one", "two", "three", "five", "six", "ten");
        assertThat(set).hasSize(6)
                .containsAnyOf("one", "eleven", "sixty")
                .containsExactlyInAnyOrder("one", "two", "three", "five", "six", "ten")
                .containsExactly("six", "one", "ten", "two", "three", "five")
                .endsWith("five");

    }
    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map map = simpleConvert.toMap( "1", "2", "3", "4", "5", "6", "7");
        assertThat(map).hasSize(7)
                .containsKey("4")
                .doesNotContainKey("8")
                .containsValue(6)
                .doesNotContainValue(7)
                .containsEntry("2", 1);
    }
}