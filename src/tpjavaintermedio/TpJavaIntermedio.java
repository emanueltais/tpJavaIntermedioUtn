/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpjavaintermedio;

import dao.EquipoDAO;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Equipo;



/**
 *
 * @author 54346
 */
public class TpJavaIntermedio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EquipoDAO equipoDAO = new EquipoDAO();
        Scanner scanner = new Scanner(System.in);
        
        boolean exit = false;
        while (!exit) {
        try {   
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar equipo");
            System.out.println("2. Mostrar todos los equipos");
            System.out.println("3. Eliminar equipo");
            System.out.println("4. Modificar propiedad de un equipo");
            System.out.println("5. Salir");
          
            int opcion = scanner.nextInt(); 
            scanner.nextLine(); 
    

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del equipo:");
                    String nombreEquipo = scanner.nextLine();
                    System.out.println("Ingrese el número de titulares:");
                    int titulares = scanner.nextInt();
                    System.out.println("Ingrese el número de suplente:");
                    int suplentes = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el Director Técnico:");
                    String directorTecnico = scanner.nextLine();
                    System.out.println("Ingrese cantidad de partidos jugados:");
                    int partidosJugados = scanner.nextInt();
                    System.out.println("Ingrese cantidad de partidos ganados:");
                    int partidosGanados = scanner.nextInt();
                    System.out.println("Ingrese cantidad de partidos perdidos:");
                    int partidosPerdidos = scanner.nextInt();
                    System.out.println("Ingrese cantidad de partidos empatados:");
                    int partidosEmpatados = scanner.nextInt();
                    model.Equipo nuevoEquipo = new model.Equipo(nombreEquipo, titulares, suplentes, directorTecnico, partidosJugados, partidosGanados, partidosPerdidos, partidosEmpatados);
                    equipoDAO.agregarEquipo(nuevoEquipo);
                    System.out.println("Equipo agregado correctamente.");
                    break;
                case 2:
                    equipoDAO.mostrarEquipos();
                    break;
                case 3:
                    System.out.println("Ingrese el ID del equipo a eliminar:");
                    int idEquipoEliminar = scanner.nextInt();
                    equipoDAO.eliminarEquipo(idEquipoEliminar);
                    break;
                case 4:
                    System.out.println("Ingrese el ID del equipo a modificar:");
                    int idEquipoModificar = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Seleccione la propiedad a modificar:");
                    System.out.println("1. Titulares");
                    System.out.println("2. Suplentes");

                    int propiedadModificar = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (propiedadModificar) {
                        case 1:
                            System.out.println("Ingrese el nuevo número de titulares:");
                            int nuevosTitulares = scanner.nextInt();
                            equipoDAO.modificarTitularesEquipo(idEquipoModificar, nuevosTitulares);
                            break;
                        case 2:
                            System.out.println("Ingrese el nuevo número de suplentes:");
                            int nuevosSuplentes = scanner.nextInt();
                            equipoDAO.modificarSuplentesEquipo(idEquipoModificar, nuevosSuplentes);
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                    break;    
                case 5:
                    System.out.println("Programa Finalizado ! ! ! !");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } catch (InputMismatchException ex) {
                System.out.println("Error: Ingrese un valor válido.");
                scanner.nextLine(); 
        } catch (Exception ex) {
                System.out.println("Error inesperado: " + ex.getMessage());
                ex.printStackTrace(); 
            }
        }
            scanner.close();
        
    }
}
