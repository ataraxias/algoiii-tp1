#!/usr/bin/python
from random import randint

def main():
    entrada = open("ej1.in", "w")
    salida = open("ej1.out", "w")
    for i in xrange(100):
        i, o = gen_test(30, randint(1, 1000))
        entrada.write(' '.join(map(lambda x: str(x), i)) + "\n")
        salida.write(str(o) + "\n")
    entrada.write("#")

    entrada.close()
    salida.close()

#retorna una tupla con la forma (input, output)
def gen_test(n, k):
    MAX = 50
    p = [n, k]

    mediciones = []
    for i in xrange(n):
        num = randint(1, MAX)
        for j in xrange(k):
            mediciones.append((j * num, i + 1))
        p.append(num)

    mediciones.sort()

    q = mediciones[k - 1][1]
    return (p, q)

if __name__ == "__main__":
    main()
