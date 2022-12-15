/*
Scrivere un programma che legga da standard input un numero in base 10 n e la nuova base b in cui n dovrà essere convertito

	e stami a video il risultato della conversione.

Oltre alla funzione main(), il programma deve definire e utilizzare:

una funzione convert10ToBaseX(n, b uint) (string, bool) che riceve in input due valori uint corrispondenti al numero in base
10 da convertire n e la base di arrivo b. La funzione restituisce il valore convertito in base b sotto forma di stringa
(i valori oltre la base 10 contengono delle lettere) e un booleano. Se la base non è nell'intervallo 2 <= b <= 16 la funzione

	ritornerà "",false

Suggerimento: l'algoritmo di conversione si basa sui resti della divisione di n per b, che rappresentano le cifre del

	risultato della conversione

si ricordi che se b > 10 si dovranno usare delle lettere
Assumendo che base sia al più 16, l'insieme delle possibili cifre sarà: "0123456789ABCDEF"
*/
package main

import "fmt"

func main() {
	fmt.Println(convert10ToBaseX(31, 16))
}

func convert10ToBaseX(n, b uint) (string, bool) {
	if b < 2 || b > 16 {
		return "", false
	}
	arr := []string{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"}
	resto := n % b
	n = n / b
	result := ""
	//fmt.Println(resto)

	for resto != 0 {
		result = arr[resto] + result
		//fmt.Println(resto)
		resto = n % b
		n = n / b

	}
	return result, true
}
