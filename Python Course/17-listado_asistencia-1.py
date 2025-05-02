"""
Programa que genera un listado para firmar, comenzando y terminando con un valor indicado.
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3

"""

from apoyo import ingresar_entero_mayor_que, mostrar_mensaje

VALOR_INICIAL = 0


def main():
    valor_inicial = ingresar_entero_mayor_que(
        "Ingrese el valor inicial: ", VALOR_INICIAL)
    valor_final = ingresar_entero_mayor_que(
        "Ingrese el valor final: ", valor_inicial)
    listado = generar_listado(valor_inicial, valor_final)
    mostrar_mensaje(listado)


def generar_listado(valor_inicial, valor_final):
    listado = ""
    for i in range(valor_inicial, valor_final+1):
        listado += f"{i:2d}.______________________________________\n"
    return listado


# def generar_listado2(valor_inicial, valor_final):
    listado = ""
    i = valor_inicial
    while i <= valor_final:
        listado += f"{i:2d}._______________________________________\n"
        i = i + 1
    return listado


main()
