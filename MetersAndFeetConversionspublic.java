public class MetersAndFeetConversionspublic {
    /** Convert from feet to meters */
    static double footToMeter(double foot){
        double meter = 0.305 * foot;
        return meter;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter){
        double foot = 3.279 * meter;
        return foot;
    }

    /** Main function */
    public static void main(String[] args) {
        /** Initialize variables */
        double i = 1.0;
        double j = 20.0;
        /** table header */
        System.out.println("Feet     Meters               Meters     Feet");
        System.out.println("--------------------------------------------------");
        /** print variable conversions */
        while(i <= 10){
            /** spacing for certain numbers */
            if (i < 10 && j < 35.0){
                System.out.println( " " + i + "     " + String.format("%.3f", footToMeter(i)) + "               " + j + "      " + String.format("%.3f", meterToFoot(j)));
            } else if(i < 10 && j >= 35.0){
                System.out.println( " " + i + "     " + String.format("%.3f", footToMeter(i)) + "               " + j + "     " + String.format("%.3f", meterToFoot(j)));
            }else {
                System.out.println(i + "     " +String.format("%.3f", footToMeter(i)) + "               " + j + "     " + String.format("%.3f", meterToFoot(j)));
            }
            i++;
            j += 5.0;
        }
    }
}