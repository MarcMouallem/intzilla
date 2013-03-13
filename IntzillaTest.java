
import java.math.BigInteger;
import java.util.Random;

public class IntzillaTest {

    public static void main(String[] args) {

        Random generator = new Random();

        { //start sum test
        boolean sumTest = true;
        for(int i = 0; i < 100; i ++){

            boolean negative_b1 = generator.nextBoolean();
            BigInteger b = new BigInteger(64, generator);
            if(negative_b1){
                BigInteger makeNegative = new BigInteger("-1");
                b = b.multiply(makeNegative);
            }
            
            boolean negative_b2 = generator.nextBoolean();
            BigInteger b2 = new BigInteger(64, generator);
            if(negative_b2){
                BigInteger makeNegative = new BigInteger("-1");
                b2 = b2.multiply(makeNegative);
            }

            Intzilla z = new Intzilla(b.toString());
            Intzilla z2 = new Intzilla(b2.toString());

            if(b.add(b2).toString().equals(z.sum(z2).toString())){
                //do nothing
            }
            else{
                sumTest = false;
            }  
        }
        if(sumTest){
            System.out.println("The sum method is working properly");
        }
        else{
            System.out.println("The sum method has returned one or more" +
                    " incorrect answers");
        }
        } //end sum test

        { //start difference test
        boolean differenceTest = true;
        for(int i = 0; i < 100; i ++){

            boolean negative_b1 = generator.nextBoolean();
            BigInteger b = new BigInteger(64, generator);
            if(negative_b1){
                BigInteger makeNegative = new BigInteger("-1");
                b = b.multiply(makeNegative);
            }

            boolean negative_b2 = generator.nextBoolean();
            BigInteger b2 = new BigInteger(64, generator);
            if(negative_b2){
                BigInteger makeNegative = new BigInteger("-1");
                b2 = b2.multiply(makeNegative);
            }

            Intzilla z = new Intzilla(b.toString());
            Intzilla z2 = new Intzilla(b2.toString());

            if(b.subtract(b2).toString().equals(z.difference(z2).toString())){
                //do nothing
            }
            else{
                differenceTest = false;
            }
        }
        if(differenceTest){
            System.out.println("The difference method is working properly");
        }
        else{
            System.out.println("The difference method has returned one or more" +
                    " incorrect answers");
        }
        } //end difference test

        { //start absoluteValue test
        boolean absoluteValueTest = true;
        for(int i = 0; i < 100; i ++){

            boolean negative_b1 = generator.nextBoolean();
            BigInteger b = new BigInteger(64, generator);
            if(negative_b1){
                BigInteger makeNegative = new BigInteger("-1");
                b = b.multiply(makeNegative);
            }

            Intzilla z = new Intzilla(b.toString());

            if(b.abs().toString().equals(z.absoluteVaule().toString())){
                //do nothing
            }
            else{
                absoluteValueTest = false;
            }
        }
        if(absoluteValueTest){
            System.out.println("The absoluteValue method is working properly");
        }
        else{
            System.out.println("The absoluteValue method has returned one or more" +
                    " incorrect answers");
        }
        } //end absoluteValue test

        { //start product test
        boolean productTest = true;
        for(int i = 0; i < 100; i ++){

            boolean negative_b1 = generator.nextBoolean();
            BigInteger b = new BigInteger(64, generator);
            if(negative_b1){
                BigInteger makeNegative = new BigInteger("-1");
                b = b.multiply(makeNegative);
            }

            boolean negative_b2 = generator.nextBoolean();
            BigInteger b2 = new BigInteger(64, generator);
            if(negative_b2){
                BigInteger makeNegative = new BigInteger("-1");
                b2 = b2.multiply(makeNegative);
            }

            Intzilla z = new Intzilla(b.toString());
            Intzilla z2 = new Intzilla(b2.toString());

            if(b.multiply(b2).toString().equals(z.product(z2).toString())){
                //do nothing
            }
            else{
                productTest = false;
            }
        }
        if(productTest){
            System.out.println("The product method is working properly");
        }
        else{
            System.out.println("The product method has returned one or more" +
                    " incorrect answers");
        }
        } //end product test

        { //start quotient test
        boolean quotientTest = true;
        for(int i = 0; i < 100; i ++){

            boolean negative_b1 = generator.nextBoolean();
            BigInteger b = new BigInteger(64, generator);
            if(negative_b1){
                BigInteger makeNegative = new BigInteger("-1");
                b = b.multiply(makeNegative);
            }

            boolean negative_b2 = generator.nextBoolean();
            BigInteger b2 = new BigInteger(32, generator);
            if(negative_b2){
                BigInteger makeNegative = new BigInteger("-1");
                b2 = b2.multiply(makeNegative);
            }

            Intzilla z = new Intzilla(b.toString());
            Intzilla z2 = new Intzilla(b2.toString());

            if(b.divide(b2).toString().equals(z.quotient(z2).toString())){
                //do nothing
            }
            else{
                quotientTest = false;
            }
        }
        if(quotientTest){
            System.out.println("The quotient method is working properly");
        }
        else{
            System.out.println("The quotient method has returned one or more" +
                    " incorrect answers");
        }
        } //end quotient test

        { //start remainder test
        boolean remainderTest = true;
        for(int i = 0; i < 100; i ++){

            boolean negative_b1 = generator.nextBoolean();
            BigInteger b = new BigInteger(64, generator);
            if(negative_b1){
                BigInteger makeNegative = new BigInteger("-1");
                b = b.multiply(makeNegative);
            }

            boolean negative_b2 = generator.nextBoolean();
            BigInteger b2 = new BigInteger(64, generator);
            if(negative_b2){
                BigInteger makeNegative = new BigInteger("-1");
                b2 = b2.multiply(makeNegative);
            }

            Intzilla z = new Intzilla(b.toString());
            Intzilla z2 = new Intzilla(b2.toString());

            if(b.remainder(b2).toString().equals(z.remainder(z2).toString())){
                //do nothing
            }
            else{
                remainderTest = false;
            }
        }
        if(remainderTest){
            System.out.println("The remainder method is working properly");
        }
        else{
            System.out.println("The remainder method has returned one or more" +
                    " incorrect answers");
        }
        } //end remainder test

        { //start gcd test
        boolean gcdTest = true;
        for(int i = 0; i < 100; i ++){

            boolean negative_b1 = generator.nextBoolean();
            BigInteger b = new BigInteger(64, generator);
            if(negative_b1){
                BigInteger makeNegative = new BigInteger("-1");
                b = b.multiply(makeNegative);
            }

            boolean negative_b2 = generator.nextBoolean();
            BigInteger b2 = new BigInteger(64, generator);
            if(negative_b2){
                BigInteger makeNegative = new BigInteger("-1");
                b2 = b2.multiply(makeNegative);
            }

            Intzilla z = new Intzilla(b.toString());
            Intzilla z2 = new Intzilla(b2.toString());

            if(b.gcd(b2).toString().equals(Intzilla.gcd(z,z2).toString())){
                //do nothing
            }
            else{
                gcdTest = false;
            }
        }
        if(gcdTest){
            System.out.println("The gcd method is working properly");
        }
        else{
            System.out.println("The gcd method has returned one or more" +
                    " incorrect answers");
        }
        } //end gcd test

    }

}
