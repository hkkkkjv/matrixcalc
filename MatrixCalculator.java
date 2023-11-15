import java.util.Scanner;

public class MatrixCalculator{
	public static void main(String[] args) {
        MatrixCalculator matrixChoice = new MatrixCalculator() ;
        matrixChoice.choice();
    }

    public static void choice(){
        System.out.println("Выберите номер операции");
        System.out.println("1. Вычисление определителя матрицы ");
        System.out.println("2. Приведение матрицы к треугольному виду");
        System.out.println("3. Транспонирование матрицы");
        System.out.println("4. Умножение матрицы на число");
        System.out.println("5. Сложение матриц");
        System.out.println("6. Умножение матриц друг на друга");
        System.out.println("7. Завершить работу");

        Scanner scan = new Scanner(System.in);
        int action = scan.nextInt();
        MatrixCalculator matrixCalculator = new MatrixCalculator() ;

        if (action == 1) {
            matrixCalculator.determinantMatrix();
        }else if (action == 2) {
            matrixCalculator.triang();
        }else if (action == 3) {
            matrixCalculator.transMatrix();
        }else if (action == 4) {
            matrixCalculator.multiplicationNum();
        }else if (action == 5) {
            matrixCalculator.sumMatrixes();
        }else if (action == 6) {
            matrixCalculator.multiplicationMatrix();
        }else if (action == 7) {
            System.out.println("Завершение работы");
            return;
        }else {
            System.out.println("Неверный ввод команды");
        }
        System.out.println("Выберите действие");
        System.out.println("1. Продолжить вычисление");
        System.out.println("2. Завершить работу");
        int ch = scan.nextInt();
        if (ch == 1) {
            matrixCalculator.choice();
        }else if (ch == 2) {
            System.out.println("Завершение работы");
        }else{
            System.out.println("Неверный ввод команды");
        }
    }

