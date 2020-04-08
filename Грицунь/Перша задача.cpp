#pragma hdrstop
#pragma argsused

#ifdef _WIN32
#include <tchar.h>
#else
  typedef char _TCHAR;
  #define _tmain main
#endif

#include <stdio.h>
#include <windows.h>
#include <iostream.h>
#include <ctime.h>

// ПП-11
// Грицунь Ярослав
// Варіант 4 (7)
// Перша задача

bool check (int *a, int z, int h){
	for (int i = 0; i < z; i++) {
		if(h%a[i] != 0) {
			return false;
		}
	}
	return true;
}

bool check2 (int *a, int z, int h){
	for (int i = 0; i < z; i++) {
		if(a[i]%h != 0) {
			return false;
		}
	}
	return true;
}

 int _tmain(int argc, _TCHAR* argv[])
{
	SetConsoleOutputCP(1251);
	cout<<"Уведіть розмірності масивів m i n з нових рядків"<<endl;
	int rozmn, rozmm;
	cin>>rozmm;
	cin>>rozmn;
	if((rozmm >10 || rozmm < 1)||(rozmn>10 || rozmn <1)) {
		cout<<"Наступного разу введіть  розмірності від 1 до 10"<<endl;
		system("pause");
		return 0;
	}
	int *m = new int [rozmm];
	int *n = new int [rozmn];
	cout<<"Оберіть спосіб заповнення масивів. Уведіть 1 для заповнення вручну, введіть 2 для заповнення автоматично"<<endl;
	int inp;
	cin >> inp;
	if(inp == 1){
		cout<<"Розпочинайте введення елементів масиву m з нових рядків:"<<endl;
		for (int i = 0; i < rozmm; i++) {
			cin>>m[i];
		}
		cout<<"Розпочинайте введення елементів масиву n з нових рядків:"<<endl;
		for (int i = 0; i < rozmn; i++) {
			cin>>n[i];
		}
	} else if (inp == 2) {
		cout<<"Згенеровані елементи масиву m:"<<endl;
		for (int i = 0; i < rozmm; i++) {
			if(i == rozmm - 1){ m[i] = rand()%51; cout<<m[i]<<endl;}
			else{
				m[i] = rand()%101;
				cout<<m[i]<<endl;
			}
		}
		cout<<"Згенеровані елементи масиву n:"<<endl;
		for (int i = 0; i < rozmn; i++) {
			if(i == rozmn - 1){ n[i] = rand()%51+50; cout<<n[i]<<endl;}
			else{
				n[i] = rand()%101;
				cout<<n[i]<<endl;
			}
		}
	}
	if(!(n[0] >=  m[rozmm-1])){
		cout<<"Помилка. Останній елемент масиву m має бути меншим за перший елемент масиву n"<<endl;
	}

	int rozmk = n[0] - m[rozmm-1] + 1;
	int *k = new int [rozmk];


	for(int p = 0, i = m[rozmm-1]; i<=n[0]; i++, p++){
	   k[p] = i;
	}

	cout<<endl<<"Розв'язок задачі:"<<endl;
	for(int i = 0; i < rozmk; i++){
			int u = k[i];
			if(check(m, rozmm, u) && check2(n, rozmn, u)){
				cout<<k[i]<<endl;
			}
	}
	system("pause");
	return 0;
}
