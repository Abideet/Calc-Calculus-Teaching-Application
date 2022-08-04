package uk.aston.calculusldc.root.InteractiveDiagrams;


public class GammaFunction {

    //Gamma function used here to be
    public static double gamma(double x)
    {
        double[] p = {0.99999999999980993, 676.5203681218851, -1259.1392167224028,
                771.32342877765313, -176.61502916214059, 12.507343278686905,
                -0.13857109526572012, 9.9843695780195716e-6, 1.5056327351493116e-7};
        int g = 7;
        if(x < 0.5) return Math.PI / (Math.sin(Math.PI * x)* gamma(1-x));

        x -= 1;
        double a = p[0];
        double t = x+g+0.5;
        for(int i = 1; i < p.length; i++){
            a += p[i]/(x+i);
        }

        return Math.sqrt(2*Math.PI)*Math.pow(t, x+0.5)*Math.exp(-t)*a;
    }

    public static double factorial(double x){
        return gamma(x+1);
    }




}
