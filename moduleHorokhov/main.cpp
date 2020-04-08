#include <iostream>

#include "task1/Matrix.h"
#include "task2/FindLST.h"

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
                int __choice, firstArrCapacity, secondArrCapacity;
                bool __flag = false;
                std::cout << "Input capacity of the first array :" << std::endl;
                std::cin >> firstArrCapacity;
                std::cout << "Input capacity of the second array :" << std::endl;
                std::cin >> secondArrCapacity;
                if( firstArrCapacity > 10 || firstArrCapacity < 1 || secondArrCapacity > 10 || secondArrCapacity < 1){
                    std::cout << "Error" << std::endl;
                    break;
                }
                FindLST myLST(firstArrCapacity, secondArrCapacity);
                int* firstArr = new int[firstArrCapacity];
                int* secondArr = new int[secondArrCapacity];
                do {
                    std::cout << "\n_____________MENU______________" << '\n';
                    std::cout << "1. Input arrays." << '\n';
                    std::cout << "2. Find least common multiple(LST). " << '\n';
                    std::cout << "0. Exit." << '\n';
                    std::cin >> __choice;
                    switch(__choice){
                        case 1 :{
                            char inputChoice;
                            std::cout << "Do you wanna to fill arrays by yourself? (y/n)" << std::endl;
                            std::cin >> inputChoice;
                            if(inputChoice == 'y'){
                                for (int i = 0; i < firstArrCapacity; i++){
                                    int inputNumber;
                                    std::cout << "Enter your number> ";
                                    std::cin >> inputNumber;
//                                    if(){}
                                    firstArr[i] = inputNumber;
                                }

                                for (int i = 0; i < secondArrCapacity; i++){
                                    int inputNumber;
                                    std::cout << "Enter your number> ";
                                    std::cin >> inputNumber;
//                                    if(){}
                                    secondArr[i] = inputNumber;
                                }
                                myLST.displayArrays(firstArr, secondArr);
                                break;
                            } else if(inputChoice == 'n'){
                                myLST.fillArraysAuto(firstArr, secondArr);
                                myLST.displayArrays(firstArr, secondArr);
                                break;
                            } else {
                                std::cout << "You've entered a wrong choice! " << std::endl;
                                break;
                            }
                        }
                        case 2 :{
                            if(!myLST.findLST(firstArr, secondArr)){
                                std::cout << "There's no LST numbers!" << std::endl;
                            }
                            break;
                        }
                        case 0 :{
                            std::cout << "Ending the task.." << std::endl;
                            __flag = true;
                            break;
                        }
                        default:{
                            std::cout << "Wrong choice!" << std::endl;
                            break;
                        }
                    }
                    delete [] firstArr;
                    delete [] secondArr;
                } while (!__flag);
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