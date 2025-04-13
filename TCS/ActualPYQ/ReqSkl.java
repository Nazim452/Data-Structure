package TCS.ActualPYQ;

import java.util.*;

public class ReqSkl {
    private static int targetMask;
    private static List<Integer> result = new ArrayList<>();
    private static Map<String, Integer> dp = new HashMap<>();

    private static void solve(List<Integer> peopleSkills, int idx, List<Integer> temp, int mask) {
        if (idx == peopleSkills.size()) {
            if (mask == targetMask && (result.isEmpty() || temp.size() < result.size()))
                result = new ArrayList<>(temp);
            return;
        }
        String key = idx + "_" + mask;
        if (dp.containsKey(key) && dp.get(key) <= temp.size())
            return;
        if (!result.isEmpty() && temp.size() >= result.size())
            return;
        solve(peopleSkills, idx + 1, temp, mask);
        int newMask = mask | peopleSkills.get(idx);
        if (newMask != mask) {
            temp.add(idx);
            solve(peopleSkills, idx + 1, temp, newMask);
            temp.remove(temp.size() - 1);
            dp.put(key, temp.isEmpty() ? -1 : temp.size());
        }
    }

    private static List<Integer> smallestSufficientTeam(List<String> reqSkills, List<List<String>> people) {
        int n = reqSkills.size();
        Map<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            skillMap.put(reqSkills.get(i), i);
        List<Integer> peopleSkills = new ArrayList<>();
        for (List<String> person : people) {
            int skillBit = 0;
            for (String skill : person)
                if (skillMap.containsKey(skill))
                    skillBit |= 1 << skillMap.get(skill);
            peopleSkills.add(skillBit);
        }
        targetMask = (1 << n) - 1;
        solve(peopleSkills, 0, new ArrayList<>(), 0);
        return result;
    }

    private static void parseInput(String input, List<String> skills, List<List<String>> people) {
        String[] parts = input.split(",");
        skills.addAll(Arrays.asList(parts[0].trim().split("\\s+")));
        for (int i = 2; i < parts.length; i++)
            people.add(Arrays.asList(parts[i].trim().split("\\s+")));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input string:");
        String input = sc.nextLine();
        sc.close();
        List<String> skills = new ArrayList<>();
        List<List<String>> people = new ArrayList<>();
        parseInput(input, skills, people);
        List<Integer> team = smallestSufficientTeam(skills, people);
        System.out.println(team.isEmpty() ? "-1" : team.toString().replaceAll("[\\[\\],]", ""));
    }
}