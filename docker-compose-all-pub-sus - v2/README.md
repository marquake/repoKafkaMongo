
Proyecto con varios subproyectos relacionados:

 -- docker-compose: Despliega los siguientes servicios
    -- app java
    -- mongoDB y mongo Express
    -- Kafka y Kafdrop

 -- app -> 
    * tiene aplicaciones java que se comunicarán entre ellas a través de kafka
    * realizarán inserciones en la base de datos de mongo

 -- mongoDB
    * Tiene una precarga de las principales tablas de la aplicación.
      Se pueden usar directamente, aunque es posible que en versiones futuras
      modifique estas tablas por otras y con toda seguridad el esqueleto.
 
-- Kafka
    * Tiene un sistema de colas donde publicaré todos los eventos de la aplicación y
      donde se suscribirán los servicios java. 
    

NOTA: En esta versión, se añaden los subcriptores de las colas de la versión 1.