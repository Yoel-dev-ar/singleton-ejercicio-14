Ejercicio 4: Administrador Único de Préstamos (Patrón Singleton)
Temática
Gestión de Biblioteca — Control centralizado de préstamos y devoluciones por ejemplar físico entre múltiples mostradores.

Consigna

Administrador Único de Préstamos

Contexto del problema: Dos mostradores de una biblioteca registran préstamos desde una misma aplicación. Al utilizar administradores independientes, ambos pueden prestar el mismo ejemplar físico a socios diferentes. Se necesita centralizar el estado de los préstamos.

Objetivo de aprendizaje: Utilizar Singleton para mantener un estado compartido y aplicar reglas de negocio sobre un recurso identificado individualmente.

Requisitos funcionales:

Registrar préstamos indicando el identificador del ejemplar, el socio y la fecha.

Impedir el préstamo de un ejemplar que ya se encuentre prestado.

Registrar devoluciones para habilitar nuevamente el ejemplar.

Consultar los préstamos activos de un socio.

Restricciones técnicas:

Ambos mostradores deben utilizar la misma instancia del administrador.

Cada ejemplar físico debe tener un identificador único, aunque pertenezca al mismo título.

Las solicitudes se realizarán de forma secuencial dentro del mismo proceso.

Una devolución de un ejemplar sin préstamo activo debe rechazarse sin modificar el estado.

Se debe demostrar que un préstamo registrado desde un mostrador impide prestar el mismo ejemplar desde el otro.

Explicación lógica
Atributos: En la clase AdministradorPrestamos se declara prestamosActivosPorEjemplar (private final Map<String, Prestamo>) para rastrear qué ejemplar físico está prestado actualmente y a qué socio, junto con instancia (private static AdministradorPrestamos) para unificar ambos mostradores.

Instancia única: El constructor private evita que cada mostrador instancie su propio administrador, y getInstancia() asegura una única fuente de verdad para el estado de cada ejemplar.

Asignación y Acceso: En Main, el mostrador 1 registra un préstamo indicando ejemplar, socio y fecha; al intentar prestar ese mismo ejemplar desde el mostrador 2, el sistema lo rechaza mientras siga activo, rechaza devoluciones de ejemplares sin préstamo activo sin modificar el estado y habilita nuevamente el ejemplar tras una devolución válida.

Estructura del ejercicio
Prestamo.java: Guarda el identificador del ejemplar físico, el identificador del socio y la fecha del préstamo.

AdministradorPrestamos.java: Implementa el Singleton con control de disponibilidad por ejemplar, devoluciones y consulta por socio.

Main.java: Simula operaciones secuenciales entre dos mostradores y valida las reglas de préstamo y devolución.