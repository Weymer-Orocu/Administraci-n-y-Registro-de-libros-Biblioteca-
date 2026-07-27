/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import DatosBiblioteca.Libros; // Define el paquete al que pertenece esta clase de lógica de control
import java.util.ArrayList; // Importa ArrayList para la manipulación de colecciones dinámicas
import java.util.Iterator; // Importa la interfaz Iterator para recorrer colecciones de forma segura

 /**
 * @author  Weymer Orocú Amador
 * Nombre del Proyecto: Sistema de Gestión y Registro de Libros
 * Descripcion del proyecto: El sistema consiste en una aplicacion desarrollada en Java Swing 
 * bajo el patrón MVC, que permite el registro, edición, búsqueda y listado de libros en tiempo 
 * real mediante el manejo de colecciones en memoria.
 */

public class GestorLibros { // Declaración de la clase GestorLibros
      private ArrayList<Libros> listaLibros; // Lista principal donde se almacenan todos los libros registrados.

    public GestorLibros() { // Constructor de la clase.
        this.listaLibros = new ArrayList<>(); // Inicializa la lista como un ArrayList vacío
    }

    public void agregarLibro(Libros libro) { // Método para agregar un nuevo libro a la lista.
        listaLibros.add(libro); // Inserta el objeto libro recibido al final del ArrayList
    }
    
    // Método Getter para obtener acceso directo a la lista original en memoria
    public ArrayList<Libros> getListaLibros() { 
        return listaLibros;
    }

    // Obtiene todos los libros utilizando Iterator.
    public ArrayList<Libros> obtenerTodosLosLibros() { 
        ArrayList<Libros> resultado = new ArrayList<>(); // Crea una lista nueva temporal para retornar los elementos
        Iterator<Libros> it = listaLibros.iterator(); // Se crea un iterador para recorrer la colección.
        while (it.hasNext()) {  // Mientras existan elementos por recorrer.
            resultado.add(it.next()); // Agrega el siguiente libro a la nueva lista.
        }
        return resultado; //Devuelve la lista temporal
    }

    // Busca libros según el nombre de la biblioteca.
    // La búsqueda es parcial e ignora mayúsculas y minúsculas.
    public ArrayList<Libros> buscarPorBiblioteca(String criterio) {
        ArrayList<Libros> filtrados = new ArrayList<>(); // Lista donde se guardarán los resultados encontrados.
        String criterioMin = criterio.toLowerCase(); // Convierte el criterio a minúsculas.

        for (Libros libro : listaLibros) { // Recorre todos los libros registrados.
            if (libro.getBiblioteca().toLowerCase().contains(criterioMin)) { // Comprueba si la biblioteca contiene el texto buscado.
                filtrados.add(libro); // Si coincide, agrega el objeto libro a la lista de resultados
            }
        }
        return filtrados; // Retorna los libros encontrados.
    }

    // Obtiene únicamente las bibliotecas diferentes.
    public ArrayList<String> obtenerBibliotecasUnicas() {
        ArrayList<String> unicas = new ArrayList<>(); // Lista donde se almacenarán las bibliotecas únicas.
        for (Libros libro : listaLibros) { // Recorre todos los libros
            String biblioActual = libro.getBiblioteca(); // Obtiene el nombre de la biblioteca actual.
            boolean existe = false; // Variable para verificar si ya existe.
            for (String u : unicas) { // Recorre las bibliotecas únicas almacenadas
                if (u.equalsIgnoreCase(biblioActual)) { // Compara ignorando mayúsculas y minúsculas
                    existe = true; // Marca que ya existe.
                    break; // Sale del ciclo.
                }
            }
            if (!existe) {  // Si no existe
                unicas.add(biblioActual); // Lo agrega a la lista.
            }
        }
        return unicas; // Retorna a las bibliotecas únicas.
    }

    public String invertirTextoRecursivo(String texto) { // Función recursiva que invierte un texto.
        if (texto == null || texto.isEmpty()) { // Valida si la cadena es nula o no tiene caracteres
            return texto; // Retorna al texto
        }
        // Toma el último carácter y lo une la inversión del resto
        return texto.charAt(texto.length() - 1) + invertirTextoRecursivo(texto.substring(0, texto.length() - 1));
    }
    
