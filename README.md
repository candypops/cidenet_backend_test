# Cidenet Sistema de Registro

Cidenet Sistema de registro permite registrar el ingreso y la salida de los empleados, así como administrar su información.

## Requerimientos
1. Java 11
2. IDE, preferiblemente Intellij
3. Postgres

## Instalacion

1. Descargar archivo zip de la rama master.
2. Importar en IDE.
3. Editar archivo src/main/resources/application.properties para la base de datos de la siguiente manera:
```
spring.datasource.url=jdbc:postgresql://localhost:{{Puerto}}/{{Nombre de tu BD}}
spring.datasource.username={{Usuario dueño de tu BD}}
spring.datasource.password={{Contraseña de tu usurario}}
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true

```
4. Navegar a la clase src/main/java/com/cidenet/cidenet/CidenetApplication.java
5. Ejecutar CidenetApplication.java

## Postman

```Request  
import foobar

# returns 'words'
foobar.pluralize('word')

# returns 'geese'
foobar.pluralize('goose')

# returns 'phenomenon'
foobar.singularize('phenomena')
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)