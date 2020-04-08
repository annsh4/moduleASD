//
// Created by Daniel on 4/8/2020.
//

#include "Matrix.h"

#include <iostream>
#include <ctime>
#include <cmath>
#include <iomanip>

Matrix::Matrix(int columns, int rows) {
    columnCount = columns;
    rowCount = rows;

    matrix = new int*[rowCount];

    for(int i = 0; i < rowCount; i++){
        matrix[i] = new int[columnCount];
    }

    for (int i = 0; i < rowCount; ++i) {
        for (int j = 0; j < columnCount; ++j) {
            matrix[i][j] = 0;
        }
    }
}

Matrix::~Matrix() {
    deleteMatrix();
}

void Matrix::deleteMatrix() {
    for(int i = 0; i < rowCount; i++){
        delete []  matrix[i];
    }
    delete [] matrix;
}

void Matrix::fillMatrixAuto(Matrix &filledMatrix) {
    srand(time(NULL));

    for(int i = 0; i < rowCount; i++){
        for(int j = 0; j < columnCount; j++){
            matrix[i][j] = rand() % 200 - 100 ;
        }
    }

    std::cout << "\nYour matrix:\n" << filledMatrix;
}

void Matrix::fillMatrixByYourself(int key_number, int rowCounter, int columnCounter, Matrix &filledMatrix) {
    matrix[rowCounter][columnCounter] = key_number;
}

int Matrix::calculateDifference(Matrix &calcMatrix) {
    int firstDiagonalSum = 0, secondDiagonalSum = 0;
    for(int i = 0; i < rowCount; i++){
        for (int j = 0; j < columnCount; j++){
            if(i == j){
                firstDiagonalSum += matrix[i][j];
            }
            if(j == columnCount - (i+1)){
                secondDiagonalSum += matrix[i][j];
            }
        }
    }
    return abs(firstDiagonalSum - secondDiagonalSum);
}

std::ostream &operator<< (std::ostream &out, Matrix &output)
{
            for (int i = 0; i < output.rowCount; i++) {
                out << "\n";
                for (int j = 0; j < output.columnCount; j++)
                    out << std::setw(5) << output.matrix[i][j];
            }
    return out;
}