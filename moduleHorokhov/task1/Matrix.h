//
// Created by Daniel on 4/8/2020.
//

#ifndef MODULEHOROKHOV_MATRIX_H
#define MODULEHOROKHOV_MATRIX_H

#include <iostream>

class Matrix {
    int rowCount;
    int columnCount;

    void deleteMatrix();

    friend std::ostream &operator<< (std::ostream &out, Matrix &output);
public:
    int **matrix;
    Matrix();
    Matrix(int columns, int rows);
    ~Matrix();


    void fillMatrixAuto(Matrix &filledMatrix);
    void fillMatrixByYourself(int key_number, int rowCounter, int columnCounter, Matrix &filledMatrix);
    int calculateDifference(Matrix &calcMatrix);
};


#endif //MODULEHOROKHOV_MATRIX_H
