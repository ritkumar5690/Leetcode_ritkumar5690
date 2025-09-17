class FoodRatings {
    Map<String, String> map1;
    Map<String, Integer> map2;
    Map<String, TreeSet<String>> map3;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        map3 = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String f = foods[i];
            String cu = cuisines[i];
            int rat = ratings[i];
            map1.put(f, cu);
            map2.put(f, rat);

            map3.computeIfAbsent(cu, k -> new TreeSet<>((a,b) -> {
                int cap = Integer.compare(map2.get(b),map2.get(a));
                return (cap!=0) ? cap: a.compareTo(b);
            })).add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        String cu = map1.get(food);
        TreeSet<String> set = map3.get(cu);
        set.remove(food);
        map2.put(food,newRating);
        set.add(food);
    }

    public String highestRated(String cuisine) {
        return map3.get(cuisine).first();
    }

   
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */