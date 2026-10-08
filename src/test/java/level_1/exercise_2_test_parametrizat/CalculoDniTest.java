package level_1.exercise_2_test_parametrizat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculoDniTest {
    @ParameterizedTest
    @CsvSource({
            "12345678, Z",
            "00000001, R",
            "00000002, W",
            "00000003, A",
            "00000004, G",
            "00000005, M",
            "00000006, Y",
            "00000007, F",
            "00000008, P",
            "00000009, D"
    })
    void calcLetter_validDni_returnsCorrectLetter(String dni, char expected) {
        assertEquals(expected, CalculoDni.calculateLetter(dni));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {
            "",
            " ",
            "1234567",
            "123456789",
            "1234567A",
            "-1234567",
            "ABCDEFGH"
    })
    void calcLetter_invalidDni_throwsException(String dni) {
        assertThrows(
                IllegalArgumentException.class,
                () -> CalculoDni.calculateLetter(dni)
        );
    }
}