package level_1.exercise_3_control_excepcions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAccesserTest {
    private ArrayAccesser arrayAccesser;

    @BeforeEach
    void setUp() {
        arrayAccesser = new ArrayAccesser();
    }

    @AfterEach
    void tearDown() {
        arrayAccesser = null;
    }

    @Test
    void accessOutOfBonds() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> arrayAccesser.accessOutOfBonds());
    }
}