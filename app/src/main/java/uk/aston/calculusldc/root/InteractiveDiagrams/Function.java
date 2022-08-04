package uk.aston.calculusldc.root.InteractiveDiagrams;




public class Function {

    public static String[] convertToRPNlv2 (String[] expression,int length){
        int index = 0; //address of the source array
        int resultIndex=0; //address of the result carrier
        int stackCounter=0; //stack counter
        //TODO: Change stop to endLoop and into a boolean
        int stop =0;
        String[] stack = new String[length];
        stack[0]="0"; //initialize stack
        String[] result = new String[length];

        //element by element the source array is evaluated
        for(index=0;index<length;index++){
            //if the string is a number
            if (expression[index] != "+" &&
                    expression[index] != "-"  &&
                    expression[index] !="*" &&
                    expression[index] !="/" &&
                    expression[index] !="(" &&
                    expression[index] !=")" &&
                    expression[index] !="^" &&
                    expression[index] !="sin" && expression[index] !="cos" && expression[index] !="tan" &&
                    expression[index] !="asin" && expression[index] !="acos" && expression[index] !="atan" &&
                    expression[index] !="sinh" && expression[index] !="cosh" && expression[index] !="tanh" &&
                    expression[index] !="asinh" && expression[index] !="acosh" && expression[index] !="atanh" &&
                    expression[index] !="√" && expression[index] !="erf" && expression[index] !="log" &&
                    expression[index] !="ln" && expression[index] !="Si" && expression[index] !="sinc"&&
                    expression[index] !="inverf" && expression[index] !="Abs" && expression[index] !="sgn"

                    ){
                //directly copy it to the result if it is a number
                result[resultIndex]=expression[index];
                //increment the result index
                resultIndex++;
            }
            //else if it is a operand or a parenthesis
            else{
                // if the operand is a plus or minus
                if(expression[index] == "+" || expression[index] == "-"){
                    //place it in the right place on the stack with a while loop, end the loop when stop is not equal to one(could make stop true or false)
                    while(stop==0){
                        //if the stack includes a plus or minus or is empty
                        if(stack[stackCounter]== "+" || stack[stackCounter]== "-" || stack[stackCounter]=="0"){
                            //if it is not empty, we must have a plus or minus
                            if(stack[stackCounter]!="0"){
                                //Thus, increment the result array with element in the stack array
                                result[resultIndex]=stack[stackCounter];
                                //increment the result index
                                resultIndex++;
                            }
                            //end the loop if the stack contains an operand analysed above
                            stop=1;
                        }

                        //if the operand is a multiplication or division or a power
                        else if(stack[stackCounter] == "*" || stack[stackCounter] == "/" || stack[stackCounter] == "^"){ //2.1.2) se invece l'operando è una * o una / oppure ^ lo stack deve essere accorciato, almeno che l'ultimo elemento dello stack non sia una parentesi aperta
                            //Copy the first operand of the stack into the result
                            result[resultIndex]=stack[stackCounter];
                            //increment the result index which keeps track of the address of the result
                            resultIndex++;
                            if(stackCounter>0)
                                stackCounter--; //the operand is removed from the stack of the stack simply by lowering the stackCounter, it will then be eventually overwritten
                            else stop=1; //if instead the stackCounter is already at zero then the stack is empty and the cycle must be interrupted so stop = 1
                        }
                        else if(stack[stackCounter] == "("){ //in caso di parentesi aperta
                            stackCounter++;
                            stop=1; //the operand is simply placed on top of the stack at the end of the cycle
                        }
                    }
                    stack[stackCounter]=expression[index]; //once the cycle is over, the operand that was used for the evaluation is placed on top of the stack
                    stop=0;
                }
                else if (expression[index] == "*" || expression[index] == "/"){ //if instead we are in front of a * or a / to be evaluated
                    while(stop==0){
                        if(stack[stackCounter]== "*" || stack[stackCounter]== "/"){ //if at the top of the stack we have * or / we have the same priority level


                            result[resultIndex]=stack[stackCounter]; //the operand at the top of the stack is moved to the result
                            resultIndex++;
                            stack[stackCounter]=expression[index];
                            stop=1;//the new opernado of equal priority is placed at the top of the stack

                        }
                        else if(stack[stackCounter]== "+" || stack[stackCounter]== "-" || stack[stackCounter] == "(" || stack[stackCounter] == "0"){
                            if(stack[stackCounter]!="0") stackCounter++;
                            stack[stackCounter]=expression[index];
                            stop=1;//if we have + - or (the operand is placed on top of the stack
                        }
                        else if(stack[stackCounter] == "^"){//if, on the other hand, we have an elevation to a power
                            result[resultIndex]=stack[stackCounter];
                            resultIndex++;
                            if(stackCounter>0) stackCounter--;
                            else stop=1;

                        }

                    }
                    stack[stackCounter]=expression[index];
                    stop=0;
                }
                else if (expression[index]== "("){ //if instead we have to place an opening parenthesis
                    if(stack[stackCounter]!="0") { //if the stack is not empty it is placed on top by increasing the stackCounter
                        stackCounter++;
                        stack[stackCounter]=expression[index];
                    }
                    else {
                        stack[stackCounter]=expression[index]; //if the position currently indicated by the stack counter is empty, the box is filled with the opening parenthesis

                    }
                }
                else if (expression[index] == "^" ||
                        expression[index] =="sin" || expression[index] =="cos" || expression[index] =="tan" ||
                        expression[index] =="asin" || expression[index] =="acos" || expression[index] =="atan" ||
                        expression[index] =="sinh" || expression[index] =="cosh" || expression[index] =="tanh" ||
                        expression[index] =="asinh" || expression[index] =="acosh" || expression[index] =="atanh" ||
                        expression[index] =="√" || expression[index] =="erf" || expression[index] =="log" ||
                        expression[index] =="ln" || expression[index] =="Si" || expression[index] =="sinc"||
                        expression[index] =="inverf" || expression[index] =="Abs" || expression[index] =="sgn"){ //power or unary operator
                    if(stack[stackCounter]!="0") { //if the stack is not empty ^ it is placed on top by incrementing the stackCounter
                        stackCounter++;
                        stack[stackCounter]=expression[index];
                    }
                    else {
                        stack[stackCounter]=expression[index]; //if the position currently indicated by the stack counter is empty, the box is filled with the opening parenthesis
                    }
                }

                else {//closing parenthesis
                    while(stack[stackCounter]!= "("){ //in case of closing parenthesis until I encounter an opening parenthesis on the stack
                        if( stack[stackCounter]!="0"){ //if the current box is not empty
                            result[resultIndex]=stack[stackCounter];//the operand is placed in the result

                            resultIndex++;
                        }
                        else break;
                        stack[stackCounter]="0"; //in any case, the box is now empty
                        if(stackCounter!=0)stackCounter--;//if possible we lower the stack counter by 1
                    }
                    stack[stackCounter]="0"; //when the while ends, it means that we point to a box with (... so we delete it
                    if(stackCounter!=0)stackCounter--; //decrement the stack counter
                    if(stack[stackCounter] =="sin" || stack[stackCounter] =="cos" || stack[stackCounter] =="tan" ||
                            stack[stackCounter] =="asin" || stack[stackCounter] =="acos" || stack[stackCounter] =="atan" ||
                            stack[stackCounter] =="sinh" || stack[stackCounter] =="cosh" || stack[stackCounter] =="tanh" ||
                            stack[stackCounter] =="asinh" || stack[stackCounter] =="acosh" || stack[stackCounter] =="atanh" ||
                            stack[stackCounter] =="√" || stack[stackCounter] =="erf" || stack[stackCounter] =="log" ||
                            stack[stackCounter] =="ln" || stack[stackCounter] =="Si" || stack[stackCounter] =="sinc"||
                            stack[stackCounter] =="inverf" || stack[stackCounter] =="Abs" || stack[stackCounter] =="sgn"){

                        result[resultIndex]=stack[stackCounter];
                        resultIndex++;
                        stack[stackCounter]="0";
                        if(stackCounter>0) stackCounter--;
                    }
                    //When the parenthesis closes, a possible unary operand is also unloaded from the stack


                }
            }
        }
        while(stackCounter>=0){ //finished evaluating the array we need to empty the stack
            if(stack[stackCounter]!="0") result[resultIndex++]=stack[stackCounter];
            stackCounter--;
        }
        return result;
    }

