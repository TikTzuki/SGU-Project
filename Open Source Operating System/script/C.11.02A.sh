#!/bin/bash
clear

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
        echo "Prime number: $i"
    fi

    if isSquare $i; then
        echo "Square number: $i"
    fi
done