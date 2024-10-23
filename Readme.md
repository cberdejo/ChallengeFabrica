# Proyecto: Simulación de Fábrica con Máquinas de Transformación de Piezas

Este proyecto simula el funcionamiento de una fábrica con una cadena de montaje formada por diferentes tipos de máquinas que actúan sobre piezas de 3x3 cuadros, transformándolas a lo largo del proceso. Existen cuatro tipos de máquinas: **Fresadoras**, **Lijadoras**, **Rotadoras** y **Taladradoras**. Cada máquina tiene un comportamiento específico que modifica una parte de la pieza de acuerdo con sus características.

## Descripción del Problema

La fábrica actúa sobre piezas con una estructura de 3x3 cuadros. Cada cuadro puede ser transformado por las máquinas en función de su posición y el tipo de operación que realizan. A continuación, se describen las funciones de cada tipo de máquina:

### 1. **Fresadoras**
Las fresadoras realizan cuñas sobre los cuadros de la pieza. Estas cuñas pueden variar en:
- **Grosor**: Fino, Medio o Grueso.
- **Orientación**: Vertical o Diagonal a la derecha o izquierda.

### 2. **Lijadoras**
Las lijadoras producen un triángulo lijado desde el centro de un cuadro hacia:
- **Dirección**: Norte (hacia arriba) o Sur (hacia abajo).
- **Grosor**: Fino, Medio o Grueso.


### 3. **Taladradoras**
Las taladradoras realizan un taladro circular en el centro de un cuadro. El taladro puede ser de diferentes grosores: Fino, Medio o Grueso.

### 4. **Rotadoras**
Las rotadoras giran la pieza 90 grados en sentido horario o antihorario, cambiando la orientación de las marcas producidas por las fresadoras y lijadoras.

## Reglas de Interacción entre Máquinas
- Al aplicar una fresadora o lijadora sobre un cuadro con una transformación previa, las marcas de mayor grosor reemplazan a las de menor grosor.
- Un taladro grueso elimina cualquier lija fina en el mismo cuadro.
- Las rotadoras afectan la orientación de las fresas y lijas:
  - Una fresa vertical se convierte en horizontal al rotar.
  - Una lija orientada al norte se convierte en este al rotar 90 grados en sentido horario.

## Clases y Métodos

### Clases Principales
1. **Fabrica**
   - Contiene el método `List<Maquina> maquinas()` que devuelve las máquinas que componen la cadena de montaje.
   - Método de clase `Fabrica aleatoria(int n)` que crea una fábrica aleatoria con `n` máquinas, distribuyendo equitativamente los tipos de máquinas.

2. **Pieza**
   - Representa una pieza de 3x3 cuadros que puede ser modificada por las máquinas.
   - Permite mostrar la pieza en formato de texto según las transformaciones aplicadas.

3. **Maquina (Interfaz)**
   - Define el método `void actua(Pieza pieza)` que todas las máquinas deben implementar para modificar la pieza.

4. **Fresadora, Lijadora, Taladradora y Rotadora**
   - Implementan la interfaz `Maquina` y cada una define el comportamiento específico para modificar la pieza.

## Contribuciones
Este es un trabajo en grupo hecho por ...


