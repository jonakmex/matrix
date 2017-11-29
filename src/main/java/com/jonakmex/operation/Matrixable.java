package com.jonakmex.operation;

import com.jonakmex.exception.IllegalMatrixFormat;

public interface Matrixable{
	Double det(Double [][]matrix) throws IllegalMatrixFormat;
	Double[][] obtenerMenorComp(Double [][]matrix, int row, int col);
	String toString(Double [][]matrix);
	Double[][] strToMatrix(String str);
}
