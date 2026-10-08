package level_1.exercise_2_test_parametrizat;

public class CalculoDni {
    private final static String LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static char calculateLetter(String dniLetterless){
        if (dniLetterless == null || dniLetterless.isBlank()) {
            throw new IllegalArgumentException("Dni is null or blank!");
        }

        if (!validateFormatLetterless(dniLetterless)){
            throw new IllegalArgumentException("Dni is not valid!");
        }

        int number = Integer.parseInt(dniLetterless);
        return LETTERS.charAt(number % 23);
    }

    // regex: \\d (digits only) , {n} n times, [A-Z] (one time)
    static boolean validateFormatLetterless(String dniLetterless){
        return dniLetterless.matches("\\d{8}");
    }

    static boolean validateFormat(String dni){
        return dni.matches("\\d{8}[A-Z]");
    }
}
