/*
 * Escribe	una	aplicación	en	Java	que	dé	solución	al	siguiente	caso	práctico:
Una	empresa	de	alquiler	de	coches	tiene	varios	registros	de	datos	almacenados	en	XML.	
Estos	ficheros	XML	tienen	los	registros	de	todos	los	clientes,	coches	y	empleados.	
La	empresa	se	ha	dado	cuenta	de	que	XML	es	un	formato	desfasado	y	necesita	tener	estos	
registros	en	JSON	para	una	posterior	implantación	de una	base	de	datos	NoSQL.
De	momento,	esta	empresa	nos	ha	contratado	para	crear	un	programa	que	dada	una	ruta	de	
una	carpeta	(directorio),	buscará	todos	los	ficheros	XML	que	estén	dentro	(no	es	necesario	
que	busque	recursivamente)	y	creará	los	correspondientes	ficheros	JSON	en	una	nueva	
carpeta	dentro	de	ese	directorio	llamada	“JSON” (el	programa	la	creará si	no	existe).	Es	
decir:
1. Creará	una	carpeta	en	esa	ruta	llamada	JSON – si	no	existe.
2. Leerá	todos	los	XML	
3. Escribirá	todos	los	JSON	en	la	carpeta	JSON en	un	formato	legible
En	caso	de	no	haber	ficheros	XML	devolverá	un	mensaje	informativo.	
 */
package Controler;

import View.Ch;

/**
 *
 * @author bitelyus @ www.miguelkiko.com
 */
public class Main {

    public static void main(String[] args) {

        boolean salir = false;
        int opcion = 0;
        
        do {
            Ch.menuPrincipal();
            opcion = Ch.pedirOpcion(3);
            switch (opcion) {
                case 1:
                    ControlerA1.comenzar();
                    break;
                case 2:
                    ControlerA2.comenzar();
                    break;
                case 3:
                    ControlerA3.comenzar();
                    break;
           
                case 0: 
                    salir = true;
                    break; 
            }
        } while (!salir);
            
        

    }

}
