#!/bin/sh/
read -p "nhap so nguyen duong" num
let num1=num
while [ $num != $num1 ]
do
	echo "num = $num"
	echo "num1 =  $num1"
	read -p 'Nhap sai"\n"Nhap lai' num
	let num1=num
done
echo "obase=2; $num" | bc
