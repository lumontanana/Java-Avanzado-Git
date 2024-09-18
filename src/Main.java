
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Ejercicio 1
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Ejecutando en clase anonima");
            }
        };
        run1.run();

        //Ejercicio 2
        Operacion op = (a,b) -> a+b;

        System.out.println(op.calcular(2,3));

        //Otra forma, method reference
        Operacion add1 = Integer::sum;


        Persona persona = new Persona();
       //persona.getNombre().startsWith("A");

        Optional<Persona> personaOpt = Optional.of(persona);
        exercises();
        //personaOpt.ifPresent((p)-> System.out.println(p.gey));
    }

    /**
     * This is the definition of the Main class containing the main method. The main method is the entry point of the Java application.
     * Ejercicio 1: Anonymous Class Implementation of Runnable
     * This is the definition of the Main class containing the main method. The main method is the entry point of the Java application.
     *
     * Ejercicio 2: Lambda Expression and Functional Interface
     * Lambda Expression: Operacion is a functional interface with a single abstract method calcular. The expression (a, b) -> a + b
     * is a lambda expression that provides an implementation of the calcular method, which adds two integers.
     * Calling the Method: op.calcular(2, 3) calls the calcular method with 2 and 3 as arguments, resulting in 5, which is then printed.
     *
     * Otra forma, Method Reference
     * Lambda Expression: Operacion is a functional interface with a single abstract method calcular. The expression (a, b) -> a + b is
     * a lambda expression that provides an implementation of the calcular method, which adds two integers.
     *
     * Calling the Method: op.calcular(2, 3) calls the calcular method with 2 and 3 as arguments, resulting in 5, which is then printed.
     *
     * Functional Interface: The @FunctionalInterface annotation indicates that the interface is intended to be a functional interface,
     * which means it has exactly one abstract method (calcular).
     */


    public static void exercises() {
        //Ejercicio 3
        List<String> lista = Arrays.asList("hola", "adios", "kala", "esi?");
        lista.stream().forEach(System.out::println);

        //Ejercicio 4: Dada una lista de enteros, utilizar streams para filtrar los numeros pares y mostrarlos en la pantalla
        List<Integer> lista2 = Arrays.asList(2,3,4,5,6,7);
        lista2.stream().filter(i -> i%2 == 0).forEach(System.out::println);

        //Ejercicio 5: dado un optional comprobar si esta presente y si lo esta, imprimir su valor
        Optional<String> optional = Optional.of("hola");
        optional.ifPresent(System.out::println);

        //Ejercicio general
        List<Empleado> empleados = Arrays.asList(new Empleado("lucas", 20, 2000),
                                                new Empleado("pepe", 58, 200),
                new Empleado("paco", 45, 50000) ) ;
        ToDoubleFunction<Empleado> salario = empleado -> empleado.salario();

        //filtrar una lista
        System.out.println("Filtrar una lista > 50000");
        empleados.stream()
                .filter(empleado -> empleado.salario()>50000)
                .sorted(Comparator.comparingInt(Empleado::salario).reversed())
                .collect(Collectors.toList());
        //ordenarlos
        System.out.println("Ordenación descendiente de salario");
        empleados.stream().sorted(Comparator.comparingInt(Empleado::salario)).forEach(System.out::println);
        //buscar
        System.out.println("Buscar empleado con nombre 'pepe'");
        Optional<Empleado> optional2 = empleados.stream().filter(empleado -> empleado.nombre().equals("pepe")).findFirst();
        optional2.ifPresent(System.out::println);

    }


}