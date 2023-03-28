package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotBlank();
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .isNotNull();
    }

    @Test
    void isExist() {
        Box box = new Box(0, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue()
                .isNotNull();
    }

    @Test
    void notExist() {
        Box box = new Box(0, -1);
        boolean result = box.isExist();
        assertThat(result).isFalse()
                .isNotNull();
    }

    @Test
    void numberOfVertices() {
        Box box = new Box(8, 12);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(8)
                .isNotNull();
    }

    @Test
    void wrongNumberOfVertices() {
        Box box = new Box(10, 12);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotEqualTo(10)
                .isNotNull();
    }

    @Test
    void cubeArea() {
        Box box = new Box(10, 12);
        double result = box.getArea();
        assertThat(result).isCloseTo(0.0, withPrecision(0.001))
                .isCloseTo(0.0, Percentage.withPercentage(1.0d))
                .isLessThan(0.1d)
                .isGreaterThan(-0.1d);
    }

    @Test
    void tetrahedronArea() {
        Box box = new Box(4, 0);
        double result = box.getArea();
        assertThat(result).isEqualTo(0.0, withPrecision(0.1))
                .isLessThan(0.3d)
                .isGreaterThan(-0.1d);

    }
}