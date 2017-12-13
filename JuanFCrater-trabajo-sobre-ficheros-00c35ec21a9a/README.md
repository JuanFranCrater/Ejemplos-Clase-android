# Tema 2 - ACDAT - Proyecto ficheros #

Trabajo final para el tema 2 Ficheros locales y Ficheros en red

###Planteamiento ###

Aplicación que permite mostrar una secuencia de imágenes y frases en pantalla.
Se introducen las rutas al fichero con enlaces a imágenes en la red y al fichero con frases para poder realizar su descarga.
Cuando se pulse el botón de descarga, se mostrarán una a una las imágenes y frases descargadas, de forma automática cada cierto tiempo. Ese tiempo estará almacenado en el fichero /raw/intervalo.txt.
Además, se añaden al fichero errores.txt situado en un servidor web  los errores que se hayan producido:
*-No se puede descargar el fichero de imágenes o el de frases
*-No se puede descargar alguna imagen.
*-Etc...
*Por cada error producido, se añade al fichero errores.txt una línea con la ruta al archivo que se quiere descargar, la fecha y hora de acceso y la causa del error.

### Posibles futuras mejoras ###

-Botones que permitan continuar a las siguientes imagenes y  frases manualmente.
*-Una opcion para añadir al fichero de enlaces de las imagenes o al fichero de frases nuevas lineas.
*-Una opcion para mostrar el archivo de errores en el servidor.
*-Boton/es para parar el avanzado de las imagenes y/o frases.

### Errores ###

-El INputStreamReader no obtiene los datos en Utf-8

