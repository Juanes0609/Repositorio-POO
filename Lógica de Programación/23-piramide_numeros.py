"""
Programa que permita generar una piramide con los numeros
Autor: Área de Programación UQ
Fecha: Abril 2024
Licencia: GNU GPL v3
"""

from apoyo import ingresar_entero_rango, mostrar_mensaje


VALOR_MINIMO = 1
VALOR_MAXIMO = 10


def main():
    valor = ingresar_entero_rango(
        "Ingrese un valor entre 1 y 10: ", VALOR_MINIMO, VALOR_MAXIMO)
    piramide = generar_piramide(valor)
    mensaje = generar_mensaje(piramide)
    mostrar_mensaje(mensaje)


def generar_piramide(valor):
    salida = ""
    for i in range(1, valor+1):
         salida += f"{i}" * i + "\n"
    return salida


def generar_mensaje(piramide):
    mensaje = f"{piramide}"
    return mensaje


main()
