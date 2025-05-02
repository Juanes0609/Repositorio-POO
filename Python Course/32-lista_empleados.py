
def buscar_empleados(empleados, nombres_interes, apellidos_interes):
    empleado_interes = None
    for empleado in empleados:
        nombres = empleado [1]
        apellidos = empleado [2]
        if nombres == nombres_interes and apellidos == apellidos_interes:
            empleado_interes = empleado
            
    return empleado_interes
    
    

