//
// Created by Daniel on 4/8/2020.
//

#include "Matrix.h"

#include <iostream>
#include <ctime>

Matrix::Matrix(int columns, int rows) {
    columnCount = columns;
    rowCount = rows;
    assigned = false;

    for(int i = 0; i < rowCount; i++){
        a[i] = new int[columnCount];
    }

}

Matrix::~Matrix() {
    deleteMatrix();
}

void Matrix::deleteMatrix() {
    for(int i = 0; i < rowCount; i++){
        delete [] a[i];
    }
    delete [] a;
}

void Matrix::fillMatrixAuto() {
    srand(time(NULL));

    for(int i = 0; i < rowCount; i++){
        for(int j = 0; j < columnCount; j++){
            a[i][j] = rand() % -100 + 200;
        }
    }
    displayMatrix();
}

void Matrix::displayMatrix(){
    if (isFilled()) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                std::cout << a[i][j];
            }
            std::cout << std::endl;
        }
    } else {
        std::cout << "Fill the matrix" << std:: endl;
    }
}

void Matrix::fillMatrixByYourself(int key_number, int rowCounter, int columnCounter) {
    a[rowCounter][columnCounter] = key_number;
}

bool Matrix::isFilled() {
    return assigned;
}

void Matrix::calculateDifference() {
    
}