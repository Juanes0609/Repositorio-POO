"""
Programa que calcula el valor del servicio público domiciliario de agua
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3
"""

from apoyo import ingresar_entero, mostrar_mensaje


def main():
    valor_recibo = ingresar_entero ("Ingrese el valor del recibo: ")
    consumo = ingresar_entero ("Ingrese el consumo total de agua en metros cúbicos: ")
    porcentaje_aumento = determinar_porcentaje_aumento (consumo)
    aumento = calcular_aumento (consumo, porcentaje_aumento)
    mensaje = generar_mensaje (consumo,porcentaje_aumento, aumento)
    mostrar_mensaje(mensaje)


def determinar_porcentaje_aumento (consumo):
    if consumo <=9 and consumo >=1: 
         porcentaje_aumento = 0.15

    elif consumo <=15 and consumo >=13:
        porcentaje_aumento = 0.15
   
    elif consumo >=20 and consumo <= 28:
        porcentaje_aumento = 0.25
    
    else:
        porcentaje_aumento = 0.03
    
    return porcentaje_aumento


def calcular_aumento (consumo, porcentaje_aumento):
    aumento = consumo * porcentaje_aumento
    return aumento


def generar_mensaje (consumo, porcentaje_aumento, aumento):
    mensaje = (f"""El consumo de agua en metros cubicos fue de {consumo}
El porcentaje de aumento en el recibo es de {porcentaje_aumento}
El aumento total en su recibo es de {aumento}"""
)

    return mensaje

main()