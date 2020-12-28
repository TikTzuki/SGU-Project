#!/bin/bash
clear
read -p "Please enter a number: " num

mod=0
rev=0

while [ $num -gt 0 ];
do
    let mod=num%10
    let rev=rev*10+mod
    let num/=10
done

echo "\nYour number in reverse order: $rev.\n"