    public static double resolveExpressionlv2(String[] expression, int length, int deg){

        if (expression.length == 1) return Double.parseDouble(expression[0]);

        double result=0;
        double c;
        //We get the conversion to degrees if necessary
        if(deg==0){
            c=1;
        }else if(deg==1){
            c=Math.PI/180;
        }else{
            c=Math.PI/200;
        }


        //convert the string
        expression= Function.convertToRPNlv2(expression, length);


    //solves the problem of unnecessary brackets in the case of a single number
       if(expression[0].length()==0) result=Double.parseDouble(expression[1]);
        else result=Double.parseDouble(expression[0]);

        for(int i=0;i<length;i++){ //scan element by element looking for the next operator
            if(expression[i]=="+"){// if the operator is a sum
                result=Double.parseDouble(expression[i-2])+Double.parseDouble(expression[i-1]);
                expression[i]=result+"";
                for(int a=i-3;a>=0;a--){
                    expression[a+2]=expression[a]; //elements are shifted to the right
                }

            }
            if(expression[i]=="-"){ // if the operator is a minus
                result=Double.parseDouble(expression[i-2])-Double.parseDouble(expression[i-1]);
                expression[i]=result+"";
                for(int a=i-3;a>=0;a--){
                    expression[a+2]=expression[a];
                }
            }
            if(expression[i]=="*"){ //if the operator is a multiplication
                result=Double.parseDouble(expression[i-2])*Double.parseDouble(expression[i-1]);
                expression[i]=result+"";
                for(int a=i-3;a>=0;a--){
                    expression[a+2]=expression[a];
                }
            }
            if(expression[i]=="/"){ // if the operator is a division
                result=Double.parseDouble(expression[i-2])/Double.parseDouble(expression[i-1]);
                expression[i]=result+"";
                for(int a=i-3;a>=0;a--){
                    expression[a+2]=expression[a];
                }
            }
            if(expression[i]=="^"){ //if the operator is a power
                result=Math.pow(Double.parseDouble(expression[i-2]),Double.parseDouble(expression[i-1]));
                expression[i]=result+"";
                for(int a=i-3;a>=0;a--){
                    expression[a+2]=expression[a];
                }
            }
            if(expression[i]=="!"){ //if the operator is a factorial
                result= uk.aston.calculusldc.root.InteractiveDiagrams.GammaFunction.factorial(Double.parseDouble(expression[i-1]));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="sin"){ //if the operator is a sin
                result=Math.sin(Double.parseDouble(expression[i-1])*c);
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="cos"){ //if the operator is a cos
                result=Math.cos(Double.parseDouble(expression[i-1])*c);
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1] = expression[a];
                }
            }
            if(expression[i]=="tan"){ //if the operator is a tan
                result=Math.tan(Double.parseDouble(expression[i-1])*c);
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="asin"){ //if the operator is an asin
                result=Math.asin(Double.parseDouble(expression[i-1]))/c;
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="acos"){ //if the operator is an acos
                result=Math.acos(Double.parseDouble(expression[i-1]))/c;
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="atan"){ //if the operator is an atan
                result=Math.atan(Double.parseDouble(expression[i-1]))/c;
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="sinh"){ //if the operator is a sinh
                result=Math.sinh(Double.parseDouble(expression[i-1]));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="cosh"){ //if the operator is a cosh
                result=Math.cosh(Double.parseDouble(expression[i-1]));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="tanh"){ //if the operator is a tanh
                result=Math.tanh(Double.parseDouble(expression[i-1]));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }

