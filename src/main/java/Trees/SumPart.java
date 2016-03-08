package Trees;


import Trees.Exceptions.InvalidSumPartException;

public class SumPart {
    public Integer number;
    public String operandus;

    public SumPart(String part){
        if(validOperandus(part))
            operandus = part;
        else try{
            number = Integer.parseInt(part);
        } catch(Exception e) {
            throw new InvalidSumPartException();
        }
    }

    public SumPart(Integer part){
        number = part;
    }

    public void setNumber(int number){
        this.number = number;
        operandus = null;
    }

    public void setOperandus(String operandus){
        if(validOperandus(operandus))
            this.operandus = operandus;
        else
            throw new InvalidSumPartException();

        number = null;
    }

    public static boolean validOperandus(String str){
        String[] operandi = {"+", "-", "*", "/"};

        for(String operandus: operandi) {
            if (operandus.equals(str))
                return true;
        }

        return false;
    }

    public static boolean validOperandus(char str){
        char[] operandi = {'+', '-', '*', '/'};

        for(char operandus: operandi) {
            if (operandus == str)
                return true;
        }

        return false;
    }

    public String toString(){
        if(operandus != null)
            return operandus;
        else if(number != null)
            return number.toString();

        return "";
    }
}

