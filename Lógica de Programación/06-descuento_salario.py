"""
Progrma que calcula el salario neto de un empleado
considerando los descuentos por salud y pensión 
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3

"""


from apoyo import ingresar_entero, mostrar_mensaje


PORCENTAJE_DESCUENTO_SALUD = 0.04
PORCENTAJE_DESCUENTO_PENSION = 0.05
SUBSIDIO_TRANSPORTE = 250000
SALARIO_INICIAL_SUBSIDIO = 1000000
SALARIO_FINAL_SUBSIDIO = 2000000

def main():
    salario = ingresar_entero("Ingrese el salario base del empleado: ")
    descuento_salario = calcular_descuento (salario)
    salario_neto = calcular_salario_neto (salario, descuento_salario)
    mensaje = generar_mensaje (salario_neto, descuento_salario)
    mostrar_mensaje(mensaje)


def calcular_descuento(salario):
    descuento = salario * (PORCENTAJE_DESCUENTO_SALUD+PORCENTAJE_DESCUENTO_PENSION)
    return descuento


def calcular_salario_neto(salario, descuento_salario):
    salario_neto = salario - descuento_salario
    return salario


def generar_mensaje(salario_neto, descuento_salario):
    mensaje = (f"El descuento a aplicar es {descuento_salario}"
               f" y el salario neto a pagar es {salario_neto}"
               
)
    if salario_neto >= SALARIO_INICIAL_SUBSIDIO and salario_neto <= SALARIO_FINAL_SUBSIDIO:
        mensaje += f" más un subsidio de transporte por {SUBSIDIO_TRANSPORTE}"

    return mensaje



main()