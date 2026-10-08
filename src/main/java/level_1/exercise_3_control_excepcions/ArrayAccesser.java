package level_1.exercise_3_control_excepcions;

import java.util.ArrayList;
import java.util.List;

public class ArrayAccesser {
    private final int num = 3;
    private final int[] numbers = new int[num];
    public void accessOutOfBonds(){
        int invalid = numbers[numbers.length];
    }
}
