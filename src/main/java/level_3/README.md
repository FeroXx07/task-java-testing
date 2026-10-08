# Desenvolupament Guiat per Proves

##  Enunciat de l'exercici
En aquest exercici treballarem amb Test-Driven Development (TDD) per construir pas a pas una calculadora amb estat intern.

Aquest enfocament ens ajudarà a entendre com el fet d’escriure una prova a la vegada ens permet modelar millor les classes i assegurar la seva correcta funcionalitat.
Objectiu

Aprendre a aplicar el cicle Red → Green → Refactor per dissenyar una classe de forma iterativa, començant per les necessitats expressades en cada test.
Exercici 1: Calculadora

Implementarem una classe anomenada Calculator que gestiona un total acumulat, inicialment 0, i que ofereix operacions com sumar, restar, multiplicar, dividir i reiniciar.

🔴 Pas 1 (RED):Crea una classe de proves anomenada CalculatorTest. Comença per escriure un únic test molt simple (per exemple: "el total inicial és zero"):

````java
@Test
void calculatorStartsWithTotalZero() {
Calculator calculator = new Calculator();
assertThat(calculator.getTotal()).isEqualTo(0);
}
````
🟢 Pas 2 (GREEN): Fes passar els tests: Implementant només el mínim necessari a la classe Calculator.

♻️ Pas 3 (REFACTOR): Refactoritza si cal.

A mesura que vagis implementant la classe, cobreix els següents comportaments amb tests:

    El total inicial és 0.
    El mètode add(x) incrementa el total.
    El mètode subtract(x) el disminueix.
    El mètode multiply(x) multiplica el total pel valor passat.
    El mètode divide(x) actualitza correctament el total dividint pel valor.
    Dividir per zero ha de generar una excepció (ArithmeticException).
    El mètode reset() ha de tornar el total a 0.
    El mètode getTotal() ha de retornar el valor actual del total.


## 🛠 Tecnologies
- Backend: Java

##  Instal·lació i Execució
1. Clonar el repositori: `git clone ...`
2. Execució de l'aplicació.
3. Proves: Executar el `Main()`.

