"""
Progrma que calcula la cantidad de rollo de fibra óptica
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3

"""

from apoyo import ingresar_entero, mostrar_mensaje

MAX_METROS_ROLLOS = 50


def main():
    metros_vendidos = ingresar_entero("ingrese los metros vendidos de fibra: ")
    cantidad_rollos = calcular_cantidad_rollos(metros_vendidos)
    cantidad_adicional_fibra = calcular_cantidad_adicional_fibra(metros_vendidos)
    mensaje = generar_mensaje(cantidad_rollos, cantidad_adicional_fibra)
    mostrar_mensaje(mensaje)


def calcular_cantidad_rollos(metros_vendidos):
    cantidad_rollos = metros_vendidos // MAX_METROS_ROLLOS
    return cantidad_rollos


def calcular_cantidad_adicional_fibra(metros_vendidos):
    cantidad_adicional_fibra = MAX_METROS_ROLLOS - metros_vendidos % MAX_METROS_ROLLOS
    return cantidad_adicional_fibra


def generar_mensaje(cantidad_rollos, cantidad_adicional_fibra):
    mensaje = f"La cantidad de rollos es {cantidad_rollos}"

    if cantidad_adicional_fibra != MAX_METROS_ROLLOS:
        mensaje += f" y necesita {cantidad_adicional_fibra} de metros para completar otro rollo"
    return mensaje



main()