# MUTANTSEARCH
repo fuentes java para servicios MercadoLibre

# Para la ejecución local

    # Desde IDE
        1. Ejecutar archivo database.sql (MYSQL) que se encuentra dentro del repositorio en la carpeta raiz.
        2. Descargar los fuentes del proyecto mutantsearch del repositorio
        3. Importar en el IDE como proyecto maven 
        4. Modificar el archivo application.yml ruta CARPETA_RAIZ\src\main\resources con las credenciales y url de BD
        4. ejecutar mvn clean install
        5. Levantar como proyecto de spring boot y ejecutar las URL a traves de postman
            http://localhost:8080/mutant
            http://localhost:8080/stats
            
    # Como aplicación local
        1. Ejecutar archivo database.sql que se encuentra dentro del repositorio en la carpeta raiz.
        2. Descargar los fuentes del proyecto mutantsearch del repositorio
        3. Modificar el archivo application.yml ruta CARPETA_RAIZ\src\main\resourcescon las credenciales y url de BD
        3. en la carpeta raiz del proyecto ejecutar mvn clean install (tener instalado maven en la maquina local)
        4. ir a la ruta CARPETA_RAIZ/target/ y ejecutar el comando java -jar MutantSearch-0.0.1-SNAPSHOT.jar (tener java 1.8 como minimo instalado en la maquina)
        5. Ejecutar localmente
            http://localhost:8080/mutant
            http://localhost:8080/stats

# Desde Api

Para la ejecución del metodo de validación de si el DNA es de mutantes o humanos
se debe ejecutar el método 

# Servicio verificación Mutante o Humano
POST /mutant/

# URL: 
http://ec2-18-118-158-73.us-east-2.compute.amazonaws.com:8080/mutant

# REQUEST
De acuerdo a lo solicitado el cuerpo o body de la petición debe tener la siguiente estructura: 

{
    "dna": [
        "TTGCGA",
        "TAGTCC",
        "TTATGT",
        "TGAAGG",
        "ACCCAA",
        "TCACTG"
    ]
}


# RESPONSE:
Sin body 
http status code 200 si es mutante
http status code 403 si es humano


# Servicio consulta estadisticas
GET /stats

# URL: 
http://ec2-18-118-158-73.us-east-2.compute.amazonaws.com:8080/stats

# REQUEST
N/A

# RESPONSE
con la estructura solicitada 
{
    "count_mutant_dna": 2,
    "count_human_dna": 1,
    "ratio": 2.0
}
