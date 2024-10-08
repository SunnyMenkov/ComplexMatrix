import java.util.Scanner;

class main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Матрицы с элементами, вводиммыми пользователем
        // 3 3
        // 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9
        System.out.print("Введите размерность первой матрицы: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Complex[] array = new Complex[n*m];

        System.out.print("Введите элементы первой матрицы (real, imaginary): ");
        for (int i=0;i<n*m;i++){
            int real = scanner.nextInt();
            int imaginary = scanner.nextInt();
            array[i] = new Complex(real,imaginary);
        }

        Matrix ma1 = new Matrix(n,m,array);
        ma1.print();

        System.out.print("Введите размерность второй матрицы: ");
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        Complex[] array2 = new Complex[k*l];

        System.out.print("Введите элементы второй матрицы (real, imaginary): ");
        for (int i=0;i<k*l;i++){
            int real = scanner.nextInt();
            int imaginary = scanner.nextInt();
            array2[i] = new Complex(real,imaginary);
        }

        Matrix ma2 = new Matrix(k,l,array2);
        ma2.print();
        System.out.println();

        Matrix res;
        //Сложение
        res = ma1.add(ma2);

        //Вычитание
        res = ma1.sub(ma2);

        //Умножение
        res = ma1.mult(ma2);

        //Транспонирование
        res = ma1.transposition();

        //Определитель
        Complex det = ma1.det();
        if (det!=null) {
            System.out.println("Det of custom matrix:");
            det.print();
        }
        //Создать матрицу со случайными элементами
        Matrix mrandom = new Matrix(4,4);
        mrandom.print();
        //Посчитать её определитель
        Complex det_random = mrandom.det();
        if (det_random!=null) {
            System.out.println("Det of random matrix:");
            det_random.print();
        }
        //Создать нулевую матрицу
        Matrix mnull = new Matrix(3,3,0);
        System.out.print("\nNull matrix (test):");
        mnull.print();


    }
}