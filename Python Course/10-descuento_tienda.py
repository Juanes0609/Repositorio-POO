"""
Programa que calcula el porcentaje de descuento según el género y el día de nacimiento
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3

"""

from apoyo import ingresar_entero, ingresar_texto, mostrar_mensaje, ingresar_real


def main():
    genero = ingresar_texto("Ingrese el género al que pertenece: ").lower()
    dia = ingresar_entero("Ingrese el dia de nacimiento: ")
    valor_cuenta = ingresar_real("Ingrese el valor de la cuenta: ")
    porcentaje_descuento = determinar_porcentaje_descuento(genero, dia)
    valor_descuento = calcular_valor_descuento(valor_cuenta, porcentaje_descuento)
    valor_final = calcular_valor_final(valor_descuento, valor_cuenta)
    mensaje = generar_mensaje(valor_cuenta, porcentaje_descuento, valor_descuento, valor_final)
    mostrar_mensaje (mensaje)

def determinar_porcentaje_descuento(genero, dia):
    if genero == "mujer" and dia % 2 == 0:
            porcentaje = 0.1
    else:
        porcentaje = 0.07
    
        if genero == "hombre" and dia >= 3 and dia <=14 or dia >= 17 and dia <= 21:
                porcentaje = 0.1
        elif dia >= 1 and dia <= 2: 
                porcentaje = 0.1
        elif dia >= 15 and dia <= 16:
                porcentaje = 0.09
        else:
            porcentaje = 0.03

        return porcentaje


def calcular_valor_descuento(valor_cuenta, porcentaje_descuento):
    valor_descuento = valor_cuenta * porcentaje_descuento
    return valor_descuento


def calcular_valor_final(valor_descuento, valor_cuenta):
    valor_final = valor_cuenta - valor_descuento
    return valor_final


def generar_mensaje(valor_cuenta, porcentaje_descuento, valor_descuento, valor_final):
    mensaje = (f"""El valor de la cuenta es ${valor_cuenta}
El porcentaje de descuento es {porcentaje_descuento * 100}%
El valor del descuento es de ${valor_descuento}
El valor final del producto es de $ {valor_final}"""
                                              )

    return mensaje

    
main()