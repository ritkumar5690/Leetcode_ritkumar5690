class TaskManager {
    Map<Integer,Integer> taskToUser;
    Map<Integer,Integer> taskToPriority;
    TreeMap<Integer, TreeSet<Integer>> prioMap;

    public TaskManager(List<List<Integer>> tasks) {
        taskToUser = new HashMap<>();
        taskToPriority = new HashMap<>();
        prioMap = new TreeMap<>(Collections.reverseOrder());

        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskToUser.put(taskId, userId);
        taskToPriority.put(taskId, priority);
        prioMap.computeIfAbsent(priority, k -> new TreeSet<>(Collections.reverseOrder()))
               .add(taskId);
    }

    public void edit(int taskId, int newPriority) {
        int oldPriority = taskToPriority.get(taskId);
        prioMap.get(oldPriority).remove(taskId);
        if (prioMap.get(oldPriority).isEmpty()) prioMap.remove(oldPriority);

        taskToPriority.put(taskId, newPriority);
        prioMap.computeIfAbsent(newPriority, k -> new TreeSet<>(Collections.reverseOrder()))
               .add(taskId);
    }

    public void rmv(int taskId) {
        int priority = taskToPriority.get(taskId);
        prioMap.get(priority).remove(taskId);
        if (prioMap.get(priority).isEmpty()) prioMap.remove(priority);

        taskToUser.remove(taskId);
        taskToPriority.remove(taskId);
    }

    public int execTop() {
        if (prioMap.isEmpty()) return -1;
        int priority = prioMap.firstKey();               
        int taskId = prioMap.get(priority).first();      
        prioMap.get(priority).remove(taskId);
        if (prioMap.get(priority).isEmpty()) prioMap.remove(priority);

        int userId = taskToUser.get(taskId);
        taskToUser.remove(taskId);
        taskToPriority.remove(taskId);
        return userId;
    }
}
