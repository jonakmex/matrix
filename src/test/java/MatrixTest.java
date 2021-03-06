import org.junit.Test;

import com.jonakmex.exception.IllegalMatrixFormat;
import com.jonakmex.operation.Matrixable;
import com.jonakmex.operation.impl.MatrixableImpl;


public class MatrixTest {

	@Test
	public void detTest(){
		Matrixable matrixable = new MatrixableImpl();
		//Double [][]matrix = {{7.0,6.0,3.0,7.0,5.0},{7.0,2.0,5.0,0.0,5.0},{3.0,3.0,4.0,6.0,0.0},{9.0,0.0,6.0,7.0,7.0},{8.0,2.0,0.0,1.0,2.0}};
		//Double [][]matrix = {{2.00,1.00,0.00,-1.00},{0.00,-1.00,0.00,3.00},{-2.00,1.00,1.00,-2.00},{3.00,2.00,0.00,1.00}};
		//Double [][]matrix = {{3.0,-1.0,-1.0},{2.0,1.0,0.0},{3.0,1.0,2.0}};
		//Double [][]matrix = {{1.0,0.0},{1.0,2.0}};
		//Double [][]matrix = {{2.0,0.0},{3.0,2.0}};
		//Double [][]matrix = {{2.0,1.0},{3.0,1.0}};
		Double [][]matrix = matrixable.strToMatrix("7.0,6.0,3.0,7.0,5.0@7.0,2.0,5.0,0.0,5.0@3.0,3.0,4.0,6.0,0.0@9.0,0.0,6.0,7.0,7.0@8.0,2.0,0.0,1.0,2.0");
		try {
			System.out.println(matrixable.toString(matrix));
			System.out.println(matrixable.det(matrix));
		} catch (IllegalMatrixFormat e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
