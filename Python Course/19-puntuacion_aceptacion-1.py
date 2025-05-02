"""
Programa que permita ingresar una puntuación entre 0 y 100.
Autor: Área de Programación UQ
Fecha: Abril 2024
Licencia: GNU GPL v3
"""

from apoyo import ingresar_entero_rango, mostrar_mensaje


VALOR_MINIMO = 0
VALOR_MAXIMO = 100


def main():
    puntuacion = ingresar_entero_rango(
        "Ingrese la puntuacion: ", VALOR_MINIMO, VALOR_MAXIMO)
    determinar = determinar_aceptacion(puntuacion)
    mensaje = generar_mensaje(determinar)
    mostrar_mensaje(mensaje)


def determinar_aceptacion(puntuacion):
    if puntuacion >= 75:
        mensaje = "ACEPTADO"
    else:
        mensaje = "RECHAZADO"

    return mensaje


def generar_mensaje(determinar):
    mensaje = f"Su puntaje ha sido {determinar}"
    return mensaje


main()
