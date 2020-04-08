//
// Created by Daniel on 4/8/2020.
//

#include "FindLST.h"

#include <ctime>
#include <iostream>
#include <iomanip>

FindLST::FindLST() {
    firstArr = new int[0];
    secondArr = new int[0];
}

FindLST::FindLST(int firstArr_size, int secondArr_size) {
    firstArr = new int[firstArr_size];
    secondArr = new int[secondArr_size];

    sizeOf_firstArr = firstArr_size;
    sizeOf_secondArr = secondArr_size;
}

FindLST::~FindLST() {
    delete [] firstArr;
    delete [] secondArr;
}

void FindLST::fillArraysAuto(int input_firstArr[], int input_secondArr[]) {
    srand(time(NULL));
    for(int i = 0; i < sizeOf_firstArr; i++){
        input_firstArr[i] = rand() % 100;
        firstArr[i] = input_firstArr[i];
    }

    for(int i = 0; i < sizeOf_secondArr; i++){
        input_secondArr[i] = rand() % 100;
        secondArr[i] = input_secondArr[i];
    }
}

void FindLST::displayArrays(int input_firstArr[], int input_secondArr[]) {
    std::cout << "\nYour first array: " << std::endl;

    for(int i = 0; i < sizeOf_firstArr; i++){
        std::cout << input_firstArr[i] << '\t';
    }

    std::cout << "\nYour second array: " << std::endl;

    for(int i = 0; i < sizeOf_secondArr; i++){
        std::cout << input_secondArr[i] << '\t';
    }
}

bool FindLST::findLST(int input_firstArr[], int input_secondArr[]) {
    std::cout << "\nArrays' LST: " << std::endl;
    int min = input_firstArr[sizeOf_firstArr - 1], max = input_secondArr[0], result = 0;
    if(min >= max){
        int temp = 0;
        temp = min;
        min = max;
        max = temp;
    }
    for (int i = min; i < max; i++){
        if(firstCondition(i) && secondCondition(i)){
            std::cout << i << std::setw(4);
            result++;
        }
    }
    return result != 0;
}

bool FindLST::firstCondition(int number) {
    for(int i = 0; i < sizeOf_firstArr; i++){
        if(number % firstArr[i] != 0) return false;
    }
    return true;
}

bool FindLST::secondCondition(int number) {
    for(int i = 0; i < sizeOf_secondArr; i++){
        if(secondArr[i] % number != 0) return false;
    }
    return true;
}

