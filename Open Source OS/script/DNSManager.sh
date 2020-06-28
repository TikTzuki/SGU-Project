#!/bin/bash

findIp2 () {
read -p "Nhap ip can tim" ip
grep -q $ip data.txt
if [ $? -eq 0 ]
then
	return 1	
else
	return 0
fi
}

findIp2
if [ $? -eq 0 ]
then
	read -p "Nhap ten mien" domain
	echo $ip" "$domain >>data.txt
	icho "file data"
	while IFS= read -r line
	do
		echo $line
	done <data.txt
else
	while read line
	do
		echo $ip
		echo $line
		if [[ $line == *$ip* ]]
		then
			IFS=' '
			read -a strarr <<< "$line"
			domainAv=${strarr[1]}
		fi
	done <data.txt
	echo "Ten mien tuong ung $domainAv"
fi

