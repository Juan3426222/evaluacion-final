🙌 TaskManagerPro

📌 Descripción del sistema
TaskManagerPro es una aplicación Java que permite gestionar tareas utilizando principios sólidos de diseño.
El sistema permite crear tareas, clonarlas, ejecutar tareas externas adaptadas al sistema interno, notificar por distintos medios y recorrer colecciones de tareas con facilidad.

🎯 Problema a resolver
En un sistema de gestión de tareas real, es común que:

Se necesiten tareas similares muchas veces (por ejemplo, tareas recurrentes o duplicadas).

Haya tareas que provienen de sistemas externos o con formatos incompatibles.

Existan múltiples formas de enviar notificaciones (correo, SMS, etc.).

Se necesita iterar tareas para mostrarlas, ejecutarlas o analizarlas.

🧩 Patrones de diseño aplicados

🧬 1. Prototype (Creacional)
¿Por qué? Para clonar tareas fácilmente sin tener que recrearlas desde cero.

¿Cómo? Implementando la interfaz Cloneable en ConcreteTask y sobrescribiendo el método clone().

¿Dónde? En ConcreteTask.java. Se demuestra en Main.java al duplicar una tarea existente.

🔌 2. Adapter (Estructural)
¿Por qué? Para permitir que tareas externas (por ejemplo, de otro sistema) puedan funcionar dentro del sistema interno.

¿Cómo? Creando un adaptador TaskAdapter que transforma ExternalTask en Task.

¿Dónde? En TaskAdapter.java. Se usa en Main.java.

🧱 3. Bridge (Estructural)
¿Por qué? Para desacoplar la abstracción de las tareas de sus mecanismos de notificación.

¿Cómo? Separando la abstracción (TaskAbstraction) de la implementación (EmailNotification, SmsNotification) mediante la interfaz TaskImplementation.

¿Dónde? En el paquete bridge/. Se demuestra en Main.java.

🔁 4. Iterator (Comportamiento)
¿Por qué? Para recorrer fácilmente la lista de tareas con un bucle for-each.

¿Cómo? Implementando la interfaz Iterable en TaskList.

¿Dónde? En TaskList.java. Se utiliza en Main.java para ejecutar todas las tareas.
