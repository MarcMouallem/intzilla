
public class Intzilla {

    static final Intzilla MINUS_ONE = new Intzilla("-1");
    static final Intzilla NEGATIVE_ONE = new Intzilla("-1");
    static final Intzilla ONE = new Intzilla("1");
    static final Intzilla PLUS_ONE = new Intzilla("+1");
    static final Intzilla POSTIVE_ONE = new Intzilla("+1");
    static final Intzilla ZERO = new Intzilla("0");

    private String magnitude;
    private char sign;

    public Intzilla(){
        magnitude = "0";
        sign = '+';
    }

    public Intzilla(Intzilla si){
        magnitude = si.magnitude;
        sign = si.sign;
    }

    public Intzilla(String si){
        if(si.charAt(0) == '+' || si.charAt(0) == '-'){
            sign = si.charAt(0);
            magnitude = si.substring(1);
        }
        else{
            sign = '+';
            magnitude = si;
        }
    }

    @Override
    public String toString(){
        if(sign == '-'){
            if(magnitude.equals("0")){
                return magnitude;
            }
            else{
                return new String(sign + magnitude);
            }
        }
        else{
            return new String(magnitude);
        }
    }

    private String simpleSum(Intzilla n){
        boolean carry = false;
        String answer = "";
        int i2 = n.magnitude.length() - 1 ;
        for(int i = this.magnitude.length() - 1; i >= 0 || i2 >= 0 ; i--){
            int temp;
            try{
                temp = Character.getNumericValue(this.magnitude.charAt(i)) +
                        Character.getNumericValue(n.magnitude.charAt(i2));
            }
            catch (Exception e){
                try{
                    temp = Character.getNumericValue(this.magnitude.charAt(i));
                }
                catch (Exception e2){
                    temp = Character.getNumericValue(n.magnitude.charAt(i2));
                }
            }
            if (carry) temp += 1;
            if(temp > 9){
                answer = (temp - 10) + answer;
                carry = true;
            }
            else{
                answer = temp + answer ;
                carry = false;
            }
            i2 --;
        }
        if (carry) answer = '1' + answer;
        int firstNonZero = 0;
        boolean allZeros = true;
        for(int i = 0; i < answer.length(); i ++){
            if(answer.charAt(i) != '0'){
                firstNonZero = i;
                allZeros = false;
                break;
            }
        }
        if(allZeros) answer = "0";
        return answer.substring(firstNonZero);
    }

    private String simpleDifference(Intzilla n){
        boolean borrow = false;
        String answer = "";
        int i2 = n.magnitude.length() - 1 ;
        for(int i = this.magnitude.length() - 1; i >= 0 || i2 >= 0 ; i--){
            int temp;
            try{
                temp = Character.getNumericValue(this.magnitude.charAt(i)) -
                        Character.getNumericValue(n.magnitude.charAt(i2));
            }
            catch (Exception e){
                try{
                    temp = Character.getNumericValue(this.magnitude.charAt(i));
                }
                catch (Exception e2){
                    temp = Character.getNumericValue(n.magnitude.charAt(i2));
                }
            }
            if (borrow) temp -= 1;
            if(temp < 0){
                answer = (temp + 10) + answer;
                borrow = true;
            }
            else{
                answer = temp + answer ;
                borrow = false;
            }
            i2 --;
        }
        int firstNonZero = 0;
        boolean allZeros = true;
        for(int i = 0; i < answer.length(); i ++){
            if(answer.charAt(i) != '0'){
                firstNonZero = i;
                allZeros = false;
                break;
            }
        }
        if(allZeros) answer = "0";
        return answer.substring(firstNonZero);
    }

    public boolean isEqualTo(Intzilla n){
        if(this.sign != n.sign){
            return false;
        }
        else{
            return this.isEqualtoInMagnitude(n);
        }        
    }

