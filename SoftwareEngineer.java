class SoftwareEngineer extends Employee {
    private String primaryLanguage;
    private double technicalAllowance;
    public SoftwareEngineer(String id, String fullName, String primaryLanguage) {
        super(id, fullName);
        if (primaryLanguage == null || primaryLanguage.isEmpty()) {
            throw new IllegalArgumentException("primaryLanguage != NULL.");
        }
        this.primaryLanguage = primaryLanguage;
        this.technicalAllowance = 0;
    }

    public SoftwareEngineer(String id, String fullName, double baseSalary,
                            String primaryLanguage, double technicalAllowance) {
        super(id, fullName, baseSalary);
        if (primaryLanguage == null || primaryLanguage.isEmpty()) {
            throw new IllegalArgumentException("primaryLanguage != NULL.");
        }
        if (technicalAllowance < 0) {
            throw new IllegalArgumentException("technicalAllowance >= 0.");
        }
        this.primaryLanguage = primaryLanguage;
        this.technicalAllowance = technicalAllowance;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    public double getTechnicalAllowance() {
        return technicalAllowance;
    }

    @Override
    public double calculateMonthlyCost() {
        return getBaseSalary() + technicalAllowance;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Primary Language: " + primaryLanguage);
        System.out.printf("Technical Allowance: %.2f%n", technicalAllowance);
    }
}
