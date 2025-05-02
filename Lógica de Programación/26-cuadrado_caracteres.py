"""
Programa que permita generar una figura con un ciclo de repetición según n
Autor: Área de Programación UQ
Fecha: Abril 2024
Licencia: GNU GPL v3
"""

from apoyo import ingresar_entero_mayor_que, mostrar_mensaje

MINIMO_VALOR = 0


def main():
    n = ingresar_entero_mayor_que("Ingrese el valor de n: ", MINIMO_VALOR)
    dibujo = generar_dibujo(n)
    mostrar_mensaje(dibujo)


def generar_dibujo(n):
    dibujo = " * " * n + "\n"
    for j in range (1, n - 1):
        dibujo += " * " + "   " * (n-2) + " * \n"
    dibujo += " * " * n + " \n"


    return dibujo


def repetir_caracter(caracter, cantidad):
    mensaje = ""
    for i in range (0, cantidad):
        mensaje += caracter

    return mensaje

main()
