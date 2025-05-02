"""
Programa que permite sugerir a sus jugadores, en unas edades establecidas, la skin a utilizar
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3

"""


from apoyo import ingresar_entero, mostrar_mensaje, ingresar_texto, ingresar_real


def main():
    genero_jugador = ingresar_texto("Escriba a que género pertenece: ")
    temporada = ingresar_entero("Ingrese la temporada del juego: ")
    edad_jugador = ingresar_entero("Ingrese su edad: ")
    pavos_jugador = ingresar_real("Ingrese la cantidad de miles de PaVos: ")
    skin_jugador = verificar_skin(genero_jugador, temporada, edad_jugador, pavos_jugador)
    mensaje = generar_mensaje(skin_jugador)
    mostrar_mensaje(mensaje)


def verificar_skin(genero_jugador, temporada, edad_jugador, pavos_jugador):
    skin_mujer = verificar_skin_mujer(
        genero_jugador, temporada, edad_jugador, pavos_jugador)
    skin_hombre = verificar_skin_hombre(
        genero_jugador, temporada, edad_jugador, pavos_jugador)

    if skin_mujer == True:
        skin ="Tarana"
    elif skin_hombre == True:
        skin = "Caballero Terrible"
    else:
        skin = "ninguna"

    return skin


def verificar_skin_mujer(genero_jugador, temporada, edad_jugador, pavos_jugador):
    skin_mujer = temporada == 6 and \
        genero_jugador == "mujer" and \
        edad_jugador >= 18 and \
        edad_jugador <= 25 and \
        pavos_jugador >= 2.6
    return skin_mujer


def verificar_skin_hombre(genero_jugador, temporada, edad_jugador, pavos_jugador):
    skin_hombre = temporada == 6 and \
        genero_jugador == "hombre" and \
        edad_jugador >= 16 and \
        edad_jugador <= 30 and \
        pavos_jugador >= 4.9
    return skin_hombre


def generar_mensaje(skin):
    mensaje = f"La skin recomendada es {skin}"

    return mensaje


main()
