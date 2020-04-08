//
// Created by Daniel on 4/8/2020.
//

#ifndef MODULEHOROKHOV_FINDLST_H
#define MODULEHOROKHOV_FINDLST_H


class FindLST {
    int* firstArr;
    int* secondArr;

    int sizeOf_firstArr, sizeOf_secondArr;

    bool firstCondition(int number);
    bool secondCondition(int number);
public:
    FindLST();
    FindLST(int firstArr_size, int secondArr_size);
    ~FindLST();

    void fillArraysAuto(int input_firstArr[], int input_secondArr[]);
    void displayArrays(int input_firstArr[], int input_secondArr[]);

    bool findLST(int input_firstArr[], int input_secondArr[]);
};


#endif //MODULEHOROKHOV_FINDLST_H
