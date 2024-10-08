public class Complex {
    long real;
    long imaginary;

    Complex(long real,long imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    Complex add(Complex c){
        Complex res = new Complex(0,0);

        res.real = real+c.real;
        res.imaginary = imaginary+c.imaginary;

        return res;
    }

    Complex sub(Complex c){
        Complex res = new Complex(0,0);

        res.real = real-c.real;
        res.imaginary = imaginary-c.imaginary;

        return res;
    }

    Complex mult(Complex c){
        Complex result = new Complex(0,0);

        result.real = real*c.real-imaginary*c.imaginary;
        result.imaginary = real*c.imaginary + imaginary*c.real;

        return result;
    }

    void print(){
        if (real!=0) {
            System.out.print(real);

            if (imaginary>0) System.out.print("+");
        }
        if (real == 0 && imaginary==0) System.out.print("0");
//        if (imaginary==1) System.out.print("i");
//        if (imaginary==-1) System.out.print("-i");

        if (imaginary!=0) System.out.print(imaginary+"i");


    }
}