    public void ordenarPorInsercionManual(ArrayList<Libros> lista) { // Ordena ascendentemente por biblioteca y luego por fecha.
        int n = lista.size(); // Obtiene la cantidad de elementos.
        for (int i = 1; i < n; ++i) { // Recorre desde el segundo elemento.
            Libros llave = lista.get(i); // Guarda temporalmente el elemento actual.(llave)
            int j = i - 1;  // Inicializa el índice del elemento previo para la comparación hacia atrás
            while (j >= 0 && debeIrAntesAscendente(llave, lista.get(j))) {  // Desplaza los elementos mayores que la llave hacia una posición adelante de su ubicación actual
                lista.set(j + 1, lista.get(j)); // Mueve el elemento hacia la derecha en la colección
                j = j - 1; // Disminuye el índice j para seguir evaluando las posiciones de la izquierda
            }
            lista.set(j + 1, llave); // Inserta la llave en su posición correcta ya ordenada
        }
    }

    // Determina si un libro debe colocarse antes que otro en orden ascendente.
    private boolean debeIrAntesAscendente(Libros l1, Libros l2) { 
        int compBiblioteca = l1.getBiblioteca().compareToIgnoreCase(l2.getBiblioteca()); // Compara  bibliotecas alfabéticamente ignorando mayúsculas
        if (compBiblioteca < 0) { // Si el nombre de l1 va antes alfabéticamente que l2
            return true; // Confirma que l1 debe posicionarse antes
        } else if (compBiblioteca == 0) { // Si ambos libros pertenecen a la misma biblioteca
            return l1.getFechaPublicacion().before(l2.getFechaPublicacion()); // Si las bibliotecas son iguales, desempata por fecha de publicación (ascendente)
        }
        return false; // No debe ir antes.
    }

    // Ordena descendentemente por biblioteca y fecha.
    public void ordenarPorMergeSortManual(ArrayList<Libros> lista) {
        if (lista.size() > 1) { // Si la lista tiene más de un elemento.
            int mitad = lista.size() / 2; // Calcula el punto medio para dividir la colección en dos partes
            ArrayList<Libros> izquierda = new ArrayList<>(lista.subList(0, mitad)); // Sublista desde el inicio hasta la mitad
            ArrayList<Libros> derecha = new ArrayList<>(lista.subList(mitad, lista.size())); // Sublista desde la mitad hasta el final
            ordenarPorMergeSortManual(izquierda); // Ordena recursivamente la parte izquierda.
            ordenarPorMergeSortManual(derecha); // Ordena recursivamente la parte derecha.
            fusionarDescendente(lista, izquierda, derecha); // Une ambas listas ordenadas.
        }
    }

    // Fusiona las dos listas ya ordenadas.
    private void fusionarDescendente(ArrayList<Libros> lista, ArrayList<Libros> izq, ArrayList<Libros> der) {
        int i = 0, j = 0, k = 0; // Inicializa los punteros de seguimiento para la lista izquierda (i), derecha (j) y destino (k)
        while (i < izq.size() && j < der.size()) { // Mientras ambas listas tengan elementos.
            if (debeIrAntesDescendente(izq.get(i), der.get(j))) { // Evalúa bajo el criterio descendente
                lista.set(k++, izq.get(i++)); // Inserta el elemento izquierdo e incrementa los índices k e i
            } else {
                lista.set(k++, der.get(j++)); // Inserta el elemento derecho e incrementa los índices k e j
            }
        }
        while (i < izq.size()) { // Ciclo para vaciar los elementos restantes de la sublista izquierda si quedaron disponibles
            lista.set(k++, izq.get(i++)); // Copia el elemento restante e incrementa los contadores
        }
        while (j < der.size()) { // Ciclo para vaciar los elementos restantes de la sublista derecha si quedaron disponibles
            lista.set(k++, der.get(j++)); // Copia el elemento restante e incrementa los contadores
        }
    }

    // Determina si un libro debe ir antes que otro en orden descendente.
    private boolean debeIrAntesDescendente(Libros l1, Libros l2) {
        int compBiblioteca = l1.getBiblioteca().compareToIgnoreCase(l2.getBiblioteca()); // Compara las bibliotecas.
        if (compBiblioteca > 0) { // Si el nombre de l1 va después alfabéticamente que l2 (Orden Inverso / Z-A)
            return true; // Confirma que l1 debe ir antes por ser ordenamiento descendente
        } else if (compBiblioteca == 0) { // Si pertenecen exactamente a la misma biblioteca
            return l1.getFechaPublicacion().after(l2.getFechaPublicacion()); // Retorna true si la fecha de l1 es más reciente que l2
        }
        return false; // En cualquier otro caso, l1 no debe ir antes que l2
    }  
}