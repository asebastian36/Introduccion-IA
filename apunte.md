# Logica y Razonamiento

***Pensamiento racional:** En enfoque a las leyes del pensamiento.

* Codifico la manera correcta de pensar -> proceso de razonamiento irrefutable.
* **Silogismos** son estructuras de argumentacion mediante las que se llega a conclusiones correctas si parten de premisas correctas.
* Ejemplo: Son alumnos del cuarto semestre de ISI; `M`
En este momento toman clase de IA; `Q` Alumnos de 4to semestre de ISI tienen clase de IA; `X`

`M^Q->X`

## Actividad 1

6 silogismos

* enunciado
* nomenclatura logica de predicado

```java
    (P)Todos los perros son mamíferos ^  (M)Todos los mamíferos tienen sangre caliente. Por lo tanto, (X) todos los perros tienen sangre caliente.
    (P ^ M -> X)

    (P)Todas las plantas necesitan agua ^ (Q)Todas las rosas son plantas. Por lo tanto, (A)todas las rosas necesitan agua.
    (P ^ Q -> A)

    (P)Algunos pájaros son pingüinos ^ (G)Todos los pingüinos son aves. Por lo tanto, (B)algunos pájaros son aves.
    (P ^ G -> B)

    (P)Todos los libros de historia son interesantes ^ (C)Algunos libros son de ciencia ficción. Por lo tanto, (H)algunos libros de ciencia ficción no son interesantes.
    (P ^ C -> H)

    (V)Todos los hombres son mortales ^ (K)Sócrates es un hombre. Por lo tanto, (I)Sócrates es mortal.
    (V ^ K -> I)

    (J)Todos los pingüinos tienen plumas ^ (L)Algunos pingüinos son negros. Por lo tanto, (R)algunos seres negros tienen plumas.
    (J ^ L -> R)
```

## Busqueda y heuristica

* Busqueda: Metodo computacional para resolver problemas.
* Problemas que resuelve:
  * Encuentra caminos
  * Satisfaccion de restricciones
* Los problemas de IA generalmente usan un termino comun llamado **estado**.
* Caracteristicas: La solucion se obtiene por enumeracion o estados, se suponen requieren IA.

La IA estudia especialmente metodos que permiten resolver problemas en los que permiten resolver problemas.

Entre menos estados se generen, mejor es el algoritmo utilizado para llegar al estado meta. Heuristico: Viene del griego heuriskein que significa encontrar o descubrir.
En inteligencia artificial, heuristico se describe mejor como **metodo de busqueda**.

La busqueda heuristica consiste en añadir informacion, basandose en el espacio estudado hasta ese momento, de forma que se restringe drasticamente esa busqueda,
Muchos problemas de IA se pueden modelar como una grafica en donde hay que buscar recorridos o caminos con ciertas caracteristicas.

Para estos modelos se han desarrollado muy diversas heuristicas que han dado muy buenos resultados para encontrar soluciones aproximadas: algoritmos geneticos, recorrido simulado, etc.

## Actividad 2

Resolver el grafo satisfaciendo la restriccion.

```java
Solucion 1:
(1 {1, 2, 3, 4, 7, 4, 2, 3, 6, 7, 4, 2, 3, 6, 5})
1 -> 2 = 1
2 -> 3 = 4
3 -> 4 = 3
4 -> 7 = 6
7 -> 4 = 4
4 -> 2 = 1
2 -> 3 = 4
3 -> 6 = 2
6 -> 7 = 9
7 -> 4 = 4
4 -> 2 = 1
2 -> 3 = 4
3 -> 6 = 2
6 -> 5 = 2
    x = 47

F(47)=2(47)+1
F(47)=95
F(47)>=50;SI

Solucion 2:
(2 {1, 2, 3, 4, 2, 3, 4, 2, 3, 6})
1 -> 2 = 1
2 -> 3 = 4
3 -> 4 = 3
4 -> 2 = 1
2 -> 3 = 4
3 -> 4 = 3
4 -> 2 = 1
2 -> 3 = 4
3 -> 6 = 2
6 -> 5 = 2
    x = 25

F(25)=2(25)+1
F(25)=25
F(25)>=50;SI


Solucion 3:
(3 {1, 4, 7, 2, 3, 4, 7})
1 -> 4 = 3
4 -> 7 = 6
7 -> 2 = 4
2 -> 3 = 4
3 -> 4 = 3
4 -> 7 = 6
    x = 26

F(26)=2(26)+1
F(26)=53
F(26)>=50;SI
```

Un problema puede definirse formalmente de:

1. Estado inicial: que es donde comienza el agente.
2. Una descripcion de las posibles acciones disponibles por el agente, la formulacion mas comun es utilizar una funcion que establece las acciones legales del estado x para cumplir o satisfacer
la accion determinada.
3. Espacio de estados: de forma implicita el estado inicial y la funcion sucesor definen un espacio de estados del problema.
4. Un camino es el espacio de estados en una secuencia de estos conectados por sus acciones. `Ejemplo (1 {1,4,7})`
5. Test objetivo es que determina si un estado es objetivo es lo que se quiere llegar a cumplir. `F(9)=2(9)+1=19`, `C1->F(9)>=50; NO`
6. Solucion de un problema es un camino que desde el estado inicial a un estado objetivo. La calidad de la solucion se mide por la funcion costo del camino y se dice que una solucion optima
sera aquella que tenga el costo mas pequeño del camino entre todas las soluciones.

## Actividad 3

```java
Solucion 1:
(1 {1, 10})
1 -> 10 = 8
      x = 8

F(8)=8(8)+2
F(8)=64+2=66
F(8)>42;SI


Solucion 2:
(2 {1, 2, 8})
1 -> 2 = 5
2 -> 8 = 2
      x = 7
      
F(7)=8(7)+2
F(7)=58
F(7)>42;SI

Solucion 3:
(3 {1, 6})
1 -> 6 = 8
    x = 8
    
F(8)=8(8)+2
F(8)=66
F(8)>42; SI
```
