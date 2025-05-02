"""
Programa que muestra un mensaje según una nota final
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3

"""

from apoyo import mostrar_mensaje, ingresar_real_rango


NOTA_MINIMA = 0.0
NOTA_MAXIMA = 5.0
NOTA_MINIMA_GANAR = 3.0


def main():
    nota_final = ingresar_real_rango(
        "Ingrese la nota final: ", NOTA_MINIMA, NOTA_MAXIMA)
    mensaje = generar_mensaje(nota_final)
    mostrar_mensaje(mensaje)


def generar_mensaje(nota_final):
    mensaje = f"Con la nota {nota_final:.1f} usted "
    if nota_final <= NOTA_MINIMA_GANAR:
        mensaje += "REPROBÓ el curso"
    else:
        mensaje += "APROBÓ el curso"

    return mensaje


main()
