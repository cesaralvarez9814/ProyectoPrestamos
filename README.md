##Peticiones para poder crear usuarios,montos y plazos

PETICION POST : http://localhost:8080/clientes
{
	"firstName":"Cesar",
	"lastName":"Alvarez",
	"email":"cesaralvarezfe@gmail.com"
},
{
	"firstName":"Manuel",
	"lastName":"Zambada",
	"email":"manuelzambada@gmail.com"
},
{
	"firstName":"Salvador",
	"lastName":"Guerrero",
	"email":"salvadorguerrero@gmail.com"
}

PETICION POST : http://localhost:8080/plazos
{
	"valor":2,
	"descripcion":"2 Quincenas"
},
{
	"valor":4,
	"descripcion":"4 Quincenas"
},
{
	"valor":6,
	"descripcion":"6 Quincenas"
},
{
	"valor":8,
	"descripcion":"8 Quincenas"
},
{
	"valor":10,
	"descripcion":"10 Quincenas"
},
{
	"valor":12,
	"descripcion":"12 Quincenas"
}

PETICION POST : http://localhost:8080/montos
{
	"valor":200,
	"descripcion":"Monto de 200 pesos mexicanos"
},
{
	"valor":400,
	"descripcion":"Monto de 400 pesos mexicanos"
},
{
	"valor":800,
	"descripcion":"Monto de 800 pesos mexicanos"
},
{
	"valor":1000,
	"descripcion":"Monto de 1000 pesos mexicanos"
},
{
	"valor":1200,
	"descripcion":"Monto de 1200 pesos mexicanos"
}


Estas son unas peticiones de prueba para poder ambientar la api

