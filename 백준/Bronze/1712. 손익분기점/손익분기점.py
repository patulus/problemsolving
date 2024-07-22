val = input()
valList = val.split(' ')
valList = [int(x) for x in valList]

fixedCosts = valList[0]
variedCosts = valList[1]
itemCosts = valList[2]

if variedCosts >= itemCosts:
    print(-1)
else:
    print(f"{fixedCosts // (itemCosts - variedCosts) + 1}")