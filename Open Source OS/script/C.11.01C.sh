#!/bin/bash
clear
read -p "Please enter a number: " num

if test $num -lt 2; then
    echo "\nThis is not a prime number.\n"
    exit 0
fi

for (( i = 2; i < num; i++ ))
do
    if test `expr $num % $i` -eq 0; then
        echo "\nThis is not a prime number.\n"
        exit 0
    fi
done

echo "\nThis is a prime number.\n"