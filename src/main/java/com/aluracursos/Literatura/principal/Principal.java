package com.aluracursos.Literatura.principal;

import com.aluracursos.Literatura.model.*;
import com.aluracursos.Literatura.repositorio.LibroRepository;
import com.aluracursos.Literatura.service.ConcumirAPI;
import com.aluracursos.Literatura.service.ConvertirDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConcumirAPI concumirAPI = new ConcumirAPI();
    private ConvertirDatos convertirDatos = new ConvertirDatos();
    private final String URL = "https://gutendex.com//books/";
    private LibroRepository libroRepository;
    private List<LibrosC> librosCRegistrados;
    private List<AutorC> auoresRegistrados;
    public Principal(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void menu(){

        var opcion = -1;
        String menu = """
                .......................................
                                  MEMU
                ........................................
                1. Buscar Libro por Titulo.
                2. Buscar Libro por Autor
                3. Libros registrados
                4. Autores registrados
                5. Autores vivos en determinado anio
                6. Libros por idioma
                7. Estadisticas
                8. Top 5 de Libros mas descargados
                0. Salir
                .......................................
                Seleccione una opcion:
                """;

        while (opcion != 0){
            System.out.println(menu);
            String input = scanner.nextLine();
            try {
                opcion = Integer.parseInt(input);
                switch (opcion) {
                    case 0:
                        System.out.println("saliendo...");
                        break;
                    case 1:
                        buscarLibro();
                        break;
                    case 2:
                        buscarLibroPorAutor();
                        break;
                    case 3:
                        mostrarLibrosRegistrados();
                        break;
                    case 4:
                        mostrarAutoresRegistrados();
                        break;
                    case 5:
                        AutoresVivosEnDetAnio();
                        break;
                    case 6:
                        mostrarLibrosPorIdioma();
                        break;
                    case 7:
                        estadisticas();
                        break;
                    case 8:
                        top5MasDescargados();
                        break;
                    default:
                        System.out.println("Ingrese una opcion del 0-8");
                }
            }catch (NumberFormatException e){
                System.out.println( "Error: "+input + " No es una opcion valida");
            }

        }
    }


    private LibrosR getDatos(String tituloABuscar){
        var json = concumirAPI.obtenerDatos(URL+"?search="+tituloABuscar.replace(" ","+"));
        DatosR datosR = convertirDatos.obtenerDatos(json, DatosR.class);
        return datosR.librosRList().stream()
                .filter(b-> b.tituloLibro().toUpperCase().contains(tituloABuscar.toUpperCase())).findFirst().orElse(null);
    }
    private void buscarLibro() {

        System.out.println("......................Buscar Libro por Titulo......................");
        System.out.println("Escriba el titulo del libro-> ");
        String libroABuscar = scanner.nextLine();
        LibrosR libroEncontrado = getDatos(libroABuscar);
        AutorC autorC = new AutorC(libroEncontrado.autorRList().getFirst());
        LibrosC librosC = new LibrosC(libroEncontrado);
        librosC.setAutorDelLibro(autorC);
        libroRepository.save(librosC);
        System.out.println("Libro encontrado\n"+ libroEncontrado);
    }
    private void mostrarLibrosRegistrados() {
        librosCRegistrados = libroRepository.findAll();
        System.out.println("......................Libros Registrados......................");
        librosCRegistrados.forEach(System.out::println);
    }
    private void buscarLibroPorAutor() {
        System.out.println("......................Buscar Libro por Autor......................");
        System.out.println("Escriba el nombre del autor: ");
        String autorABuscar = scanner.nextLine();
        librosCRegistrados= libroRepository.buscarLibroPorAutor(autorABuscar);
        System.out.println("......................Autor "+autorABuscar+"......................");
        librosCRegistrados.forEach(System.out::println);
    }
    private void mostrarAutoresRegistrados() {
        auoresRegistrados = libroRepository.buscarAuoresRegistrados();
        System.out.println("......................Mostrar Autores Registrados......................");
        auoresRegistrados.forEach(System.out::println);
    }
    private void AutoresVivosEnDetAnio() {
        System.out.println("......................Mostrar Autores Vivos en Determinado Anio......................");
        try {
            System.out.println("Ingrese el anio: ");
            String teclado = scanner.nextLine();
            int anio = Integer.parseInt(teclado);
            auoresRegistrados = libroRepository.autorVivoPorAnio(anio);
            System.out.println("......................Autores Vivos en "+anio+"......................");
            auoresRegistrados.forEach(System.out::println);
        }catch (NumberFormatException e){
            System.out.println("Error ingrese el anio");
        }
    }
    private void mostrarLibrosPorIdioma() {
        System.out.println("......................Libros por Idioma......................");
        System.out.println("Ingrese en que idioma quiere ver los libros:\n►EN(Ingleis)\n►ES(Espaniol)\n►PT(Portugues)");
        String idiomaSolicitado = scanner.nextLine();
        var idioma = Categoria.fromString(idiomaSolicitado.toLowerCase());
        librosCRegistrados = libroRepository.findByidioma(idioma);
        System.out.println("......................Idioma"+idiomaSolicitado+"......................");
        librosCRegistrados.forEach(System.out::println);
    }
    private void estadisticas() {
        librosCRegistrados = libroRepository.findAll();
        DoubleSummaryStatistics estadisticas = librosCRegistrados.stream()
                .filter(l->l.getNumeroDescargas()>0.0)
                .collect(Collectors.summarizingDouble(LibrosC::getNumeroDescargas));
        System.out.println("......................Estadisticas......................");
        System.out.printf("► Media de descargas %.2f \n► Elementos Evaluados %d\n", estadisticas.getAverage(), estadisticas.getCount());

    }
    private void top5MasDescargados() {
        librosCRegistrados = libroRepository.findTop5ByOrderByNumeroDescargasDesc();
        System.out.println("......................Top5 mas Descargados......................");
        librosCRegistrados.forEach(l-> System.out.println("► "+l.toString()));

    }
}
