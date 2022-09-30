## TPO 3
Autores:
- Benitez, Franco Fabian
- Diaz, Guillermo Nicolas
- Iovaldi, Sebastian Angel

Algoritmo que con ayuda de las clases Punto y Vector, busca el camino con menor tasa de variacion.
Almacena las derivadas parciales y formula de derivada direccional en sus respectivos módulos, para ser utilizados/modificados cuando sea necesario.

Tomando en cuenta los siguientes datos:

Puntos | Altura/Curva
- A | 9.23mts
- C,D | 8 mts
- B,E | 6 mts
- F,G | 4 mts
- H,I | 2 mts
- J | 0 mts

El camino debe partir desde A y terminar en J. 
Comienza creando vectores con puntos desde una curva a la siguiente (Ej: AC, AD (parten desde la curva de 9.23mts a la de 8mts)), comparando las derivadas entre la direcciones de estos vectores.
El que menor tasa de variacion tenga, será el siguiente origen.
Este nuevo origen se utilizará en la comparación de la siguiente curva de nivel.
Asi sucesivamente hasta que se compare con la curva de nivel de 0 mts.

Por ultimo, se imprime el camino encontrado con menor tasa de variación.
