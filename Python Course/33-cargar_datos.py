"""
Programa que carga un conjunto de datos predeterminados
Autor: Área de Programación UQ
Fecha: Mayo 2024
Licencia: GNU GPL v3
"""

from apoyo import mostrar_mensaje, convertir_empleados_mensaje

EDAD_MINIMA = 30

def main():
    empleados = cargar_empleados()
    empleados_interes = filtrar_empleados_menores(empleados, EDAD_MINIMA)
    promedio_salario = calcular_promedio_salario(empleados_interes)
    mensaje = generar_mensaje(empleados_interes, promedio_salario)
    mostrar_mensaje(mensaje)


def cargar_empleados():
    empleados = [("3021", "Diana", "Jaramillo", 23, 1700000), ("4086", "Luisa", "Giraldo",
    28, 3200000), ("5039", "Ana", " Montes", 34, 4500000), ("6712", "Sofía", "Tamayo", 25, 2300000), ("8001", "Carolina", "Rivera", 39, 5200000)]
    return empleados


def filtrar_empleados_menores(empleados, edad_minima):
    empleados_interes = []
    for empleado in empleados:
        edad = empleado [3]
        if edad < edad_minima:
            empleados_interes.append(empleado)
    return empleados_interes


def calcular_promedio_salario(empleado_interes):
    promedio = 0.0
    for empleado in empleado_interes:
        salario = empleado [4]
        promedio += salario
    promedio /= len(empleado_interes)
    return promedio


# def calcular_promedio_salarios_mayores_30(empleados, edad_minima):
#     promedio = 0
#     cantidad_empleados = 0
#     for empleado in empleados:
#         edad = empleado [3]
#         if edad > edad_minima:
#             salario = empleado [4]
#             promedio += salario
#             cantidad_empleados += 1
#     promedio /= len(cantidad_empleados)
#     return promedio


def generar_mensaje(empleados_interes, promedio_salario):
    mensaje = f"{empleados_interes}\n {promedio_salario}"
    return mensaje


main()
