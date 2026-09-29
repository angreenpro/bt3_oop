/****************/
Nguyễn Phúc Trường An
202419022
/****************/

import java.util.ArrayList;
import java.util.List;

class ProjectTeam {
    private String projectCode;
    private String projectName;
    private Employee leader;           
    private List<Employee> members;     

    public ProjectTeam(String projectCode, String projectName) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.leader = null;
        this.members = new ArrayList<>();
    }

    public ProjectTeam(String projectCode, String projectName, Employee leader) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.members = new ArrayList<>();
        this.members.add(leader);
        this.leader = leader;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public Employee getLeader() {
        return leader;
    }

    public List<Employee> getMembers() {
        return members;
    }

    public boolean addMember(Employee employee) {
        if (contains(employee.getId())) {
            return false;
        }
        members.add(employee);
        return true;
    }

    public boolean addMember(Employee employee, boolean makeLeader) {
        boolean alreadyExists = contains(employee.getId());
        if (!alreadyExists) {
            members.add(employee);
        }   
        if (makeLeader) {
            this.leader = employee;
        }
        return !alreadyExists || makeLeader;
    }

    public boolean removeMember(String employeeId) {
        if (leader != null && leader.getId().equals(employeeId)) {
            return false;
        }
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(employeeId)) {
                members.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean changeLeader(Employee employee) {
        if (!contains(employee.getId())) {
            members.add(employee);
        }
        this.leader = employee;
        return true;
    }

    public boolean contains(String employeeId) {
        for (Employee m : members) {
            if (m.getId().equals(employeeId)) {
                return true;
            }
        }
        return false;
    }

    public double calculateTotalMonthlyCost() {
        double total = 0;
        for (Employee m : members) {
            total += m.calculateMonthlyCost();
        }
        return total;
    }

    public void displayTeam() {
        System.out.println("===== PROJECT TEAM =====");
        System.out.println("Project Code: " + projectCode);
        System.out.println("Project Name: " + projectName);
        System.out.println("Leader: " + (leader != null ? leader.getFullName() : "None"));
        System.out.println("Members (" + members.size() + "):");
        System.out.println("------------------------");
        for (Employee m : members) {
            m.displayInfo();
            System.out.println("  Monthly Cost: " + String.format("%.2f", m.calculateMonthlyCost()));
            System.out.println("------------------------");
        }
    }
}
