class RandomizedCollection {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    private Random rand;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean containsKey = !map.containsKey(val);
        if (containsKey) {
            map.put(val, new HashSet<>());
        }

        map.get(val).add(list.size());
        list.add(val);
        return containsKey;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        Set<Integer> indexes = map.get(val);
        int indexToBeRemoved = indexes.iterator().next();

        indexes.remove(indexToBeRemoved);
        if (indexes.size() == 0) {
            map.remove(val);
        }

        int lastIndex = list.size() - 1;
        int last = list.get(lastIndex);

        // if not removing last element, swap
        if (indexToBeRemoved != lastIndex) {
            list.set(indexToBeRemoved, last);

            Set<Integer> lastElementSet = map.get(last);
            lastElementSet.remove(lastIndex);
            lastElementSet.add(indexToBeRemoved);
        }

        // remove last element
        list.remove(lastIndex);

        return true;

    }

    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */