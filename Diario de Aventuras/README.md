📜 Diario de Aventuras - Implementación de TDA en JAVA

📌 Descripción
El Diario de Aventuras es un programa en Java que permite a los aventureros llevar un registro organizado de sus misiones completadas. 
Implementa un Tipo de Dato Abstracto (TDA) utilizando una Pila (Stack) para gestionar las misiones en orden de finalización.

------------------------------------------------------------------------------------------------------------------------

⚙️ Funcionalidades
* Registrar misión: Agrega una nueva misión al diario con nombre, descripción y nivel de dificultad.
* Eliminar misión: Permite eliminar la última misión registrada si esta no fue completada con éxito.
* Mostrar misiones: Lista todas las misiones completadas en orden cronológico.
* Buscar misión: Verifica si una misión específica ha sido completada.
* Salir del programa: Finaliza la sesión del aventurero.

------------------------------------------------------------------------------------------------------------------------

🛠️ Tecnologías y Conceptos Usados
- Java (POO - Programación Orientada a Objetos)
- TDA - Tipo de Dato Abstracto
- Estructura de datos: Pila (Stack)
- Manejo de entrada con Scanner
- Uso de Clases y Objetos

------------------------------------------------------------------------------------------------------------------------
📂 Estructura del Proyecto

📦 DiarioAventurero
 - 📜 Mision.java          # Clase que define una misión
 - 📜 DiarioAventurero.java # TDA que maneja el registro de misiones
 - 📜 MenuOpciones.java     # Clase principal con la interfaz del usuario

------------------------------------------------------------------------------------------------------------------------

▶️ Cómo Ejecutar
- Compilar el programa:
javac *.java

- Ejecutar el programa:
java MenuOpciones

------------------------------------------------------------------------------------------------------------------------
📌 Recomendaciones
- Puedes extender la funcionalidad agregando edición de misiones registradas.
- Para hacer el programa más interactivo, podrías usar una interfaz gráfica (GUI) con JavaFX o Swing.
- Si deseas guardar el registro entre sesiones, podrías implementar almacenamiento en archivos CSV o JSON.