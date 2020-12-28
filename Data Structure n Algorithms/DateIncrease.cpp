#include <stdio.h>
#include <iostream>
#include <math.h>

void dateIncrease(int k, int date, int month, int year );
void dateDecrease(int k, int date, int month, int year );
bool isLeapYear(int year);

int main(){
    int i=0, k[50], date, month, year;
    
    printf("Nhap ngay thang nam: \nNgay:");
    scanf("%d", &date);
    printf("Nhap thang:");
    scanf("%d", &month);
    printf("Nhap nam:");
    scanf("%d", &year);
    
    while(1){
    	printf("Nhap so ngay tang:");
    	scanf("%d", &k[i]);
    	if(k[i]==0)
    		break;
    	i++;
	}
	
	for(int j=0; j<i; j++){
		if(k[j]>0)
			dateIncrease(k[j],date,month,year);
		if(k[j]<0)
			dateDecrease(k[j],date,month,year);
	}
    
}

void dateIncrease(int k, int date, int month, int year ){
    int yearsInc = k/366, dateInc = k%366;
    if(yearsInc !=0){
        for(int i=0; i<yearsInc; i++){
            year++;
            if(!isLeapYear(year)){
                dateInc+=1;
            }
        }
    }
    int monthInc = dateInc/31;
    dateInc = dateInc%31;
    if(monthInc !=0){
        for(int i=0; i<monthInc; i++){
            month++;
            if(month==13)
                month=1;
            if(month==4 || month==6 || month==9 || month==11)
                dateInc+=1;
            if(month==2)
                dateInc+=2;
        }
    }

    date+=dateInc;
    if(month==2 && date>28 && !isLeapYear(year)){
        date-=28;
        month++;
    }
    if(month==2 && date>29 && isLeapYear(year)){
        date-=29;
        month++;
    }
    if(date>30 && (month==4 || month==6 || month==9 || month ==11)){
        date-=30;
        month++;
    }
    if(date>31 && (month==1 || month==3 || month==5 || month ==7 || month==8 || month==10 || month==12)){
        date-=31;
        month++;
    }
    printf("%d-%d-%d \n", date, month, year);
}

void dateDecrease(int k, int date, int month, int year ){
    int yearsDec = abs(k)/366, dateDec = abs(k)%366;
    if(yearsDec !=0){
        for(int i=0; i<yearsDec; i++){
            year--;
            if(!isLeapYear(year)){
                dateDec+=1;
            }
        }
    }
    int monthDec = dateDec/31;
    dateDec = dateDec%31;
    if(monthDec !=0){
        for(int i=0; i<monthDec; i++){
            month--;
            if(month==0)
                month=12;
            if(month==4 || month==6 || month==9 || month==11)
                dateDec+=1;
            if(month==2)
                dateDec+=2;
        }
    }

    date-=dateDec;
	if(date<=0){
		month -= 1;
		if(month==2){
			if(isLeapYear(year))
				date = 29 - (-date);
			if(!isLeapYear(year))
				date = 28 - (-date);
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
			date = 31 - (-date);
		if(month==4 || month==6 || month==9 || month==11)
			date = 30 - (-date);
	}
    printf("%d-%d-%d \n", date, month, year);
}

bool isLeapYear(int year){
    if(year%4 == 0 && year%100 != 0 || year%400 == 0){
        return true;
    }
    return false;
}

