"""
Programa que muestra un mensaje dependiendo de la definitiva del estudiante
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3

"""

from apoyo import ingresar_real, mostrar_mensaje, calcular_promedio_ponderado


def main():
    nota1 = ingresar_real("Ingrese el valor de la nota 1: ")
    nota2 = ingresar_real("Ingrese el valor de la nota 2: ")
    nota3 = ingresar_real("Ingrese el valor de la nota 3: ")
    nota4 = ingresar_real("Ingrese el valor de la nota 4: ")
    definitiva = calcular_promedio_ponderado(nota1, nota2, nota3, nota4)
    mensaje = generar_mensaje(definitiva)
    mostrar_mensaje(mensaje)


def generar_mensaje(definitiva):
    mensaje = f"La nota definitiva es {definitiva}"
    if definitiva <= 2.9:
        mensaje += ", podemos mejorar"
    elif definitiva <= 3.5:
        mensaje += ", ya estamos cerca"
    elif definitiva <= 4.7:
        mensaje += ", muy bien"
    else:
        mensaje += ", excelente"

    return mensaje


main()
