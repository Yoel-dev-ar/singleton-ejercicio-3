Ejercicio 3: Registro de Eventos (Logger) Básico

Contexto del problema: Toda aplicación requiere registrar eventos, advertencias y errores en un archivo de texto centralizado. Si cada clase abriera su propio flujo de escritura hacia el mismo archivo de forma independiente, se producirían bloqueos de concurrencia y corrupción de datos.

Objetivo de aprendizaje: Utilizar el patrón Singleton para canalizar la escritura concurrente hacia un recurso de salida compartido de manera ordenada.

Requisitos funcionales:

Ofrecer métodos públicos para registrar mensajes indicando su nivel de severidad (INFO, WARNING, ERROR).

Consignar cada mensaje añadiendo una marca de tiempo automática antes de volcarlo al almacenamiento o consola.

Restricciones técnicas:

El mecanismo de escritura debe ser gestionado exclusivamente por una clase con control estricto de su ciclo de vida único.

El cliente debe invocar la función de registro mediante una interfaz estática o referencia única sin instanciar la clase de manera directa.

# Ejercicio 3: Libro de Registro de Movimientos (Patrón Singleton)

## Temática

Banca Digital y Tradicional — Registro centralizado de movimientos y auditoría del banco.

## Consigna

El banco necesita anotar en orden todo lo que ocurre durante el día (transferencias, bloqueos de tarjetas, aperturas de plazos fijos) para poder revisar el historial si hay algún reclamo o auditoría. Si cada sector del sistema anotara en su propio cuaderno por separado, la información quedaría dividida y desordenada.

El objetivo es centralizar todas las anotaciones en un único libro de registro para que cada movimiento quede guardado con su hora en una misma lista compartida por todo el sistema.

## Explicación lógica

1. Atributos: En la clase LibroRegistroMovimientos se declaran renglones (private List) para guardar cada movimiento anotado en orden y formatoHora (private DateTimeFormatter) con el patrón "HH:mm:ss" para darle formato de hora a cada registro. A esto se suma instancia (private static LibroRegistroMovimientos), que va a conservar la única referencia en memoria para que todos los sectores anoten en el mismo historial sin dividir los datos.


2. Instancia única: El constructor se define como private para impedir que se creen libros independientes usando new, y además inicializa la lista vacía y el formato de hora cuando se crea por primera vez. El método getInstancia() controla el acceso: revisa si instancia es null (es decir, si todavía no se creó), la instancia una sola vez y en las siguientes llamadas devuelve siempre ese mismo objeto ya existente.


3. Asignación y Acceso: En Main, se obtiene la instancia desde distintos sectores (libroCaja y libroSeguridad) y se llaman a anotarMovimiento(...) para armar cada línea con la hora actual, el sector, el cliente y la acción, agregándola a renglones y mostrándola por consola. Luego, al llamar a leerLibroCompleto() se recorren e imprimen todos los movimientos acumulados, y la comparación libroCaja == libroSeguridad confirma que ambas variables apuntan exactamente al mismo objeto en memoria.



## Estructura del ejercicio

* LibroRegistroMovimientos.java: Implementa el registro centralizado con marca de tiempo automática, historial compartido y patrón Singleton
* Main.java: Registra movimientos desde distintos sectores, imprime el historial completo y verifica que se comparte la misma instancia


