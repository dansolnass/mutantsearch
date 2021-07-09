# MUTANTSEARCH
repo fuentes java para servicios MercadoLibre



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
