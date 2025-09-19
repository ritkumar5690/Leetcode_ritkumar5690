class Spreadsheet {
    private String st = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, Integer> map;

    public Spreadsheet(int rows) {
    
        map = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        map.put(cell, value);
    }

    public void resetCell(String cell) {
        map.replace(cell, 0);
    }

    public int getValue(String formula) {
        formula = formula.substring(1);

        String[] parts = formula.split("\\+");
        String temp1 = parts[0];
        String temp2 = parts[1];

        int sum = 0;

        if (temp1.matches("\\d+")) {
            sum += Integer.parseInt(temp1);
        } else {
            sum += map.getOrDefault(temp1,0);
        }
        if (temp2.matches("\\d+")) {
            sum += Integer.parseInt(temp2);
        } else {
            sum += map.getOrDefault(temp2,0);
        }
        
        return sum;
    }

}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */