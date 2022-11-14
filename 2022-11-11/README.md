# 2022-11-11 esercitazione prog 2

## Contesto: Polinomi Sparsi

quando creaiamo  un nuovo tipo di dato ci preoccupiamo  di capire come rappresentarli 

prediamo un esempio

$$
x+7x^{42}+42x^{1000}
$$

dobbiamo pensare a come rappresentarlo a  livello di struttura di dati, useremo 2 array uno per  l'intero e uno per l'esponente

| C:  | 1   | 7   | 42   |
| --- | --- | --- | ---- |
| D:  | 1   | 42  | 1000 |

okay figo, si potrebbe fare anche fare una lista, ma per rendelo object oriented 

potremmo farlo con una lista di monomi :

Monomio(int coeff,int degree)

AF: $e\to A$

dove il dominio e sono i valori che possono essere inseriti come parametro all'interno del costruttore.

A invce è la struttura che  viene rappresentata dal nostro oggetto.

quindi:

$$
AF(c)=c.coeff*x^{c.degree}
$$

RI: $e\to\{T,F\}$

e per essere vero dobbiamo dire  che

$$
RI(c)=c.degree\ge 0 \\
c.coeff\neq 0
$$

Vediamo quindi i metodi:

- Costruttore(i)

- Metodi osservazionali

- toString,eqals,hashCode

potremmo usare una classe e fare così

```java
   private class Monomio {
        int degree;
        int coeff;
        public Monomio()
    }
```

ma  possiamo usare una nuova struttura fixx  

- [ ] 