            if(expression[i]=="asinh"){ //if the operator is an arc sinh
                Double b= Double.parseDouble(expression[i-1]);
                result=Math.log(b + Math.sqrt(b*b + 1.0));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="acosh"){ //if the operator is an arc cosh
                Double b= Double.parseDouble(expression[i-1]);
                result=Math.log(b + Math.sqrt(b*b - 1.0));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="atanh"){ //if the operator is an arc tanh
                Double b= Double.parseDouble(expression[i-1]);
                result=0.5*Math.log( (b + 1.0) / (b - 1.0) );
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="erf"){ //if the operator is an error function
                result= uk.aston.calculusldc.root.InteractiveDiagrams.ErrorFunction.erf((Double.parseDouble(expression[i-1])));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="inverf"){ //if the operator is an inverse function
                result= uk.aston.calculusldc.root.InteractiveDiagrams.ErrorFunction.invErf((Double.parseDouble(expression[i-1])));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="log"){ //if the operator is a log function
                result=Math.log10(Double.parseDouble(expression[i-1]));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }

            if(expression[i]=="ln"){ //if the operator is a natural log function
                result=Math.log(Double.parseDouble(expression[i-1]));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="Abs"){ //if the operator is to return the absolute value of am operand
                result=Math.abs(Double.parseDouble(expression[i-1]));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="sgn"){ //if the operator is the signum function
                if(Double.parseDouble(expression[i-1])>0) result=1;
                else if(Double.parseDouble(expression[i-1])<0) result=-1;
                else if(Double.parseDouble(expression[i-1])==0) result=0;
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }
            if(expression[i]=="√"){ //if the operator is a root
                result=Math.sqrt(Double.parseDouble(expression[i-1]));
                expression[i]=result+"";
                for(int a=i-2;a>=0;a--){
                    expression[a+1]=expression[a];
                }
            }

        }
        return result;
    }

    public static String[] replaceX(double valueOfX, String[] espressione, int length){

        String[] newEspressione = new String[length];
        for(int i=0;i<length;i++){
            newEspressione[i]=espressione[i];
        }

        for(int i=0; i<length; i++){


            if(newEspressione[i]=="x"){
                newEspressione[i]=valueOfX+"";
            }
        }
        return newEspressione;
    }

    public static String[] replaceConstants(double ans, String[] espressione, int length){

        String[] newExpression = new String[length];

        for(int i=0;i<length;i++){
            newExpression[i]=espressione[i];
        }

        for(int i=0; i<length; i++){


            if(newExpression[i]=="π"){
                 newExpression[i] = Math.PI + "";
            }

            if(newExpression[i]=="e"){
                newExpression[i] = Math.E + "";
            }
            if(newExpression[i]=="ans"){
                newExpression[i] = ans + "";
            }
        }
        return newExpression;
    }

    public static double[] createGraphicValues(int numberOfSamples, String[] espressione, int length, double minX, double maxX, int deg){
        double step=(maxX-minX)/(numberOfSamples-1);
        double[] values = new double[numberOfSamples];
        String[] numericExpression;

        for(int i=0;i<numberOfSamples;i++){
            numericExpression= replaceX(minX+step*i,espressione,length);
            values[i]=resolveExpressionlv2(numericExpression,length,deg);
        }
        return values;
    }

}
