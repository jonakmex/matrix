package com.jonakmex.operation.impl;

import com.jonakmex.exception.IllegalMatrixFormat;
import com.jonakmex.operation.Matrix;


public class MatrixImpl implements Matrix {

	@Override
	public Double det(Double[][] matrix)throws IllegalMatrixFormat {
		int rows = matrix.length;
		
		if(rows < 2){
			throw new IllegalMatrixFormat("La matriz debe ser por lo menos de 2X2");
		}
		
		for(int i = 0; i<matrix.length; i++){
			if(matrix[i].length != rows){
				throw new IllegalMatrixFormat("La matriz debe ser cuadrada");
			}
		}
		
		if(rows == 2){
			return (matrix[0][0] * matrix [1][1]) - (matrix[0][1] * matrix [1][0]);
		}
		else{
			double determinante = 0;
			for(int i = 0;i<1;i++){
				for(int j = 0;j<matrix[i].length;j++){
					determinante += Math.pow(-1,(i+1)+(j+1)) * (matrix[i][j] *  det(obtenerMenorComp(matrix,i,j)));
				}
			}
			
			return determinante;
		}
		
	}

	@Override
	public Double[][] obtenerMenorComp(Double[][] matrix, int row, int col) {
		Double [][]result = new Double[matrix.length-1][matrix.length-1];
		
		int resultRow = 0;
		int resultCol = 0;
		
		for(int i = 0;i<matrix.length;i++){
			if(i != row){
				for(int j = 0;j<matrix[i].length;j++){
					if(j != col){
						result[resultRow][resultCol++] = matrix[i][j];
					}
					else{
						continue;
					}
				}
				resultRow++;
				resultCol=0;
			}
			else{
				continue;
			}
			
		}
		return result;
	}

	@Override
	public String toString(Double[][] matrix) {
		StringBuilder sMatrix = new StringBuilder();
		for(int i = 0;i<matrix.length;i++){
			for(int j = 0;j<matrix[i].length;j++){
				sMatrix.append(matrix[i][j]);
				if((j) < (matrix[i].length-1)){
					sMatrix.append(",");
				}
			}
			sMatrix.append("\n");
		}
		
		return sMatrix.toString();
	}
	
	

}