    public static void determinantMatrix () {
        //Определитель матрицы
        System.out.println("Вычисление определителя матрицы");

        System.out.println("Array  size");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        if (n == m) {
            double a [][] = new double [n][n];
            double c = 0 ; 

            System.out.println("Array a");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++){
                    a[i][j] = scan.nextInt();
                }
            }
            for (int i = 0 ; i < n ; i++ ){
                for ( int j = i + 1 ; j < n ; j++){
                    double k = (-1) * (a[j][i]/a[i][i]);
                    for (int p = 0 ; p < n ; p++){
                        a[j][p] = a[i][p] * k + a[j][p];
                    }
                }
            }
            for (int i = 0; i < n; i++){
                c *= a[i][i];
            }
            System.out.println(c);
        }else{
            System.out.println("Ошибка: матрицы должна быть квадратная(количество строк и столбцов должны быть равны)");
        }
        
    
    }
    public static void transMatrix () {
        //Трансонирование матрицы
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Транспонирование матрицы");

        System.out.println("Количество строк матрицы");
        System.out.print("n=");
        int n = scanner.nextInt();
        
        System.out.println("Количество столбцов матрицы");
        System.out.print("m=");
        int m = scanner.nextInt();
        
        double a [][] = new double [n][m];
        double c [][] = new double [m][n];

        System.out.println("Введите элементы матрицы");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++){
                a[i][j] = scanner.nextDouble();
            }
        }
        for (int i = 0 ; i < n ; i++ ){
            for ( int j = 0 ; j < m ; j++){
                c[j][i] = a[i][j];
            }
        }

        System.out.println("Результат:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j]+"  ");
            }
            System.out.println(' ');
        
        }    
    }

    public static void multiplicationNum () {
        //умножение матрицы на число
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Количество строк матрицы");
        System.out.print("k=");
        int k = scanner.nextInt();
        
        System.out.println("Количество столбцов матрицы");
        System.out.print("m=");
        int m = scanner.nextInt();
        
        System.out.println("Число, на которое требуется умножить матрицу");
        System.out.print("n=");
        int n = scanner.nextInt();
        
        double [ ][ ] m1  = new double [k][m];
        double [ ][ ] m2  = new double [k][m];
        
        System.out.println("Введите элементы матрицы");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                m1[i][j] = scanner.nextDouble();
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                    m2[i][j] = m1[i][j]*n;
                }
        }
        System.out.println("Результат:");
        for (int i = 0; i<k; i++) {
            for (int j = 0; j<m; j++) {
                System.out.print(m2[i][j]+"  ");
            }
            System.out.println(' ');
        }
    }

	public static void sumMatrixes() {
        System.out.println("Сложение матриц");

        Scanner scanner = new Scanner(System.in); 
        System.out.println("Количество строк первой матрицы");
        System.out.print("m=");
        int m = scanner.nextInt();
        
        System.out.println("Количество столбцов первой матрицы");
        System.out.print("n=");
        int n = scanner.nextInt();
        
        System.out.println("Количество строк второй матрицы");
        System.out.print("z=");
        int z = scanner.nextInt();
        
        System.out.println("Количество столбцов второй матрицы");
        System.out.print("w=");
        int w = scanner.nextInt();
        
        if ((m==z)&(n==w)) {
            double [ ][ ] m1  = new double [m][n];
            double [ ][ ] m2  = new double [m][n];
            double [ ][ ] m3  = new double [m][n];
            System.out.println("Введите элементы первой матрицы");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    m1[i][j] = scanner.nextDouble();
                }
            }
            System.out.println("Введите элементы второй матрицы");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    m2[i][j] = scanner.nextDouble();
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    m3[i][j] = m1[i][j]+m2[i][j];
                }
            }
            System.out.println("Результат:");
            for (int i = 0; i<m; i++) {
                for (int j = 0; j<n; j++) {
                    System.out.print(m3[i][j]+"  ");
                }
                System.out.println(' ');
            }
        }
        else {
            System.out.println("Ошибка: количество строк и столбцов первой и второй матрицы должно быть одинаковым");
        }
           

        }
    public static void multiplicationMatrix () {
        //умножение матриц
        System.out.println("Умножение матриц");

        Scanner scanner = new Scanner(System.in); 
        System.out.println("Количество строк первой матрицы");
        System.out.print("k=");
        int k = scanner.nextInt();
        
        System.out.println("Количество столбцов первой матрицы");
        System.out.print("m=");
        int m = scanner.nextInt();
        
        System.out.println("Количество строк вторгой матрицы");
        System.out.print("z=");
        int z = scanner.nextInt();
        
        System.out.println("Количество столбцов второй матрицы");
        System.out.print("n=");
        int n = scanner.nextInt();
        if (z==m) {
            double [ ][ ] m1  = new double [k][m];
            double [ ][ ] m2  = new double [z][n];
            double [ ][ ] m3  = new double [k][n];
            System.out.println("Введите элементы первой матрицы");
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < m; j++) {
                    m1[i][j] = scanner.nextDouble();
                }
            }
            System.out.println("Введите элементы второй матрицы");
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < n; j++) {
                    m2[i][j] = scanner.nextDouble();
                }
            }
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int p = 0; p < m; p++) {
                        m3[i][j] += m1[i][p]*m2[p][j];
                    }
                }
            }
            System.out.println("Результат:");
            for (int i = 0; i<k; i++) {
                for (int j = 0; j<n; j++) {
                    System.out.print(m3[i][j]+"  ");
                }
                System.out.println(' ');
            }
        }
        else {
            System.out.println("Ошибка: количество столбцов первой матрицы и количество строк второй матрицы должно быть одинаковым");
        }
    }
    public static void triang () {
        //приведение матрицы к треугольному виду
        System.out.println("Приведение матрицы к треугольному виду");
        
        Scanner scanner = new Scanner(System.in); 
        
        System.out.println("Количество строк матрицы");
        System.out.print("n=");
        int n = scanner.nextInt();
        
        System.out.println("Количество столбцов матрицы");
        System.out.print("z=");
        int z = scanner.nextInt();
        
        if (n==z) {
            double [ ][ ] m  = new double [n][z];
            System.out.println("Введите элементы матрицы");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = scanner.nextDouble();
                }
            }
            for (int i = 0 ; i < n ; i++ ){
                for ( int j = i + 1 ; j < n ; j++){
                    double k = (-1) * (m[j][i]/m[i][i]);
                    for (int p = 0 ; p < n ; p++){
                        m[j][p] = m[i][p] * k + m[j][p];
                    }
                }
            }
            System.out.println("Результат:");
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    System.out.print(m[i][j]+"  ");
                }
                System.out.println(' ');
            }
        }
        else {
            System.out.println("Ошибка: матрицы должна быть квадратная(количество строк и столбцов должны быть равны)");
        }
    }
}
