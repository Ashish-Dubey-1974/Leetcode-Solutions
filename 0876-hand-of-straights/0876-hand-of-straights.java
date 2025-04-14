class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
        return false;
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        while (!cardCount.isEmpty()) {
            int firstCard = cardCount.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int currentCard = firstCard + i;
                if (!cardCount.containsKey(currentCard)) {
                    return false;
                }
                int count = cardCount.get(currentCard);
                if (count == 1) {
                    cardCount.remove(currentCard);
                } else {
                    cardCount.put(currentCard, count - 1);
                }
            }
        }

        return true;
    }
}