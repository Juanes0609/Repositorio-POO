"""
Programa que indica si el agua a una temperatura dada, puede o no hervir
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3

"""

from apoyo import mostrar_mensaje, ingresar_entero


HERVIR_AGUA = 100


def main():
    temperatura = ingresar_entero("Ingrese la temperatura del agua: ")
    agua = determinar_hervir_agua(temperatura, HERVIR_AGUA)
    mensaje = generar_mensaje(agua, temperatura)
    mostrar_mensaje(mensaje)


def determinar_hervir_agua(temperatura, HERVIR_AGUA):
    if temperatura >= HERVIR_AGUA:
        mensaje = "PUEDE hervir"
    else:
        mensaje = "NO puede hervir"
    return mensaje


def generar_mensaje(temperatura, agua):
    mensaje = f"La temperatura del agua es {agua} °C\nEl agua {temperatura}"
    return mensaje


main()
