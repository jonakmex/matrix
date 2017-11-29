package com.jonakmex.operation.impl;

import java.util.HashMap;
import java.util.Map;

import com.jonakmex.exception.IllegalMatrixFormat;
import com.jonakmex.operation.Matrixable;


public class MatrixableImpl implements Matrixable {

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
			Map<String,Integer> selected = seleccionarBase(matrix);
			
			if(selected.get("row") != null){
				int row = selected.get("row");
				for(int j = 0;j<matrix[0].length;j++){
					if(matrix[row][j] != 0){
						determinante += Math.pow(-1,(row+1)+(j+1)) * (matrix[row][j] *  det(obtenerMenorComp(matrix,row,j)));
					}
				}
			}
			else{
				int col = selected.get("col");
				for(int i = 0;i<matrix.length;i++){
					if(matrix[i][col] != 0){
						determinante += Math.pow(-1,(i+1)+(col+1)) * (matrix[i][col] *  det(obtenerMenorComp(matrix,i,col)));
					}
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
	
	
	
	@Override
	public Double[][] strToMatrix(String str) {
		Double [][]result = null;
		String []rows = str.split("@");
		if(rows.length > 0){
			result = new Double[rows.length][];
			for(int i = 0 ; i < rows.length ; i++){
				String []cols = rows[i].split(",");
				if(cols.length > 0){
					result[i] = new Double[cols.length];
					for(int j = 0 ; j < cols.length ; j++){
						result[i][j] = Double.parseDouble(cols[j]);
					}
				}
			}
		}
		
		return result;
	}

	private Map<String,Integer> seleccionarBase(Double [][]matrix){
		Map<String,Integer> minMap=new HashMap<String,Integer>();
		Map<String,Integer> test=new HashMap<String,Integer>();
		
		int currentMax = 0;
		//Default use the row 0
		minMap.put("row",0);
		
		for (int row = 0; row<matrix.length;row++){
			//Loop for rows
			test.put("row", row);
			int countZeros = contarCeros(matrix,test);
			if(countZeros > currentMax){
				currentMax = countZeros;
				minMap.put("row", row);
			}
		}
		
		test=new HashMap<String,Integer>();
				
		for (int col = 0; col<matrix[0].length;col++){
			//Loop for cols
			test.put("col", col);
			int countZeros = contarCeros(matrix,test);
			if(countZeros > currentMax){
				if(minMap.get("row") != null){
					minMap.remove("row");
				}
				currentMax = countZeros;
				minMap.put("col", col);
			}
		}
		
		return minMap;
	}
	
	private int contarCeros(Double [][]matrix,Map<String,Integer> base){
		int suma = 0;
		if(base.get("row") != null){
			for (int i = 0; i<matrix[base.get("row")].length;i++){
				if(matrix[base.get("row")][i] == 0){
					suma++;
				}
			}
		}
		else if (base.get("col") != null){
			for (int i = 0; i<matrix.length;i++){
				if(matrix[i][base.get("col")] == 0){
					suma++;
				}
			}
		}
		return suma;
	}
}
