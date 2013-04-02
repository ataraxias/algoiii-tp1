#!/usr/bin/python

from random import randint

def main():
    entrada = open("ej3.in", "w")
    salidaBruta = open("ej3.bruteforce.out", "w")
    salida = open("ej3.out", "w")

    for i in xrange(100):
        n = randint(1, 50)
        b = randint(1, 100)
        h = randint(1, 100)

        puntos = gen_test(n)
        result = solveBrute(puntos, b, h)
        x, y = result["rectangulos"][0]

        fun = lambda x: str(x[0]) + " " + str(x[1])
        entrada.write("%d %d %d\n" % (n, b, h))
        entrada.write(' '.join(map(fun , puntos))  + "\n")
        salida.write("%d %d %d\n" % (x, y, result["maxPuntosContenidos"]))
        salidaBruta.write(' '.join(map(fun, result["rectangulos"]))  + "\n")

    entrada.write("#")

    entrada.close()
    salida.close()
    salidaBruta.close()



def gen_test(n):
    MAX = 100
    res = set()
    while len(res) < n:
        x = randint(0, MAX)
        y = randint(0, MAX)
        res.add((x, y))
    return list(res)

def solveBrute(puntos, base, altura):
    MAX = 100

    respuesta = {"rectangulos": [], "maxPuntoscontenidos": 0}

    maxCuenta = 0
    for x in xrange(0, MAX):
        for y in xrange(0, MAX):
            tmp = cuenta(x, y, puntos, base, altura)
            if tmp > maxCuenta:
                maxCuenta = tmp

    res = [(x, y) for x in xrange(0, MAX) for y in xrange(0, MAX) if cuenta(x, y, puntos, base, altura) == maxCuenta]

    respuesta["rectangulos"] = res
    respuesta["maxPuntosContenidos"] = maxCuenta
    return respuesta

def cuenta(x, y, puntos, base, altura):
    res = [punto for punto in puntos if x <= punto[0] <= x + base and y <= punto[1] <= y + altura]
    return len(res)

if __name__ == "__main__":
    main()
