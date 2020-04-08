#include <iostream>

#include "task1/Matrix.h"

int main() {
    bool flag = false;
    int choice;
    do {
        std::cout << "\n_____________MENU______________" << '\n';
        std::cout << "1. Task #1" << '\n';
        std::cout << "2. Task #2" << '\n';
        std::cout << "0. Exit." << '\n';
        std::cin >> choice;
        ////    validation
        switch (choice) {
            case 1 : {
                int __choice, rows, columns;
                bool __flag = false, validationFlag = false;
                do {
                    std::cout << "Enter an amount of rows and columns of the matrix (rows, columns) : " << std::endl;
                    std::cin >> rows >> columns;
                    if (rows != columns) {
                        std::cout << "Wrong input! Rows and columns has to be the same!" << std::endl;
                    } else {
                        validationFlag = true;
                    }
                } while (!validationFlag);

                Matrix myMatrix(columns, rows);

                do {
                    std::cout << "\n_____________MENU______________" << '\n';
                    std::cout << "1. Fill the matrix (auto) " << '\n';
                    std::cout << "2. Fill the matrix (by yourself)" << '\n';
                    std::cout << "3. Display matrix and diagonal's difference." << '\n';
                    std::cout << "0. Exit." << '\n';
                    std::cin >> __choice;
//// validation
                    switch (__choice) {
                        case 1 : {
                            myMatrix.fillMatrixAuto(myMatrix);

                            break;
                        }
                        case 2 : {
                            int inputNumber;

                            std::cout << "Input your numbers in the matrix >" << std::endl;
                            for (int i = 0; i < rows; i++) {
                                for (int j = 0; j < columns; j++) {
                                    std::cout << "N[" << i+1 << ", " << j+1 << ']' << std::endl;
                                    std::cin >> inputNumber;

                                    myMatrix.fillMatrixByYourself(inputNumber, i, j, myMatrix);
                                }
                            }
                            std::cout << "\nYour matrix: " << myMatrix << std::endl;
                            break;
                        }
                        case 3 : {
                            std::cout << "Your matrix: " << std::endl;
                            std::cout << myMatrix << std::endl;
                            std::cout << "Diagonal's difference :" << myMatrix.calculateDifference(myMatrix) << std::endl;
                            break;
                        }
                        case 0 : {
                            std::cout << "Ending the program.." << std::endl;
                            __flag = true;
                            break;
                        }
                        default: {
                            std::cout << "Wrong choice!" << std::endl;
                            break;
                        }
                    }
                } while (!__flag);
                break;
            }
            case 2 : {

            }
            case 0: {
                std::cout << "Ending the program.." << std::endl;
                flag = true;
                break;
            }
            default: {
                std::cout << "Wrong choice!" << std::endl;
                break;
            }
        }
    } while (!flag);
    return 0;
}