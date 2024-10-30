## Tabla de contenidos 
- Simulación de un Universo Calculando las Atracciones entre Astros
- Simulación de Fábrica con Máquinas de Transformación de Piezas

# Proyecto: Simulación de un Universo Calculando las Atracciones entre Astros
  Se pretende crear una aplicación que maneje partículas en el universo. Las partículas estarán localizadas en una posición y tendrán una masa, radio y velocidad. A partir de la fuerza de atracción con otras estrellas la fuerza que actúa sobre la estrella variará y por tanto su velocidad. El universo estará compuesto de muchas partículas que se atraerán y generarán el movimiento de estas. Las clases
Particula y Universo se crearán en el paquete universo. Para esta aplicación necesitaremos las clases Punto y Vector del proyecto Rectas. Debemos publicar el proyecto Rectas e incluirla su referencia en el pom.xml de este proyecto.

 ## Clase Particula
-  La	 clase	Particula tiene	 una	 posición	 (Punto),	 una	 velocidad	 (Vector), una masa	(constante	de	tipo	double)	y	un	radio	(constante	de	tipo	doble).
-  Define un	 constructor	 donde	 se	 le	 pase	 la	 información	 de	 todas	 las	 variables	 de	instancia	en	el	orden	en	el	Que	las	hemos	definido.
-  Define los	 métodos	 Punto posicion() que	 devuelva	 la	 posición	 y	double  radio() que	devuelva	el	radio.
-  Define	 el	 método	 Vector fuerzaDesde(Particula part) que	 calcule	 la	fuerza	de	atracción	que	ejerce	la	partícula	part sobre	la	receptora.	Para	ello,	usa	la	constante	de	gravitación	universal	(G = 6.67E-11).	

-  Define	el	método	void mueve(Vector vz, double dt) que	simule	que	se aplica	 una	 fuerza	 vz a	 la	 partícula	 durante	 un	 tiempo	 dt.	 	 Como	 sabemos	 por	Física	(en	mayúsculas	están	vectores	y	puntos)

-  Define	 el	 método	 String toString() para	 visualizar	 todos	 los	 atributos	 de	
una	partícula.
## Clase Universo
Un universo contiene un array de partículas y un radio que será el espacio visible del universo.
- Define	 un	 constructor	 en	 el	 que	 se	 pase	 el	 array	 de	 partículas	 y	 el	 radio	 del	
universo.
-  Define	 un	método	void avanza(double dt) que	 simule	 como	 se	modifican	
las	posiciones	y	velocidades	de	las	partículas	transcurrido	un	tiempo	dt.

Este método calcula, para cada partícula, la fuerza de atracción total del resto de partículas. Para ello, crea un array de vectores de la misma dimensión que el de partículas y va sumando a cada posición i de ese array la fuerza de atracción de cada partícula j con i siendo j distinto de i. 
Finalmente, mueve cada partícula con la fuerza que actúa sobre ella y el tiempo que se aplica. Se proporciona un paquete gui que incluye la clase PanelUniverso que permite visualizar un universo (incluirlo en el proyecto). También se proporciona la clase Main que contiene cuatro ejemplos que pueden probarse de forma independiente. Deben ejecutarse quitando el comentario en el ejemplo en el método main. Falta crear el paquete universo y en él las clases Particula y Universo.
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
Este es un trabajo en grupo hecho por

<a href="https://github.com/cberdejo/ChallengeFabrica/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=cberdejo/ChallengesJavaPOO" alt="contrib.rocks image" />
</a>



