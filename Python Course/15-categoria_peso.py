"""
Programa que calcula el promedio
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3

"""


from apoyo import ingresar_entero, ingresar_real, calcular_promedio, mostrar_mensaje


def main():
    edad1 = ingresar_entero("Ingrese la edad del estudante 1: ")
    peso1 = ingresar_real("Ingrese el peso del estudiante 1 en kg: ")
    edad2 = ingresar_entero("Ingrese la edad del estudante 2: ")
    peso2 = ingresar_real("Ingrese el peso del estudiante 2 en kg: ")
    edad3 = ingresar_entero("Ingrese la edad del estudante 3: ")
    peso3 = ingresar_real("Ingrese el peso del estudiante 3 en kg: ")
    edad4 = ingresar_entero("Ingrese la edad del estudante 4: ")
    peso4 = ingresar_real("Ingrese el peso del estudiante 4 en kg: ")
    edad5 = ingresar_entero("Ingrese la edad del estudante 5: ")
    peso5 = ingresar_real("Ingrese el peso del estudiante 5 en kg: ")
    promedio_edad = calcular_promedio(edad1, edad2, edad3, edad4, edad5)
    promedio_peso = calcular_promedio(peso1, peso2, peso3, peso4, peso5)
    categoria_peso = determinar_categoria_peso(promedio_peso)
    mensaje = generar_mensaje(promedio_edad, categoria_peso)
    mostrar_mensaje(mensaje)


def determinar_categoria_peso(promedio_peso):
    if promedio_peso <50:
        mensaje = "muy delgado"
    elif promedio_peso >=50 and promedio_peso <= 60:
        mensaje = "delgado"
    elif promedio_peso >= 61 and promedio_peso <= 80:
        mensaje = "peso normal"
    elif promedio_peso >= 81 and promedio_peso <= 100:
        mensaje = "sobrepeso"
    else:
        mensaje = "obesidad"

    return mensaje


def generar_mensaje(promedio_edad, categoria_peso):
    mensaje = f"El promedio de edades es de {promedio_edad}\ny la categoría de peso es {categoria_peso}"
    return mensaje


main()