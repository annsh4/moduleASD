#pragma hdrstop
#pragma argsused

#ifdef _WIN32
#include <tchar.h>
#else
  typedef char _TCHAR;
  #define _tmain main
#endif

#include <stdio.h>

#include <iostream.h>
#include <windows.h>
#include <iomanip.h>
#include <math.h>

// ПП-11
// Грицунь Ярослав
// Варіант 4 (7)
// Друга задача

int round(int num){
        if(num % 10 <= 2){
			return floor(num/10.0)*10;
		}
        else if(num % 10 <= 6){
			return ((floor(num / 10.0) + 0.5)*10);
		}
		else return (ceil(num/10.0))*10;
}


 int _tmain(int argc, _TCHAR* argv[])
{
	SetConsoleOutputCP(1251);
	int n = 0;
	cout << "Уведіть кількість оцінок цілим числом:\n";
	cin >> n;
	int *marks = new int [n];
	int *marksr = new int [n];
	cout << "Починайте уводити оцінки з нових рядків:\n";
	for(int i = 0; i < n; i++){
		cin>>marks[i];
	}
	for(int i = 0; i < n; i++){
		if(marks[i]>37){
		marksr[i] = round(marks[i]);
		}
		 if(marks[i] > 100){
			marksr[i]= 100;
		}   if(marks[i] <= 36)
		 {
			marksr[i] = marks[i];
		}
		if(marks[i] <=0){
        	marksr[i] = 1;
		}
	}
	
    cout << "----------------------------------------------------------\n";
	cout << "| № з/п     | Вхідний бал   | Результат округлення       |\n";
	cout << "|-----------|---------------|----------------------------|\n";

	for(int i = 0; i < n; i++){
			cout << "|" << setw(11) << i+1 << "|"  << setw(15)<< marks[i] << "|" << setw(28)<< marksr[i] << "|\n";
	}
	cout << "-----------------------------------------------------------\n";
	system("pause");
	return 0;
}
