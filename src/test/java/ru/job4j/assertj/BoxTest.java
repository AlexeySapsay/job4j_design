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
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisThenTetrahedron() {
        Box box = new Box(4, 10);
        String result = box.whatsThis();
        assertThat(result).isNotNull()
                .isEqualTo("Tetrahedron");
    }

    @Test
    void isGetAgeThenThen173() {
        Box box = new Box(4, 10);
        double result = box.getArea();
        assertThat(result).isNotZero()
                .isPositive()
                .isGreaterThan(173)
                .isLessThan(174)
                .isEqualTo(173.20508075688772);
    }

    @Test
    void isGetAgeThenThenReturn173() {
        Box box = new Box(4, 10);
        double result = box.getArea();
        assertThat(result).isEqualTo(173.0d, withPrecision(0.5d))
                .isCloseTo(173.0d, withPrecision(0.5d))
                .isCloseTo(173.0d, Percentage.withPercentage(1.0d))
                .isGreaterThan(173.0d)
                .isLessThan(175.0d);
    }

    @Test
    void isGetNumberOfVerticesThenInt() {
        Box box = new Box(4, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotZero();
    }

    @Test
    void isExistThenReturnTrue() {
        Box box = new Box(4, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void isNotExistThenReturnFalse() {
        Box box = new Box(0, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }
}