import java.util.Scanner;

public class InsurancePolicy {
    private String policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String policyholderSmokingStatus;
    private double policyholderHeight;
    private double policyholderWeight;
    private Scanner scanner;

    public InsurancePolicy() {
        scanner = new Scanner(System.in);
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber() {
        System.out.print("Please enter The Policy Number: ");
        policyNumber = scanner.nextLine();
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }

    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }

    public int getPolicyholderAge() {
        return policyholderAge;
    }

    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }

    public String getPolicyholderSmokingStatus() {
        return policyholderSmokingStatus;
    }

    public void setPolicyholderSmokingStatus(String policyholderSmokingStatus) {
        this.policyholderSmokingStatus = policyholderSmokingStatus;
    }

    public double getPolicyholderHeight() {
        return policyholderHeight;
    }

    public void setPolicyholderHeight(double policyholderHeight) {
        this.policyholderHeight = policyholderHeight;
    }

    public double getPolicyholderWeight() {
        return policyholderWeight;
    }

    public void setPolicyholderWeight(double policyholderWeight) {
        this.policyholderWeight = policyholderWeight;
    }

    public double calculateBMI() {
        double heightInInches = policyholderHeight;
        double bmi = (policyholderWeight * 703) / (heightInInches * heightInInches);
        return bmi;
    }

    public double calculatePrice() {
        double baseFee = 600.0;
        double additionalFee = 0.0;

        if (policyholderAge > 50) {
            additionalFee += 75.0;
        }

        if (policyholderSmokingStatus.equalsIgnoreCase("Smoker")) {
            additionalFee += 100.0;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20;
        }

        return baseFee + additionalFee;
    }


    public static void main(String[] args) {
        InsurancePolicy policy = new InsurancePolicy();
        policy.setPolicyNumber();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter the Provider Name: ");
        policy.setProviderName(scanner.nextLine());

        System.out.print("Please Enter the Policyholder’s First Name: ");
        policy.setPolicyholderFirstName(scanner.nextLine());

        System.out.print("Please Erter The Policyholder’s Last Name: ");
        policy.setPolicyholderLastName(scanner.nextLine());

        System.out.print("Please Enter the Policyholder’s Age: ");
        policy.setPolicyholderAge(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Please Enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        policy.setPolicyholderSmokingStatus(scanner.nextLine());

        System.out.print("Please Enter the Policyholder’s Height (in inches): ");
        policy.setPolicyholderHeight(scanner.nextDouble());

        System.out.print("Please Enter the Policyholder’s Weight (in pounds): ");
        policy.setPolicyholderWeight(scanner.nextDouble());

        
        double bmi = policy.calculateBMI();
        double price = policy.calculatePrice();
      
        System.out.println("Policy Number Is: " + policy.getPolicyNumber());
        System.out.println("Provider Name Is: " + policy.getProviderName());
        System.out.println("Policyholder's First Name Is: " + policy.getPolicyholderFirstName());
        System.out.println("Policyholder's Last Name Is : " + policy.getPolicyholderLastName());
        System.out.println("Policyholder's Age Is: " + policy.getPolicyholderAge());
        System.out.println("Policyholder's Smoking Status( Somker/non somker): " + policy.getPolicyholderSmokingStatus());
        System.out.println("Policyholder's Height (in inches): " + policy.getPolicyholderHeight());
        System.out.println("Policyholder's Weight (in pounds): " + policy.getPolicyholderWeight());
        System.out.printf("BMI: %.2f\n", bmi);
        System.out.printf("Price: %.2f\n", price);
    }
}