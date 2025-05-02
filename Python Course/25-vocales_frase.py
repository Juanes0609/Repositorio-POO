"""
Programa que indique si se usan 
todas la vocales en una frase
Autor: Área de Programación UQ
Fecha: Abril 2024
Licencia: GNU GPL v3
"""

from apoyo import ingresar_texto, mostrar_mensaje, verificar_vocal


def main():
    frase = ingresar_texto("Ingrese la frase: ")
    vocales = vocales_empleadas(frase)
    mensaje = generar_mensaje(frase, vocales)
    mostrar_mensaje(mensaje)


def vocales_empleadas(frase):
    vocales = " "
    for vocal in "aeiou":
        if vocal not in frase:
            vocales = "NO"
        else:
            vocales = "SI"       
    return vocales



def generar_mensaje(frase, vocales):
    mensaje = f"La frase {frase}, {vocales} usa todas las vocales"
    return mensaje

main()