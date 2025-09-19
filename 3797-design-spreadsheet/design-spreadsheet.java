class Spreadsheet {
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
        int sum =0;
        for(String s : formula.substring(1).split("\\+")){
            sum += mapToval(s);
        }
        
        return sum;
    }
    private int mapToval(String s){
        return Character.isLetter(s.charAt(0))? map.getOrDefault(s,0) : Integer.parseInt(s);
    }

}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */