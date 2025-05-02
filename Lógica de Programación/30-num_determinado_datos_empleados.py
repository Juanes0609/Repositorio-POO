"""
Programa que lee e imprime datos del empleado
Autor: Área de Programación UQ
Fecha: Mayo 2024
Licencia: GNU GPL v3

"""


from apoyo import ingresar_entero, ingresar_empleado, convertir_empleado_mensaje, mostrar_mensaje


def main():
    numero_empleados = ingresar_entero("Ingrese el número de empleados: ")
    empleados = ingresar_empleados("Ingrese los datos de los empleados: ", ingresar_empleado, numero_empleados)
    mensaje = convertir_empleados_mensaje(empleados)
    mostrar_mensaje (mensaje)


def ingresar_empleados(mensaje_global, mensaje_empleado, cantidad_empleados):
    mostrar_mensaje(mensaje_global)
    empleados = []
    for numero_empleado in range (0, cantidad_empleados):
        empleado = ingresar_empleado(f"{mensaje_empleado}, N° {numero_empleado + 1}")
        empleados.append(empleado)
    return empleados


def convertir_empleados_mensaje(empleados):
    mensaje = ""
    for empleado in empleados:
        mensaje += convertir_empleado_mensaje(empleado)
    return mensaje


main()