    private boolean isEqualtoInMagnitude(Intzilla n){
        if(this.magnitude.length() != n.magnitude.length()){
            return false;
        }
        else{
            for(int i = 0; i < this.magnitude.length(); i ++){
                if(this.magnitude.charAt(i) != n.magnitude.charAt(i)){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean isGreaterThan(Intzilla n){
        if(this.isEqualTo(n)) return false;
        else if(this.sign == '+' && n.sign == '-') return true;
        else if(this.sign == '-' && n.sign == '+') return false;
        else{
            if(this.sign == '+'){
                return this.isGreaterThanInMagnitude(n);
            }
            else{
                return !this.isGreaterThanInMagnitude(n);
            }
        }
    }

    private boolean isGreaterThanInMagnitude(Intzilla n){
        if(this.magnitude.length() > n.magnitude.length()) return true;
        if(this.magnitude.length() < n.magnitude.length()) return false;
        else{
            for(int i = 0; i <this.magnitude.length(); i ++){
                if(Character.getNumericValue(this.magnitude.charAt(i)) >
                        Character.getNumericValue(n.magnitude.charAt(i))){
                    return true;
                }
                else if(Character.getNumericValue(this.magnitude.charAt(i)) <
                        Character.getNumericValue(n.magnitude.charAt(i))){
                    return false;
                }
                else{
                    //continue the loop
                }
            }
            return false;
        }
    }

    public boolean isLessThan(Intzilla n){
        if(this.isGreaterThan(n)) return false;
        else if(this.isEqualTo(n)) return false;
        else return true;
    }

    private boolean isLessThanInMagnitude(Intzilla n){
        if(this.isGreaterThanInMagnitude(n)) return false;
        else if(this.isEqualtoInMagnitude(n)) return false;
        else return true;
    }

    public Intzilla sum(Intzilla n){
        if(this.sign == '-' && n.sign == '+'){
            if(n.isGreaterThanInMagnitude(this)){
                String s = n.simpleDifference(this);
                return new Intzilla(s);
            }
            else if(n.isEqualTo(this)){
                return new Intzilla();
            }
            else{
                String s = this.simpleDifference(n);
                return new Intzilla('-' + s);
            }
        }
        else if(this.sign == '+' && n.sign == '-'){
            if(this.isGreaterThanInMagnitude(n)){
                String s = this.simpleDifference(n);
                return new Intzilla(s);
            }
            else if(n.isEqualTo(this)){
                return new Intzilla();
            }
            else{
                String s = n.simpleDifference(this);
                return new Intzilla('-' + s);
            }
        }
        else if(this.sign == '-' && n.sign == '-'){
            String s = this.simpleSum(n);
            return new Intzilla('-' + s);
        }
        else{
            String s = this.simpleSum(n);
            return new Intzilla(s);
        }
    }

    public Intzilla difference(Intzilla n){
        if(this.sign == '+' && n.sign == '-'){
            String s = this.simpleSum(n);
            return new Intzilla(s);
        }
        else if(this.sign == '-' && n.sign == '+'){
            String s = this.simpleSum(n);
            return new Intzilla('-' + s);
        }
        else if(this.sign == '-' && n.sign == '-'){
            if(n.isGreaterThanInMagnitude(this)){
                String s = n.simpleDifference(this);
                return new Intzilla(s);
            }
            else if(n.isEqualTo(this)){
                return new Intzilla();
            }
            else{
                String s = this.simpleDifference(n);
                return new Intzilla('-' + s);
            }
        }
        else{
            if(this.isGreaterThanInMagnitude(n)){
                String s = this.simpleDifference(n);
                return new Intzilla(s);
            }
            else if(n.isEqualTo(this)){
                return new Intzilla();
            }
            else{
                String s = n.simpleDifference(this);
                return new Intzilla('-' + s);
            }
        }
    }

    public Intzilla absoluteVaule(){
        return new Intzilla(this.magnitude);
    }

    private String simpleProduct(Intzilla n){
        Intzilla total = new Intzilla("0");
        int zeros = -1;
        for(int i = n.magnitude.length() - 1; i >= 0; i --){
            int carry = 0;
            String rowAnswer = "";
            for(int i2 = this.magnitude.length() - 1; i2 >= 0; i2 --){
                int temp = Character.getNumericValue(n.magnitude.charAt(i)) *
                        Character.getNumericValue(this.magnitude.charAt(i2)) + carry;
                if (temp > 9){
                    carry = temp/10;
                    rowAnswer = (temp % 10) + rowAnswer;

                }
                else{
                    carry = 0;
                    rowAnswer = temp + rowAnswer;
                }                
            }
            zeros += 1;
            rowAnswer = carry + rowAnswer;
            for(int i3 = 0; i3 < zeros; i3 ++){
                rowAnswer = rowAnswer + '0';
            }
            Intzilla z = new Intzilla(rowAnswer);
            total = new Intzilla (total.simpleSum(z));
        }
        int firstNonZero = 0;
        boolean allZeros = true;
        for(int i = 0; i < total.magnitude.length(); i ++){
            if(total.magnitude.charAt(i) != '0'){
                firstNonZero = i;
                allZeros = false;
                break;
            }
        }
        if(allZeros) total.magnitude = "0";
        return total.magnitude.substring(firstNonZero);
    }

    public Intzilla product(Intzilla n){
        if(this.sign == '+' && n.sign == '-'){
            return new Intzilla('-' + this.simpleProduct(n));
        }
        else if(this.sign == '-' && n.sign == '+'){
            return new Intzilla('-' + this.simpleProduct(n));
        }
        else if(this.sign == '-' && n.sign == '-'){
            return new Intzilla(this.simpleProduct(n));
        }
        else{
            return new Intzilla(this.simpleProduct(n));
        }
    }
    
    private Intzilla simpleQuotient(Intzilla n){
        Intzilla thisPos = this.absoluteVaule();
        Intzilla nPos = n.absoluteVaule();
        Intzilla results = new Intzilla("1");        
        Intzilla intermediate = new Intzilla(nPos); 
        if(intermediate.isGreaterThanInMagnitude(thisPos)){
            return new Intzilla();
        }
        Intzilla temp = new Intzilla(intermediate.magnitude + '0');
        while(temp.isLessThanInMagnitude(thisPos)){
            results.magnitude += '0';
            intermediate.magnitude += '0';
            temp = new Intzilla(intermediate.magnitude + '0');
        }
        Intzilla diffC = new Intzilla(thisPos.simpleDifference(intermediate));
        while(diffC.isGreaterThanInMagnitude(intermediate) || diffC.isEqualtoInMagnitude(intermediate)){
            diffC = diffC.difference(intermediate);
            int cAdder = Character.getNumericValue(results.magnitude.charAt(0));
            results.magnitude = results.magnitude.substring(1);
            results.magnitude = (cAdder + 1) + results.magnitude;
        }
        if(diffC.isGreaterThanInMagnitude(new Intzilla("2"))){
            return results.sum(diffC.simpleQuotient(nPos));
        }
        else{
            return results;
        }     
    }

    public Intzilla quotient(Intzilla n){
        if(this.sign == '+' && n.sign == '-'){
            Intzilla temp = new Intzilla(this.simpleQuotient(n));
            temp.sign = '-';
            return temp;
        }
        else if(this.sign == '-' && n.sign == '+'){
            Intzilla temp = new Intzilla(this.simpleQuotient(n));
            temp.sign = '-';
            return temp;
        }
        else if(this.sign == '-' && n.sign == '-'){
            return this.simpleQuotient(n);
        }
        else{
            return this.simpleQuotient(n);
        }
    }

    //sign of remainder is dertermined like the java BigInteger class
    public Intzilla remainder(Intzilla n){
        Intzilla thisPos = this.absoluteVaule();
        Intzilla nPos = n.absoluteVaule();
        Intzilla answer = thisPos.difference(thisPos.quotient(nPos).product(nPos));
        if(this.sign == '-'){
            return new Intzilla('-' + answer.magnitude);
        }
        else{
            return answer;
        }
    }

    public Intzilla toBitString(Intzilla n){
        //did not contruct Intzillas in binary, N/A
        throw new UnsupportedOperationException();
    }

    static public Intzilla gcd (Intzilla x, Intzilla y){
        Intzilla xPos = x.absoluteVaule();
        Intzilla yPos = y.absoluteVaule();
        if(xPos.isLessThanInMagnitude(yPos)){
            Intzilla temp = xPos;
            xPos = yPos;
            yPos = temp;
        }
        Intzilla r = xPos.remainder(yPos);

        if(r.isEqualtoInMagnitude(new Intzilla())){
            return yPos;
        }
        else{
            return Intzilla.gcd(yPos,r);
        }
    }


}
