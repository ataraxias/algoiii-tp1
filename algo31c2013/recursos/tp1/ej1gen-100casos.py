#!/usr/bin/python

from random import randint
from random import seed
from itertools import permutations

def main():
    seed()
    for i in xrange(1, 100):
        a = gen_test(7)
        if tiemposolve(a) != tiempo(solve2(a)):
            print a
            return

def tiemposolve(ls):
    return min([tiempo(perm) for perm in permutations(ls)])

def tiempo(ls):
    ta = 0
    tmax = 0
    for i in xrange(len(ls)):
        c, p = ls[i]
        ta += c
        tp = ta + p
        if tp > tmax:
            tmax = tp
    return tmax

def solve2(ls):
    return sorted(ls, cmp=lambda x, y: cmp(y[1], x[1]))

def solve(ls):
    mnum = 10000000
    ml = []
    for perm in permutations(ls):
        tmp = tiempo(perm)
        if tmp < mnum:
            mnum = tmp
            ml = []
            for k in perm:
                ml.append(k)
    return ml

def gen_test(n):
    MAX = 100
    cs = [randint(1, MAX) for x in xrange(n)]
    ps = [randint(1, MAX) for x in xrange(n)]

    return zip(cs, ps)


if __name__ == "__main__":
    main()
