#!/bin/bash
clear
read -p "Please enter a text: " txt

echo "\nYour text in upper case: `echo $txt | tr -s '[:lower:]' '[:upper:]'`.\n"