# UML — Cajero Automático

## Clases identificadas
- Billete: valor, cantidad
- Monedero: saldo, listaBilletes (7 tipos: 500,200,100,50,20,10,5)
- CajeroAutomatico: referencia 0..1 a Monedero

## Relaciones
- [CajeroAutomatico] --tiene--> [Monedero]   (composición 0..1)
- [Monedero] --tiene--> [Billete]            (composición 1..7)

## Notas de diseño
- calcularBilletes() usa algoritmo greedy (mayor a menor denominación)
- Array de resultado: posición = [500, 200, 100, 50, 20, 10, 5]
- Respetar la cantidad disponible de cada tipo de billete
