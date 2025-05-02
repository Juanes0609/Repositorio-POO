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
    dibujo = ""
    for i in range (0, n):
        for j in range (0, n):
            dibujo += " * "
        dibujo += "\n"

    return dibujo


main()

