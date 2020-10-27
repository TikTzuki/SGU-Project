#!/bin/bash
clear

primeIndex=0
squareIndex=0

isPrime() {
    if test $1 -lt 2; then
        return 1
    fi
    
    for (( j = 2; j < $1; j++ ))
    do
        if test `expr $1 % $j` -eq 0; then
            return 1
        fi
    done
    
    return 0
}

isSquare() {
    for (( k = 1; k*k <= $1; k++ ))
    do
        if test `expr $k \* $k` -eq $1; then
            return 0
        fi
    done

    return 1
}

read -p "Please enter a number: " num

for (( i = 1; i <= num; i++ ))
do
    if isPrime $i; then
        primeArray[$primeIndex]=$i
        let primeIndex++
    fi

    if isSquare $i; then
        squareArray[squareIndex]=$i
        let squareIndex++
    fi
done

printf "\nPrime numbers: "
for (( i = 0; i < primeIndex; i++ ))
do
    printf "${primeArray[$i]} "
done

printf "\nSquare numbers: "
for (( i = 0; i < squareIndex; i++ ))
do
    printf "${squareArray[$i]} "
done

echo "\n"