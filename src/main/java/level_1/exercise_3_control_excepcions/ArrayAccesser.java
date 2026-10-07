package level_1.exercise_3_control_excepcions;

import java.util.ArrayList;
import java.util.List;

public class ArrayAccesser {
    private final int size = 3;
    private final int[] array = new int[size];
    public void accessOutOfBonds(){
        int invalid = array[array.length];
    }
}
