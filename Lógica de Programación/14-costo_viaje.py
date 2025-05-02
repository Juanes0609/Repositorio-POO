"""
Programa que calcule el costo del viaje, según el medio de transporte
y kilómetros recorridos
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3

"""


from apoyo import ingresar_real, ingresar_texto, mostrar_mensaje


def main():
    transporte = ingresar_texto(
        "Ingrese el medio de transporte: ").capitalize()
    kilometros = ingresar_real(
        "Ingrese la cantidad de kilómetros recorridos: ")
    determinar_transporte = determinar_medio_transporte(transporte)
    costo_viaje = calcular_costo_viaje(determinar_transporte, kilometros)
    mensaje = generar_mensaje(costo_viaje, transporte, kilometros)
    mostrar_mensaje(mensaje)


def determinar_medio_transporte(transporte):
    if transporte == "Tren":
        costo = 2000
    else:
        costo = 5000

    return costo


def calcular_costo_viaje(determinar_transporte, kilometros):
    costo_viaje = determinar_transporte * kilometros
    return costo_viaje


def generar_mensaje(costo_viaje, transporte, kilometros):
    mensaje = (f"""El costo total del viaje es de ${costo_viaje}, si 
el medio de transporte es {transporte} y los 
kilómetros a recorrer son {kilometros}
""")
    
    return mensaje


main()
