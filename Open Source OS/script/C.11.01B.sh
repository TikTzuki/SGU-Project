#!/bin/bash
clear
echo "Your number: $1"

isPrime=0

if test $1 -lt 2; then
    echo "\nThis is not a prime number.\n"
else
    for (( i = 2; i < $1; i++ ))
    do
        if test `expr $1 % $i` -eq 0; then
            echo "\nThis is not a prime number.\n"
            isPrime=1
            break
        fi
    done

    if test $isPrime -eq 0; then
        echo "\nThis is a prime number.\n"
    fi
fi