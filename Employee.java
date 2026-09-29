/****************/
Nguyễn Phúc Trường An
202419022
/****************/

class Employee {
    private String id;
    private String fullName;
    private double baseSalary;
    public Employee() {
        this("UNKNOWN", "Unnamed employee", 0);
    }
    public Employee(String id, String fullName) {
        this(id, fullName, 0);
    }

    public Employee(String id, String fullName, double baseSalary) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id khong duoc rong.");
        }
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("fullName khong duoc rong.");
        }
        if (baseSalary < 0) {
            throw new IllegalArgumentException("baseSalary >= 0.");
        }
        this.id = id;
        this.fullName = fullName;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void increaseSalary(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Gia tri tang luong > 0.");
        }
        baseSalary += amount;
    }

    public void increaseSalary(double value, boolean byPercentage) {
        if (value <= 0) {
            throw new IllegalArgumentException("Gia tri tang luong > 0.");
        }
        if (byPercentage) {
            baseSalary *= (1 + value / 100.0);
        } else {
            baseSalary += value;
        }
    }

    public double calculateMonthlyCost() {
        return baseSalary;
    }
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.printf("Base Salary: %.2f%n", baseSalary);
    }
}
