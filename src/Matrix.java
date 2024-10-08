import java.util.Random;

public class Matrix {
    int n,m;
    Complex[][] matrix;

    // Randomized Matrix
    Matrix(int n,int m){
        this.n = n;
        this.m = m;
        matrix = new Complex[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                Random rnd = new Random();
                matrix[i][j] = new Complex(rnd.nextInt(10) + 1,rnd.nextInt(10)+1);
            }
        }
    }

    // Null Matrix
    Matrix(int n,int m, int flag){
        this.n = n;
        this.m = m;
        matrix = new Complex[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                matrix[i][j] = new Complex(0,0);
            }
        }
    }

    // Custom Matrix
    Matrix(int n,int m, Complex ... item){
        this.n = n;
        this.m = m;
        matrix = new Complex[n][m];
        int a=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                matrix[i][j] = item[a]; a++;
            }
        }
    }

    Matrix add(Matrix mat){
        if (n!=mat.n || m!=mat.m) {System.out.println("Can't add!"); return null;}

        Matrix res = new Matrix(n,mat.m);

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++) {
                res.matrix[i][j] = matrix[i][j].add(mat.matrix[i][j]);
            }
        }
        System.out.print("Addition result:");
        res.print();
        return res;
    }

    Matrix sub(Matrix mat){
        if (n!=mat.n || m!=mat.m) {System.out.println("Can't sub!"); return null;}

        Matrix res = new Matrix(n,mat.m);

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++) {
                res.matrix[i][j] = matrix[i][j].sub(mat.matrix[i][j]);
            }
        }
        System.out.print("Subtraction result:");
        res.print();
        return res;

    }

    Matrix mult(Matrix mat){
        if (m!=mat.n) { System.out.println("Can't multiply!"); return null; }

        Matrix res = new Matrix(n,mat.m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Complex summ = new Complex(0,0);
                for (int k=0;k<m;k++){

                    summ = summ.add(matrix[i][k].mult(mat.matrix[k][j]));
                }
                res.matrix[i][j]=summ;
            }
        }


        System.out.print("Multiplication result:");
        res.print();
        return res;
    }

    Matrix transposition(){
        Matrix res = new Matrix(m,n);

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                res.matrix[j][i] = matrix[i][j];
            }
        }
        System.out.print("Transposition:");
        res.print();
        return res;
    }


    Complex det(){
        Complex determinant = new Complex(0,0);
        if (n!=m) {
            System.out.println("\nNot a square matrix");
            return null;
        }

        if (n==1) determinant = matrix[0][0];
        if (n==2) determinant = matrix[0][0].mult(matrix[1][1]).sub(matrix[1][0].mult(matrix[0][1]));
        if (n==3) determinant = matrix[0][0].mult(matrix[1][1].mult(matrix[2][2])).add(matrix[0][1].mult(matrix[1][2].mult(matrix[2][0]))).add(matrix[0][2].mult(matrix[1][0].mult(matrix[2][1]))).sub(matrix[2][0].mult(matrix[1][1].mult(matrix[0][2]))).sub(matrix[2][1].mult(matrix[1][2].mult(matrix[0][0]))).sub(matrix[2][2].mult(matrix[1][0].mult(matrix[0][1])));
        if (n>3){
            //System.out.println("\nРазмерность матрицы больше 3, считаем через миноры");
            int i=0;
            Complex det_sum = new Complex(0,0);
            for (int j=0;j<m;j++){
                    Complex alg = new Complex(0,0);
                    alg.real = (int) Math.pow(-1,i+j);
                    alg = alg.mult(matrix[i][j]);
                    Matrix temp = new Matrix(n-1,m-1,0);

                    int row=0,column=0;

                    for (int k=0;k<n;k++){
                        for (int l=0;l<m;l++){
                            if (k!=0 && l!=j) {
                                temp.matrix[row][column] = matrix[k][l];
                                if (column+1<m-1) column++;
                                else{
                                    column=0; row++;
                                }

                            }

                        }
                    }

                    alg = alg.mult(temp.det());
                    det_sum = det_sum.add(alg);

            }
            determinant = det_sum;
        }
        return determinant;
    }

    void print(){
        System.out.println("\nMatrix "+n+"x"+m);
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                matrix[i][j].print();
                System.out.print(" ");
            }
            System.out.println();
        }


    }
}
