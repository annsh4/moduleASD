// ПП-11
// Ярченко Михайло
// Варіант 3 (22)

#include <iostream>
#include <iomanip>
#include <Windows.h>
#include <string>
#include <cstdlib>
#include <ctime>
#include <cmath>

using namespace std;

int readInt(string _msg, bool _isUnsigned, bool _isNull);
string readCommand();
void displayMatrix(int** matrix, int size);
void memoryAlloc(int** arr, int size);
void initialize(int** arr, int size, bool isUnsigned);
void initialize(int* arr, int size, bool isUnsigned);
int processData1(int** arr, int size);
void processResults(int* arr, int size);

int main()
{
	srand(time(0));
	int n = readInt("1. Enter a side of a square matrix: ", true, true);

	int** matrix = new int* [n];
	memoryAlloc(matrix, n);

	initialize(matrix, n, false);
	displayMatrix(matrix, n);
	
	int res = processData1(matrix, n);
	cout << "\nAnswer: "<< res << endl << endl;

	n = readInt("2. Enter a number of games: ", true, true);
	int* results = new int[n];
	initialize(results, n, true);
	processResults(results, n);

    return 0;
}

void displayMatrix(int** matrix, int size)
{
	if (size == 1)
	{
		cout << "\n{" << matrix[0][0] << "}\n";
		return;
	}
	for (int i = 0; i < size; i++)
	{
		if (i == 0)
		{
			cout << "\n/ ";
			for (int j = 0; j < size; j++)
			{
				cout << setw(6) << matrix[i][j] << " ";
			}
			cout << "\\\n";
		}
		else if (i == size - 1)
		{
			cout << "\\ ";
			for (int j = 0; j < size; j++)
			{
				cout << setw(6) << matrix[i][j] << " ";
			}
			cout << "/\n";
		}
		else
		{
			cout << "| ";
			for (int j = 0; j < size; j++)
			{
				cout << setw(6) << matrix[i][j] << " ";
			}
			cout << "|\n";
		}
	}
}

int readInt(string _msg, bool isUnsigned, bool isNotNull)
{
	int _int = 0;

	while (true)
	{
		cout << _msg;

		if (isUnsigned && isNotNull)
		{
			if (!(cin >> _int) || (_int <= 0))
			{
				cout << "Not a number or it is not positive.\n";
				cin.clear();
				cin.ignore(10000, '\n');
			}

			else break;
		}

		else if (isUnsigned)
		{
			if (!(cin >> _int) || (_int < 0))
			{
				cout << "Not a number or it is negative.\n";
				cin.clear();
				cin.ignore(10000, '\n');
			}

			else break;
		}

		else if (isNotNull)
		{
			if (!(cin >> _int) || (_int == 0))
			{
				cout << "Not a number.\n";
				cin.clear();
				cin.ignore(10000, '\n');
			}

			else break;
		}

		else
		{
			if (!(cin >> _int))
			{
				cout << "Not a number.\n";
				cin.clear();
				cin.ignore(10000, '\n');
			}

			else break;
		}
	}

	return _int;
}

void memoryAlloc(int** arr, int size)
{
	for (int i = 0; i < size; i++)
	{
		arr[i] = new int[size];
	}
}

string readCommand()
{
	string _string = "";

	while (true)
	{
		cout << "Enter 'r' or 'rand' or 'random' to choose random initialization.\n";
		cout << "Enter 'm' or 'manual' to choose manual initialization.\n";
		cout << "Enter 'e' or 'x' or 'exit' to exit the program.\n";

		if (!(cin >> _string) || (_string != "r"
			&& _string != "m"
			&& _string != "e"
			&& _string != "x"
			&& _string != "rand"
			&& _string != "random"
			&& _string != "manual"
			&& _string != "exit"))
		{
			cout << "Not a command.\n";
			cin.clear();
			cin.ignore(10000, '\n');
		}

		else break;
	}

	return _string;
}

void initialize(int** arr, int size, bool isUnsigned)
{
	string command;
	command = readCommand();

	if (command == "m" || command == "manual")
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (isUnsigned)
				{
					arr[i][j] = readInt("", true, false);
				}

				else
				{
					arr[i][j] = readInt("", false, false);
				}
			}
		}
	}

	else if (command == "r" || command == "rand" || command == "random")
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (isUnsigned)
				{
					arr[i][j] = rand() % 100;
				}

				else
				{
					arr[i][j] = rand() % 200 - 100;
				}
			}
		}
	}

	else if (command == "x" || command == "exit")
	{
		exit(0);
	}
}

void initialize(int* arr, int size, bool isUnsigned)
{
	string command;
	command = readCommand();

	if (command == "m" || command == "manual")
	{
		for (int i = 0; i < size; i++)
		{
			if (isUnsigned)
			{
				arr[i] = readInt("", true, false);
			}

			else
			{
				arr[i] = readInt("", false, false);
			}
		}
	}

	else if (command == "r" || command == "rand" || command == "random")
	{
		for (int i = 0; i < size; i++)
		{
			if (isUnsigned)
			{
				arr[i] = rand() % 1000;
			}

			else
			{
				arr[i] = rand() % 2000 - 1000;
			}
		}
	}

	else if (command == "x" || command == "exit")
	{
		exit(0);
	}
}

int processData1(int** arr, int size)
{
	int sum1 = 0, sum2 = 0;
	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size; j++)
		{
			if (i == j)
			{
				sum1 += arr[i][j];
			}
			else if (i == (size - j - 1))
			{
				sum2 += arr[i][j];
			}
		}
	}
	return fabs(sum1 - sum2);
}

void processResults(int* arr, int size)
{
	int* worst = new int[size];
	int* best = new int[size];
	int counterWorst = 0;
	int counterBest = 0;

	for (int i = 0; i < size; i++)
	{
		if (i == 0)
		{
			worst[i] = arr[i];
			best[i] = arr[i];
			continue;
		}
		if (arr[i] < arr[i - 1])
		{
			worst[i] = arr[i];
			best[i] = best[i - 1];
			counterWorst++;
		}
		else if (arr[i] > arr[i - 1])
		{
			best[i] = arr[i];
			worst[i] = worst[i - 1];
			counterBest++;
		}
		else
		{
			best[i] = best[i - 1];
			worst[i] = worst[i - 1];
		}
	}
	cout << "-------------------------------------------------\n";
	cout << "| Play      | Result    | Best      | Worst     |\n";
	for (int i = 0; i < size; i++)
	{
		cout << "|-----------|-----------|-----------|-----------|\n";
		cout << "| " << setw(9) << i << " | " << setw(9) << arr[i];
		cout << " | " << setw(9) << best[i] << " | " << setw(9) << worst[i] << " |\n";
	}
	cout << "-------------------------------------------------\n";
	cout << "\nBest: " << counterBest << ";\n";
	cout << "\nWorst: " << counterWorst << ".\n";
}