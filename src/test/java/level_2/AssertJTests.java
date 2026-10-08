package level_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertJTests {
    @ParameterizedTest
    @CsvSource({
            "Toyota, Red, 4, 150, Toyota, Red, 4, 150, BMW, Black, 4, 200",
    })
    void twoObjects_haveSame_value(
            String model1, String color1, int tyres1, int hp1,
            String model2, String color2, int tyres2, int hp2,
            String model3, String color3, int tyres3, int hp3) {

        Vehicle vehicle1 = new Vehicle(model1, color1, tyres1, hp1);
        Vehicle vehicle2 = new Vehicle(model2, color2, tyres2, hp2);
        Vehicle vehicle3 = new Vehicle(model3, color3, tyres3, hp3);

        assertThat(vehicle1).isEqualTo(vehicle2);
        assertThat(vehicle1).isNotEqualTo(vehicle3);
    }

    @ParameterizedTest
    @CsvSource({
            "Toyota, Red, 4, 150"
    })
    void twoObjects_haveSame_reference(
            String model1, String color1, int tyres1, int hp1) {

        Vehicle vehicle1 = new Vehicle(model1, color1, tyres1, hp1);
        Vehicle vehicle2 = vehicle1;
        Vehicle vehicle3 = new Vehicle(model1, color1, tyres1, hp1);

        assertThat(vehicle1).isSameAs(vehicle2);
        assertThat(vehicle1).isNotSameAs(vehicle3);
    }

    @Test
    void twoArrays_areIdentical() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};

        assertThat(array).isEqualTo(array2);
        assertThat(array).isNotEqualTo(array3);
    }

    @ParameterizedTest
    @CsvSource({
            "Toyota, Red, 4, 150, Ferrari, Red, 4, 350, BMW, Black, 4, 200",
    })
    void twoArrayList_haveSameValue_SameOrder(
            String model1, String color1, int tyres1, int hp1,
            String model2, String color2, int tyres2, int hp2,
            String model3, String color3, int tyres3, int hp3) {

        Vehicle vehicle1 = new Vehicle(model1, color1, tyres1, hp1);
        Vehicle vehicle2 = new Vehicle(model2, color2, tyres2, hp2);
        Vehicle vehicle3 = new Vehicle(model3, color3, tyres3, hp3);

        ArrayList<Vehicle> arrayListA = new ArrayList<Vehicle>(List.of(vehicle1, vehicle2, vehicle3));
        ArrayList<Vehicle> arrayListB = new ArrayList<Vehicle>(arrayListA);
        ArrayList<Vehicle> arrayListC = new ArrayList<Vehicle>(List.of(vehicle2, vehicle3, vehicle1));
        ArrayList<Vehicle> arrayListD = new ArrayList<Vehicle>(List.of(vehicle2, vehicle3));

        assertThat(arrayListA).containsExactlyElementsOf(arrayListB);
        assertThat(arrayListA).containsExactlyInAnyOrderElementsOf(arrayListC);
        assertThat(arrayListA).containsOnlyOnce(vehicle1);
        assertThat(arrayListD).doesNotContain(vehicle1);
    }

    @Test
    void mapAddition_verification(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Toyota", 1);
        map.put("Ferrari", 2);
        map.put("BMW", 3);

        assertThat(map).containsKey("Ferrari");
    }

    @Test
    void outOfBounds_verification() {
        int[] numbers = {1, 2, 3};

        assertThatThrownBy(() -> {
            int value = numbers[numbers.length];
        }).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void optional_is_empty_verification() {
        Optional<Vehicle> vehicleOptional = Optional.empty();
        assertThat(vehicleOptional).isEmpty();
    }
}
