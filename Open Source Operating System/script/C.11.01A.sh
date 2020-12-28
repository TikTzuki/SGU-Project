#!/bin/bash
clear
read -p "Please enter a number: " num

isPrime=0

if test $num -lt 2; then
    echo "\nThis is not a prime number.\n"
else
    for (( i = 2; i < num; i++ ))
    do
        if test `expr $num % $i` -eq 0; then
            echo "\nThis is not a prime number.\n"
            isPrime=1
            break
        fi
    done

    if test $isPrime -eq 0; then
        echo "\nThis is a prime number.\n"
    fi
fi