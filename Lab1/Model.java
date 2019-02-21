package Lab1;

/**
 * @author Ettore Senatore
 */

public class Model {

        private String firstName;
        private String lastName;
        private int heightInches;
        private int weight;
        private boolean canTravel;
        private boolean smoke;

        private static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
        private static final int TALL_INCHES = 67;
        private static final double THIN_POUNDS = 140.0;
        private static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
        private static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
        private static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;

        private static final int MINIMUM_WEIGHT =80;
        private static final int MAXIMUM_WEIGHT =280;
        private static final int MINIMUM_HEIGHT =24;
        private static final int MAXIMUM_HEIGHT =84;
        private static final int MINIMUM_NAME_LENGTH =3;
        private static final int MAXIMUM_NAME_LENGTH =20;

        private static final int INCHES_PER_FOOT = 12;
        private static final double CONVERTER_KG_LB = 2.2;
        private static final double CONVERTER_INCHES_CM = 2.5;

    @Override
    public String toString() {
        return super.toString();
    }

    public Model(){
            if((firstName!=null)&&(firstName.length()>=MINIMUM_NAME_LENGTH)&&(firstName.length()<=MAXIMUM_NAME_LENGTH)){
                this.firstName="";
            }
            if((lastName!=null)&&(lastName.length()>=MINIMUM_NAME_LENGTH)&&(lastName.length()<=MAXIMUM_NAME_LENGTH)){
                this.lastName="";
            }
            if((heightInches>=MINIMUM_HEIGHT)&&(heightInches<=MAXIMUM_HEIGHT)){
                this.heightInches=0;
            }
            if((weight>=MINIMUM_WEIGHT)&&(weight<=MAXIMUM_WEIGHT)){
                this.weight=0;
            }

            this.canTravel=false;
            this.smoke=false;

        }

        public Model(String firstName, String lastName, int heightInches,
                     long weightKg, boolean canTravel, boolean smoke)
        {
            setFirstName(firstName);
            setLastName(lastName);
            setHeightInches(heightInches);
            setWeight(weightKg);
            setCanTravel(canTravel);
            setSmoke(smoke);

                    }

        public Model(String firstName, String lastName, int heightInches, double weightLb){

            setFirstName(firstName);
            setLastName(lastName);
            setHeightInches(heightInches);
            setWeight(weightLb);
            setCanTravel(true);
            setSmoke(false);

        }

     public String getFirstName() {
            return firstName;
        }

     public String getLastName() {
            return lastName;
        }

     public int getHeightInches() {
            return heightInches;
        }

        public int getWeight() {
            return weight;
        }

        public final void setFirstName(String firstName) {
            if((firstName!=null)&&(firstName.length()>=MINIMUM_NAME_LENGTH)&&(firstName.length()<=MAXIMUM_NAME_LENGTH)){
                this.firstName=firstName;
            }

        }

         public final void setLastName(String lastName) {
            if((lastName!=null)&&(lastName.length()>=MINIMUM_NAME_LENGTH)&&(lastName.length()<=MAXIMUM_NAME_LENGTH)){
                this.lastName=lastName;
        }}

     public final void setHeightInches(int heightInches) {

                if((heightInches>=MINIMUM_HEIGHT)&&(heightInches<=MAXIMUM_HEIGHT)){
                    this.heightInches=heightInches;
                }
            }

    public final void setHeightInches(int feet, int inches){
        this.heightInches= feet * INCHES_PER_FOOT + inches;
    }

        public final void setWeight(double weightLb){
            if((weightLb>=MINIMUM_WEIGHT)&&(weightLb<=MAXIMUM_WEIGHT)){
                this.weight = (int)weightLb;
            }}

        public final void setWeight(long weightKg){
            if((weightKg>=MINIMUM_WEIGHT/CONVERTER_KG_LB)&&(weightKg<=MAXIMUM_WEIGHT/CONVERTER_KG_LB)){
                this.weight=(int)(weightKg*CONVERTER_KG_LB);
        }}

        public final void setCanTravel(boolean canTravel) {
            this.canTravel = canTravel;
        }

        public final void setSmoke(boolean smoke) {
            this.smoke = smoke;
        }

    public String getHeightInFeetAndInches(){
            int feet =  getHeightInches() /INCHES_PER_FOOT;
            int leftInches =getHeightInches() %INCHES_PER_FOOT;
            return (feet + " feet " + leftInches+" inches");
        }

        public void printDetails(){
            System.out.println("Name : " + getFirstName() + " " + getLastName());
            System.out.println("Height : " +getHeightInches() + " inches");
            System.out.println("Weight : " + getWeight() + " pounds");

            if(canTravel){
                System.out.println("Does travel");
            }else{
                System.out.println("Does not travel");
            }

            if(smoke){
                System.out.println("Does smoke");
            }else{
                System.out.println("does not smoke");
            }


        }

    private int calculatePayDollarsPerHour(){
        int payPerHour = 0;
        if ((heightInches>TALL_INCHES) && (weight<THIN_POUNDS)){
            payPerHour +=TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
         if(canTravel){
            payPerHour += TRAVEL_BONUS_DOLLARS_PER_HOUR;

        }
         if(smoke){
            payPerHour -= SMOKER_DEDUCTION_DOLLARS_PER_HOUR;

        }

        return payPerHour + BASE_RATE_DOLLARS_PER_HOUR ;
        }

    public void displayModelDetails(){
        System.out.println("Name : " + getFirstName()+" "+getLastName());
        System.out.println( "Height : "+getHeightInFeetAndInches());
        System.out.println("Weight : "+ getWeight()+ " pounds");

        if(canTravel){
            System.out.println("Travers : yep");
        }else{
            System.out.println("Travers : nope");
        }

        if(smoke){
            System.out.println("Smoke : yep");
        }else{
            System.out.println("Smoke : nope");
        }
        System.out.println("Hourly rate : " + calculatePayDollarsPerHour() + "$");


    }

    public void displayModelDetails(boolean metricUnits){
        System.out.println("Name : " + getFirstName() + " " + getLastName());
        System.out.println("Height : " + Math.round(heightInches*CONVERTER_INCHES_CM) + "cm");
        System.out.println("Weight : "+ Math.round((getWeight())/CONVERTER_KG_LB) + " kg");

        if(canTravel){
            System.out.println("Travers : yep");
        }else{
            System.out.println("Travers : nope");
        }

        if(smoke){
            System.out.println("Smoke : yep");
        }else{
            System.out.println("Smoke : nope");
        }
        System.out.println("Hourly rate : " + calculatePayDollarsPerHour() + " $");


    }

    }










