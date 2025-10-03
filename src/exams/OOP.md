# Zadání testu

## Prerekvizity

- Data `hospitalData.txt`
- Třídy `Doktor`, `Surgeon`, `CardiacSurgeon`

### Popis souboru

- Name;Type;Procedure
    - **Name** -> Jméno doktora
    - **Type** -> Typ doktora (`Doctor` | `Surgeon` | `CardiacSurgeon`)
    - **Procedure** -> Zákroky, který se doktor snaží provést (ruzný počet na doktora)
      - `D - diagnose()` | `S - surgery()` | `C - cardiacSurgery()`

## Dílčí úkoly

1. Upravte konstruktor třídy `Doctor`, aby měl na začátku `salary = 25 000`

2. Upravte metody
    - `diagnose()` - přidá 10 000 k `salary`
    - `surgery()` - přidá 45 000 k `salary`
    - `cardiacSurgery()` - přidá 95 000 k `salary`

3. Nahrajte data ze souboru do rozumné kolekce. 
   - alternativně můžete zpracovávat po řádcích a rovnou provádět `4. krok`

4. Exportujte do nového souboru výplatu po provedení všech zákroků
    - Za každý zákrok, na který nemá doktor kvalifikaci, dostává pokutu `50 000`
    - Každý řádek souboru bude ve formátu `Name;Salary`

> - Příklad pro jeden řádek
> - `John;Surgeon;S;D;S;S;D;D;D;C;D`
> - Vytvoří se Surgeon se jménem `John`
> - Na začátku má 40 000
> - Provede zákroky S;D;S;S;D;D;D;C;D
>   - 3 x surgery() -> + 3 x 10 000
>   - 5 x diagnose() -> + 5 x 45 000
>   - 1 x cardiacSurgery() -> pokuta 50 000 za zákrok (odečte 50 000 ze salary)
> - Celkem = 245 000

5. Vypište do konzole doktora s největší a nejmenší `salary`