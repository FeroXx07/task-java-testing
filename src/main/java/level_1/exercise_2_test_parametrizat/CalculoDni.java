package level_1.exercise_2_test_parametrizat;

public class CalculoDni {
    public static char calcLetter(String dniLetterless){
        if (dniLetterless == null || dniLetterless.isBlank()) {
            throw new IllegalArgumentException("Dni is null or blank!");
        }

        if (!validateFormatLetterless(dniLetterless)){
            throw new IllegalArgumentException("Dni is not valid!");
        }

        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int number = Integer.parseInt(dniLetterless.substring(0, 8));

        return letters.charAt(number % 23);
    }

    // regex: \\d (digits only) , {n} n times, [A-Z] (one time)
    static boolean validateFormatLetterless(String dniLetterless){
        return dniLetterless.matches("\\d{8}");
    }

    static boolean validateFormat(String dni){
        return dni.matches("\\d{8}[A-Z]");
    }
}
