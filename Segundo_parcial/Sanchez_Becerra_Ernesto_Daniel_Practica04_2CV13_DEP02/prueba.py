import pandas as pd

nfa = {}
n = int (input("Ingrese el numero de estados: "))
t = int(input("Ingrese de caminos: "))

for i in range(n):
    state = input("Ingrese el nombre del estado: ")
    nfa[state] = {}
    for j in range(t):
        path = input("Introduce el camino a seguir: ")
        print("Ingrese el estado final desde el estado {} por el camino {}: " .format(state,path))
        reaching_state = [x for x in input().split()]
        nfa[state][path] = reaching_state

print("\nImpresion del AFN tabulado:")
nfa_table = pd.DataFrame(nfa)
print(nfa_table.transpose())