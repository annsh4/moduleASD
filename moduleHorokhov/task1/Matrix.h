//
// Created by Daniel on 4/8/2020.
//

#ifndef MODULEHOROKHOV_MATRIX_H
#define MODULEHOROKHOV_MATRIX_H


class Matrix {
    int rowCount, columnCount;
    bool assigned;
    int** a = new int*[rowCount];

    void deleteMatrix();
    bool isFilled();
public:
    Matrix();
    Matrix(int columns, int rows);
    ~Matrix();


    void fillMatrixAuto();
    void fillMatrixByYourself(int key_number, int rowCounter, int columnCounter);
    void calculateDifference();
    void displayMatrix();
};


#endif //MODULEHOROKHOV_MATRIX_H
