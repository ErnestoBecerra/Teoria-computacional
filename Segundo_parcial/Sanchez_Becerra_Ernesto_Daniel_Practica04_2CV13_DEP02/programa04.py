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

print("\nImprimir el AFN tabulado:")
nfa_table = pd.DataFrame(nfa)
print(nfa_table.transpose())

print("Ingrese el estado de aceptacion del AFD: ")
nfa_final_state = [x for x in input().split()]

new_state_list = []
dfa = {}
keys_list = list(list(nfa.keys())[0])
path_list = list(nfa[keys_list[0]].keys())

############################################
dfa[keys_list[0]] = {}
for y in range(t):
    var = "".join(nfa[keys_list[0]][path_list[y]])
    dfa[keys_list[0]][path_list[y]] = var
    if var not in keys_list:
        new_state_list.append(var)
        keys_list.append(var)

###############################################
while len(new_state_list) != 0:
    dfa[new_state_list[0]] = {}
    for _ in range(len(new_state_list[0])):
        for i in range(len(path_list)):
            temp = []
            for j in range(len(new_state_list[0])):
                temp += nfa[new_state_list[0][j]][path_list[i]]
            s = ""
            s = s.join(temp)
            if s not in keys_list:
                new_state_list.append(s)
                keys_list.append(s)
            dfa[new_state_list[0]][path_list[i]] = s

    new_state_list.remove(new_state_list[0])

###################################################
print("\nImprimir AFD tabulado")
dfa_table = pd.DataFrame(dfa)
print(dfa_table.transpose())

dfa_state_list = list(dfa.keys())
dfa_final_states = []
for x in dfa_state_list:
    for i in x:
        if i in nfa_final_state:
            dfa_final_states.append(x)
            break
print("\nEstados de aceptacion del AFD nuevo: ", dfa_final_states)
