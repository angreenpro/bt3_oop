/****************/
Nguyễn Phúc Trường An
202419022
/****************/

public class main {
    public static void main(String[] args) {
        System.out.println("Test 1: Tao 2 Employee (2 constructor)");
        Employee em1 = new Employee("E001", "Nguyen Van An");
        Employee em2 = new Employee("E002", "Tran Thi Bich Nga", 15000000);
        em1.displayInfo();
        System.out.println();
        em2.displayInfo();

        System.out.println("\nTest 2: Tao 2 SoftwareEngineer (2 constructor)");
        SoftwareEngineer se1 = new SoftwareEngineer("SE01", "Le Van Huy", "Java");
        SoftwareEngineer se2 = new SoftwareEngineer("SE02", "Pham Thi Hanh", 20000000, "Python", 5000000);
        se1.displayInfo();
        System.out.println();
        se2.displayInfo();

        System.out.println("\nTest 3: Tang luong co dinh");
        System.out.println("em2 truoc khi tang: " + em2.getBaseSalary());
        em2.increaseSalary(2000000);
        System.out.println("em2 sau khi tang 2,000,000: " + em2.getBaseSalary());
        System.out.println("\nTest 4: Tang luong theo %");
        System.out.println("se2 truoc khi tang: " + se2.getBaseSalary());
        se2.increaseSalary(10, true); 
        System.out.printf("se2 sau khi tang 10%%: %.2f%n", se2.getBaseSalary());

        System.out.println("\nTest 5: Tao ProjectTeam khong co truong nhom");
        ProjectTeam team1 = new ProjectTeam("PRJ001", "He Thong Quan Ly");
        System.out.println("Leader: " + team1.getLeader());

        System.out.println("\nTest 6: addMember(employee)");
        boolean added = team1.addMember(em1);
        System.out.println("Them em1: " + added);
        System.out.println("So thanh vien: " + team1.getMembers().size());

        System.out.println("\nTest 7: addMember(engineer, true)");
        boolean addedLeader = team1.addMember(se1, true);
        System.out.println("Them se1 lam leader: " + addedLeader);
        System.out.println("Leader hien tai: " + team1.getLeader().getFullName());

        System.out.println("\nTest 8: addMember voi member da ton tai");
        boolean addedDup = team1.addMember(em1);
        System.out.println("Them em1 lan 2: " + addedDup);
        System.out.println("So thanh vien (khong tang): " + team1.getMembers().size());

        team1.addMember(em2);
        team1.addMember(se2);

        System.out.println("\nTest 9: displayTeam() — da hinh");
        team1.displayTeam();

        System.out.println("\nTest 10: calculateTotalMonthlyCost()");
        double totalCost = team1.calculateTotalMonthlyCost();
        System.out.printf("Tong chi phi hang thang: %.2f%n", totalCost);
        System.out.println("(Ky vong: 44000000.00)");

        System.out.println("\nTest 11: removeMember(leaderId)");
        boolean removedLeader = team1.removeMember(se1.getId());
        System.out.println("Xoa leader (SE01): " + removedLeader);

        System.out.println("\nTest 12: changeLeader + removeMember(old leader)");
        boolean changed = team1.changeLeader(em2);
        System.out.println("Doi leader sang em2: " + changed);
        System.out.println("Leader moi: " + team1.getLeader().getFullName());

        boolean removedOld = team1.removeMember(se1.getId());
        System.out.println("Xoa leader cu (SE01): " + removedOld);
        System.out.println("So thanh vien con lai: " + team1.getMembers().size());

        System.out.println("\nTest 13: Aggregation — nhan su thuoc 2 nhom");
        ProjectTeam team2 = new ProjectTeam("PRJ002", "Ung Dung Di Dong");
        boolean addedToTeam2 = team2.addMember(em2);
        System.out.println("Them em2 vao team2: " + addedToTeam2);
        System.out.println("em2 trong team1: " + team1.contains(em2.getId()));
        System.out.println("em2 trong team2: " + team2.contains(em2.getId()));

        System.out.println("\nTest 14 & 15: Non-owning — Employee van song sau khi nhom bi huy");
        Employee empFromTeam2 = em2; 
        team2 = null; 
        System.gc();
        System.out.println("team2 da duoc set null.");
        System.out.println("em2 van ton tai:");
        empFromTeam2.displayInfo();
        System.out.println("em2 van trong team1: " + team1.contains(em2.getId()));
    }
}
